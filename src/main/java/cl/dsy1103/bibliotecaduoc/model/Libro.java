package cl.dsy1103.bibliotecaduoc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
/*
* El modelo JPA ya no recibe datos del cliente
* dierctamente. El flujo correcto será:
*     Cliente  -> LibroRequestDTO (aquí irá @Valid)
*              -> LibroService (construye la Entidad)
*              -> Libro (entidad, sin validaciones)
*              -> BD*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "libros")
public class Libro {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(nullable = false, length = 200)
   private String titulo;

   @Column(nullable = false, length = 20, unique = true)
   private String isbn;

   @Column(nullable = false, precision = 10, scale = 2)
   private BigDecimal precio;

   @ManyToOne
   @JoinColumn(name = "categoria_id", nullable = false)
   private Categoria categoria;

}
