package com.edu.utez.Sivex.Models.Eventos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventosRepository extends JpaRepository<BeanEventos, Long> {
}
