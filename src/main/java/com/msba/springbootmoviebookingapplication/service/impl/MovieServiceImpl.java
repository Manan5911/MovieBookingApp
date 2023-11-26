package com.msba.springbootmoviebookingapplication.service.impl;

import com.msba.springbootmoviebookingapplication.dto.MovieDto;
import com.msba.springbootmoviebookingapplication.entity.Movie;
import com.msba.springbootmoviebookingapplication.exception.ResourceNotFoundException;
import com.msba.springbootmoviebookingapplication.repository.MovieRepository;
import com.msba.springbootmoviebookingapplication.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    private ModelMapper mapper;

    public MovieServiceImpl(MovieRepository movieRepository, ModelMapper mapper) {
        this.movieRepository = movieRepository;
        this.mapper = mapper;
    }

    @Override
    public MovieDto createMovie(MovieDto movieDto) {
        Movie movie = mapToEntity(movieDto);
        Movie newMovie = movieRepository.save(movie);
        return mapToDto(newMovie);
    }

    @Override
    public List<MovieDto> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream().map(movie -> mapToDto(movie)).collect(Collectors.toList());
    }

    @Override
    public MovieDto getMovieById(long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie", "id", id));
        return mapToDto(movie);
    }

    @Override
    public void deleteMovieById(long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie", "id", id));
        movieRepository.delete(movie);
    }

    @Override
    public MovieDto findByMovieName(String movieName) {
        Movie movie = movieRepository.findByMovieName(movieName);
        return mapToDto(movie);
    }

    private MovieDto mapToDto(Movie movie){
        MovieDto movieDto = mapper.map(movie, MovieDto.class);
        return movieDto;
    }

    private Movie mapToEntity(MovieDto movieDto){
        Movie movie = mapper.map(movieDto, Movie.class);
        return movie;
    }
}
