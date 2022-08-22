package GroceryApp;

import java.util.Scanner;

public class MainGrocery {
    private final static Scanner sc=new Scanner(System.in);
    private static final Groceries obj=new Groceries();
    public static void main(String... args){
        PrintListOfChoice();
        boolean Flag=true;
        while(Flag){
            System.out.println("Enter a choice From(0-8) on the Basis of Info Provided");
            if(sc.hasNextInt()){
                int choice=sc.nextInt();
                sc.nextLine();
                switch(choice){
                    case 0-> PrintListOfChoice();
                    case 1->PrintGroceries();
                    case 2->AddItem();
                    case 3->RemoveItem();
                    case 4->RemoveDuplicatesIfAny();
                    case 5->GetTotalItems();
                    case 6->Replace();
                    case 7->SendProbe();
                    case 8-> Flag=false;
                    default->System.out.println("Invalid Entry");
                }
            }else{
                System.out.println("Invalid entry!");
                sc.nextLine();
            }

        }
    }
    private static void PrintListOfChoice(){
        System.out.println("\t\t|Choice|   |  Function  |                 ");
        System.out.println("\t\t  (0)-Print List of Option On System");
        System.out.println("\t\t  (1)-Print List of Groceries.");
        System.out.println("\t\t  (2)-Add an item to the List Of Groceries!");
        System.out.println("\t\t  (3)-Remove Item by Position");
        System.out.println("\t\t  (4)-Check for and Remove Duplicates!");
        System.out.println("\t\t  (5)-Get Total Number Of Products!");
        System.out.println("\t\t  (6)-Replace an item with another Item");
        System.out.println("\t\t  (7)-Search for an item!");
        System.out.println("\t\t  (8)-Exit the Application!");
    }
    private static void AddItem(){
        System.out.println("Enter the item: ");
        obj.addItem(sc.nextLine());
    }
    private static void PrintGroceries(){
        obj.printListOfGroceries();
    }
    private static void RemoveItem(){
        System.out.println("Enter the Position of item you want to remove: ");
        obj.removeItemByIndex(sc.nextInt());
        sc.nextLine();
    }
    private static void RemoveDuplicatesIfAny(){
        System.out.println("Enter the item Name: ");
        obj.removeDuplicates(sc.nextLine());
    }
    private static void GetTotalItems(){
        obj.getTotalNumberOfProducts();
    }
    private static void Replace(){
        System.out.println("Enter the name of item to be replaced: ");
        String ToBeReplaced=sc.nextLine();
        System.out.println("Enter the Replacement item: ");
        String Replacement=sc.nextLine();
        obj.ReplaceOrModify(ToBeReplaced,Replacement);
    }
    private static void SendProbe(){
        System.out.println("Enter item: ");
        obj.SearchList(sc.nextLine());
    }



}
