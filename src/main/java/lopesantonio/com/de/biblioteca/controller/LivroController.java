package lopesantonio.com.de.biblioteca.controller;

import jakarta.validation.Valid;
import lopesantonio.com.de.biblioteca.model.entity.Emprestimo;
import lopesantonio.com.de.biblioteca.model.entity.Livro;
import lopesantonio.com.de.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<Livro>> listarTodos(){
        List<Livro> livros = livroService.listarTodos();
        return ResponseEntity.of(Optional.ofNullable(livros));
    }

    @PostMapping
    public ResponseEntity<Livro> criar(@Valid @RequestBody Livro livro){
        Livro livroSalvo = livroService.salvar(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroSalvo);
    }

    @DeleteMapping("/api/{id}")
    public ResponseEntity<Livro> deletar(@PathVariable Long id){
        livroService.deletar(id);
        return ResponseEntity.noContent().build();
    }


}
