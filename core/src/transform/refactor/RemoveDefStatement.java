package transform.refactor;

import org.eclipse.jdt.core.dom.*;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;
import transform.Utils;

import java.util.*;

public class RemoveDefStatement extends ASTVisitor{
	ArrayList targetLines;
	CompilationUnit cu = null;
	Document document = null;
	String outputDirPath = null;
	List<VariableDeclarationStatement> declStatements = new ArrayList<>();
	AST ast = null;
	ASTRewrite rewriter = null;
	float threshold;

	public RemoveDefStatement(CompilationUnit cu_, Document document_, String outputDirPath_, ArrayList targetLines, float threshold) {
		this.cu = cu_;
		this.document = document_;
		this.outputDirPath = outputDirPath_;
		ast = cu.getAST();
		rewriter = ASTRewrite.create(ast);
		this.targetLines = targetLines;
		this.threshold = threshold;
	}
	
	public boolean visit(VariableDeclarationStatement declaration) {
		declStatements.add(declaration);
		return true;
	}

	public void endVisit(CompilationUnit node) {
		if (declStatements.size() <=0 ) return;
		AST ast = cu.getAST();
		ASTRewrite rewriter = ASTRewrite.create(ast);

		Collections.shuffle(declStatements);
		int K = Math.max(1,(int)(threshold*declStatements.size()));

		declStatements =  declStatements.subList(0,K);
		for(VariableDeclarationStatement declarationStatement: declStatements) {
			rewriter.remove(declarationStatement, null);
		}
		TextEdit edits = rewriter.rewriteAST(document, null);
		Utils.applyRewrite(edits, document,outputDirPath);
		
	}
}