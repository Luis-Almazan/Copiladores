/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package analizadorlexico2;
import java.util.ArrayList;
import java.util.List;
import analizadorlexico2.Token;
/**
 *
 * @author Luis Almazan
 */
public class AnalizadorLexico2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String input = "int x = 10 + 20;";
        List<Token> tokens = analyze(input);
        for (Token token : tokens) {
            System.out.println(token);
        }
    
    
    }
    
    public static List<Token> analyze(String input) {
        List<Token> tokens = new ArrayList<>();
        String[] words = input.split("\\s+"); // Dividir por espacios en blanco
        for (String word : words) {
            if (word.matches("[a-zA-Z]+")) { // Identificador
                tokens.add(new Token(TokenType.IDENTIFIER, word));
            } else if (word.matches("\\d+")) { // Entero
                tokens.add(new Token(TokenType.INTEGER, word));
            } else if (word.matches("[\\+\\-\\*/]")) { // Operador
                tokens.add(new Token(TokenType.OPERATOR, word));
            } else if (word.matches(";")) { // Punto y coma
                tokens.add(new Token(TokenType.SEMICOLON, word));
            } else if (word.matches("=")) { // Asignación
                tokens.add(new Token(TokenType.ASSIGNMENT, word));
            }
            // Podrías agregar más casos para otros tipos de tokens según tu necesidad
        }
        return tokens;
    }
    
    
    enum TokenType {
    IDENTIFIER,
    INTEGER,
    OPERATOR,
    SEMICOLON,
    ASSIGNMENT
    // Podrías agregar más tipos de tokens según tu necesidad
}
    
    class Token {
    TokenType type;
    String value;
    
    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }}
}

