package gt.edu.usac.compiler;/*
Copyright (c) 2000 The Regents of the University of California.
All rights reserved.

Permission to use, copy, modify, and distribute this software for any
purpose, without fee, and without written agreement is hereby granted,
provided that the above copyright notice and the following two
paragraphs appear in all copies of this software.

IN NO EVENT SHALL THE UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY FOR
DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES ARISING OUT
OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF THE UNIVERSITY OF
CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY WARRANTIES,
INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY
AND FITNESS FOR A PARTICULAR PURPOSE.  THE SOFTWARE PROVIDED HEREUNDER IS
ON AN "AS IS" BASIS, AND THE UNIVERSITY OF CALIFORNIA HAS NO OBLIGATION TO
PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS, OR MODIFICATIONS.
*/

import java_cup.runtime.Symbol;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.semantics.SymbolChecks;


import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

/** The parser driver class */
abstract class ParserAntlr4 {

	/** Reads lexed tokens from consosle, and outputs the parse tree */
    public static void main(String[] args) {

		FileReader file = null;
	try {
		String inputFile = args[0];
		FileInputStream inputStream = new FileInputStream(inputFile);
		ANTLRInputStream input = new ANTLRInputStream(inputStream);
	    CoolGramaticaLexer lexer = new CoolGramaticaLexer(input);
		CommonToken token;
		while ((token= (CommonToken) lexer.nextToken()).getType()!= TokenConstants.EOF) {
			Utilities.dumpToken(System.out, lexer.getLine(), token);
		}
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CoolGramaticaParser parser = new CoolGramaticaParser(tokens);
		ParseTree arbol = parser.sintactico();
		CoolVisitor cool = new CoolVisitor();
		cool.visit(arbol);

		System.out.println(cool.visit(arbol).toString());
/*
	    Symbol result = (Flags.parser_debug
			     ? arbol.debug_parse()
			     : parser.parse());
	    if (parser.omerrs > 0) {
		System.err.println("Compilation halted due to lex and parse errors");
		System.exit(1);
	    }
	    ((Program)result.value).dump_with_types(System.out, 0);*/
	} catch (Exception ex) {
	    ex.printStackTrace(System.err);
	    //Utilities.fatalError("Unexpected exception in parser");
	}
    }
}
