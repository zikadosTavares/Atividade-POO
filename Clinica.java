import java.util.ArrayList;

public class Clinica {
    private ArrayList<Cachorro> cachorros;
    private ArrayList<Vacina> vacinas;

    public Clinica() {
        this.cachorros = new ArrayList<>(1000);
        this.vacinas = new ArrayList<>(1000);
    }
    
    public boolean cadastrarCachorro(Cachorro c) {
        if (cachorros.size() < 1000) {
            return cachorros.add(c);
        }
        return false;
    }
    
    public boolean cadastrarVacina(Vacina v) {
        if (vacinas.size() < 1000) {
            return vacinas.add(v);
        }
        return false;
    }
    
    public Cachorro pesquisarCachorro(String nome, String nomeTutor) {
        for (Cachorro c : cachorros) {

            if (c.getNome().equalsIgnoreCase(nome) && c.getTutor().getNome().equalsIgnoreCase(nomeTutor)) {
                return c;
            }
        }
        return null;
    }

    
    public Vacina pesquisarVacina(String nomeVacinaAplicacao) {
        for (Vacina v : vacinas) {
            if (v.getNome().equalsIgnoreCase(nomeVacinaAplicacao) && v.getDtAplicacao() == null) {
                return v;
            }
        }
        return null; 
    }
    
    public ArrayList<Vacina> getVacinasDisponiveis() {
        return vacinas; 
    }
    
    public ArrayList<Cachorro> getCachorrosCadastrados() {
        return cachorros;  
    }
}
