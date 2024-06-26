package transform.refactor;

import org.apache.felix.resolver.util.CopyOnWriteSet;
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

//not done
public class ReverseCondition extends ASTVisitor{
	ArrayList targetLines;
	CompilationUnit cu = null;
	Document document = null;
	String outputDirPath = null;
	List<IfStatement> ifStatementBin = new ArrayList<IfStatement>();
	List<ForStatement> forsBin = new ArrayList<ForStatement>();
	List<WhileStatement> whilesBin = new ArrayList<WhileStatement>();
	float threshold;

	public ReverseCondition(CompilationUnit cu_, Document document_, String outputDirPath_, ArrayList targetLines, float threshold) {
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

		if(ifStatementBin.size() <= 0) {
			return;
		}
		AST ast = cu.getAST();
		ASTRewrite rewriter = ASTRewrite.create(ast);

		Collections.shuffle(ifStatementBin);
		int K = Math.max(1,(int)(threshold*ifStatementBin.size()));

		ifStatementBin =  ifStatementBin.subList(0,K);


		for(IfStatement ifer: ifStatementBin){
			IfStatement newifer = (IfStatement) ASTNode.copySubtree(ast,ifer);
			Expression theexp = (Expression) ASTNode.copySubtree(ast, ifer.getExpression());
			ParenthesizedExpression psizedexp = ast.newParenthesizedExpression();
			psizedexp.setExpression(theexp);

			PrefixExpression notexp = ast.newPrefixExpression();
			notexp.setOperator(Operator.toOperator("!"));
			notexp.setOperand(psizedexp);
			newifer.setExpression(notexp);

			rewriter.replace(ifer, newifer, null);
		}

//		for(ForStatement forer: forsBin){
//			ForStatement nfor = (ForStatement) ASTNode.copySubtree(ast,forer);
//			Expression theexp = (Expression) ASTNode.copySubtree(ast, forer.getExpression());
//			ParenthesizedExpression psizedexp = ast.newParenthesizedExpression();
//			psizedexp.setExpression(theexp);
//
//			PrefixExpression notexp = ast.newPrefixExpression();
//			notexp.setOperator(Operator.toOperator("!"));
//			notexp.setOperand(psizedexp);
//			nfor.setExpression(notexp);
//
//			rewriter.replace(forer, nfor, null);
//		}
//		for(WhileStatement whiler: whilesBin){
//			WhileStatement nWhile = (WhileStatement) ASTNode.copySubtree(ast,whiler);
//			Expression theexp = (Expression) ASTNode.copySubtree(ast, whiler.getExpression());
//			ParenthesizedExpression psizedexp = ast.newParenthesizedExpression();
//			psizedexp.setExpression(theexp);
//
//			PrefixExpression notexp = ast.newPrefixExpression();
//			notexp.setOperator(Operator.toOperator("!"));
//			notexp.setOperand(psizedexp);
//			System.out.println(notexp);
//			nWhile.setExpression(notexp);
//
//
//			rewriter.replace(whiler, nWhile, null);
//		}

		TextEdit edits = rewriter.rewriteAST(document, null);
		Utils.applyRewrite(edits, document,outputDirPath);
	}
}
