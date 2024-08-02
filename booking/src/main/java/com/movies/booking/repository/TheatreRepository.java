package com.movies.booking.repository;

import com.movies.booking.model.Theatre;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface TheatreRepository extends MongoRepository<Theatre, String> {

    @Query(value = "{city: ?0}")
    List<Theatre> findAllByCityName(String cityName);

    @Query(value = "{isRunning: ?0}")
    List<Theatre> findAllByRunningShows(boolean runningShows);
}
