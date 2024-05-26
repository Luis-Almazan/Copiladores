/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorlexico2;

import java.util.List;

public class SyntaxAnalyzer {
    private List<Token> tokens;
    private int currentTokenIndex = 0;

    public SyntaxAnalyzer(List<Token> tokens) {
        this.tokens = tokens;
    }

    private Token getToken() {
        return currentTokenIndex < tokens.size() ? tokens.get(currentTokenIndex) : new Token("EOF", "", -1);
    }

    private void consumeToken() {
        if (currentTokenIndex < tokens.size()) {
            currentTokenIndex++;
        }
    }

    public void parse() {
        while (!"EOF".equals(getToken().getType())) {
            statement();
        }
    }

    private void statement() {
        Token token = getToken();
        if ("KEYWORD".equals(token.getType())) {
            switch (token.getValue()) {
                case "void":
                    consumeToken(); // Consumir 'void'
                    functionDefinition();
                    break;
                case "int":
                case "float":
                case "double":
                    variableDeclaration(token.getValue());
                    break;
                case "if":
                    consumeToken(); // Consumir 'if'
                    ifStatement();
                    break;
                case "for":
                    consumeToken(); // Consumir 'for'
                    forStatement();
                    break;
                default:
                    throw new RuntimeException("Syntax error: Unexpected keyword " + token.getValue());
            }
        } else {
            throw new RuntimeException("Syntax error: Unexpected token " + token.getValue());
        }
    }

   private void functionDefinition() {
    Token functionName = getToken();
    if ("IDENTIFIER".equals(functionName.getType())) {
        String funcName = functionName.getValue();
        consumeToken(); // Consumir el nombre de la función
        if ("main".equals(funcName)) {
            handleMainFunction();
        } else {
            handleOtherFunction(funcName);
        }
    } else {
        throw new RuntimeException("Syntax error: Expected function name, got " + functionName.getValue());
    }
}
   private void handleMainFunction() {
    consumeToken(); // Suponer que consume '('
    // Asumiendo que main no toma parámetros o maneja de manera específica
    consumeToken(); // Suponer que consume ')'
    consumeToken(); // Suponer que consume '{'
    while (!"}".equals(getToken().getValue())) {
        statement();
    }
    consumeToken(); // Consumir '}'
}

private void handleOtherFunction(String funcName) {
    // Manejo de parámetros aquí si es necesario
    consumeToken(); // Suponer que consume ')'
    consumeToken(); // Suponer que consume '{'
    while (!"}".equals(getToken().getValue())) {
        statement();
    }
    consumeToken(); // Consumir '}'
}

    private void variableDeclaration(String type) {
    Token identifier = getToken();
    if ("IDENTIFIER".equals(identifier.getType())) {
        consumeToken(); // Consumir el identificador
        if ("=".equals(getToken().getValue())) {
            consumeToken(); // Consumir '='
            expression(); // Evaluar la expresión
            if (";".equals(getToken().getValue())) {
                consumeToken(); // Consumir ';'
            } else {
                throw new RuntimeException("Syntax error: Expected ';' after expression");
            }
        } else {
            throw new RuntimeException("Syntax error: Expected '=' after identifier");
        }
    } else {
        throw new RuntimeException("Syntax error: Expected identifier after type, got " + identifier.getValue());
    }
}

    private void ifStatement() {
        consumeToken(); // Suponer que consume '('
        expression();  // Condición
        consumeToken(); // Suponer que consume ')'
        consumeToken(); // Suponer que consume '{'
        while (!"}".equals(getToken().getValue())) {
            statement();
        }
        consumeToken(); // Consumir '}'
    }

    private void forStatement() {
        consumeToken(); // Suponer que consume '('
        statement();   // Inicialización
        expression();  // Condición
        consumeToken(); // Consumir ';'
        expression();  // Incremento
        consumeToken(); // Suponer que consume ')'
        consumeToken(); // Suponer que consume '{'
        while (!"}".equals(getToken().getValue())) {
            statement();
        }
        consumeToken(); // Consumir '}'
    }

    private void expression() {
        // Esta es una implementación muy básica de expresiones.
        // Deberías expandir esto para manejar operadores aritméticos y lógicos según tu gramática.
        Token token = getToken();
        while (!";".equals(token.getValue()) && !")".equals(token.getValue()) && !"}".equals(token.getValue())) {
            consumeToken();
            token = getToken();
        }
    }
}
