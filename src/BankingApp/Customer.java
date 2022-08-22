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
        //why we instantiated the array list here
        //because as soon as the bankAccount opens the transaction arraylist we also be started
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

}
