package lopesantonio.com.de.biblioteca.model.dto;

import lopesantonio.com.de.biblioteca.model.entity.Emprestimo;
import lopesantonio.com.de.biblioteca.model.entity.Livro;
import lopesantonio.com.de.biblioteca.model.entity.Usuario;

import java.time.LocalDate;
import java.util.List;

public record EmprestimoDTO(
        Long id,
        Livro livro,
        Usuario usuario,
        LocalDate dataEmprestimo,
        LocalDate dataDevolucao,
        LocalDate dataDevolucaoPrevista,
        double multa
) {

    public static EmprestimoDTO fromEntity(Emprestimo emprestimo){
        return new EmprestimoDTO(
                emprestimo.getId(),
                emprestimo.getLivro(),
                emprestimo.getUsuario(),
                emprestimo.getDataEmprestimo(),
                emprestimo.getDataDevolucao(),
                emprestimo.getDataDevolucaoPrevista(),
                emprestimo.getMulta()
        );
    }


    public static List<EmprestimoDTO> fromEntities(List<Emprestimo> emprestimos) {
        return emprestimos.stream()
                .map(EmprestimoDTO::fromEntity)
                .toList();
    }
}
