/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorlexico2;
import java.util.Scanner;
import analizadorlexico2.Grafo.AVLTreeWord;
import analizadorlexico2.Grafo.AVLTreeWordGraph;
import analizadorlexico2.Grafo.AVLNodeWord;

import java.util.List;
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
          
        // Construir un árbol AVL a partir de la lista de palabras
        AVLTreeWord avlTree = new AVLTreeWord();
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
       // List<Token> tokens = analyze(input);
       
         //String codigoFuente = "main int a = 5; float b = 3.5; if (a > 4) { a = a + 1; } ;";
         String codigoFuente = "main int a = 5; if (a > 4) { a = a + 1; } while (a < 10) { a = a + 1; } ; ";

        // Crear el analizador léxico y analizar el código fuente
        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();
       // List<Token> tokens = lexicalAnalyzer.analyze(codigoFuente);
        List<Token> tokens = lexicalAnalyzer.analyze(input);
        
        // Crear el analizador sintáctico con los tokens obtenidos
        SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer(tokens);

        // Realizar el análisis sintáctico
        try {
            syntaxAnalyzer.parse();
            System.out.println("Syntax analysis completed successfully.");
        } catch (RuntimeException e) {
            System.err.println("Syntax analysis failed: " + e.getMessage());
        }
        
        
        // Imprimir los tokens generados
        System.out.println("Tokens generados:");
        for (Token token : tokens) {
            System.out.println(token);
             avlTree.insert(token.getValue());
        }
        // Obtener el nodo raíz del árbol AVL
        AVLNodeWord root = avlTree.getRoot();
        // Crear una instancia de AVLTreeWordGraph para visualizar el árbol AVL
        AVLTreeWordGraph graph = new AVLTreeWordGraph(root);
        
        
        
        
        
        
        /*
        
        
        
        
        // Crear el analizador sintáctico y validar la lista de tokens
        //SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer(tokens);
        boolean esValidoSintacticamente = syntaxAnalyzer.validate();
        
        // Imprimir el resultado de la validación sintáctica
        System.out.println("El código es " + (esValidoSintacticamente ? "válido sintácticamente" : "inválido sintácticamente"));
        
        if (esValidoSintacticamente) {
            // Crear el analizador semántico y validar la lista de tokens
            SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer(tokens);
            boolean esValidoSemanticamente = semanticAnalyzer.analyze();
            
            // Imprimir el resultado de la validación semántica
            System.out.println("El código es " + (esValidoSemanticamente ? "válido semánticamente" : "inválido semánticamente"));
        } 
     */
        
    }
        
     public class Grafo{
     
          AVLTreeWord a =new AVLTreeWord();
     
          public AVLNodeWord getRoot() {
            return a.getRoot();
          }
     
     
     
     
     }    
     
     
     
     
}
