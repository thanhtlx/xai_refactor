package transform.refactor;

import org.eclipse.jdt.core.dom.*;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;
import org.w3c.dom.NodeList;
import transform.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

//not done
public class ReoderParameter extends ASTVisitor {
    ArrayList<MethodDeclaration> funcs = new ArrayList<MethodDeclaration>();
    CompilationUnit cu;
    Document document;
    String outputDirPath;
    ArrayList targetLines;
    float threshold;

    public ReoderParameter(CompilationUnit cu_, Document document_, String outputDirPath_, ArrayList targetLines, float threshold) {
        this.cu = cu_;
        this.document = document_;
        this.outputDirPath = outputDirPath_;
        this.targetLines = targetLines;
        this.threshold = threshold;
    }

    public boolean visit(MethodDeclaration node) {
        funcs.add(node);
        return true;
    }

    public void endVisit(CompilationUnit node) {
        AST ast = cu.getAST();
        ASTRewrite rewriter = ASTRewrite.create(ast);
        for (MethodDeclaration func : funcs) {
            MethodDeclaration nfunc = (MethodDeclaration) ASTNode.copySubtree(ast, func);
            ArrayList<Object> pars = new ArrayList<>();
            for (Object st : nfunc.parameters()) pars.add(st);
            nfunc.parameters().clear();
            for(int i = pars.size()-1;i>=0;i--){
                nfunc.parameters().add(ASTNode.copySubtree(ast, (ASTNode) pars.get(i)));
            }
            rewriter.replace(func, nfunc, null);
        }
        TextEdit edits = rewriter.rewriteAST(document, null);
        Utils.applyRewrite(edits, document, outputDirPath);
    }
}





