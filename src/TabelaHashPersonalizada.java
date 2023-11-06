public class TabelaHashPersonalizada {
    private Integer tamanho;
    private ListaEncadeada[] dados;
    private int colisoes = 0;

    public TabelaHashPersonalizada(Integer tamanho) {
        this.tamanho = tamanho;
        dados = new ListaEncadeada[tamanho];
    }

    public void inserir(Registro registro) {
        int posicao = funcaoHashPersonalizada(registro.getCodigoRegistro());
        if (dados[posicao] == null) {
            dados[posicao] = new ListaEncadeada();
            dados[posicao].inserir(registro);
        } else {
            dados[posicao].inserir(registro);
        }
    }

    public Registro buscar(int cod, int valor) {
        int posicao = funcaoHashRestoDivisao(cod);
        int comp = 0;
        if (dados[posicao] != null) {
            Node no = dados[posicao].buscar(valor);
            if (no != null) {
                Registro resultado =  no.getRegistro();
                comp = dados[posicao].getComparacoes();
                System.out.println("Comparações para a busca: " + comp);
                return resultado;
            }
        }
        posicao = funcaoHashComMultiplicacao(cod);
        if (dados[posicao] != null) {
            Node no = dados[posicao].buscar(valor);
            if (no != null) {
                Registro resultado =  no.getRegistro();
                comp = dados[posicao].getComparacoes();
                System.out.println("Comparações para a busca: " + comp);
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
