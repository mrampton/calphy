import java.util.Arrays;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.ParserRuleContext;

public class MyListener extends CalphyBaseListener {
	ParseTreeProperty<String> values = new ParseTreeProperty<String>();
	
	@Override public void exitEveryRule(ParserRuleContext ctx) {
		String storage = "";
		String childVal = "";
		StringBuilder sb = new StringBuilder(storage);
		int childCount = ctx.getChildCount();

		if (childCount > 1) {
			for (int i = 0; i < childCount; i++) {
				childVal = values.get(ctx.getChild(i));
				
				// exitEveryRule is not called for terminals and results in childVal = null
				// in this case, we seek only the text representation of the terminal
				if ( childVal == null )
					sb.append(ctx.getChild(i).getText() + " ");
				else
					sb.append(childVal + " ");
			}
		} else {
			sb.append(ctx.getText() + " ");
		}
		values.put(ctx, sb.toString());
	}


	
	
}
