package com.tinygao.antlr4.tour;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class Calc {
    public static void main(String[] args) throws IOException {
        CharStream stream = CharStreams.fromStream(System.in);
        LabeledExprLexer lexer = new LabeledExprLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LabeledExprParser parser = new LabeledExprParser(tokens);
        ParseTree tree = parser.prog(); // pars

        EvalVisitor eval = new EvalVisitor();
        eval.visit(tree);
    }
}
