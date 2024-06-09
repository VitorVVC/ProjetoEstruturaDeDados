package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            // Leitura das palavras-chave
            ListaDuplamenteEncadeada palavrasChave = lerPalavrasChave("/Users/vitorvargas/Desktop/ProjetoAV3ED/Projeto AV3 ED/src/resources/palavras_chaves.txt");

            // Leitura do texto
            ListaDuplamenteEncadeada texto = lerTexto("/Users/vitorvargas/Desktop/ProjetoAV3ED/Projeto AV3 ED/src/resources/texto.txt");

            // Tabela hash para armazenar as palavras do texto com seus índices
            TabelaHashArvoreComIndice tabelaHash = new TabelaHashArvoreComIndice();

            // Processar o texto e inserir as palavras na tabela hash com seus índices
            ListaDuplamenteEncadeada.Nodo linhaAtual = texto.primeiro;
            int linhaNumero = 1;
            while (linhaAtual != null) {
                String[] palavras = linhaAtual.valor.split("\\W+");
                for (String palavra : palavras) {
                    if (!palavra.isEmpty()) {
                        tabelaHash.insere(palavra, linhaNumero);
                    }
                }
                linhaAtual = linhaAtual.proximo;
                linhaNumero++;
            }

            // Lista para armazenar as palavras-chave ordenadas
            ListaDuplamenteEncadeada palavrasOrdenadas = new ListaDuplamenteEncadeada();
            ListaDuplamenteEncadeada.Nodo palavraChaveAtual = palavrasChave.primeiro;
            while (palavraChaveAtual != null) {
                palavrasOrdenadas.insereFinal(palavraChaveAtual.valor);
                palavraChaveAtual = palavraChaveAtual.proximo;
            }

            // Escrever o índice remissivo em um arquivo de saída em ordem alfabética
            FileWriter writer = new FileWriter("/Users/vitorvargas/Desktop/ProjetoAV3ED/Projeto AV3 ED/src/resources/output.txt");

            // Ordena as palavras-chave e escreve no arquivo
            palavrasOrdenadas = ordenarLista(palavrasOrdenadas);
            palavraChaveAtual = palavrasOrdenadas.primeiro;
            while (palavraChaveAtual != null) {
                NodoIndice nodoIndice = tabelaHash.buscar(palavraChaveAtual.valor);
                if (nodoIndice != null) {
                    writer.write(nodoIndice.palavra + " ");
                    ListaDuplamenteEncadeada.Nodo linhaNodo = nodoIndice.linhas.primeiro;
                    while (linhaNodo != null) {
                        writer.write(linhaNodo.valor + " ");
                        linhaNodo = linhaNodo.proximo;
                    }
                    writer.write("\n");
                }
                palavraChaveAtual = palavraChaveAtual.proximo;
            }

            writer.close();

        } catch (IOException e) {
            System.err.println("Erro ao ler arquivos: " + e.getMessage());
        }
    }

    private static ListaDuplamenteEncadeada ordenarLista(ListaDuplamenteEncadeada lista) {
        if (lista.primeiro == null || lista.primeiro.proximo == null) {
            return lista;
        }

        ListaDuplamenteEncadeada.Nodo atual = lista.primeiro;
        ListaDuplamenteEncadeada.Nodo index = null;
        String temp;

        while (atual != null) {
            index = atual.proximo;

            while (index != null) {
                if (atual.valor.compareTo(index.valor) > 0) {
                    temp = atual.valor;
                    atual.valor = index.valor;
                    index.valor = temp;
                }
                index = index.proximo;
            }
            atual = atual.proximo;
        }

        return lista;
    }

    private static ListaDuplamenteEncadeada lerPalavrasChave(String caminhoArquivo) throws IOException {
        ListaDuplamenteEncadeada palavrasChave = new ListaDuplamenteEncadeada();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                palavrasChave.insereFinal(linha.trim());
            }
        }
        return palavrasChave;
    }

    private static ListaDuplamenteEncadeada lerTexto(String caminhoArquivo) throws IOException {
        ListaDuplamenteEncadeada texto = new ListaDuplamenteEncadeada();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                texto.insereFinal(linha);
            }
        }
        return texto;
    }
}
