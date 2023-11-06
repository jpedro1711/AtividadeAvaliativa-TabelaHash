public class ListaEncadeada {
    private Node comeco = null;
    private int tamanho = 0;
    private int comparacoes = 0;

    public ListaEncadeada() {
    }

    public void inserir(Registro registro) {
        Node novo = new Node();
        novo.setRegistro(registro);

        if (comeco == null) {
            comeco = novo;
            this.tamanho++;
        } else {
            Node aux = comeco;
            Node anterior = null;

            while (aux != null && registro.getInfo() > aux.getRegistro().getInfo()) {
                anterior = aux;
                aux = aux.getProx();
            }

            if (anterior == null) {
                novo.setProx(comeco);
                comeco = novo;
                this.tamanho++;
            } else {
                anterior.setProx(novo);
                novo.setProx(aux);
                this.tamanho++;
            }
        }
    }


    public void remover(int info) {
        if (comeco != null) {
            if (comeco.getRegistro().getInfo() == info) {
                comeco = comeco.getProx();
                this.tamanho--;
            }
            else {
                Node aux = comeco.getProx();
                Node anterior = comeco;
                while (aux.getRegistro().getInfo() != info) {
                    anterior = aux;
                    aux = aux.getProx();
                }
                anterior.setProx(aux.getProx());
                aux = null;
                this.tamanho--;
            }
        }
    }

    public Node buscar(int valor) {
        Node aux = comeco;
        while (aux != null && aux.getRegistro().getInfo() != valor) {
            aux = aux.getProx();
            comparacoes++;
        }
        return aux;
    }

    public void imprimir() {
        Node aux = comeco;
        System.out.print("[");
        while (aux != null) {
            if (aux.getProx() != null) {
                System.out.print(aux.getRegistro().getInfo() + " ");
            } else {
                System.out.print(aux.getRegistro().getInfo());
            }
            aux = aux.getProx();
        }
        System.out.print("]");
        System.out.println();
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getComparacoes() {
        return comparacoes;
    }
}
