package Saving_Character_Data;
import java.util.*;
public class GameCharacters implements ISaveable{
    private static String GameName="OneFringe";
    private String gameName;
    private int level;
    private String maxLifeAtRevival;
    private String characterName;

    private int characterAge;
    private ArrayList<GameCharacters> listOfCharacters;
    public GameCharacters(String gameName, int level, String maxLifeAtRevival,String characterName,int characterAge){
        this.gameName=gameName;
        this.level=level;
        this.maxLifeAtRevival=maxLifeAtRevival;
        this.characterName=characterName;
        this.characterAge=characterAge;
        this.listOfCharacters=new ArrayList<>();
    }
    public GameCharacters(){
        this.listOfCharacters=new ArrayList<>();
    }
    public void setGameName(String newGameName){
        this.gameName=newGameName;
    }
    public void setLevel(int newLevel){
        this.level=newLevel;
    }
    public void setMaxLifeAtRevival(String newMaxLife){
        this.maxLifeAtRevival =newMaxLife;
    }
    public String getDefinedGameName(){
        return gameName;
    }
    public static String getPredefinedGameName(){
        return GameName;
    }
    public int getLevel(){
        return level;
    }
    public String getMaxLifeAtRevival(){
        return maxLifeAtRevival;
    }
    public List<GameCharacters> getListOfCharacters(){
        return listOfCharacters;
    }
    public String getCharacterName(){
        return characterName;
    }
    public int getCharacterAge(){
        return characterAge;
    }
    public void setCharacterName(String characterName){
        this.characterName=characterName;
    }
    public void setCharacterAge(int newAge){
        this.characterAge=newAge;
    }
    public boolean AddToStorage(GameCharacters character){
        boolean result=listOfCharacters.add(character);
        if(result){
            return true;
        }
        System.out.println("Error saving character!");
        return false;
    }
    public void RetrieveCharactersFromStorage(){
        System.out.println("The characters are as follows: ");
        for(GameCharacters c:listOfCharacters){
            System.out.println(c+"\n");
        }
    }


}
