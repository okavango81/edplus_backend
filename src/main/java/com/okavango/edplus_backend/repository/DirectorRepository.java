package com.okavango.edplus_backend.repository;

import com.okavango.edplus_backend.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource( path = "directors", collectionResourceRel = "directorList", itemResourceRel = "director")
public interface DirectorRepository extends JpaRepository<Director, Long>
    {
    }