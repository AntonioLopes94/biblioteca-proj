package lopesantonio.com.de.biblioteca.model.dto.request;

public record UsuarioBuscaRequest(
        String nome,
        String email,
        String telefone
) {
}
