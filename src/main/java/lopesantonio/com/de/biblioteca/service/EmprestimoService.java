package lopesantonio.com.de.biblioteca.service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import lopesantonio.com.de.biblioteca.model.entity.Emprestimo;
import lopesantonio.com.de.biblioteca.model.entity.Livro;
import lopesantonio.com.de.biblioteca.model.entity.Usuario;
import lopesantonio.com.de.biblioteca.repository.EmprestimoRepository;
import lopesantonio.com.de.biblioteca.repository.LivroRepository;
import lopesantonio.com.de.biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private LivroRepository livroRepository;

    private double calcularMulta(Long diasDeAtraso){
        return diasDeAtraso * 0.75;
    }
    public void registrarDevolucao(Long emprestimoId, LocalDate devolucaoEfetiva){
        Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId).
                orElseThrow(() -> new IllegalArgumentException("Emprestimo não encontrado"));
        emprestimo.setDevolucaoEfetiva(devolucaoEfetiva);
        var dataDevolucaoPrevista = emprestimo.getDataDevolucaoPrevista();
        if(devolucaoEfetiva.isAfter(dataDevolucaoPrevista)){
            var diasDeAtraso = ChronoUnit.DAYS.between(dataDevolucaoPrevista, devolucaoEfetiva);
            emprestimo.setMulta(calcularMulta(diasDeAtraso));

        }else {
            emprestimo.setMulta(0);
        }
        Livro livro = emprestimo.getLivro();
        livro.setStatus(Livro.StatusLivro.DISPONIVEL);
        livroRepository.save(livro);
        emprestimoRepository.save(emprestimo);
    }

    public void registrarEmprestimo(String nomeLivro, String nomeUsuario){
        Usuario usuario = usuarioRepository.findByNome(nomeUsuario).orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado"));
        Livro livro = livroRepository.findByTitulo(nomeLivro).orElseThrow(() -> new IllegalArgumentException("Livro não encontrado"));

        if(livro.getStatus() != Livro.StatusLivro.DISPONIVEL){
            throw new IllegalStateException("Livro não está disponível");
        }else {
            Emprestimo emprestimo = new Emprestimo(usuario, livro);
            livro.setStatus(Livro.StatusLivro.EMPRESTADO);
            livroRepository.save(livro);
            emprestimoRepository.save(emprestimo);
        }
    }

    public List<Emprestimo> listarTodos() {
        return emprestimoRepository.findAll();
    }
}
