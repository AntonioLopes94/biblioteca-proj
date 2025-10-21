package lopesantonio.com.de.biblioteca.service;

import jakarta.validation.Valid;
import lopesantonio.com.de.biblioteca.model.dto.UsuarioDTO;
import lopesantonio.com.de.biblioteca.model.entity.Usuario;
import lopesantonio.com.de.biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario salvar(UsuarioDTO request) {
        Usuario usuario = new Usuario();
        usuario.setId(request.id());
        usuario.setNome(request.nome());
        usuario.setEmail(request.email());
        usuario.setTelefone(request.telefone());
        usuario.setMultaAcumulada(request.multaAcumulada());

        return usuarioRepository.save(usuario);
    }

    public void deletar(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        usuarioRepository.delete(usuario);
    }


}
