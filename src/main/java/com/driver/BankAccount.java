package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {

        this.name=name;
        this.balance=balance;
        this.minBalance=minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception

        if(sum>9*digits){
            throw new Exception("Account Number can not be generated");
        }

        int div=sum/9;
        int rem=sum%9;

        String accno="";
        while(div-->0){
            accno=accno+"9";
        }
        if(rem>0){
            accno=accno+rem;
        }
        int size=digits-accno.length();

        while(size-->0){
            accno=accno+"0";
        }

        return accno;



    }

    public void deposit(double amount) {
        //add amount to balance
        balance=balance+amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance

        if(balance-amount>=minBalance){
            balance=balance-amount;
        }
        else {
            throw new Exception("Insufficient Balance");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
}