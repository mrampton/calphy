import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.regex.*;

public class MyListener extends CalphyBaseListener{
  ParseTreeProperty<NodeProperty> treeProperty;
  ArrayList<Symbol> symbolTB;
  ReadTranslateTable transTable;

  public MyListener() {
	transTable = new ReadTranslateTable();
	treeProperty = new ParseTreeProperty<NodeProperty>();
	symbolTB = new ArrayList<Symbol>();
  }

  public class NodeProperty {
	public int symbolTBPointer; 
	public String value;
  }
  
  public class Symbol {
	public String type;
	public String name;
	public boolean vec;

	public Symbol(String n, String t, boolean b) {
      type = t;
      name = n; 
	  vec = b;
	}
	
	@Override
	public String toString() {
	  return name + " " + type + " " + Boolean.toString(vec);
	}
  }
 
  public Boolean isPhysicsType(String type) {
    type = type == null ? "" : type;
	Pattern p = Pattern.compile("(Mass|Acceleration|Velocity|Force|Energy|Power|Displacement)");
	Matcher m = p.matcher(type);
	return m.find();
  }
 
  public String getSymbolType(String _name) {
	for (int i = 0; i < symbolTB.size(); i++) {
	  Symbol s = symbolTB.get(i);
	  if (s.name.equals(_name)) {
		return s.type;
	  }
	} 
	return null;
  }
  
  public boolean getSymbolIsVec(String _name) {
	for (int i = 0; i < symbolTB.size(); i++) {
	  Symbol s = symbolTB.get(i);
	  if (s.name.equals(_name)) {
	    return s.vec;
	  }
    } 
	return false;
  }
  
  public void putSymbol(String name, String type, boolean isVec){
	for (Symbol s : symbolTB) {
	  if (s.name.equals(name)) {
		System.out.println("Duplicated symbol name: " + name);
        return;
	  }
	}
	symbolTB.add(new Symbol(name, type, isVec));
  }
  
  public String getChildValue(ParserRuleContext ctx, int id) {
	  if (ctx.getChild(id) == null || treeProperty.get(ctx.getChild(id)) == null) {
		return "";
	  }
	  return treeProperty.get(ctx.getChild(id)).value;
  }
  
