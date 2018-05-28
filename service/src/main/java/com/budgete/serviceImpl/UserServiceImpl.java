package com.budgete.serviceimpl;

import com.budgete.dao.UserDao;
import com.budgete.entities.User;
import com.budgete.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author imuliar
 * 09.05.2018
 */
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao=userDao;
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
