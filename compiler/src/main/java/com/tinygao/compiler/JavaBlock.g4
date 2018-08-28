grammar JavaBlock;

file
    :   (functionDecl | varDecl)+
    ;

varDecl
    : type ID ('=' expr)? ';'
    ;

type
    : 'float' | 'int' | 'void'; // 用户定义的类型

expr
    :   ID '(' exprList? ')'
    |   expr '[' expr ']'
    |   '-' expr
    |   '!' expr
    |   expr '*' expr
    |   expr '==' expr
    |   expr ('+'|'-') expr
    |   ID
    |   INT
    |   '(' expr ')'
    ;

exprList
    :   expr (',' expr)*
    ;

functionDecl
    :   type ID '(' formalParameters? ')' block
    ;

formalParameters
    :   formalParameter (',' formalParameter)*
    ;

formalParameter
    :   type ID
    ;

block
    :   '{' stat* '}'
    ;

stat
    :   block
    |   varDecl
    |   'if' expr  stat  ('else' stat)?
    |   'return' expr? ';'
    |   expr '=' expr ';'
    |   expr ';'
    ;

ID  :   [a-zA-Z]+   ;
INT :   [0-9]+  ;


