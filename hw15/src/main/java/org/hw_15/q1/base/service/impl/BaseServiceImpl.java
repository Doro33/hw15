package org.hw_15.q1.base.service.impl;

import jakarta.persistence.EntityTransaction;
import org.hw_15.q1.base.entity.BaseEntity;
import org.hw_15.q1.base.repository.BaseRepository;
import org.hw_15.q1.base.service.BaseService;

import java.io.Serializable;
import java.util.List;

public class BaseServiceImpl <E extends BaseEntity<ID>,ID extends Serializable,R extends BaseRepository<E,ID>>
        implements BaseService<E,ID> {

    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public E save(E e) {
        EntityTransaction transaction = repository.getEntityManager().getTransaction();
        transaction.begin();
        repository.save(e);
        transaction.commit();
        return e;
    }

    @Override
    public E update(E e) {
        EntityTransaction transaction = repository.getEntityManager().getTransaction();
        transaction.begin();
        repository.update(e);
        transaction.commit();
        return e;
    }

    @Override
    public void delete(E e) {
        EntityTransaction transaction = repository.getEntityManager().getTransaction();
        transaction.begin();
        repository.delete(e);
        transaction.commit();
    }

    @Override
    public E findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean isExistsById(ID id) {
        return repository.isExistsById(id);
    }

    @Override
    public Long countAll() {
        return repository.countAll();
    }
}