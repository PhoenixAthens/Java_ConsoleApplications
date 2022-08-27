package BankingApp;
import java.util.ArrayList;
public class Customer {
    private String nameOfCustomer;
    private double InitialTransaction;
    private final ArrayList<Double> Transactions;
    public Customer(String name,double InitialTransaction){
        this.nameOfCustomer=name;
        this.Transactions=new ArrayList<>();
        this.InitialTransaction=InitialTransaction;
        Transactions.add(InitialTransaction);
        //we instantiated the array list here
        //so as to make sure each customer object is instantiated with an arraylist for transactions 
    }
    public void ShowTransactions(){
        for(int i=0;i<Transactions.size();i++){
            System.out.println(i+": "+Transactions.get(i));
        }
    }
    public String ShowCustomerName(){
        return nameOfCustomer;
    }
    public void AddToTransactions(Double amount){
        Transactions.add(amount);
    }
    public boolean equals(Object obj){
        if(this==obj)return true;
        if(obj.getClass()!=getClass() || obj==null)return false;
        Customer cust=(Customer)obj;
        return (nameOfCustomer.equals(cust.nameOfCustomer)) && (InitialTransaction==cust.InitialTransaction) && (Transactions.equals(cust.Transactions);
    }                                                                                                             

}
