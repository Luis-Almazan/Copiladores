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
Alfanumnerico en id 
Mensajes de ERROR 
Reconocimiento de Simbolos .;$ #
Agregar Signos de Agrupacion (),{},[].
Mensajes "" '' / // /+
Manejo de Errores
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
        
        
        

    

