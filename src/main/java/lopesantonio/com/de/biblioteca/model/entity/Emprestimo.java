package lopesantonio.com.de.biblioteca.model.entity;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class Emprestimo {
    private Long id;
    private Livro livro;
    private Usuario usuario;

    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private LocalDate getDataDevolucaoPrevista;

    private double multa;

}
