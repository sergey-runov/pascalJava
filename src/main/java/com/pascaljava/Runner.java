package com.pascaljava;

import com.pascaljava.interpreter.Interpreter;
import com.pascaljava.lexer.Lexer;
import com.pascaljava.lexer.Token;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Lexer lexer = new Lexer();
        List<Token> tokens = lexer.tokenize("2+2");
        System.out.println("Result: " + Interpreter.interpret(tokens));
    }
}
