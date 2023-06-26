import java.util.ArrayList;
import java.util.Random;

public abstract class Tema {
    protected ArrayList<String> palavras = new ArrayList<>();
    protected Random random = new Random();

    abstract String obterPalavra();

    abstract int quantidadePalavras();
}