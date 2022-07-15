// Generated from gt/edu/usac/compiler/CoolGramatica.g4 by ANTLR 4.10.1
package gt.edu.usac.compiler;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CoolGramaticaParser}.
 */
public interface CoolGramaticaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code repeticionClase}
	 * labeled alternative in {@link CoolGramaticaParser#sintactico}.
	 * @param ctx the parse tree
	 */
	void enterRepeticionClase(CoolGramaticaParser.RepeticionClaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code repeticionClase}
	 * labeled alternative in {@link CoolGramaticaParser#sintactico}.
	 * @param ctx the parse tree
	 */
	void exitRepeticionClase(CoolGramaticaParser.RepeticionClaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code definirClase}
	 * labeled alternative in {@link CoolGramaticaParser#clase}.
	 * @param ctx the parse tree
	 */
	void enterDefinirClase(CoolGramaticaParser.DefinirClaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code definirClase}
	 * labeled alternative in {@link CoolGramaticaParser#clase}.
	 * @param ctx the parse tree
	 */
	void exitDefinirClase(CoolGramaticaParser.DefinirClaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code metodoClase}
	 * labeled alternative in {@link CoolGramaticaParser#contenido_clase}.
	 * @param ctx the parse tree
	 */
	void enterMetodoClase(CoolGramaticaParser.MetodoClaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code metodoClase}
	 * labeled alternative in {@link CoolGramaticaParser#contenido_clase}.
	 * @param ctx the parse tree
	 */
	void exitMetodoClase(CoolGramaticaParser.MetodoClaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableCLase}
	 * labeled alternative in {@link CoolGramaticaParser#contenido_clase}.
	 * @param ctx the parse tree
	 */
	void enterVariableCLase(CoolGramaticaParser.VariableCLaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableCLase}
	 * labeled alternative in {@link CoolGramaticaParser#contenido_clase}.
	 * @param ctx the parse tree
	 */
	void exitVariableCLase(CoolGramaticaParser.VariableCLaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parametroClase}
	 * labeled alternative in {@link CoolGramaticaParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametroClase(CoolGramaticaParser.ParametroClaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parametroClase}
	 * labeled alternative in {@link CoolGramaticaParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametroClase(CoolGramaticaParser.ParametroClaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code caseExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterCaseExpresion(CoolGramaticaParser.CaseExpresionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code caseExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitCaseExpresion(CoolGramaticaParser.CaseExpresionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dispatchDiExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterDispatchDiExpresion(CoolGramaticaParser.DispatchDiExpresionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dispatchDiExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitDispatchDiExpresion(CoolGramaticaParser.DispatchDiExpresionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code plusMinusExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterPlusMinusExpresion(CoolGramaticaParser.PlusMinusExpresionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code plusMinusExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitPlusMinusExpresion(CoolGramaticaParser.PlusMinusExpresionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bloqueExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterBloqueExpresion(CoolGramaticaParser.BloqueExpresionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bloqueExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitBloqueExpresion(CoolGramaticaParser.BloqueExpresionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isvoidExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterIsvoidExpresion(CoolGramaticaParser.IsvoidExpresionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isvoidExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitIsvoidExpresion(CoolGramaticaParser.IsvoidExpresionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nuevoTipoExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterNuevoTipoExpresion(CoolGramaticaParser.NuevoTipoExpresionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nuevoTipoExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitNuevoTipoExpresion(CoolGramaticaParser.NuevoTipoExpresionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterStringExpresion(CoolGramaticaParser.StringExpresionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitStringExpresion(CoolGramaticaParser.StringExpresionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cicloExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterCicloExpresion(CoolGramaticaParser.CicloExpresionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cicloExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitCicloExpresion(CoolGramaticaParser.CicloExpresionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code letExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterLetExpresion(CoolGramaticaParser.LetExpresionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitLetExpresion(CoolGramaticaParser.LetExpresionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code objetoTipoExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterObjetoTipoExpresion(CoolGramaticaParser.ObjetoTipoExpresionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code objetoTipoExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitObjetoTipoExpresion(CoolGramaticaParser.ObjetoTipoExpresionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterEqExpresion(CoolGramaticaParser.EqExpresionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitEqExpresion(CoolGramaticaParser.EqExpresionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code falseExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterFalseExpresion(CoolGramaticaParser.FalseExpresionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code falseExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitFalseExpresion(CoolGramaticaParser.FalseExpresionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multDivExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterMultDivExpresion(CoolGramaticaParser.MultDivExpresionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multDivExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitMultDivExpresion(CoolGramaticaParser.MultDivExpresionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterLtExpresion(CoolGramaticaParser.LtExpresionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitLtExpresion(CoolGramaticaParser.LtExpresionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code asignacionExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacionExpresion(CoolGramaticaParser.AsignacionExpresionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code asignacionExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacionExpresion(CoolGramaticaParser.AsignacionExpresionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterNegExpresion(CoolGramaticaParser.NegExpresionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitNegExpresion(CoolGramaticaParser.NegExpresionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trueExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterTrueExpresion(CoolGramaticaParser.TrueExpresionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trueExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitTrueExpresion(CoolGramaticaParser.TrueExpresionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code leExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterLeExpresion(CoolGramaticaParser.LeExpresionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code leExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitLeExpresion(CoolGramaticaParser.LeExpresionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parentesisExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterParentesisExpresion(CoolGramaticaParser.ParentesisExpresionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parentesisExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitParentesisExpresion(CoolGramaticaParser.ParentesisExpresionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterIntExpresion(CoolGramaticaParser.IntExpresionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitIntExpresion(CoolGramaticaParser.IntExpresionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code condicionalExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterCondicionalExpresion(CoolGramaticaParser.CondicionalExpresionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code condicionalExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitCondicionalExpresion(CoolGramaticaParser.CondicionalExpresionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dispatchStExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterDispatchStExpresion(CoolGramaticaParser.DispatchStExpresionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dispatchStExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitDispatchStExpresion(CoolGramaticaParser.DispatchStExpresionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterNotExpresion(CoolGramaticaParser.NotExpresionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpresion}
	 * labeled alternative in {@link CoolGramaticaParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitNotExpresion(CoolGramaticaParser.NotExpresionContext ctx);
}