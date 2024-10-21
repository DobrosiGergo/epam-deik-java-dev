package com.epam.training.ticketservice.model.repositories;

import com.epam.training.ticketservice.model.modelClasses.RoomModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomModelRepository extends JpaRepository<RoomModel, Integer> {
    Optional<RoomModel> findByRoomName(String roomName);
}
