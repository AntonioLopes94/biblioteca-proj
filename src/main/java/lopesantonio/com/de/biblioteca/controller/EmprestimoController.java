package lopesantonio.com.de.biblioteca.controller;

import jakarta.validation.Valid;
import lopesantonio.com.de.biblioteca.model.dto.EmprestimoDTO;
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
    public ResponseEntity<List<EmprestimoDTO>> listarTodos(){
           List<EmprestimoDTO> response = emprestimoService.listarTodos();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{idUsuario}-{idLivro}")
    public ResponseEntity<?> criarEmprestimo(@PathVariable Long idUsuario, @PathVariable Long idLivro){
        try {
            Emprestimo emprestimoRegistro = emprestimoService.registrarEmprestimo(idUsuario, idLivro);
            EmprestimoDTO emprestimoDTO = EmprestimoDTO.fromEntity(emprestimoRegistro);
            return ResponseEntity.ok(emprestimoDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Erro: "+ e.getMessage());
        }
    }

    @DeleteMapping("/{idEmprestimo}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        emprestimoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
