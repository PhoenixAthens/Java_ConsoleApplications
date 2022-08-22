package GroceryApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class Groceries {
    public static final Scanner sc=new Scanner(System.in);
    private final List<String> items=new ArrayList<>();
    private final List<String> choice = new ArrayList<>(Arrays.asList("Y","y","YES","yes","Yes"));
    public void addItem(String item){
        item=item.toUpperCase();
        items.add(item);
        System.out.println("\t\tItem: "+item+" was added");
    }
    public void removeItemByIndex(int index){
        if((index-1)<items.size()){
            items.remove(index-1);
        }
        else{
            System.out.println("Sorry but there is no item at "+index);
        }
    }
    public void removeDuplicates(String item){
        String itemA=item.toUpperCase();
        //This step removes all the duplicate products.
        items.removeIf(a->a.equals(itemA));
        //This step adds the item again to the list, so that there is a single copy of item in the list
        items.add(itemA);
    }
    public void printListOfGroceries(){

        if(items.size()>0){
            System.out.println("You have "+items.size()+" items in the cart");
            for(String i:items){
                System.out.println("\t\t"+items.indexOf(i)+" : "+i);
            }
        }else{
            System.out.println("YOu have "+items.size()+" items in the cart");
        }


    }
    public void getTotalNumberOfProducts(){
        System.out.println("You have "+items.size()+" items!");
    }
    public void ReplaceOrModify(String Remove,String newItem){

        System.out.println("Do you want to remove all entries or just the first One (y/n)");
        String input=sc.nextLine();
        if(choice.contains(input)){
            items.removeIf(a->a.equals(Remove));
            items.add(newItem);
        }
        else {
            items.remove(Remove);
            items.add(newItem);
        }

    }
    public void SearchList(String item){
        if(items.contains(item)){
            System.out.println("Item: "+item+" is at position: "+(items.indexOf(item)+1));
        }else{
            System.out.println("Sorry it doesn't exist!");
            System.out.println("So you want to add: "+item+" to cart (y/n)");
            String input=sc.nextLine();
            if(choice.contains(input)){
                items.add(item);
            }else
                System.out.println("Alright!");

        }
    }

}
