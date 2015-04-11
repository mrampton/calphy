import org.antlr.v4.runtime.*;

public class ANTLRDemo {
    public static void main(String[] args) throws Exception {
        ANTLRInputStream in = new ANTLRInputStream("");
        CalphyLexer lexer = new CalphyLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalphyParser parser = new CalphyParser(tokens);
       	parser.functionDefinition();
    }
}
