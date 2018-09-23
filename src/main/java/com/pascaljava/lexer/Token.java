package com.pascaljava.lexer;

public class Token<T> {
    public static final Token TOKEN_EOF = new Token<>(TokenType.EOF, null);
    private TokenType type;
    private T value;

    public Token(TokenType type, T value) {
        this.type = type;
        this.value = value;
    }

    public TokenType getType() {
        return type;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", value=" + value +
                '}';
    }
}
