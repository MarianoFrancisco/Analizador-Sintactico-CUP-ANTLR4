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
import picocli.CommandLine;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

/** The parser driver class */
@CommandLine.Command(name="Parser Cool-Chilero",mixinStandardHelpOptions = true,version="1.0.0",
		description = "Parser Cool programming language")
class Parser implements Callable<Integer> {
	@CommandLine.Option(names = {"-f","--file"}, description = "Archivo para leer",required = false)
	private File file;
	public void datos(String contenido){
		try {
			CoolTokenLexer lexer = new CoolTokenLexer(new StringReader(contenido));
			CoolParser parser = new CoolParser(lexer);
			Symbol result = (Flags.parser_debug
					? parser.debug_parse()
					: parser.parse());
			if (parser.omerrs > 0) {
				System.err.println("Compilation halted due to lex and parse errors");
				System.exit(1);
			}
			((Program) result.value).dump_with_types(System.out, 0);
		} catch (Exception ex) {
			ex.printStackTrace(System.err);
			Utilities.fatalError("Unexpected exception in parser");
		}
	}
	@Override
	public Integer call() throws Exception {
		if (file!=null){
			String contenido=null;
			BufferedReader bfr = Files.newBufferedReader(file.toPath());
			contenido="#name \"" + file.getName() + "\"";
			CoolLexer coolLexer = new CoolLexer(bfr);
			coolLexer.set_filename(file.getName());
			Symbol token;
			while ((token=coolLexer.next_token()).sym != TokenConstants.EOF) {
				contenido=contenido+"\n"+Utilities.pasarToken(coolLexer.get_curr_lineno(), token);
			}
			datos(contenido);
		}else{
			Scanner scanner = new Scanner(System.in);
			String contenido="";
			String input = "";
			while (!input.equals("salir")) {
				System.out.print("Ingresa tu cadena >");
				input = scanner.nextLine();
				if (input.equals("salir")){
					break;
				}
				contenido="#name \"" + "Cadena individual" + "\"";
				CoolLexer coolLexer = new CoolLexer(new StringReader(input));
				coolLexer.set_filename("Cadena individual");
				Symbol token;
				while ((token=coolLexer.next_token()).sym != TokenConstants.EOF) {
					contenido=contenido+"\n"+Utilities.pasarToken(coolLexer.get_curr_lineno(), token);
				}
				datos(contenido);
			}
		}
		return 0;
	}
    /** Reads lexed tokens from consosle, and outputs the parse tree */
    public static void main(String[] args) {
		if (args.length<1||args[0].equals("--help")||args[0].equals("-h")||args[0].equals("--file")||args[0].equals("-f")||args[0].equals("-V")||args[0].equals("--version")){
			int exitCode = new CommandLine(new Parser()).execute(args);
			System.exit(exitCode);
		} else {
			args = Flags.handleFlags(args);
			try {
				CoolTokenLexer lexer = new CoolTokenLexer(new InputStreamReader(System.in));
				CoolParser parser = new CoolParser(lexer);
				Symbol result = (Flags.parser_debug
						? parser.debug_parse()
						: parser.parse());
				if (parser.omerrs > 0) {
					System.err.println("Compilation halted due to lex and parse errors");
					System.exit(1);
				}
				((Program) result.value).dump_with_types(System.out, 0);
			} catch (Exception ex) {
				ex.printStackTrace(System.err);
				Utilities.fatalError("Unexpected exception in parser");
			}
		}
	}
}
