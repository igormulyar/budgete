package com.budgete.beans;

import java.util.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

/**
 * @author imuliar
 * 23.12.2017
 */
@Component
@SessionScope
public class LoginBean {

    private static final Logger LOGGER = Logger.getLogger(LoginBean.class.getName());

    /**
     * Users e-mail that is used as a login
     *
     */
    private String login;

    /**
     * Users password
     *
     */
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String submitCredentials(){
        LOGGER.info(String.format("Submitting the credentials where login is %s and password is %s", login, password));
        //TODO call the service for checking the creds
        return "main";
    }
}
