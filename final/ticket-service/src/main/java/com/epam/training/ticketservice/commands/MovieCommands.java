package com.epam.training.ticketservice.commands;

import com.epam.training.ticketservice.model.modelClasses.MovieModel;
import com.epam.training.ticketservice.model.repositories.MovieModelRepository;
import com.epam.training.ticketservice.services.MovieModelService;
import com.epam.training.ticketservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

@ShellComponent
@RequiredArgsConstructor
public class MovieCommands {
    private final MovieModelService movieModelService;
    private final UserService userModelService;
    @ShellMethodAvailability("isAvailable")
    @ShellMethod(key="create movie", value="You can create a movie by this command.")
    public String createMovie(String movieTitle,String genre, int time){
        movieModelService.createMovie(movieTitle,genre,time);
        return "Your movie was uploaded to the cloud.";
    }
    @ShellMethod(key="list movies", value="You can list all the movies by this command.")
    public String Movies() throws Exception {
        return movieModelService.showMovies();
    }
    @ShellMethodAvailability("isAvailable")
    @ShellMethod(key = "update movie", value = "You can update a movie via movie title.")
    public String updateMovie(String movieTitle,String genre, int time) throws Exception {
        movieModelService.updateMovie(movieTitle,genre,time);
        return "You updated the next movie "+movieTitle+"!";
    }
    @ShellMethodAvailability("isAvailable")
    @ShellMethod(key = "delete movie",value="You can delete a movie with this command")
    public String deleteMovie(String movieTitle) throws Exception {
        movieModelService.deleteMovie(movieTitle);
        return "You deleted the movie "+movieTitle+"!";
    }
    private Availability isAvailable() {
        return userModelService.getLoggedUser().getUsername().equals("admin")
                ? Availability.available()
                : Availability.unavailable("You are not authorized");
    }

}
