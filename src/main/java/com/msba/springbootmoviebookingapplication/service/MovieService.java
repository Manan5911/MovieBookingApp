package com.msba.springbootmoviebookingapplication.service;

import com.msba.springbootmoviebookingapplication.dto.MovieDto;

import java.util.List;

public interface MovieService {
    MovieDto createMovie(MovieDto movieDto);
    List<MovieDto> getAllMovies();
    MovieDto getMovieById(long id);
    void deleteMovieById(long id);
    MovieDto findByMovieName(String movieName);
}
