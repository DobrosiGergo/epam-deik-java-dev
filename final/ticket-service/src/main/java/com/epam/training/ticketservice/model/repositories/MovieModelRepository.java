package com.epam.training.ticketservice.model.repositories;

import com.epam.training.ticketservice.model.modelClasses.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieModelRepository extends JpaRepository<MovieModel, Integer> {
    Optional<MovieModel> findByMovieTitle(String movieTitle);
}
