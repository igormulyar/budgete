package com.budgete.service;

import com.budgete.entities.User;
import java.util.List;

/**
 * @author imuliar
 * 09.05.2018
 */

public interface UserService {

    User save(User user);

    List<User> getAll();
}
