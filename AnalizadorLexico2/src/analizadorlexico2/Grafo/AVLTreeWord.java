/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorlexico2.Grafo;

/**
 *
 * @author Luis
 */
public class AVLTreeWord {


    private AVLNodeWord root;

    public AVLNodeWord getRoot() {
        return root;
    }

    private int height(AVLNodeWord node) {
        if (node == null) {
            return -1;
        } else {
            return node.getHeight();
        }
    }

    private int max(int a, int b) {
        return Math.max(a, b);
    }

    private AVLNodeWord rightRotate(AVLNodeWord y) {
        AVLNodeWord x = y.getLeft();
        AVLNodeWord z = x.getRight();
        x.setRight(y);
        y.setLeft(z);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        return x;
    }

    private AVLNodeWord leftRotate(AVLNodeWord x) {
        AVLNodeWord y = x.getRight();
        AVLNodeWord z = y.getLeft();
        y.setLeft(x);
        x.setRight(z);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        return y;
    }

    private int getBalance(AVLNodeWord node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    private AVLNodeWord insert(AVLNodeWord node, String word) {
        if (node == null) {
            return new AVLNodeWord(word);
        }
        if (word.compareTo(node.getWord()) < 0) {
            node.setLeft(insert(node.getLeft(), word));
        } else if (word.compareTo(node.getWord()) > 0) {
            node.setRight(insert(node.getRight(), word));
        } else {
            return node;
        }

        node.setHeight(max(height(node.getLeft()), height(node.getRight())) + 1);

        int balance = getBalance(node);

        if (balance > 1 && word.compareTo(node.getLeft().getWord()) < 0) {
            return rightRotate(node);
        }

        if (balance < -1 && word.compareTo(node.getRight().getWord()) > 0) {
            return leftRotate(node);
        }

        if (balance > 1 && word.compareTo(node.getLeft().getWord()) > 0) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        if (balance < -1 && word.compareTo(node.getRight().getWord()) < 0) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        return node;
    }

    public void insert(String word) {
        root = insert(root, word);
    }

    private void inOrderTraversal(AVLNodeWord node) {
        if (node != null) {
            inOrderTraversal(node.getLeft());
            System.out.print(node.getWord() + " ");
            inOrderTraversal(node.getRight());
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
        System.out.println();
    }


    
}
