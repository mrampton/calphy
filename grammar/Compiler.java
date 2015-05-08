import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Compiler {
    public static void main(String[] args) throws Exception {
	if (args.length == 1) {
		CalphyLexer lexer = new CalphyLexer( new ANTLRFileStream(args[0]));
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	    CalphyParser parser = new CalphyParser(tokens);
		
		CalphyParser.ProgramContext calphyContext = parser.program();
		ParseTreeWalker walker = new ParseTreeWalker();
		//MyListener listener = new MyListener();
		MyListener2 listener = new MyListener2();
		walker.walk(listener, calphyContext);
			
		// TODO: this print should be writing to a file
		//System.out.println(listener.values.get(calphyContext));
			
	} else {
		System.out.println("usage: java Compiler source-code.calphy");
		System.exit(1);
	}	
    }
}
