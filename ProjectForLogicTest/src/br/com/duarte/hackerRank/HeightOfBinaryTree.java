package br.com.duarte.hackerRank;

// Definição da classe para um nó na árvore binária
class Node {
    int data;
    Node left, right;

    // Construtor para inicializar um nó com um valor específico
    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class HeightOfBinaryTree {

    // Função para calcular a altura de uma árvore binária
    public static int height(Node root) {
        // Caso base: se a raiz for nula, a altura é -1
        if (root == null) {
            return -1;
        } else {
            // Recursivamente calcular a altura do filho esquerdo e direito
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            // A altura do nó atual é o máximo entre as alturas do filho esquerdo e direito, mais um para contar o próprio nó
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    // Função principal para testar o cálculo da altura
    public static void main(String[] args) {
        // Construindo uma árvore binária de exemplo
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Calculando e imprimindo a altura da árvore
        System.out.println("Altura da árvore binária: " + height(root));
    }
}
