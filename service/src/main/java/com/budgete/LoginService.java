package com.budgete;

/**
 * @author imuliar
 * 23.12.2017
 */

public interface LoginService {
    Status checkCredentials(String name, String password);
}
