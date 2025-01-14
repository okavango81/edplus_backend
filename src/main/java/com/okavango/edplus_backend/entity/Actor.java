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
public class Actor
    {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private Long id;

        @Column(unique = true, columnDefinition = "VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin")
//        @JsonIgnore
        private String name;

        @ManyToMany(mappedBy = "starry")
//        @JsonIgnore
        private List<Movie> performance = new ArrayList<>();

        @ManyToMany
//        @JsonIgnore
        @JoinTable(name = "actors_personas", joinColumns = @JoinColumn(name = "actor_id"), inverseJoinColumns = @JoinColumn(name = "persona_id"))
        private List<Persona> representsCharacter = new ArrayList<>();

        @Override
        public boolean equals(Object o)
            {
                if (o == null || getClass() != o.getClass()) return false;
                Actor director = (Actor) o;
                return Objects.equals(id, director.id) && Objects.equals(name, director.name);
            }

        @Override
        public int hashCode()
            {
                return Objects.hashCode(id);
            }
    }