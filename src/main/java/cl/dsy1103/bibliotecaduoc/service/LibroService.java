package cl.dsy1103.bibliotecaduoc.service;

import cl.dsy1103.bibliotecaduoc.dto.LibroRequestDTO;
import cl.dsy1103.bibliotecaduoc.dto.LibroResponseDTO;
import cl.dsy1103.bibliotecaduoc.model.Categoria;
import cl.dsy1103.bibliotecaduoc.model.Libro;
import cl.dsy1103.bibliotecaduoc.repository.CategoriaRepository;
import cl.dsy1103.bibliotecaduoc.repository.LibroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
* * ═══════════════════════════════════════════════════
 * CLASE :LibroService.java
 * CAMBIOS RESPECTO A INICIO EA2:
 *   1. Los métodos reciben/devuelven DTOs, no Libro.
 *   2. Se agrega mapToDTO() para convertir entidad → DTO.
 *   3. guardar() y actualizar() reciben LibroRequestDTO.
 *   4. El RuntimeException ("Categoría no encontrada")
 *      ahora es capturado por GlobalExceptionHandler
 *      y devuelto como 400 Bad Request al cliente.
 * ═══════════════════════════════════════════════════*/
@Service
@RequiredArgsConstructor
public class LibroService {
    private final LibroRepository libroRepository;

    // Necesario para buscar la Categoria por id
    // cuando el DTO trae solo categoriaId (un Long).
    private final CategoriaRepository categoriaRepository;

    // ── MAPEO PRIVADO: Entidad → ResponseDTO ─────────
    // Solo lo usa este Service. El Controller y el
    // Repository nunca conocen el DTO ni la entidad
    // del otro respectivamente.
    private LibroResponseDTO mapToDTO(Libro libro){
        return new LibroResponseDTO(
                libro.getId(),
                libro.getTitulo(),
                libro.getIsbn(),
                libro.getPrecio(),
                libro.getCategoria().getNombre()
        );
    }
    // ── OBTENER TODOS ────────────────────────────────
    // Antes: List<Libro>. Ahora: List<LibroResponseDTO>.
    public List<LibroResponseDTO> obtenerTodos(){
        return libroRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // ── OBTENER POR ID ───────────────────────────────
    public Optional<LibroResponseDTO> obtenerPorId(Long id){
        return libroRepository.findById(id).map(this::mapToDTO);
    }

    // ── GUARDAR ──────────────────────────────────────
    // Antes: recibía Libro. Ahora: recibe LibroRequestDTO.
    // Si el categoriaId no existe, lanza RuntimeException.
    // GlobalExceptionHandler la captura y devuelve 400.
    public LibroResponseDTO guardar(LibroRequestDTO dto){
        Categoria categoria = categoriaRepository
                .findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException(
                        "Categoría no encontrada con id: " + dto.getCategoriaId()));
        Libro libro = new Libro(
                null,
                dto.getTitulo(),
                dto.getIsbn(),
                dto.getPrecio(),
                categoria
        );
        return mapToDTO(libroRepository.save(libro));
    }


}






