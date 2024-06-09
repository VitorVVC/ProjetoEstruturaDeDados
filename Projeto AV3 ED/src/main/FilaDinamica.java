package main;
public class FilaDinamica<T> {

    class Nodo {

        public T elemento;
        public Nodo proximo;

        public Nodo(T elemento) {
            this.elemento = elemento;
            this.proximo = null;
        }
    }

    private Nodo inicio;
    private Nodo fim;
    private int nElementos;

    public FilaDinamica() {
        this.inicio = null;
        this.fim = null;
        this.nElementos = 0;
    }

    public int tamanho() {
        return this.nElementos;
    }

    public boolean estaVazia() {
        return this.nElementos == 0;
    }

    public void imprime() {

        System.out.print("[");
        Nodo cursor = this.inicio;
        for (int i = 0; i < this.nElementos; i++) {
            System.out.print(cursor.elemento + " ");
            cursor = cursor.proximo;
        }
        if(this.nElementos == 0)
            System.out.println("] Inicio: " + this.inicio + ", Fim: " + this.fim);
        else
            System.out.println("] Inicio: " + this.inicio.elemento + ", Fim: " + this.fim.elemento);

    }

    public T desenfileira() {

        if (this.estaVazia()) {
            System.out.println("Lista vazia. Não é possível remover.");
            return null;
        }

        Nodo nodoRemovido = this.inicio;

        if(this.nElementos == 1) {
            this.inicio = null;
            this.fim = null;
        } else {
            this.inicio = nodoRemovido.proximo;

            nodoRemovido.proximo = null;
        }

        this.nElementos--;

        return nodoRemovido.elemento;

    }

    public void enfileira(T elemento) {

        Nodo novo = new Nodo(elemento);

        if (this.estaVazia()) {
            this.inicio = novo;
        } else {
            this.fim.proximo = novo;
        }

        this.fim = novo;
        this.nElementos++;
    }

    public T espia() {

        if (this.estaVazia()) {
            System.out.println("Lista vazia! Não é possível espiar.");
            return null;
        }

        return this.inicio.elemento;
    }

    public boolean contem(Integer elemento) {

        Nodo cursor = this.inicio;
        for (int i = 0; i < this.nElementos; i++) {
            if (cursor.elemento.equals(elemento)) {
                return true;
            }
            cursor = cursor.proximo;
        }

        return false;
    }
}