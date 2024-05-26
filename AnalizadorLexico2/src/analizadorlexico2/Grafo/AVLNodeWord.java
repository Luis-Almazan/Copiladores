/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorlexico2.Grafo;


public class AVLNodeWord {
    private String word;
    private AVLNodeWord left;
    private AVLNodeWord right;
    private int height;

    public AVLNodeWord(String word) {
        this.word = word;
        this.height = 0;
    }

    public String getWord() {
        return word;
    }

    public AVLNodeWord getLeft() {
        return left;
    }

    public void setLeft(AVLNodeWord left) {
        this.left = left;
    }

    public AVLNodeWord getRight() {
        return right;
    }

    public void setRight(AVLNodeWord right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
