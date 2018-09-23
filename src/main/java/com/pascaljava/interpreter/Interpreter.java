package com.pascaljava.interpreter;

import com.pascaljava.lexer.Token;
import com.pascaljava.lexer.TokenType;

import java.util.LinkedList;
import java.util.List;

public class Interpreter {
    private Interpreter() {

    }

    public static Integer interpret(List<Token> tokens) {
        LinkedList<Token<Integer>> operands = new LinkedList<>();
        LinkedList<Token> operators = new LinkedList<>();
        for (Token token : tokens) {
            if (token.getType().isOperator()) {
                operators.add(token);
            } else {
                operands.add(token);
            }
        }
        Token<Integer> first = operands.pop();
        while (!operators.isEmpty()) {
            Token<Integer> second = operands.pop();
            if (null == second.getValue()) {
                throw new RuntimeException("Invalid statement!");
            }
            Token operation = operators.pop();
            Integer result;
            switch (operation.getType()) {
                case PLUS:
                    result = first.getValue() + second.getValue();
                    break;
                case MINUS:
                    result = first.getValue() - second.getValue();
                    break;
                case MULTIPLY:
                    result = first.getValue() * second.getValue();
                    break;
                case DIVIDE:
                    result = first.getValue() / second.getValue();
                    break;
                default:
                    throw new IllegalArgumentException("Unknown operation!");
            }
            first = new Token<>(TokenType.INTEGER, result);
        }
        return first.getValue();
    }
}
