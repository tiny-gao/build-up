// Generated from E:/workspace/build-up/compiler/src/main/java/com/tinygao/compiler\JavaBlock.g4 by ANTLR 4.7
package com.tinygao.compiler;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JavaBlockParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JavaBlockVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JavaBlockParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(JavaBlockParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaBlockParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(JavaBlockParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaBlockParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(JavaBlockParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaBlockParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(JavaBlockParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaBlockParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(JavaBlockParser.ExprListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaBlockParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(JavaBlockParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaBlockParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(JavaBlockParser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaBlockParser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(JavaBlockParser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaBlockParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(JavaBlockParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaBlockParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(JavaBlockParser.StatContext ctx);
}