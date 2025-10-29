package lopesantonio.com.de.biblioteca.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo", nullable = false, length = 250)
    private String titulo;
    @Column(name = "autor", nullable = false, length = 250)
    private String autor;
    @Column(name = "genero", length = 100)
    private String genero;
    @Column(name = "status", nullable = false, length = 100)
    @Enumerated(EnumType.STRING)
    private StatusLivro status;

    @OneToMany(mappedBy = "livro", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public StatusLivro getStatus() {
        return status;
    }


    public void setStatus(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setStatus(StatusLivro status) {
        this.status = status;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
}
