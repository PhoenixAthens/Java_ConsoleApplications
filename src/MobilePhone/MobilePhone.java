package MobilePhone;
import SongsApp.Main;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MobilePhone {
    public static final Scanner scan=new Scanner(System.in);
    private final ArrayList<Contacts> contacts;
    public MobilePhone(){
        System.out.println("\n=================================================");
        System.out.println("Loading the contacts....... ");
        System.out.println("=================================================\n");
        this.contacts=new ArrayList<>();

    }


    public boolean AddContacts(String FirstName,String lastName,long PhNum){
        var result=contacts.add(Contacts.createObject(FirstName,lastName,PhNum));
        return result;



    }
    public int FindContactsWithName(String firstName){
        AtomicInteger count= new AtomicInteger(0);
        contacts.forEach(contacts->{
            if(contacts.getFirstName().equals(firstName)){
                count.getAndIncrement();
                System.out.println(contacts);
            }
        });

        return count.get();
    }
    public int FindContactWithContactNumber(long PhoneNumber){
        AtomicInteger count=new AtomicInteger(0);
        contacts.forEach(contact->{
            if(contact.getPhoneNumber()==PhoneNumber){
                count.getAndIncrement();
                System.out.println(contact);
            }
        });
        return count.get();
    }


    public boolean removeContact(String Name){
        System.out.println("\n==================================================");
        int value=FindContactsWithName(Name);
        System.out.println("==================================================\n");
        if(value>0){
            Contacts contact=inputTaker();
            return contacts.removeIf((cont)->cont.equals(contact));
        }else{
            System.out.println("Contact with Name: "+Name+", doesn't exist!!");
            return false;
        }
    }
    private Contacts inputTaker(){
        System.out.print("Enter the firstName: ");
        String firstName=scan.nextLine();
        System.out.print("Enter the lastName: ");
        String lastname=scan.nextLine();
        System.out.print("Enter the ContactNumber: ");
        long phNum=scan.nextLong();
        scan.nextLine();
        return Contacts.createObject(firstName,lastname,phNum);
    }
    public boolean ModifyContact(){
        System.out.println("\n===========================================");
        System.out.println("Enter 1 to find/Modify contact on the basis of Name ");
        System.out.println("Enter 2 to find/Modify contact on the basis of PhNumber  ");
        System.out.println("===========================================\n");
        if(scan.hasNextInt()){
            int input=scan.nextInt();
            scan.nextLine();
            switch(input){
                case 1->{
                    System.out.print("Enter contact's Name: ");
                    modifyContactOnTheBasisOfName(scan.nextLine());
                    return true;
                }
                case 2->{
                    System.out.println("Enter the contact's PhoneNumber: ");
                    long phNum=scan.nextLong();
                    scan.nextLine();
                    modifyContactsOnTheBasisOfPhoneNumber(phNum);
                    return true;
                }
                default->{
                    System.out.println("Invalid input, Aborting Process...!!");
                    return false;
                }
            }
        }else{
            System.out.println("\n===========================================");
            System.out.println("Aborting Modification!!");
            System.out.println("===========================================\n");
            return false;
        }

    }
    private void modifyContactOnTheBasisOfName(String Name){
        System.out.println("\n===========================================");
        int count=FindContactsWithName(Name);
        MainProcedure(count);

    }
    private void modifyContactsOnTheBasisOfPhoneNumber(long PhoneNumber){
        System.out.println("\n===========================================");
        int count=FindContactWithContactNumber(PhoneNumber);
        MainProcedure(count);
    }
    private void MainProcedure(int count){
        System.out.println("===========================================\n");
        if(count>0){
            Contacts contact=inputTaker();
            contacts.forEach(con->{
                if(con.equals(contact)){
                    PrintOptionsForModification();
                    modification(con);
                }
            });
        }else{
            System.out.println("Contact not found!!");
        }
    }
    private void PrintOptionsForModification(){
        System.out.println("\n=======================================");
        System.out.println("(Option)----->(Function)");
        System.out.println("(1)->Change contact's FirstName");
        System.out.println("(2)->Change contact's LastName");
        System.out.println("(3)->Change contact's PhNum");
        System.out.println("(4)->Abort!");
        System.out.println("======================================\n");
    }
    private boolean modification(Contacts contact){
        if(scan.hasNextInt()){
            int input=scan.nextInt();
            scan.nextLine();
            switch(input){
                case 1->changeFirstName(contact);
                case 2->changeLastName(contact);
                case 3->changePhoneNumber(contact);
                default->System.out.println("Aborting Modification!");
            }
            System.out.println("\n==========================================");
            System.out.println("Contact successfully updated!!");
            System.out.println("==========================================\n");
            return true;
        }else{
            System.out.println("\n===================================");
            System.out.println("Invalid input! Aborting!!");
            System.out.println("===================================\n");
            return false;
        }
    }
    private void changeFirstName(Contacts contact){
        System.out.print("Enter the new FirstName: ");
        contact.setFirstName(scan.nextLine());
    }
    private void changeLastName(Contacts contact){
        System.out.print("Enter the new Lastname: ");
        contact.setLastName(scan.nextLine());
    }
    private void changePhoneNumber(Contacts contact){
        System.out.print("Enter the new Phone Number: ");
        contact.setPhoneNumber(scan.nextLong());
        scan.nextLine();
    }
    public void PrintAllContacts(){
        contacts.forEach(System.out::println);
    }



}
