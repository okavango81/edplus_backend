package com.okavango.edplus_backend.repository;

import com.okavango.edplus_backend.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource( path = "genres", collectionResourceRel = "genreList", itemResourceRel = "genre")
public interface GenreRepository extends JpaRepository<Genre, Long>
    {
    }