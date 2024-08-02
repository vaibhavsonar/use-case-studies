package com.movies.booking.controller;

import com.movies.booking.model.Theatre;
import com.movies.booking.resources.TheatreNotFoundError;
import com.movies.booking.resources.TheatreRequest;
import com.movies.booking.service.TheatreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TheatreController {
    private final TheatreService theatreService;

    @Operation(
            operationId = "getTheatresByCityName",
            summary = "Get all theatres information by city name",
            tags = {"theatres"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Theatre.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Theatre not found", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = TheatreNotFoundError.class))
                    })
            }
    )
    @GetMapping(value = "/theatres/by/city/{cityName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Theatre>> getTheatresByCityName(@PathVariable("cityName") String cityName) {
        return ResponseEntity.ok(theatreService.findAllByCityName(cityName));
    }

    @Operation(
            operationId = "getTheatresByRunningShows",
            summary = "Get all theatres information with running",
            tags = {"theatres"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Theatre.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "Theatre not found", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = TheatreNotFoundError.class))
                    })
            }
    )
    @GetMapping(value = "/theatres/by/shows", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Theatre>> getTheatresByRunningShows(@RequestBody TheatreRequest theatreRequest) {
        return ResponseEntity.ok(theatreService.findAllByRunningShows(theatreRequest));
    }
}
