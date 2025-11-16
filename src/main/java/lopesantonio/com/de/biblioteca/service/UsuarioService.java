package lopesantonio.com.de.biblioteca.service;

import lopesantonio.com.de.biblioteca.config.SecurityConfig;
import lopesantonio.com.de.biblioteca.model.dto.UsuarioDTO;
import lopesantonio.com.de.biblioteca.model.entity.Usuario;
import lopesantonio.com.de.biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UsuarioDTO> listarTodos(){
        return usuarioRepository.findAll()
                .stream().map(this::toDTO)
                .toList();
    }

    public UsuarioDTO salvar(UsuarioDTO request) {
        Usuario usuario = new Usuario();
        usuario.setId(request.id());
        usuario.setNome(request.nome());
        usuario.setEmail(request.email());
        usuario.setTelefone(request.telefone());
        usuario.setMultaAcumulada(request.multaAcumulada());
        usuario.setSenha(passwordEncoder.encode(request.senha()));
        usuarioRepository.save(usuario);
        return request;
    }

    public void deletar(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        usuarioRepository.delete(usuario);
    }

    private UsuarioDTO toDTO(Usuario usuario){
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getEmail(),
                usuario.getMultaAcumulada(),
                usuario.getSenha());
    }


}
