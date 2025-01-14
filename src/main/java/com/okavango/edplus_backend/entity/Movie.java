package com.okavango.edplus_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
public class Movie
    {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        @JsonIgnore
        private Long id;

        @Column(unique = true, columnDefinition = "VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin")
        @JsonIgnore
        private String title;

        @JsonIgnore
        private Integer releaseYear;

        @JsonIgnore
        private Integer runtime;

        @JsonIgnore
        private String cardImg;

        @JsonIgnore
        private String mainImg;

        @JsonIgnore
        private String classification;

        @Column(unique = true, columnDefinition = "TEXT")
        @JsonIgnore
        private String synopsis;

        @Override
        public boolean equals(Object o)
            {
                if (o == null || getClass() != o.getClass()) return false;
                Movie movie = (Movie) o;
                return Objects.equals(id, movie.id);
            }

        @Override
        public int hashCode()
            {
                return Objects.hashCode(id);
            }
    }