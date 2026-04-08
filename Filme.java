public class Filme {
    private int id;
    private String nome;
    private String genero;
    private boolean disponivel;

    public Filme(int id, String nome, String genero) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.disponivel = true;
    }

    // getters e setters

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getGenero() { return genero; }
    public boolean isDisponivel() { return disponivel; }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               " | Nome: " + nome +
               " | Gênero: " + genero +
               " | Disponível: " + (disponivel ? "Sim" : "Não");
    }
}