package com.account;

public class Loan {

    private String loanType;
    private double loanAmount;

    public Loan() {
    }

    public Loan(String loanType, double loanAmount) {
        this.loanType = loanType;
        this.loanAmount = loanAmount;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    @Override
    public String toString() {
        return "Loan{loanType='" + loanType + "', loanAmount=" + loanAmount + "}";
    }
}
