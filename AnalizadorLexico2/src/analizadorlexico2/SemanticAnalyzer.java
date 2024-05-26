/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorlexico2;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class SemanticAnalyzer {
    private List<Token> tokens;
    private int currentIndex;
    private Map<String, String> symbolTable;

    public SemanticAnalyzer(List<Token> tokens) {
        this.tokens = tokens;
        this.currentIndex = 0;
        this.symbolTable = new HashMap<>();
    }

    public boolean analyze() {
        return program();
    }

    private boolean program() {
        if (tokens.get(currentIndex).getValue().equals("main")) {
            currentIndex++;
            return statementList();
        }
        return false;
    }

    private boolean statementList() {
        while (currentIndex < tokens.size()) {
            if (!statement()) {
                return false;
            }
            currentIndex++; // Move to the next statement
        }
        return true;
    }

    private boolean statement() {
        Token token = tokens.get(currentIndex);
        if (token.getValue().equals("int") || token.getValue().equals("float")) {
            return declaration(token.getValue());
        } else if (token.getType().equals("IDENTIFIER")) {
            return assignment();
        } else if (token.getValue().equals("if")) {
            return ifStatement();
        } else if (token.getValue().equals("for")) {
            return forStatement();
        }
        return false;
    }

    private boolean declaration(String type) {
        currentIndex++; // Skip type (int, float)
        Token identifier = tokens.get(currentIndex);
        if (identifier.getType().equals("IDENTIFIER")) {
            currentIndex++;
            if (tokens.get(currentIndex).getValue().equals("=")) {
                currentIndex++;
                if (expression(type)) {
                    symbolTable.put(identifier.getValue(), type);
                    return tokens.get(currentIndex).getValue().equals(";");
                }
            }
        }
        return false;
    }

    private boolean assignment() {
        Token identifier = tokens.get(currentIndex);
        if (symbolTable.containsKey(identifier.getValue())) {
            String type = symbolTable.get(identifier.getValue());
            currentIndex++;
            if (tokens.get(currentIndex).getValue().equals("=")) {
                currentIndex++;
                if (expression(type)) {
                    return tokens.get(currentIndex).getValue().equals(";");
                }
            }
        } else {
            System.err.println("Error: Variable " + identifier.getValue() + " no definida.");
        }
        return false;
    }

    private boolean ifStatement() {
        currentIndex++;
        if (tokens.get(currentIndex).getValue().equals("(")) {
            currentIndex++;
            if (expression("boolean")) {
                if (tokens.get(currentIndex).getValue().equals(")")) {
                    currentIndex++;
                    return statement();
                }
            }
        }
        return false;
    }

    private boolean forStatement() {
        currentIndex++;
        if (tokens.get(currentIndex).getValue().equals("(")) {
            currentIndex++;
            if (declaration("int") && tokens.get(currentIndex).getValue().equals(";")) {
                currentIndex++;
                if (expression("boolean") && tokens.get(currentIndex).getValue().equals(";")) {
                    currentIndex++;
                    if (assignment() && tokens.get(currentIndex).getValue().equals(")")) {
                        currentIndex++;
                        return statement();
                    }
                }
            }
        }
        return false;
    }

    private boolean expression(String expectedType) {
        Token firstToken = tokens.get(currentIndex);
        if (firstToken.getType().equals("IDENTIFIER") || firstToken.getType().equals("INTEGER") || firstToken.getType().equals("FLOAT")) {
            String firstType = getType(firstToken);
            if (!firstType.equals(expectedType)) {
                System.err.println("Error de tipo: se esperaba " + expectedType + " pero se encontró " + firstType);
                return false;
            }
            currentIndex++;
            if (tokens.get(currentIndex).getType().equals("OPERATOR")) {
                Token operator = tokens.get(currentIndex);
                currentIndex++;
                Token secondToken = tokens.get(currentIndex);
                String secondType = getType(secondToken);
                if (!secondType.equals(firstType)) {
                    System.err.println("Error de tipo: no se puede operar " + firstType + " con " + secondType);
                    return false;
                }
                currentIndex++;
                return true;
            }
            return true;
        }
        return false;
    }

    private String getType(Token token) {
        if (token.getType().equals("IDENTIFIER")) {
            if (symbolTable.containsKey(token.getValue())) {
                return symbolTable.get(token.getValue());
            } else {
                System.err.println("Error: Variable " + token.getValue() + " no definida.");
                return "undefined";
            }
        } else if (token.getType().equals("INTEGER")) {
            return "int";
        } else if (token.getType().equals("FLOAT")) {
            return "float";
        }
        return "undefined";
    }

    public Map<String, String> getSymbolTable() {
        return symbolTable;
    }
}
