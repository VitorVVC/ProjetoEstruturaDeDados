package main;

public class ArvoreBinariaBuscaComIndice {

    public NodoIndice raiz;

    public ArvoreBinariaBuscaComIndice() {
        this.raiz = null;
    }

    public void insere(String palavra, int linha) {
        this.raiz = insereRecursivo(this.raiz, palavra, linha);
    }

    private NodoIndice insereRecursivo(NodoIndice nodo, String palavra, int linha) {
        if (nodo == null) {
            nodo = new NodoIndice(palavra);
            nodo.adicionarLinha(linha);
            return nodo;
        }

        if (palavra.compareTo(nodo.palavra) < 0) {
            nodo.esquerdo = insereRecursivo(nodo.esquerdo, palavra, linha);
        } else if (palavra.compareTo(nodo.palavra) > 0) {
            nodo.direito = insereRecursivo(nodo.direito, palavra, linha);
        } else {
            nodo.adicionarLinha(linha);
        }

        return nodo;
    }

    public NodoIndice buscar(String palavra) {
        return buscarRecursivo(raiz, palavra);
    }

    private NodoIndice buscarRecursivo(NodoIndice nodo, String palavra) {
        if (nodo == null || palavra.equals(nodo.palavra)) {
            return nodo;
        }

        if (palavra.compareTo(nodo.palavra) < 0) {
            return buscarRecursivo(nodo.esquerdo, palavra);
        } else {
            return buscarRecursivo(nodo.direito, palavra);
        }
    }

    public void emOrdem(NodoIndice nodo, ListaDuplamenteEncadeada lista) {
        if (nodo != null) {
            emOrdem(nodo.esquerdo, lista);
            lista.insereFinal(nodo.palavra);
            emOrdem(nodo.direito, lista);
        }
    }
}
