package transform.refactor;

import org.eclipse.jdt.core.dom.*;
import org.eclipse.jdt.core.dom.PrefixExpression.Operator;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jdt.core.dom.rewrite.ListRewrite;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.TextEdit;
import transform.Utils;

import java.util.ArrayList;

public class RemoveControlStatement extends ASTVisitor{
	ArrayList targetLines;
	CompilationUnit cu = null;
	Document document = null;
	String outputDirPath = null;
	ArrayList<IfStatement> ifStatementBin = new ArrayList<IfStatement>();
	ArrayList<ForStatement> forsBin = new ArrayList<ForStatement>();
	ArrayList<WhileStatement> whilesBin = new ArrayList<WhileStatement>();


	public RemoveControlStatement(CompilationUnit cu_, Document document_, String outputDirPath_, ArrayList targetLines) {
		this.cu = cu_;
		this.document = document_;
		this.outputDirPath = outputDirPath_;
		this.targetLines = targetLines;
	}


	public boolean visit(IfStatement node) {
		if(Utils.checkTargetLines(this.targetLines, this.cu, node)){
			ifStatementBin.add(node);
		}
		return true;
	}
	public boolean visit(ForStatement node) {
		//Visit all for-loop statement
		if(Utils.checkTargetLines(targetLines, cu, node)){
			forsBin.add(node);
		}
		return true;
	}
	public boolean visit(WhileStatement node) {
		//visit while-loop statements
		if(Utils.checkTargetLines(targetLines, cu, node)){
			whilesBin.add(node);
		}
		return true;
	}
	
	public void endVisit(CompilationUnit node) {
		AST ast = cu.getAST();
		ASTRewrite rewriter = ASTRewrite.create(ast);
//		for(ForStatement forer: forsBin){
//			Statement nfor = (Statement) ASTNode.copySubtree(ast,forer.getBody());
//			rewriter.replace(forer, nfor, null);
//		}
//		for(WhileStatement whiler: whilesBin){
//			Statement theexp = (Statement) ASTNode.copySubtree(ast, whiler.getBody());
//			rewriter.replace(whiler, theexp, null);
//		}
//		loop (for in for, for in while) is incorrect
		for(IfStatement ifer: ifStatementBin){
			//#dev //
//			Block blockoutsideWhile;
//			if(ifer.getParent().getNodeType() != ASTNode.BLOCK) {//we have to create a new block
//				blockoutsideWhile = ast.newBlock();
//				Statement tmp = (Statement) ASTNode.copySubtree(ast,ifer.getElseStatement());
//				blockoutsideWhile.statements().add(tmp);
//				rewriter.replace(ifer, blockoutsideWhile, null);
////				blockoutsideWhile.statements().add(whiler);
////				rewriter.replace(forer, blockoutsideWhile, null);
//			}
//			else {
//				blockoutsideWhile = (Block) ifer.getParent();
//				ListRewrite lrt2 = rewriter.getListRewrite(blockoutsideWhile, Block.STATEMENTS_PROPERTY);
////				blockoutsideWhile.statements().add(ifer.getElseStatement());
//				lrt2.insertBefore(ifer.getThenStatement(), ifer, null);
////				rewriter.replace(ifer, whiler, null);
//				rewriter.remove(ifer,null);
//			}
			//#dev //
//			if(true) continue;
//			System.out.println("ifff");
//			System.out.println(ifer);
			Statement thenStms = (Statement) ASTNode.copySubtree(ast,ifer.getThenStatement());
			Statement elseStms = (Statement) ASTNode.copySubtree(ast,ifer.getElseStatement());
			Block thenBlock = null;
			if(thenStms.getNodeType() != ASTNode.BLOCK) {
				thenBlock = ast.newBlock();
				thenBlock.statements().add(thenStms);
			}else {
				thenBlock = (Block)thenStms;

			}
			Block blocker = ast.newBlock();
			blocker.statements().add(thenBlock);

			if(elseStms != null) {
				Block elseBlock = null;
				if(elseStms.getNodeType() != ASTNode.BLOCK) {
					elseBlock = ast.newBlock();
					elseBlock.statements().add(elseStms);
				}else {
					elseBlock = (Block)elseStms;
				}
				blocker.statements().add(elseBlock);

			}


//			System.out.println(blocker);
			rewriter.replace(ifer, blocker, null);
		}
		TextEdit edits = rewriter.rewriteAST(document, null);
		Utils.applyRewrite(edits, document,outputDirPath);

	}
}
