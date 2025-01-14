package com.okavango.edplus_backend.repository;

import com.okavango.edplus_backend.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long>
    {
    }