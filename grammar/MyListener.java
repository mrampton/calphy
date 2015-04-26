import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class MyListener extends CalphyBaseListener {
	ParseTreeProperty<String> values = new ParseTreeProperty<String>();
	
	@Override public void exitExpression(CalphyParser.ExpressionContext ctx) {
		CalphyExpression exp = new CalphyExpression(ctx, values);
		System.out.println(values.get(ctx));
	}
	
	
}
