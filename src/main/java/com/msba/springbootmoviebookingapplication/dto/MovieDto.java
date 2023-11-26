package com.msba.springbootmoviebookingapplication.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MovieDto {
    private Long movieId;
    private String movieName;
    private Date movieReleaseDate;
    private String movieRating;
    private String moviePosterUrl;
}
