package com.movies.booking.service;

import com.movies.booking.model.Movie;
import com.movies.booking.model.Show;
import com.movies.booking.model.Theatre;
import com.movies.booking.model.User;
import com.movies.booking.repository.MovieRepository;
import com.movies.booking.repository.TheatreRepository;
import com.movies.booking.repository.UserRepository;
import com.movies.booking.resources.BookingRequest;

import java.util.Optional;

public interface BookingOrchestrator {

    default User book(BookingRequest bookingRequest) {

        Optional<Movie> optionalMovie = movieRepository().findById(bookingRequest.getMovieId());
        Optional<Theatre> optionalTheatre = theatreRepository().findById(bookingRequest.getTheatreId());
        Optional<User> optionalUser = userRepository().findByUsername(bookingRequest.getUsername());

        if (optionalMovie.isPresent() && optionalTheatre.isPresent() && optionalUser.isPresent()) {
            Movie movie = optionalMovie.get();
            Theatre theatre = optionalTheatre.get();
            User user = optionalUser.get();

            Show savedShow = saveShow(movie, theatre, bookingRequest.getDateTime());

            User updatedUser = updateUserWithShow(user, savedShow);

            updateTheatreWithShow(theatre, savedShow);
            return updatedUser;
        }
        throw new RuntimeException("No valid selection for user, movie and theatre");
    }

    TheatreRepository theatreRepository();

    MovieRepository movieRepository();

    UserRepository userRepository();

    Show saveShow(Movie movie, Theatre theatre, long dateTime);

    User updateUserWithShow(User user, Show show);

    Theatre updateTheatreWithShow(Theatre theatre, Show show);
}
