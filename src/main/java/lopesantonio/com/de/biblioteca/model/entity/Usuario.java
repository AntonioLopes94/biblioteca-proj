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
    @Column(name = "multa_acumulada", length = 250)
    private double multaAcumulada;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Emprestimo> emprestimos = new ArrayList<>();

    //G&S
    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public double getMultaAcumulada() {
        return multaAcumulada;
    }
    public void setMultaAcumulada(double multaAcumulada) {
        this.multaAcumulada = multaAcumulada;
    }
}
