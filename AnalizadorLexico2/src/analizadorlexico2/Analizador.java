/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorlexico2;

import static analizadorlexico2.LexicalAnalyzer.analyze;
import java.util.List;
import java.util.Scanner;
/*
Version 2.0 Valor: 2 pts
Alfanumnerico en id Listo,
Mensajes de ERROR 
Reconocimiento de Simbolos .;$ 
Agregar Signos de Agrupacion (),{},[]. 
Mensajes "" '' / // /+ #LISTO 
Manejo de Errores Falto cambiar la forma en la que los muestra 
*/

/*
Version 3.0 Valor:  3pts
ERROR EN M4$
TOMAR COMO NUMERO 0.32 #LISTO
Comentarios #LISTO
Palabras Reservadas #LISTO
*/

/**
 *
 * @author Luis Almazan
 */
public class Analizador {
     public static void main(String[] args) {
        // TODO code application logic here
       Scanner scanner = new Scanner(System.in);
        StringBuilder inputBuilder = new StringBuilder();
        System.out.println("Ingresa el código fuente (termina con una línea en blanco):");

        // Leer el código fuente línea por línea hasta encontrar una línea en blanco
        String line;
        while (scanner.hasNextLine() && !(line = scanner.nextLine()).isEmpty()) {
            inputBuilder.append(line).append("\n");
        }
        scanner.close();

        // Analizar el código fuente
        String input = inputBuilder.toString();
        List<Token> tokens = analyze(input);

        // Imprimir los tokens encontrados
        for (Token token : tokens) {
            System.out.println(token);
        }
  
    }
}
