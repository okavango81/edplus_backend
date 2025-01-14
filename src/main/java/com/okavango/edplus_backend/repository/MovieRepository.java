package com.okavango.edplus_backend.repository;

import com.okavango.edplus_backend.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long>
    {
    }