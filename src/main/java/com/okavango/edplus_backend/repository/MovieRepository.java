package com.okavango.edplus_backend.repository;

import com.okavango.edplus_backend.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource( path = "movies", collectionResourceRel = "movieList", itemResourceRel = "movie")
public interface MovieRepository extends JpaRepository<Movie, Long>
    {
    }