package BankingApp;
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
    }
    private static void PrintListOfCustomers(){
        System.out.print("Enter name of Branch: ");
        String name=scan.nextLine();
        bank.PrintInformationAboutParticularBranch(name);
    }

    private static void TransactionsOfCustomer(){
        ShowListOfBranches();
        System.out.print("Enter the name of Branch: ");
        String nameOfBranch=scan.nextLine();
        System.out.print("Enter the customer's name: ");
        String name=scan.nextLine();
        bank.showTransactionForParticularCustomer(nameOfBranch,name);
    }
    private static void AddBranch(){
        System.out.print("Enter Branch name: ");
        String name=scan.nextLine();
        if(bank.addNewBranch(name)){
            System.out.println("New Branch Created!");
        }else{
            System.out.println("Branch name already in use!!");
        }
    }
    private static void addCustomer(){
        ShowListOfBranches();
        System.out.print("Enter Branch Name: ");
        String branchName=scan.nextLine();
        if(bank.SearchForBranch(branchName)==null){
            System.out.println("Invalid branch name!");
            return;
        }
        System.out.print("Enter Customer name: ");
        String name=scan.nextLine();
        if(bank.addCustomerTo(branchName,name)){
            System.out.println("Customer: "+name+", has been added to branch: "+branchName);
        }else{
            System.out.println("Customer not added!");
        }
    }
    private static void AddTransaction() {
        System.out.print("Enter BranchName: ");
        String nameOfBranch=scan.nextLine();
        Branch b=bank.SearchForBranch(nameOfBranch);
        b.PrintCustomers();
        System.out.print("Enter the Customer's name: ");
        String name = scan.nextLine();
        System.out.print("Enter Customer ID: ");
        long id=scan.nextLong();
        System.out.print("Enter the transaction amount: ");
        double amount = scan.nextDouble();
        if(bank.AddTransactionToParticularCustomer(nameOfBranch,name,id,amount)){
            System.out.println("Transaction(Withdrawal) successful1 ");
        }else{
            System.out.println("Transaction unsuccessful!");
        }
    }



}
