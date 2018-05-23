package com.budgete.daoimpl;

import com.budgete.dao.UserDao;
import com.budgete.entities.User;
import org.springframework.stereotype.Repository;

/**
 * @author imuliar
 * 09.05.2018
 */
@Repository
public class UserDaoImpl extends BasicDaoImpl<User> implements UserDao {

    public UserDaoImpl() {
        super(User.class);
    }
}
