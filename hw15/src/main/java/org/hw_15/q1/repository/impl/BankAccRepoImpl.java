package org.hw_15.q1.repository.impl;

import jakarta.persistence.EntityManager;
import org.hw_15.q1.base.repository.impl.BaseRepositoryImpl;
import org.hw_15.q1.entity.BankAccount;
import org.hw_15.q1.repository.BankAccRepo;

public class BankAccRepoImpl extends BaseRepositoryImpl<BankAccount, Long> implements BankAccRepo {
    public BankAccRepoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<BankAccount> getEntityClass() {
        return BankAccount.class;
    }
}