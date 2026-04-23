package cl.dsy1103.bibliotecaduoc.repository;

import cl.dsy1103.bibliotecaduoc.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
