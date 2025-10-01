package lopesantonio.com.de.biblioteca.repository;

import lopesantonio.com.de.biblioteca.model.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro,Long>{
    Optional<Livro> findByTitulo(String titulo);
}
