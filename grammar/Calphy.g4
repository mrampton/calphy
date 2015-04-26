grammar Calphy;

program
	:	functionDefinition
	|	functionDefinition+ functionDefinition
	;

	
expression
    :   Identifier
    |   StringLiteral+
    |	Number
    |   '(' expression ')'
    |   '<' physicsVector '>' physicsUnit?
    |   expression physicsUnit
    |   expression '[' expression ']'
    |   expression '(' expression? ')'
    |   expression '.' Identifier
    |   expression '++'
    |   expression '--'
    |   '++' expression
    |   '--' expression
    |   expression '*' expression
    |   expression '/' expression
    |   expression '%' expression
    |   expression '+' expression
    |   expression '-' expression
    |   expression '<' expression
    |   expression '>' expression
    |   expression '<=' expression
    |   expression '>=' expression
    |   expression '==' expression
    |   expression '!=' expression
    |   expression '&&' expression
    |   expression '||' expression
	// expression below might be best left with only 
	// the original unaryExpression contents
    |   expression assignmentOperator expression
    |   expression ',' expression
    ;

physicsVector
    :   expression ',' expression
    ;

physicsUnit
    :   ('[' Whitespace? unitPrefix? 'g' Whitespace? ']'
    |   '[' Whitespace? unitPrefix? 's' Whitespace? ']'
    |   '[' Whitespace? 'm/s' Whitespace? ']'
    |   '[' Whitespace? 'm/s^2' Whitespace? ']'
    |   '[' Whitespace? unitPrefix?'N' Whitespace? ']'
    |   '[' Whitespace? unitPrefix? 'm' Whitespace? ']'
    |   '[' Whitespace? unitPrefix? 'W' Whitespace? ']'
    |   '[' Whitespace? unitPrefix? 'J' Whitespace? ']')
    ;

unitPrefix
    :   ('n'
    |   'u'
    |   'm'
    |   'k'
    |   'M'
    |   'G')
    ;

unaryOperator
    :   '+' | '-' | '!'
    ;

	
assignmentOperator
    :   '=' | '*=' | '/=' | '%=' | '+=' | '-='
    ;
	
iterationStatement
    :   'while' '(' expression ')' statement
    |   'do' statement 'while' '(' expression ')' ';'
    |   'for' '(' expression? ';' expression? ';' expression? ')' statement
    |   'for' '(' declaration expression? ';' expression? ')' statement
    ;

blockItemList
    :   declaration
    |   statement
    |   blockItemList blockItemList
    ;
	
typeName
    :   specifierQualifierList
    ;
	
specifierQualifierList
    :   typeSpecifier specifierQualifierList?
    ;
	
	
typeSpecifier
    :   ('void'
    |   'char'
    |   'int'
    |   'float'
    |   'double'
    |   '_Bool')
    |   physicsSpecifier
    |   structSpecifier
    |   typedefName
    ;

physicsSpecifier
    :   ('mass'
    |   'velocity'
    |   'acceleration'
    |   'displacement'
    |   'distance'
    |   'time')
    |   physicsList
    ;

physicsList
    :   ('massList'
    |   'velocityList'
    |   'accelerationList'
    |   'displacementList'
    |   'distanceList'
    |   'timeList')
    ;

structSpecifier
    :   struct Identifier? '{' structDeclarationList '}'
    |   struct Identifier
    ;
	
struct
    :   'struct'
    ;
	
structDeclarationList
    :   structDeclaration
    |   structDeclarationList structDeclaration
    ;

structDeclaration
    :   specifierQualifierList structDeclaratorList? ';'
    ;

structDeclaratorList
    :   structDeclarator
    |   structDeclaratorList ',' structDeclarator
    ;

structDeclarator
    :   directDeclarator
    |   directDeclarator? ':' expression
    ;
	
directDeclarator
    :   Identifier
    |   '(' directDeclarator ')'
    |   directDeclarator '[' expression? ']'
    |   directDeclarator '(' parameterTypeList ')'
    |   directDeclarator '(' identifierList? ')'
    ;

identifierList
    :   Identifier
    |   identifierList ',' Identifier
    ;

typedefName
    :   Identifier
    ;

initializer
    :   expression
    |   '{' initializerList '}'
    |   '{' initializerList ',' '}'
    ;

initializerList
    :   designation? initializer
    |   initializerList ',' designation? initializer
    ;

designation
    :   designatorList '='
    ;

designatorList
    :   designator
    |   designatorList designator
    ;

designator
    :   '[' expression ']'
    |   '.' Identifier
    ;
	
statement
    :   '{' blockItemList? '}'
    |   expression? ';'
    |   iterationStatement
    ;

declaration
    :   typeSpecifier+ initDeclaratorList? ';'
    ;

/*
declarationSpecifiers
    :   typeSpecifier+
    ;
*/
	
initDeclaratorList
    :   initDeclarator
    |   initDeclaratorList ',' initDeclarator
    ;

initDeclarator
    :   directDeclarator
    |   directDeclarator '=' typeCast? initializer
    ;

typeCast
    :   '(' typeSpecifier ')'
    ;

parameterTypeList
    :   parameterList
    |   parameterList ',' '...'
    ;

parameterList
    :   parameterDeclaration
    |   parameterList ',' parameterDeclaration
    ;

parameterDeclaration
    :   typeSpecifier+ directDeclarator
    ;
	
functionDefinition
    :   typeSpecifier+? directDeclarator declarationList? '{' blockItemList? '}'
    ;

declarationList
    :   declaration
    |   declarationList declaration
    ;
	
	
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

Bool : '_Bool';

LeftParen : '(';
RightParen : ')';
LeftBracket : '[';
RightBracket : ']';
LeftBrace : '{';
RightBrace : '}';

Less : '<';
LessEqual : '<=';
Greater : '>';
GreaterEqual : '>=';

Plus : '+';
PlusPlus : '++';
Minus : '-';
MinusMinus : '--';
Star : '*';
Div : '/';
Mod : '%';

AndAnd : '&&';
OrOr : '||';
Not : '!';

Question : '?';
Colon : ':';
Semi : ';';
Comma : ',';

Assign : '=';
// '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|='
StarAssign : '*=';
DivAssign : '/=';
ModAssign : '%=';
PlusAssign : '+=';
MinusAssign : '-=';

Equal : '==';
NotEqual : '!=';

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

LineDirective
    :   '#' Whitespace? Whitespace? StringLiteral ~[\r\n]*
        -> skip
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
