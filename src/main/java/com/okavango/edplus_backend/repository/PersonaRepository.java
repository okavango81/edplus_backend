package com.okavango.edplus_backend.repository;

import com.okavango.edplus_backend.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "personas",collectionResourceRel = "personaList", itemResourceRel = "persona")
public interface PersonaRepository extends JpaRepository<Persona, Long>
    {
    }