package com.budgete;

public class LoginServiceImpl implements LoginService
{
    @Override
    public Status checkCredentials(String name, String password)
    {
        if (name == "user" && password == "qwerty")
        {
            return Status.CORRECT;
        }
        return Status.NOT_CORRECT;
    }
}
