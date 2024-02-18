/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package analizador;
import java.util.Scanner;
/**
 *
 * @author Luis Almazan
 */
/*
Version 2.0 Valor: 2 pts
Alfanumnerico en id Listo,
Mensajes de ERROR 
Reconocimiento de Simbolos .;$ # LISTO
Agregar Signos de Agrupacion (),{},[]. LISTO 
Mensajes "" '' / // /+ #Faltaron los mensajes 
Manejo de Errores Falto cambiar la forma en la que los muestra 
*/

/*
Version 3.0 Valor:  3pts
ERROR EN M4$
TOMAR COMO NUMERO 0.32
Comentarios
Palabras Reservadas
*/
public class Analizador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        analizadorParte1 Lexico = new analizadorParte1();
        System.out.print("Ingrese la expresión: ");
        
        Lexico.Ingreso_Texto(System.in);
  
    }
    
    
}
        
        
        

    

