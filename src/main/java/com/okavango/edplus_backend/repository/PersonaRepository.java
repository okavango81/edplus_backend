package com.okavango.edplus_backend.repository;

import com.okavango.edplus_backend.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long>
    {
    }