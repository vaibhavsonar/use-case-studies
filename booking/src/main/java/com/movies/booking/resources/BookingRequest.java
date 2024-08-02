package com.movies.booking.resources;

import lombok.Data;

@Data
public class BookingRequest {
    private String username;
    private String theatreId;
    private String movieId;
    private long dateTime;
    private int[] preferredSeats;
}

