package com.okavango.edplus_backend.repository;

import com.okavango.edplus_backend.entity.Genre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource( path = "genres", collectionResourceRel = "genreList", itemResourceRel = "genre")
public interface GenreRepository extends JpaRepository<Genre, Long>
    {
        Page<Genre> findGenreById(@Param("id") Long id, Pageable pageable);

        Page<Genre> findGenresByNameContainingIgnoreCase(@Param("name") String name, Pageable pageable);

    }