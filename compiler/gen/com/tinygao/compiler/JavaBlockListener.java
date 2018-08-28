// Generated from E:/workspace/build-up/compiler/src/main/java/com/tinygao/compiler\JavaBlock.g4 by ANTLR 4.7
package com.tinygao.compiler;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JavaBlockParser}.
 */
public interface JavaBlockListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JavaBlockParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(JavaBlockParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaBlockParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(JavaBlockParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaBlockParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(JavaBlockParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaBlockParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(JavaBlockParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaBlockParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(JavaBlockParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaBlockParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(JavaBlockParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaBlockParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(JavaBlockParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaBlockParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(JavaBlockParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaBlockParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(JavaBlockParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaBlockParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(JavaBlockParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaBlockParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(JavaBlockParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaBlockParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(JavaBlockParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaBlockParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(JavaBlockParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaBlockParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(JavaBlockParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaBlockParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(JavaBlockParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaBlockParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(JavaBlockParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaBlockParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(JavaBlockParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaBlockParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(JavaBlockParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaBlockParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(JavaBlockParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaBlockParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(JavaBlockParser.StatContext ctx);
}