package com.pascaljava.lexer;

public enum TokenType {
    INTEGER(false), PLUS(true), MINUS(true), MULTIPLY(true), DIVIDE(true), EOF(false);

    private boolean isOperator;

    TokenType(boolean isOperator) {
        this.isOperator = isOperator;
    }
    public boolean isOperator() {
        return this.isOperator;
    }
}
