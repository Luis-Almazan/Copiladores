/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorlexico2;

import java.util.List;

/**
 *
 * @author pc
 */
public class SyntaxAnalyzer {
    public static boolean validate(List<Token> tokens) {
        // Verificar si la lista de tokens comienza con "inicio" y termina con "fin"
        if (tokens.size() >= 2 && tokens.get(0).getValue().equals("main") && tokens.get(tokens.size() - 1).getValue().equals(";")) {
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean validate2(List<Token> tokens) {
        // Variable para rastrear el índice actual mientras recorremos los tokens
        int currentIndex = 0;
        int tokenCount = tokens.size();

        // Comenzamos con la validación del ciclo for
        while (currentIndex < tokenCount) {
            Token currentToken = tokens.get(currentIndex);

            // Verificamos si el ciclo for comienza con la palabra clave "for"
            if (currentToken.getValue().equals("for")) {
                // Si encuentra un ciclo for, verifica la estructura interna
                currentIndex++; // Avanzamos al siguiente token
                if (currentIndex < tokenCount && tokens.get(currentIndex).getValue().equals("(")) {
                    // Avanzamos al siguiente token
                    currentIndex++;
                    // Aquí validarías la estructura dentro del ciclo for, por ejemplo, variables, condiciones, etc.
                    // Implementa tu lógica de validación aquí
                    // Asumiendo que la estructura dentro del ciclo for es válida, avanzamos hasta el final del ciclo for
                    while (currentIndex < tokenCount && !tokens.get(currentIndex).getValue().equals(")")) {
                        currentIndex++;
                    }
                    if (currentIndex >= tokenCount) {
                        // No se encontró el paréntesis de cierre
                        return false;
                    }
                    // Si se encontró el paréntesis de cierre, avanzamos al siguiente token
                    currentIndex++;
                } else {
                    // No se encontró el paréntesis de apertura
                    return false;
                }
            }

            // Verificamos si hay otros tipos de estructuras como while, if, etc.
            // Implementa la lógica similar para validar otras estructuras

            // Avanzamos al siguiente token
            currentIndex++;
        }

        // Si hemos llegado hasta aquí sin encontrar ninguna discrepancia, el código es válido
        return true;
    }





}
