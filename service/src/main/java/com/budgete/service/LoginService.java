package com.budgete.service;

import com.budgete.dto.Status;

/**
 * @author imuliar
 * 23.12.2017
 */

public interface LoginService {
    Status checkCredentials(String name, String password);
}
