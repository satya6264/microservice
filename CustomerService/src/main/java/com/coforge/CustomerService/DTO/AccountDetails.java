package com.coforge.CustomerService.DTO;

public class AccountDetails {

    long accountNumber;
    int customerNumber;
    int branchId;
    double openingBalance;
    String accountType;
    String accountStatus;

    public AccountDetails(double openingBalance) {
        this.openingBalance = openingBalance;
    }

    public AccountDetails(){}

    public AccountDetails(int customerNumber, int branchId, double openingBalance, String accountType, String accountStatus) {
        this.customerNumber = customerNumber;
        this.branchId = branchId;
        this.openingBalance = openingBalance;
        this.accountType = accountType;
        this.accountStatus = accountStatus;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public double getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(double openingBalance) {
        this.openingBalance = openingBalance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }
}
