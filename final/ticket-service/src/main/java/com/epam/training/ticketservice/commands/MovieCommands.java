package com.epam.training.ticketservice.commands;

import com.epam.training.ticketservice.model.modelClasses.MovieModel;
import com.epam.training.ticketservice.model.repositories.MovieModelRepository;
import com.epam.training.ticketservice.services.MovieModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

@ShellComponent
@RequiredArgsConstructor
public class MovieCommands {
    private final MovieModelService movieModelService;
    //@ShellMethodAvailability("isAvailable")
    @ShellMethod(key="create movie", value="You can create a movie by this command.")
    public String createMovie(String movieTitle,String genre, int time){
        movieModelService.createMovie(movieTitle,genre,time);
        return "Your movie was uploaded to the cloud.";
    }
    @ShellMethod(key="list movies", value="You can list all the movies by this command.")
    public String Movies() throws Exception {
        return movieModelService.showMovies();
    }
    //@ShellMethodAvailability("isAvailable")
    @ShellMethod(key = "update movie", value = "You can update a movie via movie title.")
    public String updateMovie(String movieTitle,String genre, int time) throws Exception {
        movieModelService.updateMovie(movieTitle,genre,time);
        return "You updated the next movie "+movieTitle+"!";
    }

}
