package com.okavango.edplus_backend.entity.projection;

import com.okavango.edplus_backend.entity.Actor;
import com.okavango.edplus_backend.entity.Director;
import com.okavango.edplus_backend.entity.Genre;
import com.okavango.edplus_backend.entity.Movie;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "main", types = {Movie.class})
public interface MovieDetailProjection
    {
        Long getId();

        String getTitle();

        String getReleaseYear();

        String getClassification();

        String getMainImg();

        Director getIsDirected();

        List<ActorSummaryProjection> getStarry();

        List<GenreSummaryProjection> getBelongsToGenre();

    }

@Projection(name = "actorSummary", types = {Actor.class})
interface ActorSummaryProjection
    {
        Long getId();

        String getName();
    }

@Projection(name = "genreSummary", types = {Genre.class})
interface GenreSummaryProjection
    {
        Long getId();

        String getName();
    }
