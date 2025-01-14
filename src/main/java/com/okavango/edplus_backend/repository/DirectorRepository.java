package com.okavango.edplus_backend.repository;

import com.okavango.edplus_backend.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long>
    {
    }