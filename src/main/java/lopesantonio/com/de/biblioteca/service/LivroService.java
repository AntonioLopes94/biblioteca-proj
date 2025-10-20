package lopesantonio.com.de.biblioteca.service;

import lopesantonio.com.de.biblioteca.model.dto.request.LivroRequest;
import lopesantonio.com.de.biblioteca.model.dto.response.LivroResponse;
import lopesantonio.com.de.biblioteca.model.entity.Livro;
import lopesantonio.com.de.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }
    public Livro salvar(LivroRequest request) {
        Livro livro = new Livro();
        livro.setTitulo(request.titulo());
        livro.setGenero(request.genero());
        livro.setAutor(request.autor());
        livro.setStatus(Livro.StatusLivro.DISPONIVEL);
        return livroRepository.save(livro);
    }

    public void deletar(Long id){
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        livroRepository.delete(livro);
    }


}
