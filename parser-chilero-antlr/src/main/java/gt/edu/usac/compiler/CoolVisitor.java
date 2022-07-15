package gt.edu.usac.compiler;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class CoolVisitor extends CoolGramaticaBaseVisitor<Object> {
    AbstractSymbol curr_filename() {
        return null;
    }
    @Override
    public Classes visitRepeticionClase(CoolGramaticaParser.RepeticionClaseContext ctx) {
        if(ctx.clase() != null) {
            Classes nuevaClase = new Classes(ctx.getStart().getLine());
            for (int i=0; i<ctx.clase().size(); i++) {
                nuevaClase.appendElement((class_c)visit(ctx.clase(i)));
            }
            return nuevaClase;
        }else{
            return null;
        }
    }

    @Override
    public class_c visitDefinirClase(CoolGramaticaParser.DefinirClaseContext ctx) {
        if(ctx.INHERITS() != null){
            if(ctx.SEMI() != null){
                Features features = new Features(ctx.getStart().getLine());
                for (int i=0; i<ctx.contenido_clase().size(); i++){
                    features.appendElement((Feature)visit(ctx.contenido_clase(i)));
                }
                return new class_c(ctx.getStart().getLine(),
                        AbstractTable.idtable.addString(ctx.TYPEID(0).getText()),
                        AbstractTable.idtable.addString(ctx.TYPEID(1).getText()),
                        features, curr_filename());

            }else{
                return new class_c(ctx.getStart().getLine(),
                        AbstractTable.idtable.addString(ctx.TYPEID(0).getText()),
                        AbstractTable.idtable.addString(ctx.TYPEID(1).getText()),
                        new Features(ctx.getStart().getLine()), curr_filename());
            }
        }else{
            if(ctx.SEMI() != null){
                Features features = new Features(ctx.getStart().getLine());
                for (int i=0; i<ctx.contenido_clase().size(); i++){
                    features.appendElement((Feature)visit(ctx.contenido_clase(i)));
                }
                return new class_c(ctx.getStart().getLine(),
                        AbstractTable.idtable.addString(ctx.TYPEID(0).getText()),
                        AbstractTable.idtable.addString("Object"),
                        features, curr_filename());

            }else{
                return new class_c(ctx.getStart().getLine(),
                        AbstractTable.idtable.addString(ctx.TYPEID(0).getText()),
                        AbstractTable.idtable.addString("Object"),
                        new Features(ctx.getStart().getLine()), curr_filename());
            }
        }
    }

    @Override
    public Feature visitMetodoClase(CoolGramaticaParser.MetodoClaseContext ctx) {
        if(ctx.parametro().size()==0){
            return new method(ctx.getStart().getLine(),AbstractTable.idtable.addString(ctx.OBJECTID().getText()),
                    new Formals(ctx.getStart().getLine()),AbstractTable.idtable.addString(ctx.TYPEID().getText()),
                    (Expression)visit(ctx.expresion()));
        }else{
            Formals formals = new Formals(ctx.getStart().getLine());
            for (int i=0; i<ctx.parametro().size(); i++) {
                formals.appendElement((formalc) visit(ctx.parametro(i)));
            }
            return new method(ctx.getStart().getLine(),AbstractTable.idtable.addString(ctx.OBJECTID().getText()),
                    formals,AbstractTable.idtable.addString(ctx.TYPEID().getText()),
                    (Expression)visit(ctx.expresion()));
        }
    }

    @Override
    public Feature visitVariableCLase(CoolGramaticaParser.VariableCLaseContext ctx) {
        if (ctx.expresion() != null) {
            return new attr(ctx.getStart().getLine(), AbstractTable.idtable.addString(ctx.OBJECTID().getText()),
                    AbstractTable.idtable.addString(ctx.TYPEID().getText()),
                    (Expression) visit(ctx.expresion()));

        } else {
            return new attr(ctx.getStart().getLine(),AbstractTable.idtable.addString(ctx.OBJECTID().getText()),
                    AbstractTable.idtable.addString(ctx.TYPEID().getText()),
                    new no_expr(ctx.getStart().getLine()));
        }
    }

    @Override
    public formalc visitParametroClase(CoolGramaticaParser.ParametroClaseContext ctx) {
        return new formalc(ctx.getStart().getLine(),AbstractTable.idtable.addString(ctx.OBJECTID().getText()),AbstractTable.idtable.addString(ctx.TYPEID().getText()));
    }

    @Override
    public Expression visitCaseExpresion(CoolGramaticaParser.CaseExpresionContext ctx) {
        Cases newCase = new Cases(ctx.getStart().getLine());
        for (int i=0; i<ctx.expresion().size();i++){
            newCase.appendElement(new branch(ctx.getStart().getLine(),
                    AbstractTable.idtable.addString(ctx.TYPEID(i).getText()),
                    AbstractTable.idtable.addString(ctx.OBJECTID(i).getText()),
                    (Expression) visit(ctx.expresion(i))));
        }
        return new typcase(ctx.getStart().getLine(), (Expression) ctx.expresion(), newCase);
    }

    @Override
    public Expression visitDispatchDiExpresion(CoolGramaticaParser.DispatchDiExpresionContext ctx) {
        AbstractSymbol aS=AbstractTable.idtable.addString("self");
        if(ctx.expresion().size()==0){
            return new dispatch(ctx.getStart().getLine(),new object(ctx.getStart().getLine(),aS),
                    AbstractTable.idtable.addString(ctx.OBJECTID().getText()),
                    new Expressions(ctx.getStart().getLine()));
        }else{
            Expressions nuevaExpresion=new Expressions(ctx.getStart().getLine());
            for (int i=0;i<ctx.expresion().size();i++){
                nuevaExpresion.appendElement((Expression) visit(ctx.expresion(i)));
            }
            return new dispatch(ctx.getStart().getLine(),new object(ctx.getStart().getLine(),aS),
                    AbstractTable.idtable.addString(ctx.OBJECTID().getText()),
                    nuevaExpresion);
        }
    }

    @Override
    public Expression visitPlusMinusExpresion(CoolGramaticaParser.PlusMinusExpresionContext ctx) {
        if (ctx.op.getType()== CoolGramaticaParser.PLUS) {
            return new plus(ctx.getStart().getLine(), (Expression) visit(ctx.expresion(0)), (Expression) visit(ctx.expresion(1)));
        }else{
            return new sub(ctx.getStart().getLine(), (Expression) visit(ctx.expresion(0)), (Expression) visit(ctx.expresion(1)));
        }
    }

    @Override
    public Expression visitBloqueExpresion(CoolGramaticaParser.BloqueExpresionContext ctx) {
        Expressions nuevaExpresion = new Expressions(ctx.getStart().getLine());
        for (int i=0;i<ctx.expresion().size();i++){
            nuevaExpresion.appendElement((Expression) visit(ctx.expresion(i)));
        }
        return new block(ctx.getStart().getLine(),nuevaExpresion);


    }

    @Override
    public Expression visitIsvoidExpresion(CoolGramaticaParser.IsvoidExpresionContext ctx) {
        return new isvoid(ctx.getStart().getLine(), (Expression) visit(ctx.expresion()));
    }

    @Override
    public Expression visitNuevoTipoExpresion(CoolGramaticaParser.NuevoTipoExpresionContext ctx) {
        return new new_(ctx.getStart().getLine(), AbstractTable.idtable.addString(ctx.TYPEID().getText()));
    }

    @Override
    public Expression visitStringExpresion(CoolGramaticaParser.StringExpresionContext ctx) {
        return new string_const(ctx.getStart().getLine(), AbstractTable.stringtable.addString(ctx.STR_CONST().getText()));
    }

    @Override
    public Expression visitCicloExpresion(CoolGramaticaParser.CicloExpresionContext ctx) {
        return new loop(ctx.getStart().getLine(), (Expression) visit(ctx.expresion(0)),(Expression) visit(ctx.expresion(1)));
    }

    @Override
    public Expression visitLetExpresion(CoolGramaticaParser.LetExpresionContext ctx) {
        if(ctx.COMMA()!=null){
            return null;
        }else{
            if(ctx.ASSIGN()!=null){
                return new let(ctx.getStart().getLine(),AbstractTable.idtable.addString(ctx.OBJECTID(0).getText())
                        ,AbstractTable.idtable.addString(ctx.TYPEID(0).getText())
                        ,(Expression) visit(ctx.expresion(0)),(Expression) visit(ctx.expresion(1)));
            }else{
                return new let(ctx.getStart().getLine(),AbstractTable.idtable.addString(ctx.OBJECTID(0).getText())
                        ,AbstractTable.idtable.addString(ctx.TYPEID(0).getText())
                        ,new no_expr(ctx.getStart().getLine()),(Expression) visit(ctx.expresion(1)));
            }

        }
    }

    @Override
    public Expression visitObjetoTipoExpresion(CoolGramaticaParser.ObjetoTipoExpresionContext ctx) {
        return new object(ctx.getStart().getLine(), AbstractTable.idtable.addString(ctx.OBJECTID().getText()));
    }

    @Override
    public Expression visitEqExpresion(CoolGramaticaParser.EqExpresionContext ctx) {
        return new eq(ctx.getStart().getLine(),(Expression) visit(ctx.expresion(0)),(Expression) visit(ctx.expresion(1)));
    }

    @Override
    public Expression visitFalseExpresion(CoolGramaticaParser.FalseExpresionContext ctx) {
        return new bool_const(ctx.getStart().getLine(), false);
    }

    @Override
    public Expression visitMultDivExpresion(CoolGramaticaParser.MultDivExpresionContext ctx) {
        if (ctx.op.getType()== CoolGramaticaParser.MULT) {
            return new mul(ctx.getStart().getLine(), (Expression) visit(ctx.expresion(0)), (Expression) visit(ctx.expresion(1)));
        }else{
            return new divide(ctx.getStart().getLine(), (Expression) visit(ctx.expresion(0)), (Expression) visit(ctx.expresion(1)));
        }
    }

    @Override
    public Expression visitLtExpresion(CoolGramaticaParser.LtExpresionContext ctx) {
        return new lt(ctx.getStart().getLine(), (Expression) visit(ctx.expresion(0)), (Expression) visit(ctx.expresion(1)));
    }

    @Override
    public Expression visitAsignacionExpresion(CoolGramaticaParser.AsignacionExpresionContext ctx) {
        return new assign(ctx.getStart().getLine(),AbstractTable.idtable.addString(ctx.OBJECTID().getText()),(Expression) visit(ctx.expresion()));
    }

    @Override
    public Expression visitNegExpresion(CoolGramaticaParser.NegExpresionContext ctx) {
        return new neg(ctx.getStart().getLine(), (Expression) visit(ctx.expresion()));
    }

    @Override
    public Expression visitTrueExpresion(CoolGramaticaParser.TrueExpresionContext ctx) {
        return new bool_const(ctx.getStart().getLine(), true);
    }

    @Override
    public Expression visitLeExpresion(CoolGramaticaParser.LeExpresionContext ctx) {
        return new leq(ctx.getStart().getLine(), (Expression) visit(ctx.expresion(0)), (Expression) visit(ctx.expresion(1)));
    }

    @Override
    public Expression visitParentesisExpresion(CoolGramaticaParser.ParentesisExpresionContext ctx) {
        return (Expression) visit(ctx.expresion());
    }

    @Override
    public Expression visitIntExpresion(CoolGramaticaParser.IntExpresionContext ctx) {
        return new int_const(ctx.getStart().getLine(), AbstractTable.inttable.addString(ctx.INT_CONST().getText()));
    }

    @Override
    public Expression visitCondicionalExpresion(CoolGramaticaParser.CondicionalExpresionContext ctx) {
        return new cond(ctx.getStart().getLine(), (Expression) visit(ctx.expresion(0)), (Expression) visit(ctx.expresion(1)), (Expression) visit(ctx.expresion(2)));
    }

    @Override
    public Expression visitDispatchStExpresion(CoolGramaticaParser.DispatchStExpresionContext ctx) {
        if(ctx.TYPEID()!=null){
            if(ctx.expresion().size()==1){
                return new static_dispatch(ctx.getStart().getLine(),(Expression) visit(ctx.expresion(0)),
                        AbstractTable.idtable.addString(ctx.TYPEID().getText()),
                        AbstractTable.idtable.addString(ctx.OBJECTID().getText()),
                        new Expressions(ctx.getStart().getLine()));
            }else{
                Expressions nuevaExpresion=new Expressions(ctx.getStart().getLine());
                for (int i=1;i<ctx.expresion().size();i++){
                    nuevaExpresion.appendElement((Expression) visit(ctx.expresion(i)));
                }
                return new static_dispatch(ctx.getStart().getLine(),(Expression) visit(ctx.expresion(0)),
                        AbstractTable.idtable.addString(ctx.TYPEID().getText()),
                        AbstractTable.idtable.addString(ctx.OBJECTID().getText()),
                        nuevaExpresion);
            }
        }else{
            if(ctx.expresion().size()==1){
                return new dispatch(ctx.getStart().getLine(),(Expression) visit(ctx.expresion(0)),
                        AbstractTable.idtable.addString(ctx.OBJECTID().getText()),
                        new Expressions(ctx.getStart().getLine()));
            }else{
                Expressions nuevaExpresion=new Expressions(ctx.getStart().getLine());
                for (int i=1;i<ctx.expresion().size();i++){
                    nuevaExpresion.appendElement((Expression) visit(ctx.expresion(i)));
                }
                return new dispatch(ctx.getStart().getLine(),(Expression) visit(ctx.expresion(0)),
                        AbstractTable.idtable.addString(ctx.OBJECTID().getText()),
                        nuevaExpresion);
            }

        }
    }

    @Override
    public Expression visitNotExpresion(CoolGramaticaParser.NotExpresionContext ctx) {
        return new comp(ctx.getStart().getLine(), (Expression) visit(ctx.expresion()));
    }
}
