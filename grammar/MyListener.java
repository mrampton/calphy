import java.util.Arrays;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.ParserRuleContext;

public class MyListener extends CalphyBaseListener {
	ParseTreeProperty<String> values = new ParseTreeProperty<String>();
	ReadTranslateTable translateList = new ReadTranslateTable();

	@Override public void exitProgram(CalphyParser.ProgramContext ctx) {
		ChildCollection collection = new ChildCollection(ctx, values);
		values.put(ctx, collection.toString());
	}
	@Override public void exitFunctionDefinition(CalphyParser.FunctionDefinitionContext ctx) {
		ChildCollection collection = new ChildCollection(ctx, values);
		collection.prepend(0, "public static ");
		values.put(ctx, collection.toString());
	}
	@Override public void exitFunctionDeclarator(CalphyParser.FunctionDeclaratorContext ctx) {
		ChildCollection collection = new ChildCollection(ctx, values);
		// translate the specified value if that value corresponds to an entry in translateList
		collection.translate(0, translateList);
		values.put(ctx, collection.toString());
	}
	@Override public void exitStatement(CalphyParser.StatementContext ctx) {
		ChildCollection collection = new ChildCollection(ctx, values);
		values.put(ctx, collection.toString());
	}
	@Override public void exitIterationStatement(CalphyParser.IterationStatementContext ctx) {
		ChildCollection collection = new ChildCollection(ctx, values);
		values.put(ctx, collection.toString());
	}
	@Override public void exitSelectionStatement(CalphyParser.SelectionStatementContext ctx) {
		ChildCollection collection = new ChildCollection(ctx, values);
		values.put(ctx, collection.toString());
	}
	@Override public void exitAssignStatement(CalphyParser.AssignStatementContext ctx) {
		ChildCollection collection = new ChildCollection(ctx, values);
		values.put(ctx, collection.toString());
	}
	@Override public void exitReturnStatement(CalphyParser.ReturnStatementContext ctx) {
		ChildCollection collection = new ChildCollection(ctx, values);
		values.put(ctx, collection.toString());
	}
	@Override public void exitParameterList(CalphyParser.ParameterListContext ctx) {
		ChildCollection collection = new ChildCollection(ctx, values);
		values.put(ctx, collection.toString());
	}
	@Override public void exitParameter(CalphyParser.ParameterContext ctx) {
		ChildCollection collection = new ChildCollection(ctx, values);
		values.put(ctx, collection.toString());
	}
	@Override public void exitDeclaration(CalphyParser.DeclarationContext ctx) {
		ChildCollection collection = new ChildCollection(ctx, values);
		values.put(ctx, collection.toString());
	}
	@Override public void exitExpression(CalphyParser.ExpressionContext ctx) {
		ChildCollection collection = new ChildCollection(ctx, values);
		values.put(ctx, collection.toString());
	}
	@Override public void exitPhysicsQuantity(CalphyParser.PhysicsQuantityContext ctx) {
		ChildCollection collection = new ChildCollection(ctx, values);
		values.put(ctx, collection.toString());
	}
	@Override public void exitVector(CalphyParser.VectorContext ctx) {
		ChildCollection collection = new ChildCollection(ctx, values);
		values.put(ctx, collection.toString());
	}
	@Override public void exitPhysicsUnit(CalphyParser.PhysicsUnitContext ctx) {
		ChildCollection collection = new ChildCollection(ctx, values);
		values.put(ctx, collection.toString());
	}
	@Override public void exitBinaryOperator(CalphyParser.BinaryOperatorContext ctx) {
		ChildCollection collection = new ChildCollection(ctx, values);
		values.put(ctx, collection.toString());
	}
	@Override public void exitUnaryOperator(CalphyParser.UnaryOperatorContext ctx) {
		ChildCollection collection = new ChildCollection(ctx, values);
		values.put(ctx, collection.toString());
	}
	@Override public void exitCompareOperator(CalphyParser.CompareOperatorContext ctx) {
		ChildCollection collection = new ChildCollection(ctx, values);
		values.put(ctx, collection.toString());
	}
	@Override public void exitLogicOperator(CalphyParser.LogicOperatorContext ctx) {
		ChildCollection collection = new ChildCollection(ctx, values);
		values.put(ctx, collection.toString());
	}
	@Override public void exitAssignmentOperator(CalphyParser.AssignmentOperatorContext ctx) {
		ChildCollection collection = new ChildCollection(ctx, values);
		values.put(ctx, collection.toString());
	}
	@Override public void exitType(CalphyParser.TypeContext ctx) {
		ChildCollection collection = new ChildCollection(ctx, values);
		collection.translate(0, translateList);
		values.put(ctx, collection.toString());
	}
	@Override public void exitPhysicsType(CalphyParser.PhysicsTypeContext ctx) {
		ChildCollection collection = new ChildCollection(ctx, values);
		values.put(ctx, collection.toString());
	}
	@Override public void exitPhysicsList(CalphyParser.PhysicsListContext ctx) {
		ChildCollection collection = new ChildCollection(ctx, values);
		values.put(ctx, collection.toString());
	}
	
}
