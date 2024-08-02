package com.movies.booking.resources;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TheatreNotFoundError {

    private final String message;

}

