grammar Expr;

prog: stat+;

stat: expr NL
    | ID '=' expr NL
    | NL
    ;

expr: expr ('*'|'/') expr
    | expr ('+'|'-') expr
    | INT
    | ID
    | '(' expr ')'
    ;

ID: [a-zA-Z]+;
INT: [0-9]+;
NL: '\n';
WS: [ \t\r]+ -> skip;
