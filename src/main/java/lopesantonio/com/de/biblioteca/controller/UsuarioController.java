package lopesantonio.com.de.biblioteca.controller;

import jakarta.validation.Valid;
import lopesantonio.com.de.biblioteca.model.dto.UsuarioDTO;
import lopesantonio.com.de.biblioteca.model.entity.Usuario;
import lopesantonio.com.de.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarTodos(){
        List<Usuario> usuarios = usuarioService.listarTodos();
        List<UsuarioDTO> response = UsuarioDTO.fromEntities(usuarios);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<?> criar(@Valid @RequestBody UsuarioDTO request){
       try {
           Usuario usuarioSalvo = usuarioService.salvar(request);
           UsuarioDTO response = UsuarioDTO.fromEntity(usuarioSalvo);
           return ResponseEntity.status(HttpStatus.CREATED).body(response);
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
