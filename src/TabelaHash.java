public class TabelaHash {
    private Integer tamanho;
    private ListaEncadeada[] dados;
    private int colisoes = 0;

    public TabelaHash(Integer tamanho) {
        this.tamanho = tamanho;
        dados = new ListaEncadeada[tamanho];
    }

    public void inserir(Registro registro) {
        int posicao = funcaoHashRestoDivisao(registro.getCodigoRegistro());
        if (dados[posicao] == null) {
            dados[posicao] = new ListaEncadeada();
            dados[posicao].inserir(registro);
        } else {
            dados[posicao].inserir(registro);
        }
    }

    public Registro buscar(int cod, int valor) {
        int posicao = funcaoHashRestoDivisao(cod);
        if (dados[posicao] != null) {
            Node no =  dados[posicao].buscar(valor);
            if (no != null) {
                Registro resultado = no.getRegistro();
                int comparacoes = dados[posicao].getComparacoes();
                System.out.println("Comparações para a busca: " + comparacoes);
                return resultado;
            }
        }
        return null;
    }

    public void imprime() {
        for (int i = 0; i < tamanho; i++) {
            if (dados[i] != null) {
                System.out.print(i + " - ");
                dados[i].imprimir();
            } else {
                System.out.println(i + " - []");
            }
        }
    }

    public int funcaoHashRestoDivisao(int cod) {
        return cod % tamanho;
    }

    public int funcaoHashComMultiplicacao(int cod) {
        double resultado = (cod * 0.72) % tamanho;
        int resultInt = (int) resultado;
        return resultInt;
    }

    public int funcaoHashPersonalizada(int cod) {
        int posicao = funcaoHashRestoDivisao(cod);
        if (dados[posicao] != null) {
            posicao = funcaoHashComMultiplicacao(cod);
        }
        return posicao;
    }

    public int pegarColisoes() {
        int total = 0;
        for (int i = 0; i < tamanho; i++) {
            if (dados[i] != null) {
                total += dados[i].getTamanho() - 1;
            }
        }
        return total;
    }
}
