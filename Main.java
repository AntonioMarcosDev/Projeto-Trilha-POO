import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Exibir o menu inicial
        Menu.exibir();

        // Escolher o tema do jogo
        Scanner entrada = new Scanner(System.in);
        Tema tema = null;
        /*Tratar exceção de opção não disponível*/
        do {
            try {
                // Tratar casos onde a opcção digitada não foi um número
                String opcao;
                System.out.print("Digite uma opção: ");
                opcao = entrada.nextLine();
                while (!opcao.matches("[0-9]+$")) {
                    System.out.println("Opção informada não é um número");
                    System.out.print("Por favor, escolha uma opção válida:");
                    opcao = entrada.nextLine();
                }
                tema = Menu.selecionarTema(Integer.parseInt(opcao));
            } catch (IllegalArgumentException e) {
                System.out.println("Opção inválida. Por favor, escolha uma opção válida:");
            }
        } while (tema == null);

        // Limpar Terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Informações sobre o tema escolhido
        int tamanho = tema.quantidaDePalavras();
        String nome = tema.nomeTema();
        System.out.println("Existem " + tamanho + " " + nome + " no Banco de Palavras");

        // Criação do jogo
        JogoDaForca jogo = new JogoDaForca(tema.obterPalavra());
        jogo.iniciarJogo();

        // Jogando...
        do {
            String palpite;
            System.out.print("Insira uma letra ou tente acertar a palavra: ");
            palpite = entrada.nextLine().toLowerCase();
            // Permitir apenas letras como palpite
            while (!palpite.matches("[a-záàâãéíóôõúç -]+$") || (palpite.charAt(0) == ' ') || (palpite.charAt(0) == '-')) {
                System.out.println("Palpite Inválido");
                System.out.print("Insira uma letra ou tente acertar a palavra: ");
                palpite = entrada.nextLine().toLowerCase();
            }
            palpite = palpite.toUpperCase();
            // Limpar Terminal
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