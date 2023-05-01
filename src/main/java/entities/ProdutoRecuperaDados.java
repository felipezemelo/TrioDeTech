package entities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRecuperaDados {
    public static List<Produto> LerProdutosDoArquivo(String fileName) {
        List<Produto> produtos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {
            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(";");
                String nome = fields[0];
                double preco = Double.parseDouble(fields[1]);
                produtos.add(new Produto(nome, preco));
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return produtos;
    }
}
