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
    @Column(name = "genero", nullable = true, length = 100)
    private String genero;
    @Column(name = "status", nullable = false, length = 100)
    @Enumerated(EnumType.STRING)
    private StatusLivro status = StatusLivro.DISPONIVEL;

    @OneToMany(mappedBy = "livro", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void setStatus(Enum status) {
        this.status = (StatusLivro) status;
    }


    public StatusLivro getStatus() {
        return status;
    }

    public enum StatusLivro {
        EMPRESTADO,
        DISPONIVEL;
    }
    
    public void setStatus(){} 
}
