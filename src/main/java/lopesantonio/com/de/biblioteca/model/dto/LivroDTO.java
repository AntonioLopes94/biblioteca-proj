package lopesantonio.com.de.biblioteca.model.dto;

import lopesantonio.com.de.biblioteca.model.entity.Livro;
import lopesantonio.com.de.biblioteca.model.entity.StatusLivro;

import java.util.List;

public record LivroDTO(
        Long id,
        String titulo,
        String autor,
        String genero,
        StatusLivro status) {


    public static LivroDTO fromEntity(Livro livro) {
        return new LivroDTO(
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getGenero(),
                livro.getStatus()

        );
    }
    public static List<LivroDTO> fromEntities(List<Livro> livros) {
        return livros.stream()
                .map(LivroDTO::fromEntity)
                .toList();
    }


}
