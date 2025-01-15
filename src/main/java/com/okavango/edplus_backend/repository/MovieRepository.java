package com.okavango.edplus_backend.repository;

import com.okavango.edplus_backend.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource( path = "movies", collectionResourceRel = "movieList", itemResourceRel = "movie")
public interface MovieRepository extends JpaRepository<Movie, Long>
    {
        @Query("SELECT m FROM Movie m " +
                "JOIN m.starry a " +
                "JOIN m.belongsToGenre g " +
                "JOIN m.isDirected d " +
                "JOIN m.hasCharacter p " +
                "WHERE (LOWER(a.name) LIKE LOWER(CONCAT('%', :search, '%')) " +
                "OR LOWER(g.name) LIKE LOWER(CONCAT('%', :search, '%')) " +
                "OR LOWER(m.title) LIKE LOWER(CONCAT('%', :search, '%')) " +
                "OR LOWER(d.name) LIKE LOWER(CONCAT('%', :search, '%'))" +
                "OR LOWER(p.name) LIKE LOWER(CONCAT('%', :search, '%')) )")
        Page<Movie> findByAnyCriterion(Pageable pageable, @Param("search") String search);
    }