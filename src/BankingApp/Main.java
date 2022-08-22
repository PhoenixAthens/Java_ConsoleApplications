package BankingApp;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static final Scanner scan=new Scanner(System.in);
    private static final Bank bank=new Bank("Phoenix Bank!");
    private static void PrintOptions(){
        System.out.println("<------Functions------->");
        System.out.println("Welcome to "+bank.getBankName());
        System.out.println("(1)->Show List of Branches");
        System.out.println("(2)->Show List of Customers in a particular Branch");
        System.out.println("(3)->Show List of transactions for a particular Customer");
        System.out.println("(4)->Add Branch to Bank");
        System.out.println("(5)->Add Customer to Branch");
        System.out.println("(6)->Add Transactions to Customer's Account");
        System.out.println("(7)->Exit()");
        System.out.println("(8)->Show Options");
    }
    public static void main(String...args){
        PrintOptions();
        boolean flag=true;
        while(flag){
            System.out.println("Enter option from (1-8)");
            int entry=scan.nextInt();
            scan.nextLine();
            switch(entry){
                case 1->ShowListOfBranches();
                case 2->PrintListOfCustomers();
                case 3->TransactionsOfCustomer();
                case 4->AddBranch();
                case 5->addCustomer();
                case 6->AddTransaction();
                case 7->flag=false;
                case 8->PrintOptions();
            }

        }
    }


    private static void ShowListOfBranches(){
        bank.PrintBranches();
        System.out.println(bank.getBankName()+" has a total of "+bank.getBranches().size());
        //System.out.println("Branches Successfully printed");
    }
    private static void PrintListOfCustomers(){
        System.out.println("Enter name of Branch: ");
        String name=scan.nextLine();
        for(Branch i:bank.getBranches()) {
            String nameOfBranch=i.getBranchName();
            if (nameOfBranch.equals(name)) {
                i.PrintCustomers();
            } else {
                System.out.println("Invalid name!");
            }
        }
    }
    private static void TransactionsOfCustomer(){
        ShowListOfBranches();
        System.out.println("Enter the name of Branch");
        String nameOfBranch=scan.nextLine();
        System.out.print("Enter the customer's name: ");
        String name=scan.nextLine();
        for(Branch i: bank.getBranches()){
            String nameOf=i.getBranchName();
            if(nameOf.equals(nameOfBranch)){
                for(Customer c:i.getCustomerArray()){
                    String nameOfCustomer=c.ShowCustomerName();
                    if(nameOfCustomer.equals(name)){
                        c.ShowTransactions();
                        return;
                    }
                }

            }
        }
        System.out.println("Customer not found!");
    }
    private static void AddBranch(){
        System.out.print("Enter Branch name: ");
        String name=scan.nextLine();
        bank.addNewBranch(name);
    }
    private static void addCustomer(){
        System.out.print("Enter Customer name: ");
        String name=scan.nextLine();
        bank.addCustomerTo(name,0.0);
    }
    private static void AddTransaction(){
        System.out.print("Enter the Customer's name: ");
        String name=scan.nextLine();
        System.out.print("Enter the transaction amount: ");
        Double amount=scan.nextDouble();
        scan.nextLine();
        for(Branch i:bank.getBranches()){
                for(Customer j:i.getCustomerArray()) {
                    String nameOfCustomer=j.ShowCustomerName();
                    if(name.equals(nameOfCustomer)){
                        System.out.println("Customer already exists! in  Branch: " + i.getBranchName());
                        System.out.println("Adding Transaction to existing Customer's Billings!");
                        j.AddToTransactions(amount);
                        System.out.println("Transaction Complete!");
                    }
                }
        }
    }
    /*
    * Now if you think because methods are static so you can invoke them in Other classes
    * you are right you can do Main.AddBranch and etc because they won't be worth calling
    * however there is Main.main that is invoking the main method of class that will work but we don't need it so we can
    * go and declare all method of our Main class as private.
    * You can also declare main method as private as well but then it won't work so declare it as public only;
    * */


}
