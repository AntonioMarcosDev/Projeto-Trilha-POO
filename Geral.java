import java.io.*;

public class Geral extends Tema {
    public Geral() {
        try {
            // Abrindo o arquivo
            File file = new File("Animais.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            // Percorrendo o arquivo e salvando no Array
            while ((line = bufferedReader.readLine()) != null) {
                palavras.add(line);
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Implementação do método abstrato para obter uma palavra
    @Override
    public String obterPalavra() {
        int indice = random.nextInt(palavras.size());
        return palavras.get(indice);
    }

    @Override
    int quantidadePalavras() {
        return palavras.size();
    }
}