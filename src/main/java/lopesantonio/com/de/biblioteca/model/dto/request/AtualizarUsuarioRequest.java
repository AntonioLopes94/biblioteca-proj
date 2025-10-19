package lopesantonio.com.de.biblioteca.model.dto.request;

public record AtualizarUsuarioRequest(
        String nome,
        String email,
        String telefone,
        double multaAcumulada
) {
}
