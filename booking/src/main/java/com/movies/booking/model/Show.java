package com.movies.booking.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Data
@Accessors(chain = true)
@Document("shows")
public class Show {
    @Id
    String id;
    private long startDateTime;

    @DocumentReference(collection = "movies")
    private Movie movie;
    private Boolean isRunning;
    private Boolean released;
    private int[] preferredSeats;
}

