package com.budgete.dao;

import com.budgete.entities.BasicEntityFrame;
import java.io.Serializable;
import java.util.List;

/**
 * @author imuliar
 * 09.05.2018
 */

public interface BasicDao<T extends BasicEntityFrame> extends Serializable {

    T save(T o);

    T update(T o);

    void delete(T o);

    T find(long id);

    List<T> getAll();
}
