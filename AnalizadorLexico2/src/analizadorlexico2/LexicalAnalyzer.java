/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorlexico2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexicalAnalyzer {
    // Definir los patrones para diferentes tipos de tokens
    private static final String REGEX_INTEGER = "\\d+";  // Solo números enteros
    private static final String REGEX_FLOAT = "\\d+\\.\\d*";  // Números flotantes
    private static final String REGEX_IDENTIFIER = "[a-zA-Z][a-zA-Z0-9]*";
    private static final String REGEX_OPERATOR = "[+\\-*/]";
    private static final String REGEX_WHITESPACE = "\\s+";
    private static final String REGEX_COMMENT = "//.*";  // Solo comentarios de línea
    private static final String REGEX_GROUPING_SYMBOLS = "[\\(\\)\\[\\]\\{\\}]";
    private static final String REGEX_SYMBOLS = "[=<>!&|;:,@$%*]";  // Agregar otros símbolos según sea necesario

    private static final List<String> RESERVED_WORDS = Arrays.asList("int", "float", "if", "elseif", "endif", "else", "while", "for", "return","void");

    // Compilar el patrón una sola vez
    private static final String FULL_REGEX = REGEX_INTEGER + "|" + REGEX_FLOAT + "|" + REGEX_IDENTIFIER + "|" + REGEX_OPERATOR + "|" + REGEX_WHITESPACE + "|" + REGEX_COMMENT + "|" + REGEX_GROUPING_SYMBOLS + "|" + REGEX_SYMBOLS;
    private static final Pattern PATTERN = Pattern.compile(FULL_REGEX);

    public static List<Token> analyze(String input) {
        List<Token> tokens = new ArrayList<>();
        String[] lines = input.split("\\n");

        int lineNumber = 1;
        for (String line : lines) {
            Matcher matcher = PATTERN.matcher(line);

            while (matcher.find()) {
                String token = matcher.group();
                if (token.matches(REGEX_INTEGER)) {
                    tokens.add(new Token("INTEGER", token, lineNumber));
                } else if (token.matches(REGEX_FLOAT)) {
                    tokens.add(new Token("FLOAT", token, lineNumber));
                } else if (token.matches(REGEX_IDENTIFIER)) {
                    if (RESERVED_WORDS.contains(token)) {
                        tokens.add(new Token("KEYWORD", token, lineNumber));
                    } else {
                        tokens.add(new Token("IDENTIFIER", token, lineNumber));
                    }
                } else if (token.matches(REGEX_OPERATOR)) {
                    tokens.add(new Token("OPERATOR", token, lineNumber));
                } else if (!token.matches(REGEX_WHITESPACE)) {  // Ignorar espacios en blanco, pero procesar todo lo demás
                    if (token.matches(REGEX_COMMENT)) {
                        tokens.add(new Token("COMMENT", token, lineNumber));
                    } else if (token.matches(REGEX_GROUPING_SYMBOLS)) {
                        tokens.add(new Token("GROUPING_SYMBOL", token, lineNumber));
                    } else if (token.matches(REGEX_SYMBOLS)) {
                        tokens.add(new Token("SYMBOL", token, lineNumber));
                    }
                }
            }
            lineNumber++;
        }
        return tokens;
    }
}