public class MyListener extends CalphyBaseListener {
	
	@Override public void enterExpression(CalphyParser.ExpressionContext ctx) {
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
			if (printString.contains("'") && printString.contains("'"))
				printString = printString.substring(1,printString.length() - 1);
			System.out.println(printString);
		}
		System.out.println("Child count: "+childCount);
	}
	
	
}
