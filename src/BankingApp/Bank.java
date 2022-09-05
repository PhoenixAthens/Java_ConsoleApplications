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
    public Bank(){
        this.Branches=new ArrayList<>();
    }
    //missing functionality : findBranches method to check if the branch we are creating already exists
    public boolean addNewBranch(String name){
        if(SearchForBranch(name)==null){
            boolean result=Branches.add(new Branch(name));
            Branches.sort(null);
        //System.out.println("Branch Created Successfully");
            return result;
            //System.out.println("Branch name already in use!");
        }else{
            return false;
        }

    }
    public ArrayList<Branch> getBranches(){
        return Branches;
    }
    public void PrintBranches(){
        for(Branch i:Branches){
            System.out.println(Branches.indexOf(i)+1+": "+i.getBranchName());
        }
    }
    public String getBankName(){
        return BankName;
    }
    public boolean addCustomerTo(String branchName,String nameOfCustomer){
        PrintBranches();
        Branch b=SearchForBranch(branchName);
        if(b!=null){
            return b.AddCustomer(nameOfCustomer);
        }else{
            return false;
        }
    }
    public void PrintInformationAboutParticularBranch(String nameOfBranch){
        for(Branch b:Branches){
            if(b.getBranchName().equals(nameOfBranch)){
                System.out.println(b.getBranchName());
                b.PrintCustomers();
            }
        }

    }
    public Branch SearchForBranch(String branchName){
        for(Branch b:Branches){
            if(b.getBranchName().equals(branchName)){
                return b;
            }
        }
        return null;
    }
    public boolean changeBranchName(String oldName,String newName){
        Branch obtained=SearchForBranch(oldName);
        if(obtained!=null){
            obtained.setBranchName(newName);
            return true;
        }
        return false;
    }
    public boolean AddTransactionToParticularCustomer(String BranchName,String CustomerName,long id,double amount){
        Branch branch=SearchForBranch(BranchName);
        if(branch==null){
            return false;
        }
        return branch.addTransactions(CustomerName,id,amount);
    }
    public void showTransactionForParticularCustomer(String BranchName,String CustomerName){
        Branch branch=SearchForBranch(BranchName);
        if(branch!=null){
            branch.showTransactions(CustomerName);
        }
        else{
            System.out.println("Invalid BranchName!");
        }
    }


}
