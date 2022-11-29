package org.hw_15.q1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.hw_15.q1.base.entity.BaseEntity;
import org.hw_15.q1.utils.AppContext;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter
@AllArgsConstructor
public class BankAccount extends BaseEntity<Long> {

    @Column(unique = true, nullable = false, updatable = false)
    private String accountNumber;

    @Column(unique = true, nullable = false)
    private String cardNumber;

    //@CreationTimestamp
    private LocalDate createDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountType accountType;

    @Column(nullable = false)
    private double balance;

    @Column(nullable = false)
    private short cvv2;

    private LocalDate cardExpirationDate;

    @Column(nullable = false)
    private boolean isActive;

    public BankAccount(String accountNumber, String cardNumber, AccountType accountType) {
        setAccountNumber(accountNumber);
        setCardNumber(cardNumber);
        this.createDate=LocalDate.now();
        this.accountType = accountType;
        this.balance=0;
        this.cvv2 = (short) AppContext.getRANDOM().nextInt(100,10000);
        this.cardExpirationDate = createDate.plusYears(4);
        this.isActive=true;
    }

    public void setAccountNumber(String accountNumber) {
        if (accountNumber.matches("^\\d{10}$"))
             this.accountNumber = accountNumber;
        else
            throw new RuntimeException("This account number is not valid.");
    }

    public void setCardNumber(String cardNumber) {
        if (cardNumber.matches("^\\d{16}$"))
             this.cardNumber = cardNumber;
        else
            throw new RuntimeException("This card number is not valid.");
    }
}