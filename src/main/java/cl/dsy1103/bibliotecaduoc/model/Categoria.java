package cl.dsy1103.bibliotecaduoc.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* Crear la clase para levar esta entidad a la base
* de datos.
* Las validaciones NO estarán acá.
* Estarán en DTO: Tenerlas acá es código muerto
* que solo confunde.
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //NOT NULL sigue aquí: es una restricción de BD
    @Column(nullable = false, length = 100)
    private String nombre;

    @Column
    private String descripcion;

}
