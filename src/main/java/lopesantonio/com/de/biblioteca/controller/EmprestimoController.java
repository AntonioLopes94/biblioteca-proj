package lopesantonio.com.de.biblioteca.controller;

import lopesantonio.com.de.biblioteca.model.entity.Emprestimo;
import lopesantonio.com.de.biblioteca.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/emprestimo")
public class EmprestimoController {
    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    public ResponseEntity<List<Emprestimo>> listarTodos(){
        List<Emprestimo> emprestimos = emprestimoService.listarTodos();
        return ResponseEntity.of(Optional.ofNullable(emprestimos));
    }
}
