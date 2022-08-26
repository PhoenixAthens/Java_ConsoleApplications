package Saving_Character_Data;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static Scanner sc=new Scanner(System.in);
    private static GameCharacters gc=new GameCharacters();
    public static void PrintOptions(){
        StringBuffer buff=new StringBuffer("++++Functions++++\n");
        buff.append("1->Spawn a new Character\n");
        buff.append("2->Mould a new MONSTER\n");
        buff.append("3->Retrieve All GameCharacters\n");
        buff.append("4->Search for a particular character/monster in the database\n");
        buff.append("5->Add quirks to a player\n");
        buff.append("6->Add weapons to a monster's armory\n");
        buff.append("7->Quit!\n");
        buff.append("8->Print options\n");
        System.out.println(buff);

    }
    private static boolean isThisAProtagonist(GameCharacters gd){
        if(gd.getClass().getSimpleName().equals("Protagonists")){
            return true;
        }else{
            return false;
        }
    }
    private static boolean spawnANewCharacter(GameCharacters character){
        Protagonists proto= (Protagonists) character;
        System.out.println("Saving to "+proto.getDefinedGameName()+"'s database");
        System.out.println("Saving: "+proto.getCharacterName()+"............\n" +
                "with health "+proto.getMaxLifeAtRevival()+"............\n"+
                "age "+proto.getCharacterAge()+"...........\n"+
                "quirks: "+ Stream.of(proto.getQuirks()).filter(Objects::nonNull).map(Objects::toString).collect(Collectors.joining(",","[","]"))+".............\n"+
                "at level: "+proto.getLevel()+"............\n"+
                " to the database");
        return gc.AddToStorage(proto);

    }
    private static boolean MouldANewMonster(GameCharacters character){
        Monsters monster=(Monsters) character;
        System.out.println("Saving to "+monster.getDefinedGameName()+"'s database");
        System.out.println("Saving: "+monster.getCharacterName()+"............\n" +
                "with health "+monster.getMaxLifeAtRevival()+"............\n"+
                "age "+monster.getCharacterAge()+"...........\n"+
                "Weapons: "+monster.getWeapons()+".............\n"+
                "at level: "+monster.getLevel()+"............\n"+
                "Total Kills: "+monster.getTotalKills()+".............\n"+
                "Threat Level "+monster.getAngerStrength()+".............\n"+
                " to the database");
        return gc.AddToStorage(monster);
    }
    //create a method to use typecasting when accessing a method in monster class for object of type interface
    private static void retrieveAllCharacter(){
        //gc.RetrieveCharactersFromStorage();
        if(gc.getListOfCharacters().isEmpty()){
            System.out.println("The Database consist of \'0\' characters!");
        }else{
            System.out.println("The game consist of following characters: ");
            for(GameCharacters gf:gc.getListOfCharacters()){
                if(gf.getClass().getSimpleName().equals("Protagonists")) {
                    System.out.println((Protagonists)gf+"\n");

                }else {
                    System.out.println((Monsters) gf+"\n");
                }
            }
        }
    }
    private static GameCharacters Search(String nameOfCharacter_Monster){
        if(gc.getListOfCharacters().isEmpty()){
            System.out.println("The Database is empty, no characters found!");
            return null;
        }else{
            for(GameCharacters cg:gc.getListOfCharacters()){
                if(cg.getCharacterName().equals(nameOfCharacter_Monster)){
                    //System.out.println("Character "+nameOfCharacter_Monster+" exists!");
                    return cg;
                }

            }

        }
        System.out.println("Character "+nameOfCharacter_Monster+" not found!");
        return null;
    }
    private static void AddQuirksToPlayer(String newQuirk,String characterName){
        if(Search(characterName)!=null){
            GameCharacters character=Search(characterName);
            if(((Protagonists)character).addQuirkToCharacter(newQuirk)){
                System.out.println("Quirk added!");
            }else{
                System.out.println("Error detected!");
            }
        }
    }
    private static void AddWeapons(String weapon,String MonsterName){
        if(Search(MonsterName)!=null){
            GameCharacters character=Search(MonsterName);
            if(((Monsters)character).addWeapons(weapon)){
                System.out.println("Quirk added!");
            }else{
                System.out.println("Error detected!");
            }
        }
    }
    /*
    * There should be an error detection conditional, wherever an int is scanned using a scanner from the input stream
    **/
    public static void main(String...args){
        boolean flag=true;
        //Scanner sc=new Scanner(System.in);
        PrintOptions();
        while(flag){
            System.out.println("Enter you choice based on provided options: ");
            if(sc.hasNextInt()){
                int num=sc.nextInt();
                sc.nextLine();
                switch(num){
                    case 1->{
                        try{
                            System.out.print("Enter character name: ");
                            String name=sc.nextLine();
                            System.out.print("Enter character age: ");
                            int age=sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter the number of quirks you want to add:  ");
                            int qn=sc.nextInt();
                            sc.nextLine();
                            String[] quirks=new String[qn];
                            System.out.println("Add "+qn+" quirks: ");
                            int i=0;
                            while(i<quirks.length){
                                String j= sc.nextLine();
                                quirks[i]=j;
                                System.out.print(" ");
                                i++;
                            }
                            System.out.print("Enter character level: ");
                            int level=sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter charHealth spawn: ");
                            String health=sc.nextLine();
                            if(spawnANewCharacter(new Protagonists(name,age,quirks,level,health))){
                                System.out.println("Character added! \n");
                            }else{
                                System.out.println("Error adding character! \n");
                            }
                        }catch(InputMismatchException ex){
                            sc.nextLine();
                            System.out.println("\nError: "+ex.getClass().getSimpleName()+"\n");
                        }catch(Exception ex){
                            sc.nextLine();
                            System.out.println("\nError: "+ex.getClass().getSimpleName()+"\n");
                        }
                    }
                    case 2->{
                        try{
                            System.out.print("Enter Monster name: ");
                            String name=sc.nextLine();
                            System.out.print("Enter Monster age: ");
                            int age=sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter monster's threat level:  ");
                            String threatLevel=sc.nextLine();
                            System.out.print("Enter total kills:");
                            int totalKills=sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter character level: ");
                            int level=sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter charHealth spawn: ");
                            String health=sc.nextLine();
                            if(MouldANewMonster(new Monsters(name,age,level,health,threatLevel,totalKills))){
                                System.out.println("Monster added! \n");
                            }else{
                                System.out.println("Error adding Monster! \n");
                            }

                        }catch(InputMismatchException ex){
                            sc.nextLine();
                            System.out.println("\nError: "+ex.getClass().getSimpleName()+"\n");
                        }catch(Exception ex){
                            sc.nextLine();
                            System.out.println("\nError: "+ex.getClass().getSimpleName()+"\n");
                        }
                    }case 3->retrieveAllCharacter();
                    case 4->{
                        //This check should have been in Search method, that would have prevented repetition in code!
                        /*if(gc.getListOfCharacters().isEmpty()){
                            System.out.println("The database is empty!");
                        }else {*/
                            System.out.print("Enter name of character/Monster: ");
                            String name=sc.nextLine();
                            GameCharacters character=Search(name);
                            if(character!=null){
                                if(isThisAProtagonist(character)){
                                    System.out.println((Protagonists)character);
                                }else{
                                    System.out.println((Monsters)character);
                                }
                            }else{
                                System.out.println(name+" not found!");
                            }
                        //}
                    }case 5->{
                        /*if(gc.getListOfCharacters().isEmpty()){
                            System.out.println("The Database is empty");
                        }else{*/
                            System.out.print("Enter Name of Character: ");
                            String name=sc.nextLine();
                            System.out.print("Enter quirk: ");
                            String quirk=sc.nextLine();
                            AddQuirksToPlayer(quirk,name);
                        //}
                    }case 6->{
                        /*if(gc.getListOfCharacters().isEmpty()){
                            System.out.println("The Database is empty");
                        }else{
                        */  System.out.print("Enter Name of Monster: ");
                            String name=sc.nextLine();
                            System.out.print("Enter Weapon: ");
                            String quirk=sc.nextLine();
                            AddWeapons(quirk,name);
                        //}

                    }case 7-> flag=false;
                    case 8-> PrintOptions();
                    default-> System.out.println("Invalid entry!");

                }
            }else{
                System.out.println("Invalid entry!");
                sc.nextLine();
            }
        }
    }

}
