package com.movies.booking.resources;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MovieNotFoundError {

    private final String message;

}

