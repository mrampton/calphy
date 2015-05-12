import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.PrintWriter;

public class Compiler {
	public static void main(String[] args) throws Exception {
		if (args.length >= 1) {
			String defaultClass = "CalphyClass";
			CalphyLexer lexer = new CalphyLexer( new ANTLRFileStream(args[0]));
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	    CalphyParser parser = new CalphyParser(tokens);
		
			CalphyParser.ProgramContext calphyContext = parser.program();
			ParseTreeWalker walker = new ParseTreeWalker();
			MyListener listener = new MyListener();
			walker.walk(listener, calphyContext);
			
			String outputClass = args.length == 1 ? defaultClass + ".java" : args[1] + ".java";
		
			PrintWriter writer = new PrintWriter(outputClass, "UTF-8");
			if (args.length == 2)
				writer.print(listener.treeProperty.get(calphyContext).value.replaceAll(defaultClass, args[1]));
			else
				writer.print(listener.treeProperty.get(calphyContext).value);
			writer.close();
			
		} else {
			System.out.println("usage: java Compiler source-code.calphy");
			System.exit(1);
		}	
  }
}
