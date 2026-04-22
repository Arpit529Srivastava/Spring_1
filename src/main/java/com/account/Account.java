package com.account;

public class Account {

    private int accountId;
    private String accountHolderName;
    private double balance;
    private Loan loan;

    public Account() {
    }

    public Account(int accountId, String accountHolderName, double balance, Loan loan) {
        this.accountId = accountId;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.loan = loan;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    @Override
    public String toString() {
        return "Account{accountId=" + accountId +
               ", accountHolderName='" + accountHolderName +
               "', balance=" + balance +
               ", loan=" + loan + "}";
    }
}
