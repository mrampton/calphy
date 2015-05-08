import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;


public class MyListener2 extends CalphyBaseListener{
  ParseTreeProperty<NodeProperty> treeProperty;
  ArrayList<Symbol> symbolTB;
  ReadTranslateTable transTable;

  public MyListener2() {
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
	
	public Symbol(String t, String n) {
      type = t;
      name = n; 
	}
  }
 
  public String getSymbol(String _name) {
	for (int i = 0; i < symbolTB.size(); i++) {
	  Symbol s = symbolTB.get(i);
	  if (s.name == _name) {
		return s.type;
	  }
	} 
	return null;
  }
  
  public String concatAllChildren(ParserRuleContext ctx) {
	int childCount = ctx.getChildCount();
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < childCount; i++) {
	  String childVal = treeProperty.get(ctx.getChild(i)).value;
	  sb.append(childVal);
	  if (i < childCount-1) {
		sb.append(" ");
	  }
	}
	return sb.toString();
  }
  
	@Override public void enterProgram(CalphyParser.ProgramContext ctx) { 
	  //System.out.println("enter: program");
	}
	
	@Override public void exitProgram(CalphyParser.ProgramContext ctx) {
	  String _Java_Program = "public class TestClass { \n" + 
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
	}

	@Override public void enterFunctionDeclarator(CalphyParser.FunctionDeclaratorContext ctx) {
      ; // do nothing      
	}

	@Override public void exitFunctionDeclarator(CalphyParser.FunctionDeclaratorContext ctx) {
	  //if (treeProperty.get(ctx.getChild(0)).value.equals("print"))
	//	treeProperty.get(ctx.getChild(0)).value = "System.out.println";
	  treeProperty.get(ctx.getChild(0)).value = transTable.transList.get(ctx.getChild(0).getText());
	  String _Java_str = concatAllChildren(ctx);
	  treeProperty.get(ctx).value = _Java_str;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStatement(CalphyParser.StatementContext ctx) {
 	  	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStatement(CalphyParser.StatementContext ctx) {
	  String _Java_str = concatAllChildren(ctx);
	  treeProperty.get(ctx).value = _Java_str;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIterationStatement(CalphyParser.IterationStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIterationStatement(CalphyParser.IterationStatementContext ctx) { }
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
	@Override public void exitSelectionStatement(CalphyParser.SelectionStatementContext ctx) { }
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
	@Override public void exitAssignStatement(CalphyParser.AssignStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterReturnStatement(CalphyParser.ReturnStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitReturnStatement(CalphyParser.ReturnStatementContext ctx) { }
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
	  System.out.println(_Java_str);
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
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDeclaration(CalphyParser.DeclarationContext ctx) { 
	  boolean primType = false;
	  String _Java_str = "";
	  if (treeProperty.get(ctx.getChild(0)).value.equals("int") || treeProperty.get(ctx.getChild(0)).value.equals("float"))	//add more prim types
		primType = true;

	  if (primType == false) {
		_Java_str = treeProperty.get(ctx.getChild(0)).value + " " + treeProperty.get(ctx.getChild(1)).value + " =  " 
		+ "new " + treeProperty.get(ctx.getChild(0)).value + " " + treeProperty.get(ctx.getChild(3)).value;   
		treeProperty.get(ctx).value = _Java_str;
	  }
	  else {
	 	_Java_str = treeProperty.get(ctx.getChild(0)).value + " " + treeProperty.get(ctx.getChild(1)).value + " =  "
			+ treeProperty.get(ctx.getChild(3)).value;
		treeProperty.get(ctx).value = _Java_str;	
	  }
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExpression(CalphyParser.ExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExpression(CalphyParser.ExpressionContext ctx) { 
	  String _Java_str = concatAllChildren(ctx);
          treeProperty.get(ctx).value = _Java_str;
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
	  //String _Java_str = ctx.getChild(0).getText()+ctx.getChild(2).getText()+")";
	  String _Java_str = "("+treeProperty.get(ctx.getChild(0)).value + "," + treeProperty.get(ctx.getChild(2)).value + ")";
          treeProperty.get(ctx).value = _Java_str;	
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterVector(CalphyParser.VectorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitVector(CalphyParser.VectorContext ctx) { 
	  String _Java_str = ctx.getChild(1).getText()+ctx.getChild(2).getText()+ctx.getChild(3).getText();
          treeProperty.get(ctx).value = _Java_str;
	}
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
	@Override public void enterBinaryOperator(CalphyParser.BinaryOperatorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBinaryOperator(CalphyParser.BinaryOperatorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterUnaryOperator(CalphyParser.UnaryOperatorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitUnaryOperator(CalphyParser.UnaryOperatorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCompareOperator(CalphyParser.CompareOperatorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCompareOperator(CalphyParser.CompareOperatorContext ctx) { }
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
	@Override public void exitLogicOperator(CalphyParser.LogicOperatorContext ctx) { }
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
	@Override public void exitAssignmentOperator(CalphyParser.AssignmentOperatorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterType(CalphyParser.TypeContext ctx) { 
		
	}
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
	  //String _Java_str = concatAllChildren(ctx);
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
	  int oldPointer = treeProperty.get(ctx).symbolTBPointer;
	  // pop the variables that are out of scope
	  while (symbolTB.size() > oldPointer) {
		symbolTB.remove(symbolTB.size());
	  }
	}

	@Override public void visitTerminal(TerminalNode node) {
	  //System.out.println("terminal : " + node.getSymbol().getText());
	  NodeProperty np = new NodeProperty();
	  np.value = node.getSymbol().getText();
	  treeProperty.put(node, np);
	}
	
	@Override public void visitErrorNode(ErrorNode node) { }
}
