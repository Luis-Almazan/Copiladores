/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorlexico2;
/*
Esto es una Prueba
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Luis Almazan
 */
public class LexicalAnalyzer {
   private static final String REGEX_INTEGER = "\\d+\\.?\\d*";
    private static final String REGEX_IDENTIFIER = "[a-zA-Z][a-zA-Z0-9]*";
    private static final String REGEX_OPERATOR = "[+\\-*/]";
    private static final String REGEX_WHITESPACE = "\\s+";
    private static final String REGEX_COMMENT = "\"(?:\\\\\"|[^\"])*\"|//.*";
    private static final String REGEX_GROUPING_SYMBOLS= "[\\(\\)\\[\\]\\{\\}]";
    private static final String REGEX_SYMBOLS = "[=<>!&|;:,@$%*]"; // Agregar otros símbolos según sea necesario
    
    private static final List<String> RESERVED_WORDS = Arrays.asList("int", "float", "if","elseif","endif", "else", "while", "for", "return");

    public static List<Token> analyze(String input) {
        List<Token> tokens = new ArrayList<>();
        String[] lines = input.split("\n");

        int lineNumber = 1;
        for (String line : lines) {
            String regex = REGEX_INTEGER + "|" + REGEX_IDENTIFIER + "|" + REGEX_OPERATOR + "|" + REGEX_WHITESPACE + "|" + REGEX_COMMENT + "|" + REGEX_GROUPING_SYMBOLS+ "|" + REGEX_SYMBOLS;
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String token = matcher.group();
                if (token.matches(REGEX_INTEGER)) {
                    tokens.add(new Token("INTEGER", token, lineNumber));
                } else if (token.matches(REGEX_IDENTIFIER)) {
                    if (RESERVED_WORDS.contains(token)) {
                        tokens.add(new Token("RESERVED_WORD", token, lineNumber));
                    } else {
                        tokens.add(new Token("IDENTIFIER", token, lineNumber));
                    }
                } else if (token.matches(REGEX_OPERATOR)) {
                    tokens.add(new Token("OPERATOR", token, lineNumber));
                } else if (token.matches(REGEX_WHITESPACE)) {
                    // No hacer nada para espacios en blanco
                } else if (token.matches(REGEX_COMMENT)) {
                    tokens.add(new Token("COMMENT", token, lineNumber));
                } else if (token.matches(REGEX_GROUPING_SYMBOLS)) {
                    tokens.add(new Token("GROUPING_SYMBOL", token, lineNumber));
                }else if (token.matches(REGEX_SYMBOLS)) {
                    tokens.add(new Token("SYMBOL", token, lineNumber));
                } 
                
                else {
                    tokens.add(new Token("ERROR", token, lineNumber));
                }
            }
            lineNumber++;
        }
        return tokens;
    }

}