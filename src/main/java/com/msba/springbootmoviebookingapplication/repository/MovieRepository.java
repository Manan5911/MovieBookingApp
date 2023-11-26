package com.msba.springbootmoviebookingapplication.repository;

import com.msba.springbootmoviebookingapplication.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query(value = "select * from movies as u where u.movie_name = :name", nativeQuery = true)
    Movie findByMovieName(@Param("name") String movieName);
}
