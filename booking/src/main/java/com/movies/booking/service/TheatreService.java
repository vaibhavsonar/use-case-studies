package com.movies.booking.service;

import com.movies.booking.model.Show;
import com.movies.booking.model.Theatre;
import com.movies.booking.model.User;
import com.movies.booking.repository.ShowRepository;
import com.movies.booking.repository.TheatreRepository;
import com.movies.booking.resources.TheatreRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Slf4j
@Component
@RequiredArgsConstructor
public class TheatreService {
    private final TheatreRepository theatreRepository;
    private final ShowRepository showRepository;

    public List<Theatre> findAllByCityName(String cityName) {
        return theatreRepository.findAllByCityName(cityName);
    }

    public List<Theatre> findAllByRunningShows(TheatreRequest theatreRequest) {
        Stream<Theatre> theatreStream = theatreRepository.findAll()
                .stream()
                .map(theatre -> {
                    theatre.setShows(theatre.getShows()
                            .stream()
                            .filter(show -> show.getIsRunning().equals(theatreRequest.isRunningShowsOnly()))
                            .toList())
                    ;
                    return theatre;
                });
        if(Objects.nonNull(theatreRequest.getCity())) {
            theatreStream = theatreStream.filter(theatre -> theatre.getCity().equals(theatreRequest.getCity()));
        }
        return theatreStream.toList();
    }

    public Theatre addShow(Theatre theatre, Show show) {
        List<Show> shows = theatre.getShows();
        if(Objects.isNull(shows)) {
            shows = new ArrayList<>();
        }
        shows.add(show);
        theatre.setShows(shows);
        return theatreRepository.save(theatre);
    }
}
