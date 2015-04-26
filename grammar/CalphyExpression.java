import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class CalphyExpression {
	public String storage = "";

	public CalphyExpression(CalphyParser.ExpressionContext ctx, ParseTreeProperty<String> values) {
		
		int childCount = ctx.getChildCount();
		if (childCount > 1) {
			for (int i = 0; i < childCount; i++) {
				storage += ctx.getChild(i).getText();
			}
		} else {
			storage += ctx.getText();
		}
		values.put(ctx, storage);
	}
	
	public String getStorage() {
		
		return storage;
	}
	
}
