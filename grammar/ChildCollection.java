import java.util.HashMap;
import java.util.Arrays;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.ParserRuleContext;

public class ChildCollection {

	// [row][col]
	String[][] collection;
	int RULES = 0;
	int CHILDREN = 1;
	
	ChildCollection(ParserRuleContext ctx, ParseTreeProperty<String> values) {
		String storage = "";
		String childVal = "";
		int childCount = ctx.getChildCount();
		// create 2D array; row0 tracks rule_match of child; row1 tracks value of child
		// we guarantee the second row has at least a size of 1
		collection = new String[2][childCount == 0 ? 1 : childCount];

		for (int i = 0; i < childCount; i++) {
			childVal = values.get(ctx.getChild(i));
			// let's make sure values is stored even for nodes we do not visit (i.e. leaf attributes)
			if (childVal == null) {
				values.put(ctx.getChild(i), ctx.getChild(i).getText());
				childVal = values.get(ctx.getChild(i));
				
			}
			childVal = childVal.equals("null") ? "" : childVal;
			collection[CHILDREN][i] = childVal;
		}
		
	}

	public void translate(int child, ReadTranslateTable table) {
		if(table.transList.containsKey(collection[CHILDREN][child]))
			collection[CHILDREN][0] = table.transList.get(collection[CHILDREN][child]);
	}

	public void prepend(int child, String pre) {
		collection[CHILDREN][child] = pre + collection[CHILDREN][child];
	}

	public void append(int child, String app) {
		collection[CHILDREN][child] += app;
	}


	public String toString() {
		//return String.join(" ", collection[CHILDREN]);
		String joinString = "";
		for (int i = 0; i < collection[CHILDREN].length; i++)
			joinString += collection[CHILDREN][i] + " ";
		return joinString;
	}
	
	public String[] getChildren() {
		return collection[CHILDREN];
	}
	
	public String[] getRules() {
		return collection[RULES];
	}

	
}
