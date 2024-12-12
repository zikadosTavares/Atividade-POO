public class Pessoa {
    private String nome;
    private String cpf;
    private String telefone;

    public Pessoa(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Nome=" + nome + "\nCPF=" + cpf + "\nTelefone=" + telefone;
    }

    public String getNome() {
        
        return nome;
    }
}
    

