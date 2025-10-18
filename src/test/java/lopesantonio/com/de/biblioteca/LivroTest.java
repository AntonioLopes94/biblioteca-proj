package lopesantonio.com.de.biblioteca;

import lopesantonio.com.de.biblioteca.model.entity.Livro;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class LivroTest{

    @Test
    @DisplayName("Should create a book with all parameters correct")
    void testCriarLivroComTodosAtributos(){
        Livro livro = new Livro();
        livro.setId(1L);
        livro.setTitulo("Dom Casmurro");
        livro.setAutor("Machado de Assis");
        livro.setGenero("Terror");
        livro.setStatus(Livro.StatusLivro.DISPONIVEL);

        assertEquals(1L, livro.getId());
        assertEquals("Dom Casmurro", livro.getTitulo());
        assertEquals("Machado de Assis", livro.getAutor());
        assertEquals("Terror", livro.getGenero());
        assertEquals(Livro.StatusLivro.DISPONIVEL, livro.getStatus());
    }

    @Test
    @DisplayName("Should create a book with EMPRESTADO status")
    void testCriarLivroComStatusEmprestado(){
        Livro livro = new Livro();
        livro.setStatus(Livro.StatusLivro.EMPRESTADO);

        assertEquals(Livro.StatusLivro.EMPRESTADO, livro.getStatus());
        assertNotEquals(Livro.StatusLivro.DISPONIVEL, livro.getStatus());
    }

    @Test
    @DisplayName("Should update book title correctly")
    void testAtualizarTituloLivro(){
        Livro livro = new Livro();
        livro.setTitulo("Titulo antigo");

        livro.setTitulo("Titulo novo");

        assertEquals("Titulo novo", livro.getTitulo());
        assertNotEquals("Titulo antigo", livro.getTitulo());

    }

}