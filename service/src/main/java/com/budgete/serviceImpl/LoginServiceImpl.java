package com.budgete.serviceImpl;

import com.budgete.dto.Status;
import com.budgete.entities.User;
import com.budgete.service.LoginService;
import com.budgete.service.UserService;
import java.sql.SQLException;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class LoginServiceImpl implements LoginService {

    UserService userService;

    @Override
    public Status checkCredentials(String email, String password) {
        try {
            Map<String, String> users = getUsers();

            if (users.entrySet().stream()
                    .anyMatch(stringStringEntry -> stringStringEntry.getKey().equals(email)
                            && stringStringEntry.getValue().equals(password))) {
                return Status.SUCCESS;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Status.FAIL;
    }

    private Map<String, String> getUsers() throws SQLException {
        return userService.getAll().stream()
                .collect(Collectors.toMap(User::getEmail, User::getPassword));
    }
}
