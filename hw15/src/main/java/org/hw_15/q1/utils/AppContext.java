package org.hw_15.q1.utils;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import org.hw_15.q1.repository.BankAccRepo;
import org.hw_15.q1.repository.impl.BankAccRepoImpl;
import org.hw_15.q1.service.BankAccService;
import org.hw_15.q1.service.impl.BankAccServiceImpl;

import java.util.Random;

public class AppContext {
    private final static  EntityManager ENTITY_MANAGER;
    private final static  BankAccRepo BANK_ACC_REPO;
    @Getter
    private final static Random RANDOM;
    @Getter
    private final static  BankAccService BANK_ACC_SERVICE;
    static {
        ENTITY_MANAGER = HibernateUtils.getEntityManagerFactory().createEntityManager();
        BANK_ACC_REPO = new BankAccRepoImpl(ENTITY_MANAGER);
        BANK_ACC_SERVICE = new BankAccServiceImpl(BANK_ACC_REPO);
        RANDOM = new Random();
    }
}