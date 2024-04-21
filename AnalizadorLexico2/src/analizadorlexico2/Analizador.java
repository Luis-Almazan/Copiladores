/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorlexico2;

import analizadorlexico2.Grafo.AVLNodeWord;
import analizadorlexico2.Grafo.AVLTreeWord;
import analizadorlexico2.Grafo.AVLTreeWordGraph;
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
        List<Token> tokens = analyze(input);

        // Imprimir los tokens encontrados
        for (Token token : tokens) {
            System.out.println(token);
            avlTree.insert(token.getValue());
            
        }
        
        //boolean isValid = SyntaxAnalyzer.validate2(tokens);

        // Obtener el nodo raíz del árbol AVL
        AVLNodeWord root = avlTree.getRoot();
        // Crear una instancia de AVLTreeWordGraph para visualizar el árbol AVL
        AVLTreeWordGraph graph = new AVLTreeWordGraph(root);
        
        // Validar la sintaxis
        if (SyntaxAnalyzer.validate(tokens)) {
            System.out.println("La sintaxis del código es válida.");
        } else {
            System.out.println("Error de sintaxis en el código.");
        }
  
        if (SyntaxAnalyzer.validate3(tokens)) {
            System.out.println("El código es válido.2 ");
        } else {
            System.out.println("El código no es válido.2");
        }
        
        
        
        
    }
     
     public class Grafo{
     
          AVLTreeWord a =new AVLTreeWord();
     
          public AVLNodeWord getRoot() {
            return a.getRoot();
          }
     
     
     
     
     }    
     
     
     
     
}
