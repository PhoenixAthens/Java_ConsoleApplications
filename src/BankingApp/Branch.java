package BankingApp;

import java.util.*;

public class Branch implements Comparable<Branch>{
    private static Scanner scan=new Scanner(System.in);
    private String BranchName;
    private final ArrayList<Customer> CustomerArray;
    public Branch(String name){
        this.BranchName=name;
        this.CustomerArray=new ArrayList<>();
    }
    public boolean AddCustomer(String name){
        Customer customer=new Customer(name,0.00);
        for(Customer c:CustomerArray){
            if(c.equals(customer)){
                System.out.println("Customer already exists!");
                return false;
            }
        }       
        boolean result=CustomerArray.add(customer);
        System.out.println("New Customer Added!");
        AutomaticSort(CustomerArray);
        return true;
    }
    public void showTransactions(String EnterName){
        List<Customer> listObtained=SearchCustomer(EnterName);
        if(listObtained!=null){
            if(listObtained.size()==1){
                System.out.println(listObtained.get(0).getCustomerID()+" :: "+listObtained.get(0).getNameOfCustomer()+"\n");
                listObtained.get(0).ShowTransactions();
            }else{
                for(Customer c:listObtained){
                    System.out.println(c);
                }
                System.out.print("Enter customer ID for Specific details: ");
                if(scan.hasNextLong()){
                    long id=scan.nextLong();
                    scan.nextLine();
                    checkOutAParticularCustomer(listObtained,id);
                }else{
                    System.out.println("Invalid Customer ID");
                    scan.nextLine();
                }

            }
        }else {
            System.out.println("Customer not found!");
        }
    }
    public String getBranchName(){
        return BranchName;
    }
    public void setBranchName(String newBranchName){
        this.BranchName=newBranchName;
    }
    public void PrintCustomers(){
        for(Customer c:CustomerArray){
            System.out.println(c);
        }
    }
    public ArrayList<Customer> getCustomerArray(){
        return CustomerArray;
    }
    public List<Customer> SearchCustomer(String enterCustomerName){
        List<Customer> listOfCustomersWithTheSameName=new ArrayList<>();
        for(Customer c:CustomerArray){
            String customerName=c.ShowCustomerName();
            if(customerName.equals(enterCustomerName)){
                listOfCustomersWithTheSameName.add(c);
            }
               
        }
        return listOfCustomersWithTheSameName;
   }  
   public boolean addTransactions(String name,long ID,double amount){
        List<Customer> returnedList=SearchCustomer(name);
        if(returnedList!=null){
            for(Customer c:returnedList){
                if(c.getCustomerID()==ID){
                    return c.AddToTransactions(amount);
                }
            }
        }

       return false;
   }
   public void AutomaticSort(List<Customer> listOfCustomers){
        listOfCustomers.sort(null);
   }
   public void checkOutAParticularCustomer(List<Customer> listFromSearch,long CustomerID){
        for(Customer c:listFromSearch){
            if(c.getCustomerID()==CustomerID){
                System.out.println("Customer Data: ");
                System.out.println(c);
                c.ShowTransactions();
            }
        }
   }
   public int compareTo(Branch b){
        int result=BranchName.compareTo(b.BranchName);
        return result;
   }


       
}
