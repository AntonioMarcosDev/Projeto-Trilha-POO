import java.util.ArrayList;
import java.util.Random;

public abstract class Tema {
    protected ArrayList<String> palavras = new ArrayList<>();
    protected Random random = new Random();

    public abstract String obterPalavra();

    public int quantidaDePalavras(){
        return palavras.size();
    };

    public String nomeTema(){
        return this.getClass().getSimpleName();
    }
}