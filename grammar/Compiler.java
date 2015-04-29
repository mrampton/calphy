import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Compiler {
    public static void main(String[] args) throws Exception {
		CalphyLexer lexer = new CalphyLexer( new ANTLRFileStream(args[0]));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalphyParser parser = new CalphyParser(tokens);
		
		CalphyParser.ProgramContext calphyContext = parser.program();
		ParseTreeWalker walker = new ParseTreeWalker();
		MyListener listener = new MyListener();
		walker.walk(listener, calphyContext);
    }
}
