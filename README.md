Compilador CHILERO (segunda fase)
=================================

Al iniciar la tarea, su repositorio debe contener los siguientes archivos y directorios importantes:

* Makefile
* README.md
* lexer-chilero (igual a la fase número 1)
* parser-chilero-cup
* parser-chilero-antlr
* cooltests

`Makefile` contiene objetivos para compilar y ejecutar su programa. NO MODIFICAR.

`README.md` contiene esta información. 

`lexer-chilero/src/main/jflex/simpletokenizer.lex` es un archivo esqueleto para la especificación del analizador léxico. Deberá completarlo con su solución elaborada en la primera fase para su parser con CUP.

`parser-chilero-cup/src/main/cup/parser.cup` es un archivo esqueleto para la especificación del analizador sintáctico. El archivo ya contiene definiciones importantes para el funcionamiento del parser que deberá utilizar junto a su gramática.

`parser-chilero-antlr` es una copia de parser-chilero-cup. Deberá utilizar este proyecto Java como base y reemplazar CUP por ANTLR, para ello deberá efectuar modificaciones en el archivo pom.xml para soportar ANTLR 4, implementar su visitor/ listener y aprovechar las clases de la implementación original de UC Berkley que también son utilizadas en la versión CUP.

Dentro de `cooltests` encontrará dos programas de prueba:

1. `factloop.cl` es una calculadora de factorial previamente elaborada en el laboratorio.
3. `stack.cl` es una solución a la máquina de pila previamente elaborada en el laboratorio.


`mycoolccup` es un script de shell que une las fases del compilador que utiliza pipes de Unix en lugar de vincular estáticamente el código.  Si bien es ineficiente, esta arquitectura facilita la combinación y combinación los componentes que escribe con los del compilador del curso. NO MODIFICAR.


`mycoolcantlr` es un script de shell que une las fases del compilador que utiliza pipes de Unix en lugar de vincular estáticamente el código.  Si bien es ineficiente, esta arquitectura facilita la combinación y combinación los componentes que escribe con los del compilador del curso. NO MODIFICAR.

Tareas principales
------------------

1. Implemente el analizador sintáctico para CHILERO y COOL en el archivo `parser-chilero-cup/src/main/cup/parser.cup`.
2. Modifique el proyecto parser-chilero-antlr para soportar ANTLR 4 de forma similar al ejercicio elaborado en laboratorio. Luego implemente su solución en la carpeta `src/main/antlr4`
3. Reemplace las clases Parser (CUP y ANTLR) por una versión equivalente que utilice PicoCLI tanto para archivos como para cadenas a ser analizadas en modo interactivo
4. El día de la entrega/calificación su instructor le indicará algunas modificaciones con pruebas adicionales (programas en español, ejecuciones de parser en línea de comandos). El cual usted deberá aceptar para comprobar el análisis de su solución.

Note que el autograder proporcionado con este repositorio incluye únicamente pruebas sobre stack y factorial

Instrucciones de uso del makefile
---------------------------------

El archivo Makefile incluido en su repositorio presenta algunas tareas útiles que pueden ser invocadas directamente en la línea de comandos.

Para compilar su programa ejecute

> make compile

Para generar un script `lexer` que ejecute su analizador léxico, ejecute

> make lexer

Para generar un script `parser` que ejecute su analizador léxico versión CUP, ejecute

> make parsercup

Para generar un script `parser` que ejecute su analizador léxico versión ANTLR 4, ejecute

> make parserantlr

Para limpiar todo el proyecto ejecute:

> make clean

Así mismo existen cuatro fases adicionales que ejecutan en secuencia varios pasos para una prueba completa de su solución.

1. `make dofactorialcup` la cual limpia su proyecto, ejecuta la compilación, genera el lexer, el parser versión CUP y ejecuta una prueba del programa `factloop.cl`.
2. `make dofactorialantlr` la cual limpia su proyecto, ejecuta la compilación, genera el lexer, el parser versión ANTLR 4 y ejecuta una prueba del programa `factloop.cl`.
3. `make dostackcup` la cual limpia su proyecto, ejecuta la compilación, genera el lexer, el parser versión CUP y ejecuta una prueba del programa `stack.cl`.
4. `make dostackantlr` la cual limpia su proyecto, ejecuta la compilación, genera el lexer, el parser versión ANTLR y ejecuta una prueba del programa `stack.cl`.

