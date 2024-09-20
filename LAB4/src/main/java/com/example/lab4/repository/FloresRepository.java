package com.example.lab4.repository;

import com.example.lab4.entity.Flores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FloresRepository extends JpaRepository<Flores, Integer>{

    @Query(value = "SELECT f.* " +
            "FROM flores f " +
            "JOIN tipo t ON f.tipo_id = t.id " +
            "JOIN color c ON f.color_id = c.id " +
            "JOIN ocasion o ON f.ocasion_id = o.id " +
            "WHERE f.nombre LIKE %:nombre% " +
            "AND t.nombretipo = :tipo " +
            "AND c.nombrecolor = :color " +
            "AND o.nombreocasion = :ocasion",
            nativeQuery = true)
    List<Flores> buscarFloresConFiltros(String tipo,
                                      String color,
                                      String ocasion);
}
