public interface Jogo {
    void iniciarJogo();

    void receberPalpite(char letra);

    void receberPalpite(String palavra);

    boolean isJogoTerminado();
}