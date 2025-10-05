package lopesantonio.com.de.biblioteca.controller;

import jakarta.validation.Valid;
import lopesantonio.com.de.biblioteca.model.entity.Usuario;
import lopesantonio.com.de.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodos(){
        List<Usuario> usuarios = usuarioService.listarTodos();
        return ResponseEntity.of(Optional.ofNullable(usuarios));
    }

    @PostMapping
    public ResponseEntity<?> criar(@Valid @RequestBody Usuario usuario){
       try {
           Usuario usuarioSalvo = usuarioService.salvar(usuario);
           return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
       }
       catch (Exception e){
           return ResponseEntity.badRequest().body("Erro: " + e.getMessage());
       }
    }

    @DeleteMapping("/api/{id}")
    public ResponseEntity<Usuario> deletar(@PathVariable Long id){
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }




}
