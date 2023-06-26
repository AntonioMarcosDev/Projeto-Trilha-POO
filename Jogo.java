public interface Jogo {
    void iniciarJogo();

    void tentarLetra(char letra);

    void tentarPalavra(String palavra);

    boolean isJogoTerminado();
}