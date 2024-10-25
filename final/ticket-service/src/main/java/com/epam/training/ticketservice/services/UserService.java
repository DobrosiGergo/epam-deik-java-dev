package com.epam.training.ticketservice.services;

import com.epam.training.ticketservice.udto.UserDto;

public interface UserService {
    String signIn(String username, String password);

    String logOut();


    String describeAccount(String username);

    UserDto getLoggedUser();
}
