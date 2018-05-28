package com.budgete.serviceimpl;

import com.budgete.dto.Status;
import com.budgete.entities.User;
import com.budgete.service.LoginService;
import com.budgete.service.UserService;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginServiceImpl implements LoginService {

    private UserService userService;

    @Autowired
    public LoginServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Status checkCredentials(String email, String password) {
        Map<String, String> users = getUsers();
        if (users.entrySet().stream()
                .anyMatch(stringStringEntry -> stringStringEntry.getKey().equals(email)
                        && stringStringEntry.getValue().equals(password))) {
            return Status.SUCCESS;
        }
        return Status.FAIL;
    }

    private Map<String, String> getUsers() {
        return userService.getAll().stream()
                .collect(Collectors.toMap(User::getEmail, User::getUserPassword));
    }
}
