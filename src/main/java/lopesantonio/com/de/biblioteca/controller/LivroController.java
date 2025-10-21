package lopesantonio.com.de.biblioteca.controller;

import jakarta.validation.Valid;
import lopesantonio.com.de.biblioteca.model.dto.request.LivroRequest;
import lopesantonio.com.de.biblioteca.model.dto.response.LivroResponse;
import lopesantonio.com.de.biblioteca.model.entity.Livro;
import lopesantonio.com.de.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroResponse>> getTodosLivros(){
        List<Livro> livros = livroService.listarTodos();
        List<LivroResponse> response = LivroResponse.fromEntities(livros);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<LivroResponse> criarLivro(@Valid @RequestBody LivroRequest request){
        Livro livro = livroService.salvar(request);
        LivroResponse response  = LivroResponse.fromEntity(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }


}
