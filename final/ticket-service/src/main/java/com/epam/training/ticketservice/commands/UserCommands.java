package com.epam.training.ticketservice.commands;

import com.epam.training.ticketservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class UserCommands {
private final UserService userModelService;
@ShellMethod(key = "sign in privileged",value = "You can sign in with this command.")
public String sngIn(String username, String passwd){
    return userModelService.signIn(username, passwd);
}
@ShellMethod(key = "log out", value = "You can log out from your account with this comment.")
public String logOut(){
    return userModelService.logOut();
}
    @ShellMethod(key = "describe account", value = "You can view the description for a specific account.")
    public String describeAccount(String username){
        return userModelService.describeAccount(username);
    }

}
