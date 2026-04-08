import java.util.Scanner;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== SISTEMA DE FILMES ===");
        System.out.println("1 - Modo Console");
        System.out.println("2 - Interface Gráfica");
        System.out.print("Escolha: ");

        int escolha = sc.nextInt();

        if (escolha == 1) {
            rodarConsole();
        } else if (escolha == 2) {
            rodarInterface();
        } else {
            System.out.println("Opção inválida.");
        }

        sc.close();
    }

    // 🔹 MODO CONSOLE (seu código original organizado)
    public static void rodarConsole() {
        Scanner sc = new Scanner(System.in);
        FilmeService service = new FilmeService();

        int opcao;

        do {
            System.out.println("\n1 - Cadastrar Filme");
            System.out.println("2 - Listar Filmes");
            System.out.println("3 - Alugar Filme");
            System.out.println("4 - Devolver Filme");
            System.out.println("5 - Remover Filme");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Gênero: ");
                    String genero = sc.nextLine();

                    service.adicionarFilme(new Filme(id, nome, genero));
                    break;

                case 2:
                    service.listarFilmes();
                    break;

                case 3:
                    System.out.print("ID do filme: ");
                    service.alugarFilme(sc.nextInt());
                    break;

                case 4:
                    System.out.print("ID do filme: ");
                    service.devolverFilme(sc.nextInt());
                    break;

                case 5:
                    System.out.print("ID do filme: ");
                    service.removerFilme(sc.nextInt());
                    break;
            }

        } while (opcao != 0);

        sc.close();
    }

    // 🔹 MODO INTERFACE (Swing)
    public static void rodarInterface() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaFilmes().setVisible(true);
            }
        });
    }
}