package lopesantonio.com.de.biblioteca.service;

import lopesantonio.com.de.biblioteca.model.dto.UsuarioDTO;
import lopesantonio.com.de.biblioteca.model.entity.Usuario;
import lopesantonio.com.de.biblioteca.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthService {
    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;
    private UsuarioService usuarioService;

    public boolean passwordAuth(String email, String senhaHash) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usário não encontrado"));
        return passwordEncoder.matches(senhaHash, usuario.getSenha());
    }

    public UsuarioDTO registrarUsuario(UsuarioDTO request){
        UsuarioDTO novoUsuarioDTO = new UsuarioDTO(
                request.id(),
                request.nome(),
                request.email(),
                request.telefone(),
                request.multaAcumulada(),
                passwordEncoder.encode(request.senha()));

        return usuarioService.salvar(novoUsuarioDTO);


    }
}


