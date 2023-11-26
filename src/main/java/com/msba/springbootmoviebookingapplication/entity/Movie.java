package com.msba.springbootmoviebookingapplication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    @Column(nullable = false)
    private String movieName;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date movieReleaseDate;
    @Column(nullable = false)
    private String movieRating;
    @Column(nullable = false)
    private String moviePosterUrl;
}
