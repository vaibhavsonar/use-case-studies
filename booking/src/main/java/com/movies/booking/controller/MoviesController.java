package com.movies.booking.controller;

import com.movies.booking.model.Movie;
import com.movies.booking.model.Show;
import com.movies.booking.model.User;
import com.movies.booking.resources.BookingRequest;
import com.movies.booking.resources.MovieNotFoundError;
import com.movies.booking.service.BookingService;
import com.movies.booking.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MoviesController {
    private final MovieService movieService;
    private final BookingService bookingService;

    @Operation(
            operationId = "getMoviesByTitle",
            summary = "Get all movies information by title",
            tags = {"movies"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Movie.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Movie not found", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = MovieNotFoundError.class))
                    })
            }
    )
    @GetMapping(value = "/movies/by/title/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Movie>> getMoviesByTitle(@PathVariable("title") String title) {
        return ResponseEntity.ok(movieService.findAllByTitle(title));
    }

    @Operation(
            operationId = "bookTickets",
            summary = "Book movie tickets",
            tags = {"movies"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Show.class))
                    })
            }
    )
    @PostMapping(value = "/movies/book", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> bookTickets(@RequestBody BookingRequest bookingRequest) {
        return ResponseEntity.ok(bookingService.book(bookingRequest));
    }


}
