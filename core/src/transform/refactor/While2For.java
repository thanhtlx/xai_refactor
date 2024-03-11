package transform.refactor;

import org.eclipse.jdt.core.dom.*;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;
import transform.Utils;

import java.util.ArrayList;
import java.util.Collections;

public class While2For extends ASTVisitor {
    ArrayList targetLines;
    CompilationUnit cu = null;
    Document document = null;
    String outputDirPath = null;
    ArrayList<WhileStatement> whileBin = new ArrayList<WhileStatement>();
    float threshold;

    public While2For(CompilationUnit cu_, Document document_, String outputDirPath_, ArrayList targetLines, float threshold) {
        this.cu = cu_;
        this.document = document_;
        this.outputDirPath = outputDirPath_;
        this.targetLines = targetLines;
        this.threshold = threshold;
    }


    public boolean visit(WhileStatement node) {
        //visit while-loop statements
        whileBin.add(node);

        return true;
    }

    public void endVisit(CompilationUnit node) {

        // If whileBin is empty, let's skip
        if (whileBin.size() == 0) {
            return;
        }
        Collections.shuffle(whileBin);
        int K = Math.max(1,(int)(threshold*whileBin.size()));

        whileBin = (ArrayList<WhileStatement>) whileBin.subList(0,K);


        AST ast = cu.getAST();
        ASTRewrite rewriter = ASTRewrite.create(ast);

        //Loop over while-loop statements
        for (WhileStatement whiler : whileBin) {
            //Convert while-loop to for-loop
            ForStatement forer = ast.newForStatement();
            Expression theexp = (Expression) ASTNode.copySubtree(ast, whiler.getExpression());
            forer.setExpression(theexp);
            Statement bodystatement = whiler.getBody();
            Statement forbody = (Statement) ASTNode.copySubtree(ast, bodystatement);
            forer.setBody(forbody);
            rewriter.replace(whiler, forer, null);
        }

        //Rewrite
        TextEdit edits = rewriter.rewriteAST(document, null);
        Utils.applyRewrite(edits, document, outputDirPath);
    }
}
