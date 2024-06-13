
public class BankAccount {
    // MEMBER VARIABLES
    private double checkingBalance;
    private double savingsBalance;
    private static int accounts;
    private static double totalMoney; // refers to the sum of all bank account checking and savings balances
    private int accountNumber;
    // CONSTRUCTOR
    // Be sure to increment the number of accounts
    public BankAccount(){
        checkingBalance = 0.0;
        savingsBalance = 0.0;
        accounts ++;
        accountNumber = accounts;
        

    }


        // GETTERS
    // for checking, savings, accounts, and totalMoney
    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public static int getAccounts() {
        return accounts;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public static double getTotalMoney() {
        return totalMoney;
    }
    
    // METHODS
    // deposit
    // - users should be able to deposit money into their checking or savings account
    public void deposit(double amount, String accountType){
        if (accountType.equals("checkingBalance")){
            checkingBalance += amount;
        }
        else {
            savingsBalance += amount; 
        }
        totalMoney += amount;
    }

    // withdraw 
    // - users should be able to withdraw money from their checking or savings account
    // - do not allow them to withdraw money if there are insufficient funds
    // - all deposits and withdrawals should affect totalMoney
    public void widthdraw(double amount, String accountType){
        if (accountType.equals("checkingBalance")){
            if (checkingBalance >= amount){
                checkingBalance-=amount;
                totalMoney-=amount; 
            }
            else{
                System.out.println("You don't have enough money in your accout. ");
            }
        } else if (accountType.equals("savingsBalance")){
            if (savingsBalance >= amount){
                savingsBalance-=amount;
                totalMoney-=amount; 
            }
            else{
                System.out.println("You don't have enough money in your accout. ");
                }

            
        }
    
    }

    // getBalance
    public double getBalance(){
        return checkingBalance + savingsBalance; 
    }

}
