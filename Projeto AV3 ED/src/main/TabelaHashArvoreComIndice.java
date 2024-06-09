package main;

public class TabelaHashArvoreComIndice {
    public ArvoreBinariaBuscaComIndice[] tabela;

    public TabelaHashArvoreComIndice() {
        this.tabela = new ArvoreBinariaBuscaComIndice[26];
        for (int i = 0; i < 26; i++) {
            tabela[i] = new ArvoreBinariaBuscaComIndice();
        }
    }

    private int funcaoHash(String palavra) {
        if (palavra == null || palavra.isEmpty()) {
            return -1; // Valor inválido para indicar string vazia ou nula
        }
        return Character.toLowerCase(palavra.charAt(0)) - 'a';
    }

    public void insere(String palavra, int linha) {
        int indice = funcaoHash(palavra);
        if (indice >= 0 && indice < 26) {
            tabela[indice].insere(palavra, linha);
        }
    }

    public NodoIndice buscar(String palavra) {
        int indice = funcaoHash(palavra);
        return (indice >= 0 && indice < 26) ? tabela[indice].buscar(palavra) : null;
    }

    public void emOrdem(ListaDuplamenteEncadeada lista) {
        for (int i = 0; i < 26; i++) {
            tabela[i].emOrdem(tabela[i].raiz, lista);
        }
    }
}
