grammar Expr;
import CommonLexerRules;
/**使用嵌套，这样在不同的语言时候，可以使用不同的标识符，而在Expr.g4中是全部在一起**/

prog:   stat+;

stat:   expr NEWLINE
    |   ID '=' expr NEWLINE
    |   NEWLINE
    ;
expr:   expr ('*'|'/') expr
    |   expr ('+'|'-') expr
    |   INT
    |   ID
    |   '(' expr ')'
    ;
