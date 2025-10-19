package lopesantonio.com.de.biblioteca.model.dto.request;

import lopesantonio.com.de.biblioteca.model.entity.Livro;

public record LivroBuscaRequest(
        String titulo,
        String autor,
        String genero,
        Livro.StatusLivro status
) {}
