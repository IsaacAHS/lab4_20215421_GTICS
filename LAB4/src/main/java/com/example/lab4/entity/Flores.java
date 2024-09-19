package com.example.lab4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.attoparser.dom.Text;


@Entity
@Getter
@Setter
@Table(name = "flores")
public class Flores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idflores", nullable = false)
    private int id;

    @Column(length = 45, nullable = true)
    private String imagen;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = true)
    private int stock;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "color_idcolor")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "ocasion_idocasion")
    private Ocasion ocasion;

    @ManyToOne
    @JoinColumn(name = "tipo_idtipo")
    private Tipo tipo;









}
