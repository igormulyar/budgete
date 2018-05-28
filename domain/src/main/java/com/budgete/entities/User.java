package com.budgete.entities;

import java.time.LocalDate;
import java.util.Locale;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author imuliar
 * 07.01.2018
 */

@Entity
@Table(name = "USERS")
public class User extends BasicEntityFrame{

    private String userName;

    private String email;

    private String userPassword;

    private LocalDate dateOfBirth;

    //TODO consider ORM mapping for this field
    @Transient
    private Locale locale;

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String password) {
        this.userPassword = password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public User(String userName, String email, String userPassword, LocalDate dateOfBirth, Locale locale) {
        this.userName = userName;
        this.email = email;
        this.userPassword = userPassword;
        this.dateOfBirth = dateOfBirth;
        this.locale = locale;
    }
}
