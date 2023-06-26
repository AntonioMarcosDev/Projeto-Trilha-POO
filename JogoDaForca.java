import java.text.Normalizer;

public class JogoDaForca implements Jogo {
    private String palavra;
    private StringBuilder palavraParcial;
    private StringBuilder letrasUsadas;
    private int tentativas;
    private Desenho forca;
    private String palavraSemAcentos;

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
    public void tentarLetra(char letra) {
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
        System.out.println("Letras Usadas: " + letrasUsadas.toString());
    }

    // Implementação do método tentarPalavra
    @Override
    public void tentarPalavra(String palavra) {
        if (this.palavra.equals(palavra)) {
            palavraParcial.replace(0, palavra.length(), palavra);
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
        } else if (palavra.equals(palavraParcial.toString())) {
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
            if (palavra.charAt(i) == ' '){
                palavraParcial.setCharAt(i, ' ');
            }
        }
    }

    private String removerAcentos(String palavra) {
        return Normalizer.normalize(palavra, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
}

