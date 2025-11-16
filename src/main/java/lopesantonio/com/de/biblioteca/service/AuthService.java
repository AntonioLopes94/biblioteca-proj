package lopesantonio.com.de.biblioteca.service;

import lopesantonio.com.de.biblioteca.model.entity.Usuario;
import lopesantonio.com.de.biblioteca.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AuthService {
    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;

    public boolean passwordAuth(String email, String senhaHash) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usário não encontrado"));
        return passwordEncoder.matches(senhaHash, usuario.getSenha());
    }
}


