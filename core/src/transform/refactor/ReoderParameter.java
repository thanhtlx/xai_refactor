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

    public ReoderParameter(CompilationUnit cu_, Document document_, String outputDirPath_, ArrayList targetLines) {
        this.cu = cu_;
        this.document = document_;
        this.outputDirPath = outputDirPath_;
        this.targetLines = targetLines;
        System.out.println("reorder parameter");
        System.out.println(targetLines);
    }

    public boolean visit(MethodDeclaration node) {
        System.out.println(node + " " + node.getNodeType());
        funcs.add(node);
        return true;
    }

    public void endVisit(CompilationUnit node) {
        AST ast = cu.getAST();
        ASTRewrite rewriter = ASTRewrite.create(ast);
        for (MethodDeclaration func : funcs) {
//
            List<ASTNode> tmp = func.parameters();
//            Collections.reverse(tmp);
//            tmp.sort((o1, o2) -> -o1.getStartPosition() + o2.getStartPosition());
            func.setProperty("parameters",tmp);
//            System.out.println(func.getAST().pa);
//            func.setProperty();
//            func.set

        }
        TextEdit edits = rewriter.rewriteAST(document, null);
        Utils.applyRewrite(edits, document, outputDirPath);
    }
}





