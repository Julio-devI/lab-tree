package tree;

import estrut.Tree;

class Node {
    int valor;
    Node esquerdo, direito;

    public Node(int item) {
        valor = item;
        esquerdo = direito = null;
    }
}

public class BinarySearchTree implements Tree{
    private Node raiz;

    @Override
    public boolean buscaElemento(int valor) {
        return true;
    }

    @Override
    public int minimo() {
        return 0;
    }

    @Override
    public int maximo() {
        return 0;
    }

    @Override
    public void insereElemento(int valor) {
        return;
    }

    private int encontraSucessor(Node raizSubArvore) {
        int minimo = raizSubArvore.valor;
        while (raizSubArvore.esquerdo != null) {
            minimo = raizSubArvore.esquerdo.valor;
            raizSubArvore = raizSubArvore.esquerdo;
        }
        return minimo;
    }

    private Node removeArvore(Node raizSubArvore, int valor){
        if (no == null) {
            return no;
        }

        // Busca pelo nó a ser removido
        if (valor < no.valor) {
            no.esquerdo = removeArvore(no.esquerdo, valor);
        } else if (valor > no.valor) {
            no.direito = removeArvore(no.direito, valor);
        } else {
            // Nó encontrado, trata os casos de remoção
            // Caso 1: O nó é uma folha ou tem um único filho
            if (no.esquerdo == null) {
                return no.direito;
            } else if (no.direito == null) {
                return no.esquerdo;
            }

            // Caso 2: O nó tem dois filhos
            // Encontra o sucessor in-order (o menor nó na subárvore direita)
            no.valor = encontraMinimo(no.direito);

            // Remove o sucessor in-order
            no.direito = removeArvore(no.direito, no.valor);
        }

        return no;
    }

    @Override
    public void remove(int valor) {
        raiz = removeArvore(raiz, valor);
        return;
    }

    @Override
    public int[] preOrdem() {
        return new int[]{1,2};
    }

    @Override
    public int[] emOrdem() {
        return new int[]{1,2};
    }

    @Override
    public int[] posOrdem() {
        return new int[]{1,2};
    }

}