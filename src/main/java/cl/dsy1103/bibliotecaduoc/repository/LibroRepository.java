package cl.dsy1103.bibliotecaduoc.repository;

import cl.dsy1103.bibliotecaduoc.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    //Convención de Nombres
    /*Esto en la BD sería así:
    * SELECT * FROM libros WHERE UPPER(titulo) LIKE UPPER('%?%')
    * */
    List<Libro> findByTituloContainingIgnoreCase(String titulo);

}
