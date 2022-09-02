package BankingApp;

import java.util.*;

public class Branch {
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
            for(Customer c:listObtained){
                System.out.println(listObtained.indexOf(c)+": "+c.getCustomerID()+" :: "+c.getNameOfCustomer());
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

        }else{
            System.out.println("Customer not found!");
        }

        /*if(CustomerArray.contains(EnterName)){
            for(Customer c:CustomerArray){
                if(c.ShowCustomerName().equals(EnterName)){
                    c.ShowTransactions();
                }
            }
        }else{
            System.out.println("Customer Not Found!");
        }*/

    }
    public String getBranchName(){
        return BranchName;
    }
    public void PrintCustomers(){
        for(Customer i:CustomerArray){
            System.out.println(CustomerArray.indexOf(i)+": "+i.ShowCustomerName());
        }
    }
    //Missing functionality: findCustomer and addTransaction
    public ArrayList<Customer> getCustomerArray(){
        return CustomerArray;
    }
    //Missing functionalities are marked as @Deprecated until the implementation is tested in real-time!
    public List<Customer> SearchCustomer(String enterCustomerName){
        List<Customer> listOfCustomersWithTheSameName=new ArrayList<>();
        for(Customer c:CustomerArray){
            String customerName=c.ShowCustomerName();
            if(customerName.equals(enterCustomerName)){
                listOfCustomersWithTheSameName.add(c);
            }
               
        }
        if(listOfCustomersWithTheSameName.isEmpty()){
            System.out.println("Customer with name: "+enterCustomerName+" not found!");
            return null;
        }//when putting this method into implementation remember to receive the return value and there check if you get null or an array
        return listOfCustomersWithTheSameName;
   }  
   public boolean addTransactions(double amount){
   //yet to be implemented!!
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
            }
        }
   }
       
}
