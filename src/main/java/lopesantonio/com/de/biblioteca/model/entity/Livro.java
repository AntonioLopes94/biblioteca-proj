package lopesantonio.com.de.biblioteca.model.entity;

public class Livro {
    private Long id;
    private String titulo;
    private String autor;
    private String genero;
    private StatusLivro status;

    public enum StatusLivro {
        EMPRESTADO,
        DISPONIVEL;
    }
}
