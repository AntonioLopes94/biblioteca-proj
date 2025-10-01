package lopesantonio.com.de.biblioteca.model.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class Livro {
    private Long id;
    private String titulo;
    private String autor;
    private String genero;
    private StatusLivro status;

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
