package com.example.biblioteca.entity;

import jakarta.persistence.*;
import lombok.*;

@Data //Evita definir los getters y setters
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Se generara de forma automatica
    private Long id;

    @Column(nullable = false) // Al ponerlo a posterior, hay que modificar la propiedad
    private String titulo;

    @Column
    private String autor;
}
