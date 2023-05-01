package GUI;

import entities.Produto;
import entities.ProdutoGravaDados;
import entities.ProdutoRecuperaDados;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TrioDeTechGUI extends JFrame {

    private JTable table;
    private DefaultTableModel model;
    private List<Produto> produtos;

    public TrioDeTechGUI() {
        super("Loja Trio de Tech");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        model = new DefaultTableModel(new Object[]{"Nome", "Preço"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton addButton = new JButton("Adicionar");
        addButton.addActionListener(e -> {
            String nome = JOptionPane.showInputDialog("Digite o nome do produto:");
            if (nome != null && !nome.trim().isEmpty()) {
                double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do produto:"));
                Produto produto = new Produto(nome, preco);
                produtos.add(produto);
                model.addRow(new Object[]{produto.getNome(), produto.getPreco()});
            }
        });

        JButton removeButton = new JButton("Remover");
        removeButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                produtos.remove(selectedRow);
                model.removeRow(selectedRow);
            }
        });

        JButton saveButton = new JButton("Salvar");
        saveButton.addActionListener(e -> {
            String fileName = JOptionPane.showInputDialog("Digite o nome do arquivo:");
            if (fileName != null && !fileName.trim().isEmpty()) {
                ProdutoGravaDados.escreverProdutosParaArquivo(produtos, fileName);
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(saveButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setSize(400, 300);
        setVisible(true);

        produtos = new ArrayList<>();

        String fileName = "produtos.txt";
        File file = new File(fileName);
        if (file.exists()) {
            produtos = ProdutoRecuperaDados.LerProdutosDoArquivo(fileName);
            for (Produto produto : produtos) {
                model.addRow(new Object[]{produto.getNome(), produto.getPreco()});
            }
        }
    }

    public static void main(String[] args) {
        new TrioDeTechGUI();
    }
}
