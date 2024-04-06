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
    
}
