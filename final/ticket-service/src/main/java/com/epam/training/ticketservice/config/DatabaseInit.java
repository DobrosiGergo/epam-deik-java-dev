package com.epam.training.ticketservice.config;
import com.epam.training.ticketservice.model.modelClasses.UserModel;
import com.epam.training.ticketservice.model.repositories.UserModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class DatabaseInit {

    private final UserModelRepository userModelRepository;

    @PostConstruct
    public void init() {
        UserModel admin = new UserModel("admin", "admin", UserModel.Role.ADMIN);
        userModelRepository.save(admin);
    }
}