package com.coforge.CustomerService.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="customer_account_transaction")
public class CustomerAccountTransaction {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    long transactionNumber;

    long accountNumber;

    Date dateOfTransaction;

    String modeOfTransaction;

    String transactionType;

    double transactionAmount;

    public  CustomerAccountTransaction(){}


    public CustomerAccountTransaction(long accountNumber, Date dateOfTransaction, String modeOfTransaction, String transactionType, double transactionAmount) {
        this.accountNumber = accountNumber;
        this.dateOfTransaction = dateOfTransaction;
        this.modeOfTransaction = modeOfTransaction;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
    }

    public long getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(long transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(Date dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public String getModeOfTransaction() {
        return modeOfTransaction;
    }

    public void setModeOfTransaction(String modeOfTransaction) {
        this.modeOfTransaction = modeOfTransaction;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
