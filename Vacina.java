import java.time.LocalDate;

public class Vacina {
    private String nome;
    private String lote;
    private LocalDate dtVencimento;
    private LocalDate dtAplicacao;

    public Vacina(String nome, String lote, LocalDate dtVencimento) {
        this.nome = nome;
        this.lote = lote;
        this.dtVencimento = dtVencimento;
        this.dtAplicacao = null;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDtAplicacao() {
        return dtAplicacao;
    }

    public void setDtAplicacao(LocalDate dtAplicacao) {
        this.dtAplicacao = dtAplicacao;
    }
    public boolean isVencida() {
        return dtVencimento.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return "Nome=" + nome + ", Lote=" + lote + ", Vencimento=" + dtVencimento +
            ", Aplicação=" + (dtAplicacao == null ? "Não aplicada" : dtAplicacao+", Status=" + (isVencida() ? "Vencida" : "Válida") +
"\n---------------------");
    }
}
