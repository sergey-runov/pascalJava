package com.pascaljava.lexer;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private int pos = 0;
    //client string input, e.g. "3+5"
    private String text;
    private boolean hasNext = true;

    /*Lexical analyzer (also known as scanner or tokenizer)
    This method is responsible for breaking a sentence
    apart into tokens. One token at a time. */
    private Token nextToken() {
        if (this.pos > text.length() - 1) {
            hasNext = false;
            return Token.TOKEN_EOF;
        }
        StringBuilder sb = new StringBuilder();
        Character curChar = text.charAt(this.pos);
        if (Character.isDigit(curChar)) {
            do {
                curChar = text.charAt(this.pos);
                sb.append(curChar);
                this.pos++;
                if (this.pos > text.length() - 1 || !Character.isDigit(text.charAt(this.pos))) {
                    String integerToParse = sb.toString();
                    return new Token<>(TokenType.INTEGER, Integer.parseInt(integerToParse));
                }
            } while (Character.isDigit(text.charAt(this.pos)));
        } else if (curChar.equals('+')) {
            this.pos++;
            return new Token<>(TokenType.PLUS, curChar);
        } else if (curChar.equals('-')) {
            this.pos++;
            return new Token<>(TokenType.MINUS, curChar);
        } else if (curChar.equals('*')) {
            this.pos++;
            return new Token<>(TokenType.MULTIPLY, curChar);
        } else if (curChar.equals('/')) {
            this.pos++;
            return new Token<>(TokenType.DIVIDE, curChar);
        } else if (curChar.equals(' ')) {
            this.pos++;
            return nextToken();
        }
        throw new IllegalArgumentException("Incorrect character: " + curChar);
    }

    //expr -> INTEGER PLUS INTEGER
    public List<Token> tokenize(String text) {
        List<Token> tokens = new ArrayList<>();
        this.text = text;
        do {
            tokens.add(nextToken());
        } while (hasNext);
        return tokens;
    }
}
