package com.budgete.daoimpl;

import com.budgete.dao.BasicDao;
import com.budgete.entities.BasicEntityFrame;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * @author imuliar
 * 09.05.2018
 */

public class BasicDaoImpl<T extends BasicEntityFrame> implements BasicDao<T> {

    private Class<T> type;

    @PersistenceContext
    private EntityManager entityManager;

    public BasicDaoImpl(Class<T> type) {
        this.type = type;
    }

    @Override
    public T save(T o) {
        entityManager.persist(o);
        return o;
    }

    @Override
    public T update(T o) {
        return entityManager.merge(o);
    }

    @Override
    public void delete(T o) {
        entityManager.remove(entityManager.merge(o));
    }

    @Override
    public T find(long id) {
        return entityManager.find(type, id);
    }

    @Override
    public List<T> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteria = criteriaBuilder.createQuery(type);
        Root<T> root = criteria.from(type);
        criteria.orderBy(criteriaBuilder.asc(root.get("id")));
        return entityManager.createQuery(criteria).getResultList();
    }
}
