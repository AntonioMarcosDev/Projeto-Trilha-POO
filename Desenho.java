public class Desenho {
    String[] desenho = {
            "\t\t\t\t\t\t\t  +---+",
            "\t\t\t\t\t\t\t  |   |",
            "\t\t\t\t\t\t\t      |",
            "\t\t\t\t\t\t\t      |",
            "\t\t\t\t\t\t\t      |",
            "\t\t\t\t\t\t\t      |",
            "\t\t\t\t\t\t\t========="
    };

    // Para exibir o desenho atual
    public void imprime() {
        for (String linha : desenho) {
            System.out.println(linha);
        }
    }

    // Para atualizar o desenho conforme o jogador erra as letras
    public void atualiza(int tentativas) {
        switch (tentativas) {
            case 5 -> desenho[2] = "\t\t\t\t\t\t\t  O   |";
            case 4 -> desenho[3] = "\t\t\t\t\t\t\t  |   |";
            case 3 -> desenho[3] = "\t\t\t\t\t\t\t /|   |";
            case 2 -> desenho[3] = "\t\t\t\t\t\t\t /|\\  |";
            case 1 -> desenho[4] = "\t\t\t\t\t\t\t /    |";
            case 0 -> desenho[4] = "\t\t\t\t\t\t\t / \\  |";
        }
    }
}