package BankingApp;

import java.util.*;

public class Branch {
    private String BranchName;
    private final ArrayList<Customer> CustomerArray;
    public Branch(String name){
        this.BranchName=name;
        this.CustomerArray=new ArrayList<>();
    }
    public boolean AddCustomer(String name,double initialTransaction){
        Customer customer=new Customer(name,initialTransaction);
        for(Customer c:CustomerArray){
            if(c.equals(customer)){
                System.out.println("Customer exists!");
                return false;
            }
        }       
        boolean result=CustomerArray.add(customer);
        System.out.println("Customer Added!");
        return true;
    }
    public void showTransactions(String EnterName){

        if(CustomerArray.contains(EnterName)){
            for(Customer c:CustomerArray){
                if(c.ShowCustomerName().equals(EnterName)){
                    c.ShowTransactions();
                }
            }
        }else{
            System.out.println("Customer Not Found!");
        }

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
       
}
