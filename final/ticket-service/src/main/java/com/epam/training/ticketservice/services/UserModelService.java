package com.epam.training.ticketservice.services;

import com.epam.training.ticketservice.model.modelClasses.UserModel;
import com.epam.training.ticketservice.model.repositories.UserModelRepository;
import com.epam.training.ticketservice.udto.UserDto;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserModelService implements UserService {
    private UserDto loggedInUser = null;
    private final UserModelRepository userModelRepository;
    @Override
    public String signIn(String username, String password) {
        Optional<UserModel> adminUser = userModelRepository.findByUsername(username);
        if (adminUser.isPresent() && adminUser.get().getUsername().equals(password)) {
            loggedInUser = new UserDto(adminUser.get());
            return "Signed in";
        } else {
            return "Login failed due to incorrect credentials";
        }
    }

    @Override
    public String logOut() {
        if (loggedInUser != null) {
            String user = loggedInUser.getUsername();
            loggedInUser = null;
            return "Signed out";
        } else {
            return "You are not signed in";
        }
    }

    @Override
    public String describeAccount(String username) {
        if (loggedInUser != null) {
            return "Signed in with privileged account '" + loggedInUser.getUsername() + "'";
        } else {
            return "You are not signed in";
        }
    }

    @Override
    public UserDto getLoggedUser() {
        return loggedInUser;
    }
}
