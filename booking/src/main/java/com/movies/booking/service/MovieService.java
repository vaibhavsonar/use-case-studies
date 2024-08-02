package com.movies.booking.service;

import com.movies.booking.model.Movie;
import com.movies.booking.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public List<Movie> findAllByTitle(String title) {
        String regex = ".*" + title + ".*";
        return movieRepository.findAllByTitle(regex);
    }
}
