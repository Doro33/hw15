package org.hw_15.q1.service;

import org.hw_15.q1.base.service.BaseService;
import org.hw_15.q1.entity.BankAccount;

public interface BankAccService extends BaseService<BankAccount,Long> {
    BankAccount deactivateBankAcc(BankAccount bankAccount);
    BankAccount reactivateBankAcc(BankAccount bankAccount);
    BankAccount deposit(BankAccount bankAcc, double depositAmount);
    BankAccount withdraw(BankAccount bankAcc, double withdrawAmount);
}