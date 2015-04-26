import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.ParserRuleContext;

public class MyListener extends CalphyBaseListener {
	ParseTreeProperty<String> values = new ParseTreeProperty<String>();
	
	@Override public void exitExpression(CalphyParser.ExpressionContext ctx) {
		// CalphyExpression exp = new CalphyExpression(ctx, values);
		// System.out.println(values.get(ctx));
	}

	@Override public void exitEveryRule(ParserRuleContext ctx) {
		String storage = "";
		int childCount = ctx.getChildCount();
		if (childCount > 1) {
			for (int i = 0; i < childCount; i++) {
				storage += ctx.getChild(i).getText();
			}
		} else {
			storage += ctx.getText();
		}
		values.put(ctx, storage);
		System.out.println(values.get(ctx));
		
	}
	
	
	
}
