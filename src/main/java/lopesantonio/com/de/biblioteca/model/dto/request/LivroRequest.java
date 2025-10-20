package lopesantonio.com.de.biblioteca.model.dto.request;

import lopesantonio.com.de.biblioteca.model.entity.Livro;

public record LivroRequest(
        String titulo,
        String autor,
        String genero,
        Livro.StatusLivro status
) {
}
