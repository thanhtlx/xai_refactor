package transform.refactor;

import org.eclipse.jdt.core.dom.*;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jdt.core.dom.rewrite.ListRewrite;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;
import transform.Utils;

import java.util.*;

public class RemoveUseStatement extends ASTVisitor{
	ArrayList targetLines;
	CompilationUnit cu = null;
	Document document = null;
	String outputDirPath = null;
	Map<VariableDeclarationStatement, VariableDeclarationStatement> VarDecscanSwitch =
			new HashMap<VariableDeclarationStatement, VariableDeclarationStatement>();
	Set<VariableDeclarationStatement> involvedStatements = new HashSet<VariableDeclarationStatement>();
	AST ast = null;
	ASTRewrite rewriter = null;

	public RemoveUseStatement(CompilationUnit cu_, Document document_, String outputDirPath_, ArrayList targetLines) {
		this.cu = cu_;
		this.document = document_;
		this.outputDirPath = outputDirPath_;
		ast = cu.getAST();
		rewriter = ASTRewrite.create(ast);
		this.targetLines = targetLines;
	}
	
	public boolean visit(Assignment blocker) {
		System.out.println("??");
		System.out.println(blocker);
		return true;
	}



	public void endVisit(CompilationUnit node) {

		TextEdit edits = rewriter.rewriteAST(document, null);
		Utils.applyRewrite(edits, document,outputDirPath);
		
	}
}