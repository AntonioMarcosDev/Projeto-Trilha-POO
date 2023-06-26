public class Menu {
    public static void exibir() {
        System.out.println("\t\t\t\t" + "=".repeat(17));
        System.out.println("\t\t\t\t" + "= JOGO DA FORCA =");
        System.out.println("\t\t\t\t" + "=".repeat(17));
        System.out.println("Escolha entre um dos temas disponíveis ou se aventure no modo aleatório, com todos os temas combinados");
        System.out.println("Você pode tentar adivinhar a palavra completa, mas lembre-se:\nSe errar, você perde TODAS as tentativas restantes. CUIDADO!");
        System.out.println("Opções de temas:");
        System.out.println("1 - Animais");
        System.out.println("2 - Frutas");
        System.out.println("3 - Países");
        System.out.println("4 - Aleatório");
        System.out.print("Digite uma opção: ");
    }

    public static Tema selecionarTema(int opcao) {
        return switch (opcao) {
            case 1 -> new Animais();
            case 2 -> new Frutas();
            case 3 -> new Paises();
            case 4 -> new Geral();
            default -> throw new IllegalArgumentException("Opção inválida");
        };
    }
}
