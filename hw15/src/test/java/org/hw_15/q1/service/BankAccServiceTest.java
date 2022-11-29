package org.hw_15.q1.service;

import org.hw_15.q1.entity.AccountType;
import org.hw_15.q1.entity.BankAccount;
import org.hw_15.q1.utils.AppContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class BankAccServiceTest {
    private static BankAccount bankAccount=new BankAccount("0123456789","0123456789123456", AccountType.CHECKING_ACCOUNT);
    @BeforeEach
    void beforeEach() {
        if (AppContext.getBANK_ACC_SERVICE().isExistsById(bankAccount.getId()))
            AppContext.getBANK_ACC_SERVICE().delete(bankAccount);
    }

    @Test
    public void testSave(){
        AppContext.getBANK_ACC_SERVICE().save(bankAccount);
        Assert.assertEquals(bankAccount,
                AppContext.getBANK_ACC_SERVICE().findById(bankAccount.getId()));
    }
    @Test
    public void testUpdate(){
        AppContext.getBANK_ACC_SERVICE().save(bankAccount);
        bankAccount.setCardNumber("6543210987654321");
        bankAccount.setAccountType(AccountType.INTEREST_FREE);
        AppContext.getBANK_ACC_SERVICE().update(bankAccount);
        Assert.assertEquals(bankAccount,
                AppContext.getBANK_ACC_SERVICE().findById(bankAccount.getId()));
    }
    @Test
    public void findById(){
        AppContext.getBANK_ACC_SERVICE().save(bankAccount);
        Assert.assertEquals(bankAccount,
                AppContext.getBANK_ACC_SERVICE().findById(bankAccount.getId()));
    }
    @Test
    public void testDelete(){
        AppContext.getBANK_ACC_SERVICE().save(bankAccount);
        Assert.assertTrue(AppContext.getBANK_ACC_SERVICE().isExistsById(bankAccount.getId()));
        AppContext.getBANK_ACC_SERVICE().delete(bankAccount);
        Assert.assertFalse(AppContext.getBANK_ACC_SERVICE().isExistsById(bankAccount.getId()));
    }

    @Test
    public void testDeactivateBankAcc() {
        AppContext.getBANK_ACC_SERVICE().save(bankAccount);
        Assert.assertTrue(bankAccount.isActive());
        AppContext.getBANK_ACC_SERVICE().deactivateBankAcc(bankAccount);
        Assert.assertFalse(bankAccount.isActive());
    }

    @Test
    public void testReactivateBankAcc() {
        AppContext.getBANK_ACC_SERVICE().save(bankAccount);
        Assert.assertTrue(bankAccount.isActive());
        AppContext.getBANK_ACC_SERVICE().deactivateBankAcc(bankAccount);
        Assert.assertFalse(bankAccount.isActive());
        AppContext.getBANK_ACC_SERVICE().reactivateBankAcc(bankAccount);
        Assert.assertTrue(bankAccount.isActive());
    }

    @Test
    public void testDeposit0() {
        AppContext.getBANK_ACC_SERVICE().save(bankAccount);
        AppContext.getBANK_ACC_SERVICE().deposit(bankAccount,100);
        Assert.assertEquals(100,bankAccount.getBalance(),0);
    }
    @Test
    public void testDeposit1() {
        AppContext.getBANK_ACC_SERVICE().save(bankAccount);
        AppContext.getBANK_ACC_SERVICE().deactivateBankAcc(bankAccount);
        try {
            AppContext.getBANK_ACC_SERVICE().deposit(bankAccount,100);
            fail("An error expected");
        } catch (RuntimeException e) {
            assertEquals("This Bank account is deactivated.", e.getMessage());
        }
    }

    @Test
    public void testWithdraw0() {
        AppContext.getBANK_ACC_SERVICE().save(bankAccount);
        AppContext.getBANK_ACC_SERVICE().deposit(bankAccount,100);
        Assert.assertEquals(100,bankAccount.getBalance(),0);
        AppContext.getBANK_ACC_SERVICE().withdraw(bankAccount,60);
        Assert.assertEquals(40,bankAccount.getBalance(),0);
    }
    @Test
    public void testWithdraw1() {
        AppContext.getBANK_ACC_SERVICE().save(bankAccount);
        AppContext.getBANK_ACC_SERVICE().deposit(bankAccount,100);
        Assert.assertEquals(100,bankAccount.getBalance(),0);
        try {
            AppContext.getBANK_ACC_SERVICE().withdraw(bankAccount,120);
            fail("An error expected");
        } catch (RuntimeException e) {
            assertEquals("Insufficient funds.", e.getMessage());
        }
    }

    @Test
    public void testWithdraw2(){
        AppContext.getBANK_ACC_SERVICE().save(bankAccount);
        AppContext.getBANK_ACC_SERVICE().deposit(bankAccount,100);
        AppContext.getBANK_ACC_SERVICE().deactivateBankAcc(bankAccount);
        try {
            AppContext.getBANK_ACC_SERVICE().withdraw(bankAccount,60);
            fail("An error expected");
        } catch (RuntimeException e) {
            assertEquals("This Bank account is deactivated.", e.getMessage());
        }
    }
}