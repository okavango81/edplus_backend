package com.okavango.edplus_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Director
    {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private Long id;

        @Column(unique = true, columnDefinition = "VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin")
//        @JsonIgnore
        private String name;

        @OneToMany(mappedBy = "isDirected")
//        @JsonIgnore
        private List<Movie> directs = new ArrayList<>();




        @Override
        public boolean equals(Object o)
            {
                if (o == null || getClass() != o.getClass()) return false;
                Director director = (Director) o;
                return Objects.equals(id, director.id) && Objects.equals(name, director.name);
            }

        @Override
        public int hashCode()
            {
                return Objects.hashCode(id);
            }
    }