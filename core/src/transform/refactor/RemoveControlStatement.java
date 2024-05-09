package transform.refactor;

import org.eclipse.jdt.core.dom.*;
import org.eclipse.jdt.core.dom.PrefixExpression.Operator;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jdt.core.dom.rewrite.ListRewrite;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;
import transform.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class RemoveControlStatement extends ASTVisitor {
    ArrayList targetLines;
    CompilationUnit cu = null;
    Document document = null;
    String outputDirPath = null;
    List<IfStatement> ifStatementBin = new ArrayList<IfStatement>();
    List<ForStatement> forsBin = new ArrayList<ForStatement>();
    List<WhileStatement> whilesBin = new ArrayList<WhileStatement>();
    float threshold;

    public RemoveControlStatement(CompilationUnit cu_, Document document_, String outputDirPath_, ArrayList targetLines, float threshold) {
        this.cu = cu_;
        this.document = document_;
        this.outputDirPath = outputDirPath_;
        this.targetLines = targetLines;
        this.threshold = threshold;
    }


    public boolean visit(IfStatement node) {
        ifStatementBin.add(node);
        return true;
    }

    public boolean visit(ForStatement node) {
        //Visit all for-loop statement

        return true;
    }

    public boolean visit(WhileStatement node) {
        //visit while-loop statements
        return true;
    }

    public void endVisit(CompilationUnit node) {
        if(ifStatementBin.size() <= 0) return;
        AST ast = cu.getAST();
        ASTRewrite rewriter = ASTRewrite.create(ast);

        Collections.shuffle(ifStatementBin);
        int K = Math.max(1,(int)(threshold*ifStatementBin.size()));

        ifStatementBin = ifStatementBin.subList(0,K);

        for (IfStatement ifer : ifStatementBin) {
            //#dev //
            ArrayList<Object> els = new ArrayList<>();

            if (ifer.getThenStatement().getNodeType() == ASTNode.BLOCK) {
                Block tmpThen = (Block) ifer.getThenStatement();
                for (Object st : tmpThen.statements()) {
                    els.add(st);
                }
            }else{
                els.add(ifer.getThenStatement());
            }
            if(ifer.getElseStatement() != null) {
                if (ifer.getElseStatement().getNodeType() == ASTNode.BLOCK) {
                    Block tmpThen = (Block) ifer.getElseStatement();
                    for (Object st : tmpThen.statements()) {
                        els.add(st);
                    }
                } else {
                    els.add(ifer.getElseStatement());
                }
            }

            Block blockoutsideWhile;
            if (ifer.getParent().getNodeType() != ASTNode.BLOCK) {//we have to create a new block
                blockoutsideWhile = ast.newBlock();
                ASTNode tmp = null;
                for(Object el :els) {
                    tmp =  ASTNode.copySubtree(ast, (ASTNode) el);
                    blockoutsideWhile.statements().add(tmp);
                }
                rewriter.replace(ifer, blockoutsideWhile, null);
            } else {
                blockoutsideWhile = (Block) ifer.getParent();
                ListRewrite lrt2 = rewriter.getListRewrite(blockoutsideWhile, Block.STATEMENTS_PROPERTY);
                if (ifer.getThenStatement().getNodeType() == ASTNode.BLOCK) {
                    for (Object st : els) {
                        ASTNode tmpSt = ASTNode.copySubtree(ast, (ASTNode) st);
                        lrt2.insertBefore(tmpSt, ifer, null);
                    }
                }
                rewriter.remove(ifer, null);
            }
        }
        TextEdit edits = rewriter.rewriteAST(document, null);
        Utils.applyRewrite(edits, document, outputDirPath);

    }
}
