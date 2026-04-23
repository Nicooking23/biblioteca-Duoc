package cl.dsy1103.bibliotecaduoc.dto;

/*
* * ═══════════════════════════════════════════════════
 * CLASE: LibroRequestDTO.java
 *
 * DTO de ENTRADA: lo que el cliente envía en el body
 * del POST o PUT.
 *
 * REGLA CLARA:
 *   Las validaciones (@NotBlank, @Positive...) viven
 *   AQUÍ y solo aquí. No en la entidad Libro.java.
 *   Cuando el Controller usa @Valid, Spring valida
 *   este DTO. Si falla, GlobalExceptionHandler
 *   captura el error y devuelve un 400 con el mapa
 *   { "campo": "mensaje de error" }.
 * ═══════════════════════════════════════════════════*/

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibroRequestDTO {

    // No tiene campo "id": MySQL lo genera.
    // El cliente no debe poder enviarlo.

    @NotBlank(message = "El título no puede estar vacío.")
    private String titulo;

    @NotBlank(message = "El ISBN no puede estar vacío.")
    private String isbn;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor a 0")
    private BigDecimal precio;

    // Solo el id de la categoría. El Service busca
    // el objeto Categoria en BD usando este id.
    @NotNull(message = "El categoriaId es obligatorio")
    private Long categoriaId;

}















