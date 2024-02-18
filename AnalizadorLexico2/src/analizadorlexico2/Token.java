/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorlexico2;

/**
 *
 * @author Luis Almazan
 */
public class Token {
    
    String dato;
    String Type;
    Token Next;

    public Token(String dato, String Type, Token Next) {
        this.dato = dato;
        this.Type = Type;
        this.Next = Next;
    }

    public Token() {
    }
    
}
