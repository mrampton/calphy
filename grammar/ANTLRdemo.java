import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class ANTLRDemo {
    public static void main(String[] args) throws Exception {
		String s = 	"void main(){ " +
					" print('hello world')" 		+
					"}";

        ANTLRInputStream in = new ANTLRInputStream(s);
        CalphyLexer lexer = new CalphyLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalphyParser parser = new CalphyParser(tokens);
		
		CalphyParser.FunctionDefinitionContext calphyContext = parser.functionDefinition();
		ParseTreeWalker walker = new ParseTreeWalker();
		CalphyBaseListener listener = new CalphyBaseListener();
		walker.walk(listener, calphyContext);
       	//parser.functionDefinition();
    }
}
