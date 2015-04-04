grammar Calphy;

primaryExpression
    :   Identifier
    |   StringLiteral+
    |   '(' expression ')'
    |   '(' compoundStatement ')' // Blocks (GCC extension)
    ;

postfixExpression
    :   primaryExpression
    |   postfixExpression '[' expression ']'
    |   postfixExpression '(' argumentExpressionList? ')'
    |   postfixExpression '.' Identifier
    |   postfixExpression '++'
    |   postfixExpression '--'
    |   '(' typeName ')' '{' initializerList '}'
    |   '(' typeName ')' '{' initializerList ',' '}'
    ;

argumentExpressionList
    :   assignmentExpression
    |   argumentExpressionList ',' assignmentExpression
    ;

unaryExpression
    :   postfixExpression
    |   '++' unaryExpression
    |   '--' unaryExpression
    ;

unaryOperator
    :   '+' | '-' | '!'
    ;

multiplicativeExpression
    :   unaryExpression
    |   multiplicativeExpression '*' unaryExpression
    |   multiplicativeExpression '/' unaryExpression
    |   multiplicativeExpression '%' unaryExpression
    ;
	
additiveExpression
    :   multiplicativeExpression
    |   additiveExpression '+' multiplicativeExpression
    |   additiveExpression '-' multiplicativeExpression
    ;
	
relationalExpression
    :   additiveExpression
    |   relationalExpression '<' additiveExpression
    |   relationalExpression '>' additiveExpression
    |   relationalExpression '<=' additiveExpression
    |   relationalExpression '>=' additiveExpression
    ;

equalityExpression
    :   relationalExpression
    |   equalityExpression '==' relationalExpression
    |   equalityExpression '!=' relationalExpression
    ;

andExpression
    :   equalityExpression
    |   andExpression '&' equalityExpression
    ;
	
logicalAndExpression
    :   andExpression
    |   logicalAndExpression '&&' andExpression
    ;

logicalOrExpression
    :   logicalAndExpression
    |   logicalOrExpression '||' logicalAndExpression
    ;

conditionalExpression
    :   logicalOrExpression ('?' expression ':' conditionalExpression)?
    ;
	
assignmentExpression
    :   conditionalExpression
    |   unaryExpression assignmentOperator assignmentExpression
    ;
	
assignmentOperator
    :   '=' | '*=' | '/=' | '%=' | '+=' | '-='
    ;
	
expression
    :   assignmentExpression
    |   expression ',' assignmentExpression
    ;
	
expressionStatement
    :   expression? ';'
    ;
	
compoundStatement
    :   '{' blockItemList? '}'
    ;

iterationStatement
    :   'while' '(' expression ')' statement
    |   'do' statement 'while' '(' expression ')' ';'
    |   'for' '(' expression? ';' expression? ';' expression? ')' statement
    |   'for' '(' declaration expression? ';' expression? ')' statement
    ;

blockItemList
    :   blockItem
    |   blockItemList blockItem
    ;

blockItem
    :   declaration
    |   statement
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
    |   '_Bool')
    |   structSpecifier
    |   typedefName
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
    |   directDeclarator? ':' conditionalExpression
    ;
	
directDeclarator
    :   Identifier
    |   '(' directDeclarator ')'
    |   directDeclarator '[' assignmentExpression? ']'
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
    :   assignmentExpression
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
    :   '[' conditionalExpression ']'
    |   '.' Identifier
    ;
	
statement
    :   compoundStatement
    |   expressionStatement
    |   iterationStatement
    ;

declaration
    :   declarationSpecifiers initDeclaratorList? ';'
    ;

declarationSpecifiers
    :   declarationSpecifier+
    ;

declarationSpecifiers2
    :   declarationSpecifier+
    ;
	
declarationSpecifier
    :	typeSpecifier
    |   functionSpecifier
    ;

initDeclaratorList
    :   initDeclarator
    |   initDeclaratorList ',' initDeclarator
    ;

initDeclarator
    :   directDeclarator
    |   directDeclarator '=' initializer
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
    :   declarationSpecifiers directDeclarator
    |   declarationSpecifiers2
    ;
	
functionSpecifier
    :   ('inline')
    ;
	
functionDefinition
    :   declarationSpecifiers? directDeclarator declarationList? compoundStatement
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
Inline : 'inline';
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