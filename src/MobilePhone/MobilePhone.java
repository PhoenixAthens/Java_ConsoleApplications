package MobilePhone;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;
public class MobilePhone {
    public static Scanner scan=new Scanner(System.in);
    private final ArrayList<Contacts> contacts=new ArrayList<>();
    //you can also declare arraylist as follows
    // public MobilePhone(){
    //     this.contacts=new ArrayList<>();
    //so every time an object of contacts is created, we get array list created;


    public void AddContacts(String name,long PhNum){
        try{
            contacts.add(Contacts.createObject(name,PhNum));
            System.out.println("Contact Saved!");
        }catch(Exception ex){
            System.out.println("ERROR!");
        }


    }
    public void PrintDuplicates(String name){
        ArrayList<Integer>duplicate=FindContact(name);
        for(Integer c:duplicate){
            System.out.println("[Name: "+contacts.get(c).getName()+", PhNum: "+contacts.get(c).getPhoneNumber()+"]");
        }

    }
    public void removeContact(String Name){
        ArrayList<Integer> same=FindContact(Name);
        System.out.println("You have "+same.size()+" contacts with the same name!");
        System.out.println("They are as follows: ");
        PrintDuplicates(Name);
        System.out.println("Enter Y: To remove all Duplicates, To Remove particular enter (1-"+same.size()+")");
        String reply=scan.nextLine();
        if(reply.equals("Y")||reply.equals("y")||reply.equals("yes")||reply.equals("Yes")){
            contacts.removeIf(a->a.getName().equals(Name));
            System.out.println("Removal Successful\n");
            PrintAllContacts();
        }else{
            int value=Integer.parseInt(reply)-1;
            int val=same.get(value);
            contacts.remove(val);
            System.out.println("Removal Successful\n");
            PrintAllContacts();


        }
    }
    public void ModifyContact(){
        System.out.println("\t\tEnter 1: to Modify contact via number.");
        System.out.println("\t\tEnter 2: to Modify contact via name.");
        int num=scan.nextInt();
        scan.nextLine();
            switch(num){
                case 1->{
                    System.out.println("Enter the Phone number");
                    long numeric=scan.nextLong();
                    scan.nextLine();
                    FindViaNumber(numeric);

                }
                case 2->{
                    System.out.print("Enter the name: ");
                    String name=scan.nextLine();
                    ArrayList<Integer> list=FindContact(name);
                    System.out.println("You have "+list.size()+" contacts with the same name!");
                    PrintDuplicates(name);
                    System.out.println("Do you want to change All the contacts(Y/N)/(1-"+list.size()+") to remove particulars!");
                    String reply=scan.nextLine();
                    if(reply.equals("Y")||reply.equals("y")){
                        System.out.println("Enter the new contact number");
                        long number=scan.nextLong();
                        for(Integer c:list){
                            contacts.get(c).setPhoneNumber(number);
                        }
                        System.out.println("Modification Successful!");
                        scan.nextLine();
                    }else{
                        System.out.println("Enter the new contact number");
                        long number=scan.nextLong();
                        int value=Integer.parseInt(reply)-1;
                        int val=list.get(value);
                        contacts.get(val).setPhoneNumber(number);
                        System.out.println("Modification Successful!");
                        scan.nextLine();
                    }
                }
            }

        //add functionality to change name//and also to change number not just add it there
    }
    public void PrintAllContacts(){

        if(contacts.size()>0){
            for (Contacts c : contacts) {
                System.out.println("Name: " + c.getName() + ", PhNum: " + c.getPhoneNumber());

            }
            System.out.println("YOU HAVE TOTAL OF " + contacts.size() + " CONTACTS");
        }else{
            System.out.println("NO CONTACTS FOUND!");
        }

    }
    public void FindViaNumber(long Number){
        for(Contacts x:contacts){
            if(x.getPhoneNumber()==Number){
                String name=x.getName();
                PrintDuplicates(name);
                System.out.println("Enter the new name");
                String NewName=scan.nextLine();
                x.setName(NewName);
            }

        }
    }
    public ArrayList FindContact(String name){
        ArrayList<Integer> duplicateIndex=new ArrayList<>();
        for(Contacts C:contacts){
            if(C.getName().equals(name)){
                duplicateIndex.add(contacts.indexOf(C));
            }
        }
        return duplicateIndex;

    }

}
