import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TelaFilmes extends JFrame {

    private FilmeService service = new FilmeService();

    private JTextField campoNome;
    private JTextField campoGenero;
    private JTextField campoId;
    private JTextArea areaFilmes;

    public TelaFilmes() {
        setTitle("Locadora de Filmes");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // 🔹 CAMPOS
        add(new JLabel("Nome:"));
        campoNome = new JTextField(15);
        add(campoNome);

        add(new JLabel("Gênero:"));
        campoGenero = new JTextField(15);
        add(campoGenero);

        add(new JLabel("ID:"));
        campoId = new JTextField(5);
        add(campoId);

        // 🔹 BOTÕES
        JButton btnAdicionar = new JButton("Adicionar");
        add(btnAdicionar);

        JButton btnListar = new JButton("Listar");
        add(btnListar);

        JButton btnAlugar = new JButton("Alugar");
        add(btnAlugar);

        JButton btnDevolver = new JButton("Devolver");
        add(btnDevolver);

        JButton btnRemover = new JButton("Remover");
        add(btnRemover);

        // 🔹 ÁREA DE TEXTO
        areaFilmes = new JTextArea(10, 40);
        areaFilmes.setEditable(false);
        add(new JScrollPane(areaFilmes));

        // 🔹 AÇÃO ADICIONAR
        btnAdicionar.addActionListener(e -> {
            String nome = campoNome.getText();
            String genero = campoGenero.getText();

            if (!nome.isEmpty() && !genero.isEmpty()) {
                int id = (int) (Math.random() * 1000);

                service.adicionarFilme(new Filme(id, nome, genero));

                JOptionPane.showMessageDialog(null, "Filme adicionado!");

                campoNome.setText("");
                campoGenero.setText("");

                atualizarLista();
            } else {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            }
        });

        // 🔹 LISTAR
        btnListar.addActionListener(e -> atualizarLista());

        // 🔹 ALUGAR
        btnAlugar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(campoId.getText());
                service.alugarFilme(id);

                JOptionPane.showMessageDialog(null, "Filme alugado!");

                atualizarLista();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ID inválido!");
            }
        });

        // 🔹 DEVOLVER
        btnDevolver.addActionListener(e -> {
            try {
                int id = Integer.parseInt(campoId.getText());
                service.devolverFilme(id);

                JOptionPane.showMessageDialog(null, "Filme devolvido!");

                atualizarLista();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ID inválido!");
            }
        });

        // 🔹 REMOVER
        btnRemover.addActionListener(e -> {
            try {
                int id = Integer.parseInt(campoId.getText());

                service.removerFilme(id);

                JOptionPane.showMessageDialog(null, "Filme removido!");

                atualizarLista();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ID inválido!");
            }
        });
    }

    // 🔄 ATUALIZA LISTA
    private void atualizarLista() {
        areaFilmes.setText("");

        ArrayList<Filme> filmes = service.getFilmes();

        if (filmes.isEmpty()) {
            areaFilmes.setText("Nenhum filme cadastrado.");
            return;
        }

        for (Filme f : filmes) {
            areaFilmes.append(f.toString() + "\n");
        }
    }
}