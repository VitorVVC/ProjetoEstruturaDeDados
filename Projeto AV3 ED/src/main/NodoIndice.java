package main;

public class NodoIndice {
    public String palavra;
    public ListaDuplamenteEncadeada linhas;
    public NodoIndice esquerdo;
    public NodoIndice direito;

    public NodoIndice(String palavra) {
        this.palavra = palavra;
        this.linhas = new ListaDuplamenteEncadeada();
        this.esquerdo = null;
        this.direito = null;
    }

    public void adicionarLinha(int linha) {
        linhas.insereFinal(String.valueOf(linha));
    }
}
