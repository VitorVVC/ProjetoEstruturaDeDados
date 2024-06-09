package main;

public class ListaDuplamenteEncadeada {
    public static class Nodo {
        public String valor;
        public Nodo proximo;
        public Nodo anterior;

        public Nodo(String valor) {
            this.valor = valor;
            this.proximo = null;
            this.anterior = null;
        }
    }

    public Nodo primeiro;
    public Nodo ultimo;
    private int tamanho;

    public ListaDuplamenteEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public void insereInicio(String valor) {
        Nodo novoNodo = new Nodo(valor);
        if (primeiro == null) {
            primeiro = novoNodo;
            ultimo = novoNodo;
        } else {
            novoNodo.proximo = primeiro;
            primeiro.anterior = novoNodo;
            primeiro = novoNodo;
        }
        tamanho++;
    }

    public void insereFinal(String valor) {
        Nodo novoNodo = new Nodo(valor);
        if (ultimo == null) {
            primeiro = novoNodo;
            ultimo = novoNodo;
        } else {
            ultimo.proximo = novoNodo;
            novoNodo.anterior = ultimo;
            ultimo = novoNodo;
        }
        tamanho++;
    }

    public boolean contem(String valor) {
        Nodo atual = primeiro;
        while (atual != null) {
            if (atual.valor.equals(valor)) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public Nodo buscar(String valor) {
        Nodo atual = primeiro;
        while (atual != null) {
            if (atual.valor.startsWith(valor + " ")) {
                return atual;
            }
            atual = atual.proximo;
        }
        return null;
    }

    public int tamanhoLista() {
        return tamanho;
    }

    public void imprimirLista() {
        Nodo atual = primeiro;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}
