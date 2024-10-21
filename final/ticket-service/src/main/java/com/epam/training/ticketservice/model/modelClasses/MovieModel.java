package com.epam.training.ticketservice.model.modelClasses;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "movies")
public class MovieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String movieTitle;
    private String genre;
    private int time;

    public MovieModel(String movieTitle, String genre, int time) {
        this.movieTitle = movieTitle;
        this.genre = genre;
        this.time = time;
    }
}
