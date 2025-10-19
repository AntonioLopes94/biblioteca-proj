package lopesantonio.com.de.biblioteca.model.dto.request;

public record AtualizarLivroRequest(
        String titulo,
        String autor,
        String genero
) {}
