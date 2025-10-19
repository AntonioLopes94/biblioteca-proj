package lopesantonio.com.de.biblioteca.model.dto.request;

import lopesantonio.com.de.biblioteca.model.entity.Livro;

import java.time.LocalDate;

public record EmprestimoBuscaRequest(
        Long usuarioId,
        Long livroId,
        Livro.StatusLivro status,
        LocalDate dataInicio,
        LocalDate dataFim
) {
}
