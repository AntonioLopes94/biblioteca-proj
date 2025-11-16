package lopesantonio.com.de.biblioteca.model.dto;

import jakarta.validation.Valid;
import lopesantonio.com.de.biblioteca.model.entity.Usuario;

import java.util.List;

public record UsuarioDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        double multaAcumulada,
        String senha
) {

    public static UsuarioDTO fromEntity(Usuario usuario){
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getMultaAcumulada(),
                usuario.getSenha()
        );
    }

    public static List<UsuarioDTO> fromEntities(List<Usuario> usuarios) {
        return usuarios.stream()
                .map(UsuarioDTO::fromEntity)
                .toList();
    }

}
