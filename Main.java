import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Exibir o menu inicial
        Menu.exibir();

        // Escolher o tema do jogo
        Scanner entrada = new Scanner(System.in);
        Tema tema = null;
        do {
            System.out.print("Digite uma opção: ");
            int opcao = entrada.nextInt();
            entrada.nextLine();
            // Tratar exceção de opção não disponível
            try {
                tema = Menu.selecionarTema(opcao);
            } catch (IllegalArgumentException e) {
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (tema == null);

        // Quantidade de palavras possíveis
        int tamanho = tema.quantidadePalavras();
        String nome = (tema.getClass().getSimpleName().equals("Geral")) ? "possibilidades" : tema.getClass().getSimpleName();
        System.out.println("Existem " + tamanho + " " + nome + " no Banco de Palavras");

        // Criação do jogo
        JogoDaForca jogo = new JogoDaForca(tema.obterPalavra());
        jogo.iniciarJogo();

        // Jogando...
        do {
            String palpite;
            System.out.print("Insira uma letra ou tente acertar a palavra: ");
            palpite = entrada.nextLine().toUpperCase();
            // Permitir apenas letras como palpite
            while (!palpite.matches("[A-ZÁÀÂÃÉÈÍÓÔÕÚÇ ]+$") || (palpite.charAt(0) == ' ')) {
                System.out.println("Palpite Inválido");
                System.out.print("Insira uma letra ou tente acertar a palavra: ");
                palpite = entrada.nextLine().toUpperCase();
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();
            if (palpite.length() > 1) {
                jogo.receberPalpite(palpite);
            } else {
                jogo.receberPalpite(palpite.charAt(0));
            }
        } while (!jogo.isJogoTerminado());

        entrada.close();
    }

}