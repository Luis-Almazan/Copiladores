/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizador;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Luis Almazan
 */
public class analizadorParte1 {
    // Contador de identificadores
    private int contadorIdentificadores = 0;
    public void Ingreso_Texto(InputStream Token){
        // Formatea Los Datos
        String[] tokens= Formatear_Datos(Token);
        // Mostrar la tabla con los tokens clasificados
        System.out.println("Token\t\tClasificación");
        System.out.println("-------------------------------");
        //Ciclo para Generar la Tabla
        for (String token : tokens) {
            String clasificacion = clasificarToken(token);
            if (clasificacion.equals("Identificador")) {
                contadorIdentificadores++;
                System.out.println(token + "\t\t" + clasificacion + " " + contadorIdentificadores);
            } else {
                System.out.println(token + "\t\t" + clasificacion);
            }
        }
        
    }
    
    // Metodo para Formatear Dados de un texto ingresado 
    private String[] Formatear_Datos(InputStream Token){
        Scanner scanner = new Scanner(Token);
        scanner.useDelimiter("'|\\s+");
        String expresion = scanner.nextLine();
        // Dividir la expresión en tokens
        String[] tokens = expresion.split("'|\\s+");
        return tokens;
        
    }
    
    // Método para clasificar un token como identificador, operador u otro
    private static String clasificarToken(String token) {
        if (token.startsWith("'") && token.endsWith("'")) {
        return "Comentarios";
        }
        // Si es un identificador (asumiendo que comienza con una letra seguida de letras y/o números)
        if (token.matches("[a-zA-Z][a-zA-Z0-9]*")) {
            return "Identificador";
        }
        // Si es un operador (por ejemplo, +, -, *, /, etc.)
        else if (token.matches("[+\\-*/]")) {
            return "Operador";
        }
        else if (token.matches("[()\\[\\]{}]+")) {
        return "Agrupacion";
        }
        // Todo lo que no es parte de del Alfabeto o numeros 
        else if (token.matches("[^a-zA-Z0-9]+")) {
        return "Simbolo";
        }
        // Si Son numeros
        else if (token.matches("[0-9]+")) {
        return "Numero";
        }
        // Si no coincide con ninguna de las clasificaciones anteriores
        else {
            return "No Especificado";
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //Con Numeros 
    private static String Type_with_Number(String token) {
        // Si es un identificador (asumiendo que comienza con una letra seguida de letras y/o números)
        if (token.matches("[a-zA-Z0-9]*[a-zA-Z0-9]*")) {
            return "Identificador";
        }
        // Si es un operador (por ejemplo, +, -, *, /, etc.)
        else if (token.matches("[+\\-*/]")) {
            return "Operador";
        }
        // Si no coincide con ninguna de las clasificaciones anteriores
        else {
            return "Otro";
        }
    }
}
