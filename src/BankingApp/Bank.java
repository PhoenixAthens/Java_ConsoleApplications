package BankingApp;
import java.util.ArrayList;
import java.util.Scanner;
public class Bank {
    private static Scanner scan=new Scanner(System.in);
    private String BankName="Phoenix Funds Bank";
    private ArrayList<Branch> Branches;
    public Bank(String name){
        this.BankName=name;
        this.Branches=new ArrayList<>();
    }
    //missing functionality : findBranches method to check if the branch we are creating already exists
    public void addNewBranch(String name){
        Branches.add(new Branch(name));
        System.out.println("Branch Created Successfully");
    }
    public ArrayList<Branch> getBranches(){
        return Branches;
    }
    public void PrintBranches(){
        for(Branch i:Branches){
            System.out.println(Branches.indexOf(i)+": "+i.getBranchName());
        }
    }
    public String getBankName(){
        return BankName;
    }
    public void addCustomerTo(String nameOfCustomer,double initialTransaction){
        PrintBranches();
        System.out.println("Enter branch name from above list!");
        String name=scan.nextLine();
        for(Branch i:Branches){
            String NAME=i.getBranchName();
            if(NAME.equals(name)){
                i.AddCustomer(nameOfCustomer,initialTransaction);
            }
        }
    }

}
