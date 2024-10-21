package com.epam.training.ticketservice.services;

import com.epam.training.ticketservice.model.modelClasses.MovieModel;
import com.epam.training.ticketservice.model.repositories.MovieModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieModelService {
    private final MovieModelRepository movieModelRepository;

    public void createMovie(String movieTitle, String genre, int time){
        MovieModel movieModel = new MovieModel(movieTitle, genre, time);
        if(movieModelRepository.findByMovieTitle(movieTitle).isPresent()){
            throw new RuntimeException("This movie already exists");
        }else{
            movieModelRepository.save(movieModel);
        }
    }
    public String showMovies() throws Exception {
        List<MovieModel> movieModels= movieModelRepository.findAll();
        if (movieModels.isEmpty()){
            throw new Exception("There are no movies currently on the list!");
        }else {
            String movies ="";

            for(MovieModel movieModel: movieModels){
                movies +=movieModel+"\n";
            }
            return movies;
        }
    }
}
