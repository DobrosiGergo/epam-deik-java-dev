package com.epam.training.ticketservice.model.modelClasses;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "Room")
public class RoomModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String roomName;
    private int roomRow;
    private int roomColumn;

    public RoomModel(int roomColumn, int roomRow, String roomName) {
        this.roomColumn = roomColumn;
        this.roomRow = roomRow;
        this.roomName = roomName;
    }
}
