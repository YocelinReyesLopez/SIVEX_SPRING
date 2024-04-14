package com.edu.utez.Sivex.Models.Espacios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EspaciosRepository  extends JpaRepository<BeanEspacios, Long> {
    Optional<BeanEspacios> findByName(String name);
}
