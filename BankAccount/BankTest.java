public class BankTest {
    public static void main(String[] args){
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();
        BankAccount account3 = new BankAccount();


        // Deposit Test
        // - deposit some money into each bank account's checking or savings account and display the balance each time
        // - each deposit should increase the amount of totalMoney
        account1.deposit(100, "checkingBalance");
        account2.deposit(200, "checkingBalance");
        account2.deposit(200, "savingsBalance");
        account3.deposit(300, "checkingBalance");
        System.out.println("Total money:" + BankAccount.getTotalMoney());


        // Withdrawal Test
        // - withdraw some money from each bank account's checking or savings account and display the remaining balance
        // - each withdrawal should decrease the amount of totalMoney
        account1.widthdraw(100, "checkingBalance");
        account2.widthdraw(200, "checkingBalance");
        account2.widthdraw(200, "savingsBalance");
        account3.widthdraw(300, "checkingBalance");
        System.out.println("Total money:" + BankAccount.getTotalMoney());

        // Static Test (print the number of bank accounts and the totalMoney)
        System.out.println("Total accounts number: " + "" + BankAccount.getAccounts());
        System.out.println(account3.getAccountNumber());
        

    }
}
