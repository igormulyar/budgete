package com.budgete;

import org.springframework.stereotype.Component;

@Component
public class LoginServiceImpl implements LoginService {

    @Override
    public Status checkCredentials(String name, String password) {
        if (name.equals("user@example.com") && password.equals("qwerty")) {
            return Status.SUCCESS;
        }
        return Status.FAIL;
    }
}