package lopesantonio.com.de.biblioteca.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "emprestimos")
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "livro_id")
    private Livro livro;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "data_emprestimo")
    private LocalDate dataEmprestimo;
    @Column(name = "data_devolucao")
    private LocalDate dataDevolucao;
    @Column(name = "data_devolucao_prevista")
    private LocalDate dataDevolucaoPrevista;

    @Column(name = "multa")
    private Double multa = 0.0;

    public Emprestimo(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
    }

    public Emprestimo(){};

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



    public void setMulta(double multa) {
        this.multa = multa;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    public void setDataEmprestimo(LocalDate dataEmprestimo){
        this.dataEmprestimo = dataEmprestimo;
    }
    public void setDataDevolucaoPrevista(LocalDate localDate){
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }
    public Double getMulta() {
        return multa;
    }
    public void setMulta(Double multa) {
        this.multa = multa;
    }
    public Livro getLivro() {
        return this.livro;
    }
}
