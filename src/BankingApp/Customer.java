package BankingApp;
import java.util.ArrayList;
public class Customer implements Comparable<Customer>{
    private static long CustomerCount=1;
    private String nameOfCustomer;
    private final long CustomerID;
    private final double InitialTransaction;
    private final ArrayList<Double> Transactions;
    public Customer(String name,double InitialTransaction){
        this.nameOfCustomer=name;
        this.Transactions=new ArrayList<>();
        this.InitialTransaction=InitialTransaction;
        Transactions.add(InitialTransaction);
        CustomerID=CustomerCount;
        CustomerCount++;
        //we instantiated the array list here
        //to make sure each customer object is instantiated with an arraylist for transactions
    }
    public void ShowTransactions(){
        for(int i=0;i<Transactions.size();i++){
            System.out.println(i+1+": "+Transactions.get(i));
        }
    }
    public String ShowCustomerName(){
        return nameOfCustomer;
    }
    public boolean AddToTransactions(Double amount){
        return Transactions.add(amount);
    }
    public boolean equals(Object obj){
        if(this==obj)return true;
        if(obj.getClass() != getClass())return false;
        Customer customer=(Customer)obj;
        return (nameOfCustomer.equals(customer.nameOfCustomer)) && (CustomerID==customer.CustomerID);
    }
    public int compareTo(Customer c){
        int result=Long.compare(CustomerID,c.CustomerID);
        if(result==0){
            result=nameOfCustomer.compareTo(c.nameOfCustomer);
        }
        return result;
    }
    public String getNameOfCustomer(){
        return nameOfCustomer;
    }
    public void setNameOfCustomer(String newName){
        this.nameOfCustomer=newName;
    }
    public long getCustomerID(){
        return CustomerID;
    }
    public String toString(){
        return "\nCustomerID:: "+CustomerID+"\nCustomer Name: "+nameOfCustomer+"\n";
    }

}
