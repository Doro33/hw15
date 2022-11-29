package org.hw_15.q1;

import org.hw_15.q1.entity.AccountType;
import org.hw_15.q1.entity.BankAccount;
import org.hw_15.q1.utils.AppContext;

import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        BankAccount ba=new BankAccount("0123456789","0123456789123456", AccountType.CHECKING_ACCOUNT);
        System.out.println(AppContext.getBANK_ACC_SERVICE().save(ba));
        System.out.println(AppContext.getBANK_ACC_SERVICE().deposit(ba,100));
        System.out.println(AppContext.getBANK_ACC_SERVICE().findById(ba.getId()));
        System.out.println(AppContext.getBANK_ACC_SERVICE().deactivateBankAcc(ba));
        System.out.println(AppContext.getBANK_ACC_SERVICE().findById(5L));

        System.out.println(AppContext.getBANK_ACC_SERVICE().deposit(ba,100));
        System.out.println(AppContext.getBANK_ACC_SERVICE().reactivateBankAcc(ba));
        System.out.println(AppContext.getBANK_ACC_SERVICE().withdraw(ba,60));
        System.out.println(AppContext.getBANK_ACC_SERVICE().withdraw(ba,60));

        }
}
