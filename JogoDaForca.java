import java.text.Normalizer;

public class JogoDaForca implements Jogo {
    private final String palavra;
    private StringBuilder palavraParcial;
    private final StringBuilder letrasUsadas;
    private int tentativas;
    private final Desenho forca;
    private final String palavraSemAcentos;

    // Construtor que recebe uma palavra do banco
    public JogoDaForca(String palavra) {
        this.palavra = palavra;
        iniciandoPalavra();
        this.letrasUsadas = new StringBuilder(26);
        this.tentativas = 6;
        this.forca = new Desenho();
        this.palavraSemAcentos = removerAcentos(palavra);
    }

    // Implementação do método iniciarJogo
    @Override
    public void iniciarJogo() {
        System.out.println("Palavra: " + palavraParcial.toString() + " com " + palavra.length() + " letras");
        forca.imprime();
        System.out.println("Tentativas restantes: " + tentativas);
    }

    // Implementação do método tentarLetra
    @Override
    public void receberPalpite(char letra) {
        letrasUsadas.append(letra);
        boolean letraEncontrada = false;
        for (int i = 0; i < palavra.length(); i++) {
            if (palavraSemAcentos.charAt(i) == letra) {
                palavraParcial.setCharAt(i, palavra.charAt(i));
                letraEncontrada = true;
            }
        }
        if (!letraEncontrada) {
            tentativas--;
            forca.atualiza(tentativas);
        }
        System.out.println("Palavra: " + palavraParcial.toString() + " com " + palavra.length() + " letras");
        forca.imprime();
        System.out.println("Tentativas restantes: " + tentativas);
        System.out.println("Letras Usadas: " + letrasUsadas);
    }

    // Implementação do método tentarPalavra
    @Override
    public void receberPalpite(String palavra) {
        if (this.palavra.equals(palavra)) {
            palavraParcial.replace(0, palavraParcial.length(), palavra);
        } else {
            tentativas = 0;
        }
    }

    // Implementação do método isJogoTerminado
    @Override
    public boolean isJogoTerminado() {
        if (tentativas == 0) {
            System.out.println("Você perdeu! A palavra correta era: " + palavra);
            return true;
        } else if (palavra.contentEquals(palavraParcial)) {
            System.out.println("Parabéns! Você venceu!");
            return true;
        }
        return false;
    }

    private void iniciandoPalavra() {
        this.palavraParcial = new StringBuilder("_".repeat(palavra.length()));
        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) == '-') {
                palavraParcial.setCharAt(i, '-');
            }
            if (palavra.charAt(i) == ' ') {
                palavraParcial.setCharAt(i, ' ');
            }
        }
    }

    private String removerAcentos(String palavra) {
        return Normalizer.normalize(palavra, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
}

