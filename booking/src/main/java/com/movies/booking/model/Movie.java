package com.movies.booking.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Accessors(chain = true)
@Document("movies")
public class Movie {

    @Id
    private String id;
    private String title;
    private int year;
    private List<String> cast;
    private List<String> genres;
    private String href;
    private String extract;
    private String thumbnail;
    private int thumbnailWidth;
    private int thumbnailHeight;
}

