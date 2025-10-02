package lopesantonio.com.de.biblioteca.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false, length = 250)
    private String nome;
    @Column(name = "email", nullable = false, length = 250)
    private String email;
    @Column(name = "telefone", nullable = false, length = 250)
    private String telefone;
    @Column(name = "multa_acumulada", nullable = true, length = 250)
    private double multaAcumulada;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Emprestimo> emprestimos = new ArrayList<>();
}
