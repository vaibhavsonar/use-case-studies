package com.movies.booking.resources;

import lombok.Data;

/**
 * TheatreRequest
 */

@Data
public class TheatreRequest {
    private String city;
    private boolean runningShowsOnly;
}

