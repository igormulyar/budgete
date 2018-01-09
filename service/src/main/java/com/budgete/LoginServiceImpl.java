package com.budgete;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class LoginServiceImpl implements LoginService
{
    @Override
    public Status checkCredentials(String name, String password)
    {
        try
        {
            Map<String, String> users = getUsers();

            if(users.entrySet().stream().anyMatch(
                    stringStringEntry -> stringStringEntry.getKey().equals(name) && stringStringEntry.getValue()
                            .equals(password)))
            {
                return Status.CORRECT;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return Status.NOT_CORRECT;
    }
    
    private Map<String, String> getUsers() throws SQLException
    {
        Map<String, String> result = new HashMap<>();
        
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("scott");
        dataSource.setPassword("tiger");
        dataSource.setServerName("myDBHost.example.org");

        try (Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT username, password FROM budgete.users"))
        {
            while (resultSet.next())
            {
                result.put(resultSet.getString("username"), resultSet.getString("password"));
            }
        }

        return result;
    }
}
