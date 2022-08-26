package Saving_Character_Data;
import java.util.*;
public class Monsters extends GameCharacters{
    private List<String> Weapons=new ArrayList<>();
    private String AngerStrength;
    private int totalKills;
    public Monsters(String monsterName,int age,int level,String lifeAtSpawn,String angerStrength,int totalKills){
        super(GameCharacters.getPredefinedGameName(),level,lifeAtSpawn,monsterName,age);
        this.AngerStrength=angerStrength;
        Weapons.add("Blade Of Blood");
        Weapons.add("Hammer of Hell");
        Weapons.add("The lost blade of honour");
        this.totalKills=totalKills;
    }
    public void addToWeaponArmory(String weapon){
        Weapons.add(weapon);
    }
    public String getAngerStrength(){
        return AngerStrength;
    }
    public void setAngerStrength(String changeState){
        this.AngerStrength=changeState;
    }
    public int getTotalKills(){
        return totalKills;
    }
    public void setTotalKills(int HowManyMore){
        this.totalKills+=HowManyMore;
    }
    public String toString(){
        return "Monster Name: "+getCharacterName()+"\n"+
                "Monster Age: "+getCharacterAge()+"\n"+
                "Weapons: "+Weapons+"\n"+
                "TotalKills: "+totalKills+"\n"+
                "Life at spawn: "+getMaxLifeAtRevival();
    }
    public void printWeapons(){
        for(String weapons:Weapons){
            System.out.println("weapons");
        }
    }
    public List<String> getWeapons(){
        return Weapons;
    }
    public boolean equals(Object obj){
        if(this==obj)return true;
        if(obj instanceof Monsters){
            Monsters mont=(Monsters)obj;
            return mont.getCharacterName().equals(getCharacterName());
        }
        return super.equals(obj);
    }
    public boolean addWeapons(String weaponName){
        return Weapons.add(weaponName);
    }

}
