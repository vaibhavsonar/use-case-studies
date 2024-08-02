package com.movies.booking.service;

import com.movies.booking.model.Movie;
import com.movies.booking.model.Show;
import com.movies.booking.model.Theatre;
import com.movies.booking.model.User;
import com.movies.booking.repository.ShowRepository;
import com.movies.booking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User addShow(User user, Show show) {
        List<Show> bookedShows = user.getBookedShows();
        if(Objects.isNull(bookedShows)) {
            bookedShows = new ArrayList<>();
        }
        bookedShows.add(show);
        user.setBookedShows(bookedShows);
        return userRepository.save(user);
    }
}
