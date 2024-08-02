package com.movies.booking.service;

import com.movies.booking.model.Movie;
import com.movies.booking.model.Show;
import com.movies.booking.model.Theatre;
import com.movies.booking.model.User;
import com.movies.booking.repository.MovieRepository;
import com.movies.booking.repository.TheatreRepository;
import com.movies.booking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class BookingService implements BookingOrchestrator {
    private final TheatreRepository theatreRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final ShowService showService;
    private final UserService userService;
    private final TheatreService theatreService;

    @Override
    public TheatreRepository theatreRepository() {
        return theatreRepository;
    }

    @Override
    public MovieRepository movieRepository() {
        return movieRepository;
    }

    @Override
    public UserRepository userRepository() {
        return userRepository;
    }

    @Override
    public Show saveShow(Movie movie, Theatre theatre, long dateTime) {
        return showService.save(movie, theatre, dateTime);
    }

    @Override
    public User updateUserWithShow(User user, Show show) {
        return userService.addShow(user, show);
    }

    @Override
    public Theatre updateTheatreWithShow(Theatre theatre, Show show) {
        return theatreService.addShow(theatre, show);
    }
}
