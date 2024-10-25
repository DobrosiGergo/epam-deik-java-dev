package com.epam.training.ticketservice.udto;

import com.epam.training.ticketservice.model.modelClasses.UserModel;
import lombok.Getter;

@Getter
public class UserDto {

    private final String username;
    private final UserModel.Role role;

    public UserDto(UserModel userModel) {
        this.username = userModel.getUsername();
        this.role = userModel.getRole();
    }
}
