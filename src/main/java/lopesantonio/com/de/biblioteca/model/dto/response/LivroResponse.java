package lopesantonio.com.de.biblioteca.model.dto.response;

import lopesantonio.com.de.biblioteca.model.entity.Livro;

import java.util.List;

public record LivroResponse(
        Long id,
        String titulo,
        String autor,
        String genero,
        Livro.StatusLivro status
) {
    public static LivroResponse fromEntity(Livro livro) {
        return new LivroResponse(
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getGenero(),
                livro.getStatus()

        );
    }
    public static List<LivroResponse> fromEntities(List<Livro> livros) {
        return livros.stream()
                .map(LivroResponse::fromEntity)
                .toList();
    }
}
