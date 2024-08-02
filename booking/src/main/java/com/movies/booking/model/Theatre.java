package com.movies.booking.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
@Document("theatres")
public class Theatre {

    @Id
    String id;
    private String name;
    private String city;
    private String address;

    @DocumentReference(collection = "shows")
    List<Show> shows;
}

