package com.edu.utez.Sivex.Models.Servicios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ServiciosRepository extends JpaRepository<BeanServicios, Long>{
    Optional<BeanServicios> findByNombre(String nombre);
}
