/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package triangulo;

/**
 *
 * @author Luis Almazan
 */
public class Triangulo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         int n = 5; // Altura del triángulo
        imprimirTriangulo(n);
    }

    // Método para imprimir el triángulo
    public static void imprimirTriangulo(int n) {
        if (n > 0) {
            imprimirTriangulo(n - 1);
            imprimirLinea(n);
        }
        
    }
    public static void imprimirLinea(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }
    
}
