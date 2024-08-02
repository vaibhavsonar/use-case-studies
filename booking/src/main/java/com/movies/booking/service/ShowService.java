package com.movies.booking.service;

import com.movies.booking.model.Movie;
import com.movies.booking.model.Show;
import com.movies.booking.model.Theatre;
import com.movies.booking.repository.MovieRepository;
import com.movies.booking.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ShowService {
    private final ShowRepository showRepository;

    public Show save(Movie movie, Theatre theatre, long dateTime) {
        Show show = new Show()
                .setMovie(movie)
//                .setTheatre(theatre)
                .setIsRunning(false)
                .setReleased(true)
                .setStartDateTime(dateTime);
        return showRepository.save(show);
    }



}
