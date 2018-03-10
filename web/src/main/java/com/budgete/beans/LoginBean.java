package com.budgete.beans;

import com.budgete.dto.Status;
import com.budgete.service.LoginService;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
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
     */
    private String login;

    /**
     * Users password
     */
    private String password;

    /**
     * service for managing the user authentication
     */
    private LoginService loginService;

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

    /**
     * <p>Action method that executes during the credential submitting.
     * The purpose is to let the user navigate to the next page if right credentials provided
     * or print the error message if not.</p>
     */
    public String submitCredentials() {
        ResourceBundle resourceBundle = PropertyResourceBundle.getBundle("en_bundle");
        LOGGER.info(String.format("Submitting the credentials where login is {} and password is {}", login, password));
        if (Status.SUCCESS == loginService.checkCredentials(login, password)) {
            return "main";
        } else {
            FacesContext.getCurrentInstance().addMessage("signinButton",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, resourceBundle.getString("error.wrongCredentials"),
                            "Wrong login or password or both."));
            return null;
        }
    }

    public LoginService getLoginService() {
        return loginService;
    }

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}
