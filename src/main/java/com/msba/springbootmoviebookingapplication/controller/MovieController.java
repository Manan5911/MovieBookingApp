package com.msba.springbootmoviebookingapplication.controller;

import com.msba.springbootmoviebookingapplication.dto.MovieDto;
import com.msba.springbootmoviebookingapplication.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @PostMapping
    public ResponseEntity<MovieDto> createMovie(@RequestBody MovieDto movieDto){
        return new ResponseEntity<>(movieService.createMovie(movieDto), HttpStatus.CREATED);
    }
    @GetMapping
    public List<MovieDto> getAllMovies(){
        return movieService.getAllMovies();
    }
    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(movieService.getMovieById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable(name="id") long id){
        movieService.deleteMovieById(id);
        return new ResponseEntity<>("Movie entity deleted successfully.", HttpStatus.OK);
    }
    @GetMapping("/{name}")
    public ResponseEntity<MovieDto> getMovieByName(@PathVariable(name="name") String movieName){
        return ResponseEntity.ok(movieService.findByMovieName(movieName));
    }
}
