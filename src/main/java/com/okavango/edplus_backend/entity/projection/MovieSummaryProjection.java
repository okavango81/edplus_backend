package com.okavango.edplus_backend.entity.projection;

import com.okavango.edplus_backend.entity.Movie;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "card", types = {Movie.class})
public interface MovieSummaryProjection
    {
        Long getId();

        String getTitle();

        String getReleaseYear();

        String getClassification();

        String getCardImg();

    }
