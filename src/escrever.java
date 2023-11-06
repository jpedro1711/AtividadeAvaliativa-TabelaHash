import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class escrever {
    public static void main(String[] args) {
        Random random = new Random();
        int valor;
        int cod;
        int counter = 0;
        while (counter < 5000000) {
            valor = random.nextInt(999) + 1;
            cod = random.nextInt(900000000) + 100000000;
            String linha = cod + ", " + valor;
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("./src/5000000dados.txt", true))) {
                bw.write(linha);
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            counter++;
        }
    }
}
