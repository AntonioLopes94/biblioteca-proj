package lopesantonio.com.de.biblioteca.repository;

import lopesantonio.com.de.biblioteca.model.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LivroRepository extends JpaRepository<Livro,Long>{
    Optional<Livro> findByTitulo(String titulo);
}
