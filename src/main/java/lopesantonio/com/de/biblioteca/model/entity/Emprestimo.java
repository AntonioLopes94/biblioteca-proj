package lopesantonio.com.de.biblioteca.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "emprestimo")
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "livro_id")
    private Livro livro;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "data_emprestimo")
    private LocalDate dataEmprestimo;
    @Column(name = "data_devolucao")
    private LocalDate dataDevolucao;
    @Column(name = "data_devolucao_prevista", nullable = false)
    private LocalDate dataDevolucaoPrevista;

    @Column(name = "multa")
    private Double multa = 0.0;

    public Emprestimo(Usuario usuario, Livro livro) {
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setDevolucaoEfetiva(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo){
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataEmprestimo.plusDays(15);
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public Livro getLivro() {
        return this.livro;
    }
}
