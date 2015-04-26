import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class ANTLRDemo {
    public static void main(String[] args) throws Exception {
	String s = 	"void main(){ print('hello world'); }";
	// String s = 	"void main(){ print(2 + 3); }";

        // ANTLRInputStream in = new ANTLRInputStream(s);
		CalphyLexer lexer = new CalphyLexer( new ANTLRFileStream(args[0]));
        // CalphyLexer lexer = new CalphyLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalphyParser parser = new CalphyParser(tokens);
	
	CalphyParser.ProgramContext entryPoint = parser.Program();
	ParseTreeWalker walker = new ParseTreeWalker();
	MyListener listener = new MyListener();
	walker.walk(listener, entryPoint);
       	//parser.functionDefinition();
    }
}
