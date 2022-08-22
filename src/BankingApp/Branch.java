package BankingApp;

import java.util.ArrayList;

public class Branch {
    private String BranchName;
    private final ArrayList<Customer> CustomerArray;
    public Branch(String name){
        this.BranchName=name;
        this.CustomerArray=new ArrayList<>();
    }
    public void AddCustomer(String name,double initialTransaction){//add return type boolean to check if customer
        CustomerArray.add(new Customer(name,initialTransaction));//already exists it s/h1 does don't add the customer;
        System.out.println("Customer Added!");
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
}
