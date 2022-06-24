package umasolucao.dados;
 
public class Pessoa {
    private String nome;
    private int telefone;
    private String endereco;

    /**
     * Construtor
     * @param nome Nome da pessoa
     * @param telefone Telefone da pessoa (apenas numeros)
     */
    public Pessoa(String nome, int telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " - " +
                "Telefone: " + telefone +
                "Endereço: " + endereco + "\n";
    }
}
