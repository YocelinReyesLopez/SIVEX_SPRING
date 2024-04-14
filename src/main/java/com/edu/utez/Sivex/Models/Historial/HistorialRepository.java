package com.edu.utez.Sivex.Models.Historial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialRepository extends JpaRepository<BeanHistorial, Long> {
}
