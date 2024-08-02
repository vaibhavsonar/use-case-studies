package com.movies.booking.repository;

import com.movies.booking.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    @Query(value = "{'title': {$regex: ?0 }}")
    List<Movie> findAllByTitle(String title);

}
