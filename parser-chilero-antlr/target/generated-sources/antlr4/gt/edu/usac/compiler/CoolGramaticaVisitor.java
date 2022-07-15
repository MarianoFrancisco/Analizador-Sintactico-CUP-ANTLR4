// Generated from gt/edu/usac/compiler/CoolGramatica.g4 by ANTLR 4.10.1
package gt.edu.usac.compiler;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CoolGramaticaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CoolGramaticaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code repeticionClase}
	 * labeled alternative in {@link CoolGramaticaParser#sintactico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeticionClase(CoolGramaticaParser.RepeticionClaseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code definirClase}
	 * labeled alternative in {@link CoolGramaticaParser#clase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinirClase(CoolGramaticaParser.DefinirClaseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code metodoClase}
	 * labeled alternative in {@link CoolGramaticaParser#contenido_clase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetodoClase(CoolGramaticaParser.MetodoClaseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableCLase}
	 * labeled alternative in {@link CoolGramaticaParser#contenido_clase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableCLase(CoolGramaticaParser.VariableCLaseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parametroClase}
	 * labeled alternative in {@link CoolGramaticaParser#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametroClase(CoolGramaticaParser.ParametroClaseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code caseExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseExpresion(CoolGramaticaParser.CaseExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dispatchDiExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDispatchDiExpresion(CoolGramaticaParser.DispatchDiExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code plusMinusExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusMinusExpresion(CoolGramaticaParser.PlusMinusExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bloqueExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloqueExpresion(CoolGramaticaParser.BloqueExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isvoidExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsvoidExpresion(CoolGramaticaParser.IsvoidExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nuevoTipoExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNuevoTipoExpresion(CoolGramaticaParser.NuevoTipoExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpresion(CoolGramaticaParser.StringExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cicloExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCicloExpresion(CoolGramaticaParser.CicloExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code letExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetExpresion(CoolGramaticaParser.LetExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code objetoTipoExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjetoTipoExpresion(CoolGramaticaParser.ObjetoTipoExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpresion(CoolGramaticaParser.EqExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseExpresion(CoolGramaticaParser.FalseExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multDivExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDivExpresion(CoolGramaticaParser.MultDivExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ltExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLtExpresion(CoolGramaticaParser.LtExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code asignacionExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacionExpresion(CoolGramaticaParser.AsignacionExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegExpresion(CoolGramaticaParser.NegExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueExpresion(CoolGramaticaParser.TrueExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code leExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeExpresion(CoolGramaticaParser.LeExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parentesisExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentesisExpresion(CoolGramaticaParser.ParentesisExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpresion(CoolGramaticaParser.IntExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code condicionalExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicionalExpresion(CoolGramaticaParser.CondicionalExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dispatchStExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDispatchStExpresion(CoolGramaticaParser.DispatchStExpresionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpresion(CoolGramaticaParser.NotExpresionContext ctx);
}