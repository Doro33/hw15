package org.hw_15.q1.service.impl;

import org.hw_15.q1.base.service.impl.BaseServiceImpl;
import org.hw_15.q1.entity.BankAccount;
import org.hw_15.q1.repository.BankAccRepo;
import org.hw_15.q1.service.BankAccService;


public class BankAccServiceImpl extends BaseServiceImpl<BankAccount,Long, BankAccRepo>
        implements BankAccService {
    public BankAccServiceImpl(BankAccRepo repository) {
        super(repository);
    }

    @Override
    public BankAccount deactivateBankAcc(BankAccount bankAccount) {
        bankAccount.setActive(false);
        return update(bankAccount);
    }

    @Override
    public BankAccount reactivateBankAcc(BankAccount bankAccount) {
        bankAccount.setActive(true);
        return update(bankAccount);
    }

    @Override
    public BankAccount deposit(BankAccount bankAcc, double depositAmount) {
        if (bankAcc.isActive()) {
            bankAcc.setBalance(bankAcc.getBalance() + depositAmount);
             update(bankAcc);
        }else
            throw new RuntimeException("This Bank account is deactivated.");
        return bankAcc;
    }

    @Override
    public BankAccount withdraw(BankAccount bankAcc, double withdrawAmount) {
        if (bankAcc.isActive()) {
            if (bankAcc.getBalance() >= withdrawAmount) {
                bankAcc.setBalance(bankAcc.getBalance() - withdrawAmount);
                update(bankAcc);
            }else
                throw new RuntimeException("Insufficient funds.");
        }else
            throw new RuntimeException("This Bank account is deactivated.");
        return bankAcc;
    }
}