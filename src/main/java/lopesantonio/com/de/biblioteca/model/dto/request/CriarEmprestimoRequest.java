package lopesantonio.com.de.biblioteca.model.dto.request;

public record CriarEmprestimoRequest(
        Long usuarioId,
        Long livroId
) {
}
