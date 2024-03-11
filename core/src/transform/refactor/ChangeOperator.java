package transform.refactor;

import org.eclipse.jdt.core.dom.*;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;
import transform.Utils;

import java.util.ArrayList;
import java.util.List;

//not done
public class ChangeOperator extends ASTVisitor{
	ArrayList targetLines;
	CompilationUnit cu = null;
	Document document = null;
	String outputDirPath = null;
	List<InfixExpression> relationStatementBin = new ArrayList<InfixExpression>();

	public ChangeOperator(CompilationUnit cu_, Document document_, String outputDirPath_, ArrayList targetLines) {
		this.cu = cu_;
		this.document = document_;
		this.outputDirPath = outputDirPath_;
		this.targetLines = targetLines;
	}


	public boolean visit(InfixExpression node) {
		if(node.getOperator().equals(InfixExpression.Operator.PLUS)
				|| node.getOperator().equals(InfixExpression.Operator.MINUS)
				|| node.getOperator().equals(InfixExpression.Operator.TIMES)
				|| node.getOperator().equals(InfixExpression.Operator.REMAINDER)
				|| node.getOperator().equals(InfixExpression.Operator.DIVIDE)) {
			if(Utils.checkTargetLines(this.targetLines, this.cu, node)){
				relationStatementBin.add(node);
			}
		}
		return true;
	}


	public InfixExpression.Operator getOppositeOperator(InfixExpression.Operator op){
		ArrayList<InfixExpression.Operator> ops = new ArrayList<>();
		ops.add(InfixExpression.Operator.PLUS);
		ops.add(InfixExpression.Operator.MINUS);
		ops.add(InfixExpression.Operator.TIMES);
		ops.add(InfixExpression.Operator.REMAINDER);
		ops.add(InfixExpression.Operator.DIVIDE);
		ops.remove(op);
		java.util.Random random = new java.util.Random();
		int op_index = random.nextInt(4);
		return ops.get(op_index);

	}

	public void endVisit(CompilationUnit node) {
		AST ast = cu.getAST();
		ASTRewrite rewriter = ASTRewrite.create(ast);

		if (relationStatementBin.size() == 0) {
			return;
		}
		for(InfixExpression equ : relationStatementBin) {
			InfixExpression copyedOne = (InfixExpression) ASTNode.copySubtree(ast, equ);
			InfixExpression.Operator op = getOppositeOperator(equ.getOperator());
			assert op != null;
			copyedOne.setOperator(op);
			rewriter.replace(equ, copyedOne, null);
		}
		TextEdit edits = rewriter.rewriteAST(document, null);
		Utils.applyRewrite(edits, document,outputDirPath);

	}
}
