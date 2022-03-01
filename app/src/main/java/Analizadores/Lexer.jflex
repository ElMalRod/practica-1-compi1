 package Analizadores;
import java.util.ArrayList;
import java.util.List;
import java_cup.runtime.*;
import Reportes.*;




%%

/*---------- 2da Area: Opciones y Declaraciones ----------*/

%public
%class Lexer
%cup
%cupdebug
%full
%line
%column

/*---------- Caracteres y Separadores ----------*/

SEPARADORES = [ \r\t\b\f\n]
ENTERO = [0-9]+
LETRA=[a-zA-Z]+
DECIMAL=[0-9]+"."[0-9]+ \
COMILLAS = \"([a-zA-Z]|(\s)|[0-9])+\"
COMENTARIO = "#"


/*---------- Reservadas ----------*/


DEF =  ("def" | "Def" )
BARRAS = ("Barras" )
PIE = ("Pie")
TITULO = "titulo"
EJEX = "ejex"
EJEY = "ejey"
ETIQUETAS = "etiquetas"
VALORES = "valores"
UNIR = "unir"
TIPO = "tipo"
TOTAL = "total"
EXTRA = "extra"
EJECUTAR = "Ejecutar"

CORCHETE_A = "["
CORCHETE_C = "]"
LLAVE_A = "{"
LLAVE_C = "}"
PARENTESIS_A = "("
PARENTESIS_C = ")"
DOSPUNTOS = ":"
PUNTOCOMA = ";"
PORCENTAJE = "Porcentaje"
CANTIDAD = "Cantidad"

SUMA = "+"
RESTA = "-"
MULTI = "*"
DIVISION = "/"
COMA = ","

%{
   	private ArrayList<ErrorToken> errorsList = new ArrayList<>();
%}

%{
   	private Symbol symbol(int type) {
           String lexeme = yytext();
           //System.out.printf("Token tipo %d, lexeme %s, en linea %d, columna %d\n", type, lexeme == null ? "" : lexeme, yyline + 1, yycolumn + 1);
           return new Symbol(type, new Token(lexeme, yyline + 1, yycolumn + 1));
       }

       private Symbol symbol(int type, String lexeme) {
           //System.out.printf("Token tipo %d, lexeme %s, en linea %d, columna %d\n", type, lexeme == null ? "" : lexeme, yyline + 1, yycolumn + 1);
           return new Symbol(type, new Token(lexeme, yyline + 1, yycolumn + 1));
       }

       private void error(String lexeme) {
          ErrorToken error = new ErrorToken(lexeme,yyline+1,yycolumn+1,"Simbolo no existe en el lenguaje","Lexico");
          System.out.printf("Lexema: %s Linea: %s Columna: %s Descripcion: %s",error.getLexeme(),error.getLine(),error.getColumn(),error.getDescripcion());
          errorsList.add(error);
       }

       public ArrayList<ErrorToken> getErrorsList(){
           return errorsList;
       }

%}

%init{
    errorList = new ArrayList();
%init}
%%
/*---------- 3ra Area: Reglas Lexicas ----------*/

<YYINITIAL> {
/*---------- SIMBOLOS ----------*/
	 {CORCHETE_A}
		{ return new symbol(CORCHETE_A, yyline + 1, yycolumn + 1, yytext());}
	 {CORCHETE_C}
		{ return new symbol(CORCHETE_C, yyline + 1, yycolumn + 1, yytext());}
	 {LLAVE_A}
		{ return new symbol(LLAVE_A, yyline + 1, yycolumn + 1,  yytext());}
	 {LLAVE_C}
		{ return new symbol(LLAVE_C, yyline + 1, yycolumn + 1, yytext());}
	 {PARENTESIS_A}
		{ return new symbol(PARENTESIS_A, yyline + 1, yycolumn + 1, yytext());}
	 {PARENTESIS_C}
		{ return new symbol(PARENTESIS_C, yyline + 1, yycolumn + 1, yytext());}
	 {DOSPUNTOS}
		{ return new symbol(DOSPUNTOS, yyline + 1, yycolumn + 1, yytext());}
	 {PUNTOCOMA}
	 	{ return new symbol(PUNTOCOMA, yyline + 1, yycolumn + 1, yytext());}
	 {COMA}
	 	{ return new symbol(COMA, yyline + 1, yycolumn + 1, yytext());}

/*---------- OPERADORES ----------*/
	 {SUMA}
		{ return new symbol(SUMA, yyline + 1, yycolumn + 1, yytext());}
	 {RESTA}
		{ return new symbol(RESTA, yyline + 1, yycolumn + 1, yytext());}
	 {MULTI}
		{ return new symbol(MULTI, yyline + 1, yycolumn + 1, yytext());}
	 {DIVISION}
		{ return new symbol(DIVISION, yyline + 1, yycolumn + 1, yytext());}

/*---------- RESERVADAS ----------*/
	 {DEF}
		{ return new symbol(DEF, yyline + 1, yycolumn + 1, yytext());}
	 {BARRAS}
		{ addGrafica(yytext()); return new symbol(BARRAS, yyline + 1, yycolumn + 1, yytext());}
	 {PIE}
		{addGrafica(yytext()); return new symbol(PIE, yyline + 1, yycolumn + 1, yytext());}
	 {TITULO}
		{ return new symbol(TITULO, yyline + 1, yycolumn + 1, yytext());}
	 {EJEX}
		{ return new symbol(EJEX, yyline + 1, yycolumn + 1, yytext());}
	 {EJEY}
		{ return new symbol(EJEY, yyline + 1, yycolumn + 1, yytext());}
	 {ETIQUETAS}
		{ return new symbol(ETIQUETAS, yyline + 1, yycolumn + 1, yytext());}
	 {VALORES}
		{ return new symbol(VALORES, yyline + 1, yycolumn + 1, yytext());}
	 {UNIR}
		{ return new symbol(UNIR, yyline + 1, yycolumn + 1, yytext());}
	 {TIPO}
		{ return new symbol(TIPO, yyline + 1, yycolumn + 1, yytext());}
	{PORCENTAJE}
    	{ return new symbol(PORCENTAJE, yyline + 1, yycolumn + 1, yytext());}
    {CANTIDAD}
    	{ return new symbol(CANTIDAD, yyline + 1, yycolumn + 1, yytext());}

	 {TOTAL}
		{ return new symbol(TOTAL, yyline + 1, yycolumn + 1, yytext());}
	 {EXTRA}
		{ return new symbol(EXTRA, yyline + 1, yycolumn + 1, yytext());}
	{EJECUTAR}
		{ return new symbol(EJECUTAR, yyline + 1, yycolumn + 1, yytext());}

/*---------- ADICIONALES ----------*/
	{COMILLAS}        
		{return new symbol( COMILLAS, yyline + 1, yycolumn + 1, yytext());}
	{ENTERO}
		 {return new symbol(ENTERO, yyline + 1, yycolumn + 1, yytext(), new Integer yytext()));}
	{DECIMAL}
		 {return new symbol(DECIMAL, yyline + 1, yycolumn + 1, yytext(), Double.valueOf(yytext()));}
	{LETRA}
		{ return new symbol(LETRA, yyline + 1, yycolumn + 1, yytext());}
	{SEPARADORES}
	 	{/* los ignoramos */}
	{COMENTARIO}
	 	{/* los ignoramos */}
}

/*--------- Error por cualquier otro simbolo ----------*/
[^]
		{ error(yytext()); return symbol(error,  yyline + 1, yycolumn + 1, yytext());}

<<EOF>>
		{ return symbol(EOF); }