  public String concatAllChildren(ParserRuleContext ctx) {
	int childCount = ctx.getChildCount();
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < childCount; i++) {
	  String childVal = getChildValue(ctx, i);
	  if (childVal.equals("{")) {
		sb.append("{\n");
	  } else if (i < childCount - 1) {
	    sb.append(childVal + " ");
	  } else {
		sb.append(childVal);
	  }
	}
	return sb.toString();
  }
  
  public boolean checkValidOp(String op, String a, String b) {
	return false;
  }
  
  public void throwCompileException(String info) {
    try {
      System.out.println("Calphy Compile Exception: " + info);
	  throw new Exception();
	} catch (Exception e) {
	  System.exit(0);
	}
  }
  
  // All parse rule actions are defined below:
	@Override public void enterProgram(CalphyParser.ProgramContext ctx) { 
	}
	
	@Override public void exitProgram(CalphyParser.ProgramContext ctx) {
	  String _Java_Program = "public class CalphyClass { \n" + 
			  			 concatAllChildren(ctx) + 
			  			 "\n}";
	  String _Java_str = concatAllChildren(ctx);
	  treeProperty.get(ctx).value = _Java_Program;
	  System.out.println(_Java_Program);
	}

	@Override public void enterFunctionDefinition(CalphyParser.FunctionDefinitionContext ctx) { 
	  ; // do nothing
	}

	@Override public void exitFunctionDefinition(CalphyParser.FunctionDefinitionContext ctx) {
	  String _Java_str = "public static " + concatAllChildren(ctx);
	  treeProperty.get(ctx).value = _Java_str;
	  int oldPointer = treeProperty.get(ctx).symbolTBPointer;
	  // pop the variables that are out of scope
	  while (symbolTB.size() > oldPointer) {
		symbolTB.remove(symbolTB.size() - 1);
	  }
	}

	@Override public void enterFunctionDeclarator(CalphyParser.FunctionDeclaratorContext ctx) {
      ; // do nothing      
	}

	@Override public void exitFunctionDeclarator(CalphyParser.FunctionDeclaratorContext ctx) {
	  treeProperty.get(ctx.getChild(0)).value = transTable.transList.get(ctx.getChild(0).getText());
	  String _Java_str = concatAllChildren(ctx) + "\n";
	  treeProperty.get(ctx).value = _Java_str;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStatement(CalphyParser.StatementContext ctx) {
 	}

	@Override public void exitStatement(CalphyParser.StatementContext ctx) {
	  if (! (ctx.getChild(0) instanceof CalphyParser.DeclarationContext) ) {	
		int oldPointer = treeProperty.get(ctx).symbolTBPointer;
		// pop the variables that are out of scope
		while (symbolTB.size() > oldPointer) {
		  symbolTB.remove(symbolTB.size() - 1);
		}
	  }
	  // block statement
	  if (getChildValue(ctx, ctx.getChildCount()-1).equals(";")){
	    treeProperty.get(ctx).value = concatAllChildren(ctx) + "\n";
	  } else {
		treeProperty.get(ctx).value = concatAllChildren(ctx); 
	  }
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIterationStatement(CalphyParser.IterationStatementContext ctx) { }
	
	@Override public void exitIterationStatement(CalphyParser.IterationStatementContext ctx) { 
	  String _Java_str = concatAllChildren(ctx);
	  treeProperty.get(ctx).value = _Java_str + "\n";
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSelectionStatement(CalphyParser.SelectionStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitSelectionStatement(CalphyParser.SelectionStatementContext ctx) { 
	  String _Java_str = concatAllChildren(ctx);
      treeProperty.get(ctx).value = _Java_str;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAssignStatement(CalphyParser.AssignStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAssignStatement(CalphyParser.AssignStatementContext ctx) { 
	  System.out.println("DEBUG: exitAssignStatement: " + concatAllChildren(ctx));
	  String var = getChildValue(ctx,0);
	  String op = getChildValue(ctx, 1);
	  String expression = getChildValue(ctx,2);
	   
	  String type = getSymbolType(var);
	  if (type == null) {
	    throwCompileException (var + " not declared");
	  }
	   
	  if (isPhysicsType(type)) {
	    if (op.equals("+="))
		  expression = new String(var + " = " + "_ADD(" + var + ", " + expression + ")");
		else if(op.equals("-="))
		  expression = new String(var + " = " + "_SUB(" + var + ", " + expression + ")"); 
		else if (op.equals("*="))
		  expression = new String(var + " = " + "_MULT(" + var + ", " + expression + ")"); 
		else if (op.equals("/="))
		  expression = new String(var + " = " + "_DIV(" + var + ", " + expression + ")"); 
		else
		  expression = new String(var + " = new " + type + "(" + expression + ")");
		treeProperty.get(ctx).value = expression;
		return;
	  }
	  treeProperty.get(ctx).value = concatAllChildren(ctx);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterReturnStatement(CalphyParser.ReturnStatementContext ctx) { }

	@Override public void exitReturnStatement(CalphyParser.ReturnStatementContext ctx) { 
	  String _Java_str = concatAllChildren(ctx);
	  treeProperty.get(ctx).value = _Java_str + "\n";
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterParameterList(CalphyParser.ParameterListContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitParameterList(CalphyParser.ParameterListContext ctx) { 
	  String _Java_str = concatAllChildren(ctx);
	  treeProperty.get(ctx).value = _Java_str;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterParameter(CalphyParser.ParameterContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitParameter(CalphyParser.ParameterContext ctx) { 
	  String _Java_str = concatAllChildren(ctx);
      treeProperty.get(ctx).value = _Java_str;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDeclaration(CalphyParser.DeclarationContext ctx) { }
	/*
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDeclaration(CalphyParser.DeclarationContext ctx) { 
	  String type = getChildValue(ctx,0);
	  String var = getChildValue(ctx,1);
	  String expression = getChildValue(ctx,3);
	  if (isPhysicsType(type)) {
	    expression = "new " + type + "(" + expression + ")";
	    treeProperty.get(ctx).value = type + " " + var + " = " + expression;
	    
	  } else {
	    treeProperty.get(ctx).value = concatAllChildren(ctx);
	  }
	  putSymbol(var, type, false);
	} 

	@Override public void enterExpression(CalphyParser.ExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	
	@Override public void exitExpression(CalphyParser.ExpressionContext ctx) {
	  // Process binary operation
	  System.out.println("DEBUG: exitExpression: " + concatAllChildren(ctx));
	  if (!getChildValue(ctx,1).isEmpty()) {
        String op = getChildValue(ctx,1);
        if (op.equals("_MULT") || op.equals("_DIV") || op.equals("_MOD") || op.equals("_ADD") || op.equals("_SUB")) {
          String _Java_str = op + "(" + getChildValue(ctx,0) + "," + getChildValue(ctx, 2) + ")";
          checkValidOp(op, getChildValue(ctx,0), getChildValue(ctx,2));
          treeProperty.get(ctx).value = _Java_str;
          return;
        } else {
		  treeProperty.get(ctx).value = concatAllChildren(ctx);
	    }
	  }
	  // Process unary operation
      if (ctx.getChild(0) instanceof CalphyParser.UnaryOperatorContext) {
    	ParserRuleContext expression = (ParserRuleContext)ctx.getChild(1);
        if (expression.getChild(0) instanceof CalphyParser.PhysicsQuantityContext) {
          throwCompileException("unary operator can't be applied to PhysicsQuantity");
        } else {
          String var = getChildValue(expression, 0);
          String type = getSymbolType(var);
          if (type!=null && isPhysicsType(type)) {
            throwCompileException("unary operator can't be applied to PhysicsQuantity");
          }
        }
      }
	  // otherwise, simply pass everything up 
	  treeProperty.get(ctx).value = concatAllChildren(ctx);
	}
	
	@Override public void exitMultDivMod(CalphyParser.MultDivModContext ctx) { 
	  String child = concatAllChildren(ctx);
	  String op = "";
	  if (child.equals("*")) {
		op = "_MULT";
	  } else if (child.equals("/")) {
		op = "_DIV";
	  } else if (child.equals("%")) {
		op = "_MOD";
	  } else {
		;  // should not get here
	  }
	  treeProperty.get(ctx).value = op;
	}
	
	@Override public void exitPlusMinus(CalphyParser.PlusMinusContext ctx) {
	  String child = concatAllChildren(ctx);
	  String op = "";
	  if (child.equals("+")) {
		op = "_ADD";
	  } else if (child.equals("-")) {
		op = "_SUB";
	  } else {
		;  // should not get here
	  }
	  treeProperty.get(ctx).value = op;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterPhysicsQuantity(CalphyParser.PhysicsQuantityContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPhysicsQuantity(CalphyParser.PhysicsQuantityContext ctx) { 
	try {
	  String _Java_str;
	  if (getChildValue(ctx,2).equals(""))
		_Java_str = getChildValue(ctx, 0);
	  else
	  	_Java_str = getChildValue(ctx, 0) + "," + getChildValue(ctx, 2);
	  
          treeProperty.get(ctx).value = _Java_str;	
	} catch (Exception e) {
                System.out.println("Physics Quantity Error: "+e);
        }
	  String _Java_str = getChildValue(ctx, 0) + "," + getChildValue(ctx, 2);
      	  treeProperty.get(ctx).value = _Java_str;
	}
	
	@Override public void enterVector(CalphyParser.VectorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */

	@Override public void exitVector(CalphyParser.VectorContext ctx) { 
	  String _Java_str = ctx.getChild(1).getText() + ctx.getChild(2).getText() + ctx.getChild(3).getText();
      treeProperty.get(ctx).value = _Java_str;
	}

	@Override public void enterPhysicsUnit(CalphyParser.PhysicsUnitContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterPhysicsUnit(CalphyParser.PhysicsUnitContext ctx) { 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPhysicsUnit(CalphyParser.PhysicsUnitContext ctx) { 
	  String _Java_str = "\""+concatAllChildren(ctx)+"\"";
 	  treeProperty.get(ctx).value = _Java_str;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterUnaryOperator(CalphyParser.UnaryOperatorContext ctx) { }


	@Override public void exitUnaryOperator(CalphyParser.UnaryOperatorContext ctx) { 
	  String _Java_str = concatAllChildren(ctx);
	  treeProperty.get(ctx).value = _Java_str;	
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCompareOperator(CalphyParser.CompareOperatorContext ctx) { 
	}

	@Override public void exitCompareOperator(CalphyParser.CompareOperatorContext ctx) { 
	  String _Java_str = concatAllChildren(ctx);
	  treeProperty.get(ctx).value = _Java_str;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLogicOperator(CalphyParser.LogicOperatorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLogicOperator(CalphyParser.LogicOperatorContext ctx) { 
	  String _Java_str = concatAllChildren(ctx);
	  treeProperty.get(ctx).value = _Java_str;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAssignmentOperator(CalphyParser.AssignmentOperatorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAssignmentOperator(CalphyParser.AssignmentOperatorContext ctx) { 
	  System.out.println("DEBUG: exitAssignmentOperator: " + concatAllChildren(ctx));
	  String _Java_str = concatAllChildren(ctx);
      treeProperty.get(ctx).value = _Java_str;
	} 
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterType(CalphyParser.TypeContext ctx) {}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitType(CalphyParser.TypeContext ctx) { 
	  String _Java_str = concatAllChildren(ctx);
	  treeProperty.get(ctx).value = _Java_str;
	}
	
	@Override public void enterPhysicsType(CalphyParser.PhysicsTypeContext ctx) { 
	  ; // do nothing
	}

	@Override public void exitPhysicsType(CalphyParser.PhysicsTypeContext ctx) { 
	  String _Java_str = transTable.transList.get(ctx.getChild(0).getText());
	  treeProperty.get(ctx).value = _Java_str;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterPhysicsList(CalphyParser.PhysicsListContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPhysicsList(CalphyParser.PhysicsListContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { 
	  int oldPointer = symbolTB.size();
	  NodeProperty np = new NodeProperty();
	  np.symbolTBPointer = oldPointer;
	  treeProperty.put(ctx, np);
	}

	@Override public void exitEveryRule(ParserRuleContext ctx) { 
	  /*
	  int oldPointer = treeProperty.get(ctx).symbolTBPointer;
	  // pop the variables that are out of scope
	  while (symbolTB.size() > oldPointer) {
		symbolTB.remove(symbolTB.size() - 1);
	  }
	  System.out.println("exit rule: gets:" + treeProperty.get(ctx).value);
	  */
	}

	@Override public void visitTerminal(TerminalNode node) {
	  NodeProperty np = new NodeProperty();
	  np.value = node.getSymbol().getText();
	  treeProperty.put(node, np);
	}
	
	@Override public void visitErrorNode(ErrorNode node) { }
}
