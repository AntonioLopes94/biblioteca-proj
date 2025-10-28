package lopesantonio.com.de.biblioteca.service;

import lopesantonio.com.de.biblioteca.model.dto.EmprestimoDTO;
import lopesantonio.com.de.biblioteca.model.entity.Emprestimo;
import lopesantonio.com.de.biblioteca.model.entity.Livro;
import lopesantonio.com.de.biblioteca.model.entity.Usuario;
import lopesantonio.com.de.biblioteca.repository.EmprestimoRepository;
import lopesantonio.com.de.biblioteca.repository.LivroRepository;
import lopesantonio.com.de.biblioteca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

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
    public Emprestimo registrarDevolucao(Long emprestimoId, LocalDate devolucaoEfetiva){
        Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId).
                orElseThrow(() -> new IllegalArgumentException("Emprestimo não encontrado"));
        emprestimo.setDevolucaoEfetiva(devolucaoEfetiva);
        var dataDevolucaoPrevista = emprestimo.getDataDevolucaoPrevista();
        if(devolucaoEfetiva.isAfter(dataDevolucaoPrevista)){
            var diasDeAtraso = ChronoUnit.DAYS.between(dataDevolucaoPrevista, devolucaoEfetiva);
            emprestimo.setMulta(calcularMulta(diasDeAtraso));

        }else {
            emprestimo.setMulta(0.0);
        }
        Livro livro = emprestimo.getLivro();
        livro.setStatus(Livro.StatusLivro.DISPONIVEL);
        livroRepository.save(livro);
        Emprestimo emprestimoAtualizado = emprestimoRepository.save(emprestimo);
        return emprestimoAtualizado;
    }

    public Emprestimo registrarEmprestimo(Long idUsuario, Long idLivro){
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado"));
        Livro livro = livroRepository.findById(idLivro).orElseThrow(() -> new IllegalArgumentException("Livro não encontrado"));
        if(livro.getStatus() != Livro.StatusLivro.DISPONIVEL){
            throw new IllegalStateException("Livro não está disponível");
        }
        Emprestimo emprestimo = new Emprestimo(usuario, livro);
        emprestimo.setUsuario(usuario);
        emprestimo.setLivro(livro);
        Emprestimo emprestimoSalvo = emprestimoRepository.save(emprestimo);
        livro.setStatus(Livro.StatusLivro.EMPRESTADO);
        livroRepository.save(livro);
        return emprestimoSalvo;
    }

    public List<Emprestimo> listarTodos() {
        return emprestimoRepository.findAll()
                .stream().map(this::toDTO).toList();
    }



    public void deletar(Long id) {
        Emprestimo emprestimo = emprestimoRepository.findById(id).orElseThrow(() -> new RuntimeException("Emprestimo nao encontrado"));
        emprestimoRepository.delete(emprestimo);
    }
//todo  entender o problema com get multa, usuario e livros e resolver
    private EmprestimoDTO toDTO(Emprestimo emprestimo) {
        return new EmprestimoDTO(
                emprestimo.getId(),
                emprestimo.getUsuario(),
                emprestimo.getLivro(),
                emprestimo.getDataEmprestimo(),
                emprestimo.getDataDevolucao(),
                emprestimo.getDataDevolucaoPrevista(),
                emprestimo.getMulta());
    }
}
