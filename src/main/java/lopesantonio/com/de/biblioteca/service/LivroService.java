package lopesantonio.com.de.biblioteca.service;

import lopesantonio.com.de.biblioteca.model.dto.LivroDTO;
import lopesantonio.com.de.biblioteca.model.dto.UsuarioDTO;
import lopesantonio.com.de.biblioteca.model.entity.Livro;
import lopesantonio.com.de.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public List<LivroDTO> listarTodos() {
        return livroRepository.findAll()
                .stream().map(this::toDTO)
                .toList();
    }


    public LivroDTO salvar(LivroDTO request) {
        Livro livro = new Livro();
        livro.setTitulo(request.titulo());
        livro.setGenero(request.genero());
        livro.setAutor(request.autor());
        livro.setStatus(Livro.StatusLivro.DISPONIVEL);
        livroRepository.save(livro);
        return request;
    }

    public void deletar(Long id){
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        livroRepository.delete(livro);
    }

    private LivroDTO toDTO(Livro livro) {
        return new LivroDTO(
                livro.getId(),
                livro.getTitulo(),
                livro.getGenero(),
                livro.getAutor(),
                livro.getStatus());
    }


}
