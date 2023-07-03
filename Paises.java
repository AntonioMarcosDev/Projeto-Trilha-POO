import java.io.*;

public class Paises extends Tema {
    public Paises() {
        final String caminhoArquivo = "Banco" + File.separator + "Paises.txt";
        try {
            // Abrindo o arquivo
            File file = new File(caminhoArquivo);
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
            System.out.println("O arquivo pode ter sido apagado ou movido. Certifique-se que existe um arquivo Paises.txt no diretório Banco");;
        }
    }

    // Implementação do método abstrato para obter uma palavra
    @Override
    public String obterPalavra() {
        int indice = random.nextInt(palavras.size());
        return palavras.get(indice);
    }

}