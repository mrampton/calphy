grammar Calphy;

program
    :	(functionDefinition)*
    ;

functionDefinition
    :   type functionDeclarator '{' statement* '}'
    ;

functionDeclarator
    :   Identifier '(' parameterList ')'
    ;

statement
    :   '{' statement* '}'
    |   expression ';'
    |   iterationStatement
    |   selectionStatement
    |   declaration ';'
    |   assignStatement ';'
    |   returnStatement
    ;

iterationStatement
    :   'while' '(' expression ')' statement
    |   'do' statement 'while' '(' expression ')' ';'
    |   'for' '(' expression? ';' expression? ';' expression? ')' statement
    |   'for' '(' declaration expression? ';' expression? ')' statement
    ;

selectionStatement
    :   'if' '(' expression ')' statement ('else' statement)?
    ;

assignStatement
    :   Identifier '=' expression
    ;

returnStatement
    :   Return expression ';'
    ;

parameterList
    :   (parameter ',')* parameter?
    ;

parameter
    :   type? expression
    ;

declaration
    :   type Identifier
    |   type Identifier '=' expression
    ;

// expression is anything that can be assigned as the value of a variable
expression
    :   Identifier
    |   Number
    |   physicsQuantity
    |   StringLiteral+
    |   functionDeclarator
    |   expression '.' Identifier
    |   expression unaryOperator
    |   unaryOperator expression
    |   expression binaryOperator expression
    |   expression compareOperator expression
    |   expression logicOperator expression
    |   '(' expression ')'
    ;

physicsQuantity
    :   (Number | vector) '[' physicsUnit ']' 
    ;

vector
    :  '<' expression ',' expression '>'
    ;

// not complete
physicsUnit
    : 'g' | 'kg' | 
    | 'mg' | 'kg' | 's' | 'us' | 'ns' | 'ms'
    | 'm/s^2' | 'm/s'
    ;

binaryOperator
    :   '+' | '-' | '*' | '/' | '%'
    ;

unaryOperator
    :   '+' | '-' | '!' | '++' | '--'
    ;

compareOperator
    :   '>' | '<' | '==' | '<=' | '>=' | '!='
    ;

logicOperator
    :   '&&' | '||'
    ;

assignmentOperator
    :   '=' | '*=' | '/=' | '%=' | '+=' | '-='
    ;
	
type
    :   ('void'
    |   'char'
    |   'int'
    |   'float'
    |   'double'
    |   'boolean')
    |   physicsType
    ;

physicsType
    :   ('mass'
    |   'velocity'
    |   'acceleration'
    |   'displacement'
    |   'distance'
    |   'time'
    |   'force')
    |   physicsList
    ;

//TODO: should we make it a general typed list? 
physicsList
    :   ('massList'
    |   'velocityList'
    |   'accelerationList'
    |   'displacementList'
    |   'distanceList'
    |   'timeList')
    ;

//////////////////////////////////////////////////////////////
Break : 'break';
Char : 'char';
Continue : 'continue';
Do : 'do';
Else : 'else';
Float : 'float';
For : 'for';
If : 'if';
Int : 'int';
Return : 'return';
Struct : 'struct';
Void : 'void';
While : 'while';
Dot : '.';

Identifier
    :   IdentifierNondigit
        (   IdentifierNondigit
        |   Digit
        )*
    ;

Number
    :	Digit+ (Dot Digit+)?
    ;

fragment
IdentifierNondigit
    :   Nondigit
    |   UniversalCharacterName
    //|   // other implementation-defined characters...
    ;

fragment
Nondigit
    :   [a-zA-Z_]
    ;

fragment
Digit
    :   [0-9]
    ;

fragment
UniversalCharacterName
    :   '\\u' HexQuad
    |   '\\U' HexQuad HexQuad
    ;

fragment
HexQuad
    :   HexadecimalDigit HexadecimalDigit HexadecimalDigit HexadecimalDigit
    ;
	
fragment
HexadecimalDigit
    :   [0-9a-fA-F]
    ;

StringLiteral
	:   '"' SCharSequence? '"'
	|   '\'' SCharSequence? '\''
    ;

fragment
SCharSequence
    :   SChar+
    ;
fragment
SChar
    :   ~["\\\r\n]
    |   EscapeSequence
    ;

fragment
EscapeSequence
    :   SimpleEscapeSequence
    ;
fragment
SimpleEscapeSequence
    :   '\\' ['"?abfnrtv\\]
    ;

Whitespace
    :   [ \t]+
        -> skip
    ;

Newline
    :   (   '\r' '\n'?
        |   '\n'
        )
        -> skip
    ;

BlockComment
    :   '/*' .*? '*/'
        -> skip
    ;

LineComment
    :   '//' ~[\r\n]*
        -> skip
    ;
