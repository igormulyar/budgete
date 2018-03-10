package com.budgete.serviceImpl;

import com.budgete.dto.Status;
import com.budgete.service.LoginService;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class LoginServiceImpl implements LoginService {

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
        Map<String, String> result = new HashMap<>();

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("rootpass");
        dataSource.setServerName("localhost");

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT email, password FROM budgete.users")) {
            while (resultSet.next()) {
                result.put(resultSet.getString("email"), resultSet.getString("password"));
            }
        }

        return result;
    }
}
