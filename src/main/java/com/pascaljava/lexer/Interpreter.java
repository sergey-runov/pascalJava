package com.pascaljava.lexer;

import com.sun.corba.se.impl.oa.toa.TOA;

public class Interpreter {
    private int pos = 0;
    //client string input, e.g. "3+5"
    private String text;
    private Token curToken;

    public Interpreter(String text) {
        this.text = text;
    }

    /*Lexical analyzer (also known as scanner or tokenizer)
    This method is responsible for breaking a sentence
    apart into tokens. One token at a time. */
    private Token nextToken() {
        if (this.pos > text.length() - 1) return Token.TOKEN_EOF;
        Character curChar = text.charAt(this.pos);
        this.pos++;
        if (Character.isDigit(curChar)) {
            return new Token<>(TokenType.INTEGER, Character.getNumericValue(curChar));
        }
        if (curChar.equals('+')) {
            return new Token<>(TokenType.PLUS, curChar);
        }
        throw new IllegalArgumentException("Incorrect character: " + curChar);
    }

    /* Compare the current token type with the passed token
     type and if they match then "eat" the current token
     and assign the next token to the self.current_token,
     otherwise raise an exception. */
    private void eat(TokenType type) {
        if (this.curToken.getType() == type) {
            this.curToken = nextToken();
        } else {
            throw new IllegalArgumentException("Incorrect token type: " + type.name());
        }
    }

    //expr -> INTEGER PLUS INTEGER
    public Integer calculate() {
        this.curToken = nextToken();
        Token<Integer> left = this.curToken;
        eat(TokenType.INTEGER);
        Token<Character> operation = this.curToken;
        eat(TokenType.PLUS);
        Token<Integer> right = this.curToken;
        eat(TokenType.INTEGER);
        return left.getValue() + right.getValue();
    }
}
