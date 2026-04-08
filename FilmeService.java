import java.util.ArrayList;

public class FilmeService {
    private ArrayList<Filme> filmes = new ArrayList<>();

    // Adicionar filme
    public void adicionarFilme(Filme filme) {
        filmes.add(filme);
    }

    // Listar filmes (console - ainda útil)
    public void listarFilmes() {
        for (Filme f : filmes) {
            System.out.println(f);
        }
    }

    // Buscar por ID
    public Filme buscarPorId(int id) {
        for (Filme f : filmes) {
            if (f.getId() == id) {
                return f;
            }
        }
        return null;
    }

    // Alugar filme
    public void alugarFilme(int id) {
        Filme f = buscarPorId(id);
        if (f != null && f.isDisponivel()) {
            f.setDisponivel(false);
        }
    }

    // Devolver filme
    public void devolverFilme(int id) {
        Filme f = buscarPorId(id);
        if (f != null && !f.isDisponivel()) {
            f.setDisponivel(true);
        }
    }

    public boolean removerFilme(int id) {
        Filme f = buscarPorId(id);
        if (f != null) {
            filmes.remove(f);
            return true;
    }
    return false;
    }

    // retornar lista (necessário pra interface)
    public ArrayList<Filme> getFilmes() {
        return filmes;
    }
}