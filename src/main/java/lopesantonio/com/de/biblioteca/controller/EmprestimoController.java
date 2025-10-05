package lopesantonio.com.de.biblioteca.controller;

import jakarta.validation.Valid;
import lopesantonio.com.de.biblioteca.model.entity.Emprestimo;
import lopesantonio.com.de.biblioteca.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/emprestimos")
public class EmprestimoController {
    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    public ResponseEntity<List<Emprestimo>> listarTodos(){
        List<Emprestimo> emprestimos = emprestimoService.listarTodos();
        return ResponseEntity.of(Optional.ofNullable(emprestimos));
    }

    @PostMapping("/{idUsuario}-{idLivro}")
    public ResponseEntity<?> criarEmprestimo(@PathVariable Long idUsuario, @PathVariable Long idLivro){
        try {
            Emprestimo emprestimoRegistro = emprestimoService.registrarEmprestimo(idUsuario, idLivro);
            return ResponseEntity.ok(emprestimoRegistro);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Erro: "+ e.getMessage());
        }
    }


}
