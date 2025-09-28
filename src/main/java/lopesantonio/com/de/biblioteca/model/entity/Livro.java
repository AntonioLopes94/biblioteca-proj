package lopesantonio.com.de.biblioteca.model.entity;

import lopesantonio.com.de.biblioteca.model.enums.StatusLivro;

public class Livro {
    private Long id;
    private String titulo;
    private String autor;
    private String genero;
    private StatusLivro status = StatusLivro.DISPONIVEL;
}
