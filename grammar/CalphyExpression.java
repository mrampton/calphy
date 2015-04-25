public class CalphyExpression {
	
	public CalphyExpression(CalphyParser.ExpressionContext ctx) {
		int childCount = ctx.getChildCount();
		boolean print = false;
		String printString = "";
		
		if (childCount > 1) {
			for(int i = 0; i < childCount; i++) {
				String text = ctx.getChild(i).getText();
				if (text.equals("print")) {
					print = true;
				} else if (!(text.equals(")") || text.equals("("))) {
					printString += text;
				}
			}
			
		}
		if (print) {
			System.out.println(printString);
		}
		
	}
	
}