Si cree que su analizador léxico es correcto (versión CUP), puede ejecutar `mycoolccup` el cual une SU analizador léxico con, SU analizador sintáctico (el cual haya generado con make pasercup), semánticos, generador de código y optimizador de cool. 

Si cree que su analizador léxico es correcto (versión ANTLR), puede ejecutar `mycoolcantlr` el cual une SU analizador léxico y sintáctico (el cual haya generado con make paserantlr), semánticos, generador de código y optimizador de cool. 

Si su analizador léxico se comporta de una manera inesperada, puede obtener errores en cualquier lugar, es decir, durante análisis sintáctico, durante el análisis semántico, durante la generación de código o solo cuando ejecuta el código producido en spim. 

¡Éxitos!

Redacción para segunda fase
---------------------------

1. ¿Que tipo de analizador es generado por CUP y por ANTLR?  
   El tipo de analizador para ANTLR es ``LL(*) top-down``, facilmente definido como un analizador
   donde se analiza de arriba hacia abajo, incluso de esta manera podemos saber que lo que este arriba tiene mayor precedencia que lo que esta abajo.  
   Para CUP es lo contrario a lo hecho con ANTLR, dado que es un analizador ``LALR bottom-up``, que empieza a leer de abajo hacia arriba.


2. En ANTLR existen dos formas para generar acciones a partir del arbol de parsing, ¿Cuál utilizó y porqué?  
   Para generar acciones, aunque no se considera su implementacion como 100% correcto dado que por cuestiones de tiempo no se
   implementó exitosamente la clase principal que reconozca los test, estableciendo esta aclaración, se utilizó ``Visitor`` , ya que con el listener, se recorre el arbol sintactico con walker, y se realiza acciones cada vez que entramos o sale de algo, un tanto tedioso a considerar, en cambio el visitor puede seguir haciendo acciones de un estado, 
   luego de ejecutar ese estado lo devolvemos hacia arriba y seguimos ejecutando, claro cada uno puede tener sus beneficios por distintos objetivos, en este caso se consideró que era mejor realizar el visitor.  


3. ¿Cúales requisitos debió cumplir su gramática para ser compatible con CUP?  
   Para la gramática compatible con CUP, se verifica el pom.xml y ya cuenta con el ``plugin de CUP``, por lo tanto se modifica el archivo de parser.cup, creando las respectivas producciones(se cambia la produccion por defecto ``class a clase`` por error en palabra reservada), no terminales y estableciendo ``precedencia`` y acciones, así mismo verificando que el lexer contenga %cup para compatibilidad con CUP.
   Seguidamente se tiene como objetivo modificar Parser.java, estableciendo compatibilidad de picocli, esto haciendo posible analizar individualmente y por archivos usando -f, para ello se creó una copia de dumptoken como pasarToken en Utilities.java, sólo que en lugar de imprimir, lo que hace es guardar el valor en un string, de esta manera se pasa a CoolTokenLexer y ejecuta el procedimiento correcto para generar el arbol.


4. ¿Cuáles requisitos debió cumplir su gramática para ser compatible con ANTLR?  
   Para que la gramática compatible con ANTLR, se agrega el plugin de ANTLR4, asi mismo se agrega la dependencia, ambas de org.antlr, y tienen que ir con la ``misma versión``, si se pone ``4.10.1`` en el plugin, tiene que ir 4.10.1 en la dependencia para evitar conflictos. Así mismo se cambia el nombre de la clase de ``Parser a ParserAntlr4`` y se cambia de cup a antlr4/gt/edu/usac/compiler, si no da conflitos por la clase definida por antlr4, y para que esté correctamente, se define 
   con los mismos nombres los token para el lexer que se usaron en jflex, así mismo cuando recibe un testo por ejemplo Clase, se modifique a class, dando por defecto algo funcional para cool, y posteriormente con las producciones se realiza parecido al manual donde se pueden usar regex para su resolución y se pone precedencia de mas importante va arriba, por último se crea una clase visitor para poder hacer acciones y se realizan las mismas acciones dependiendo de las posibilidades, usando ``cool-tree``.
# Analizador-Sintactico-CUP-ANTLR4
