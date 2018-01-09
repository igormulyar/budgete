package com.budgete.model;

import java.time.LocalDate;
import java.util.Locale;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author imuliar
 * 07.01.2018
 */

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    private Long id;

    private String userName;

    private String email;

    private String password;

    private LocalDate dateOfBirth;

    //TODO consider ORM mapping for this field
    private Locale locale;

    public User() {
    }

    public User(String userName, String email, String password, LocalDate dateOfBirth, Locale locale) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.locale = locale;
    }
}
