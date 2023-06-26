import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        //Exibir o menu inicial
        Menu.exibir();

        // Escolher o tema do jogo
        Scanner entrada = new Scanner(System.in);
        int opcao = entrada.nextInt();
        Tema tema = Menu.selecionarTema(opcao);

        // Quantidade de palavras possíveis
        int tamanho = tema.quantidadePalavras();
        System.out.println("Esse tema tem " + tamanho + " palavaras");

        // Criação do jogo
        JogoDaForca jogo = new JogoDaForca(tema.obterPalavra());
        jogo.iniciarJogo();

        // Jogando...
        String palpite;
        do {
            System.out.print("Insira uma letra ou tente acertar a palavra: ");
            palpite = entrada.next().toUpperCase();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            if (palpite.length() > 1) {
                jogo.tentarPalavra(palpite);
            } else {
                jogo.tentarLetra(palpite.charAt(0));
            }
        } while (!jogo.isJogoTerminado());

        entrada.close();
    }

}