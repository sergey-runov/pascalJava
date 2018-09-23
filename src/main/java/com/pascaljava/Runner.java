package com.pascaljava;

import com.pascaljava.lexer.Interpreter;

public class Runner {
    public static void main(String[] args) {
        Interpreter interpreter = new Interpreter("6+2");
        System.out.println("Result: " + interpreter.calculate());
    }
}
