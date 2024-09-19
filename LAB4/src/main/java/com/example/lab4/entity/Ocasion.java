package com.example.lab4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "ocasion")
public class Ocasion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idocasion", nullable = false)
    private int id;

    @Column(length = 45, nullable = false)
    private String nombreocasion;

}
