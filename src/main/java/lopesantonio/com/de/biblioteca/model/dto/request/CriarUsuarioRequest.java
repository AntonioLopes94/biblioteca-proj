package lopesantonio.com.de.biblioteca.model.dto.request;

public record CriarUsuarioRequest(
        String nome,
        String email,
        String telefone
) {
}
