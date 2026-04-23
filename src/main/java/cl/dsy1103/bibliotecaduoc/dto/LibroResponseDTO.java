package cl.dsy1103.bibliotecaduoc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/*
* * ═══════════════════════════════════════════════════
 * CLASE: LibroResponseDTO.java
 * Sin cambios de lógica. Sin anotaciones de validación:
 * este DTO es de SALIDA, el servidor lo construye,
 * no viene del cliente, por eso no necesita @Valid.
 * ═══════════════════════════════════════════════════*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibroResponseDTO {

    private Long id;
    private String titulo;
    private String isbn;
    private BigDecimal precio;

    // Solo el nombre de la categoría, no el objeto completo.
    private String categoriaNombre;
}










