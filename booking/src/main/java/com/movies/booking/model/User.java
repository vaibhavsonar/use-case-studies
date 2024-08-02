package com.movies.booking.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@Document("users")
@Accessors(chain = true)
public class User {
    @Id
    private String id;
    private String username;
    private long mobile;

    @DocumentReference(collection = "shows")
    private List<Show> bookedShows;

}

