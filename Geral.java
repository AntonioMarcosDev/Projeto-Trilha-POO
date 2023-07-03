import java.io.*;

public class Geral extends Tema {
    public Geral() {
        try {
            // Obter os todos os arquivos do diretório informado
            final String caminhoDiretorio = "Banco" + File.separator;
            File directory = new File(caminhoDiretorio);
            File[] files = directory.listFiles(); // Lista de arquivos no diretório

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        FileReader fileReader = new FileReader(file);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        String line;

                        while ((line = bufferedReader.readLine()) != null) {
                            palavras.add(line);
                        }

                        bufferedReader.close();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("O arquivo pode ter sido apagado ou movido. Certifique-se que existem aruivos com a extensão .txt no diretório Banco");
            ;
        }
    }

    // Implementação do método abstrato para obter uma palavra
    @Override
    public String obterPalavra() {
        int indice = random.nextInt(palavras.size());
        return palavras.get(indice);
    }

    @Override
    public String nomeTema(){
        return "possibilidades";
    }
}