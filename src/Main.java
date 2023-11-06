import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TabelaHash tabelaHash = new TabelaHash(40000);
        TabelaHashMultiplicacao hashMultiplicacao = new TabelaHashMultiplicacao(40000);
        TabelaHashPersonalizada hashPersonalizada = new TabelaHashPersonalizada(40000);
        //long tempoInicial = System.currentTimeMillis();
        File file = new File("./src/1000000dados.txt");
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String[] dados = linha.split(",");
                if (dados.length >= 2) {
                    String cod = dados[0].trim();
                    String dado = dados[1].trim();
                    Registro r = new Registro(Integer.parseInt(cod), Integer.parseInt(dado));
                    //tabelaHash.inserir(r);
                    //hashMultiplicacao.inserir(r);
                    hashPersonalizada.inserir(r);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Colisões: " + hashPersonalizada.pegarColisoes());

        long tempoInicial;
        long tempoFinal;

        System.out.println();
        System.out.println("HASH RESTO DIVISÃO");
        tempoInicial = System.currentTimeMillis();
        System.out.println(hashPersonalizada.buscar(679514138, 599));
        tempoFinal = System.currentTimeMillis() - tempoInicial;
        System.out.println("tempo de execução hash resto divisão " + tempoFinal + " ms");

    }
}