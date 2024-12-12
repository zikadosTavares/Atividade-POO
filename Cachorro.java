import java.time.LocalDate;
import java.util.ArrayList;

public class Cachorro {
    private String nome;
    private Pessoa tutor;
    private String raca;
    private String cor;
    private char sexo;
    private LocalDate dtNascimento;
    private double peso;
    private ArrayList<Vacina> vacinas;

    public Cachorro(String nome, String raca, String cor, char sexo, LocalDate dtNascimento, double peso, Pessoa tutor) {
        this.nome = nome;
        this.raca = raca;
        this.cor = cor;
        this.sexo = sexo;
        this.dtNascimento = dtNascimento;
        this.peso = peso;
        this.tutor = tutor;
        this.vacinas = new ArrayList<>(30);
    }

    public boolean cadastrarVacina(Vacina v) {
        if (vacinas.size() < 30) {
            v.setDtAplicacao(LocalDate.now());
            return vacinas.add(v);
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("Nome=" + nome + "\nRaça=" + raca + "\nCor=" + cor +
                "\nSexo=" + sexo + "\nData de Nascimento=" + dtNascimento + "\nPeso=" + peso + "\nTutor=" + tutor + "\n");
        info.append("Vacinas:\n" + "\n");
        for (Vacina v : vacinas) {
            info.append(v).append("\n");
        }
        return info.toString();
    }

    public String getNome() {
        
        return nome;
    }

    public Pessoa getTutor() {
        
        return tutor;
    }
}


