package Saving_Character_Data;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Protagonists extends GameCharacters{

    private String[] quirks=new String[1000];
    private int presentIndex=0;
    public Protagonists(String characterName, int characterAge, String[] quirk, int level, String MaxLifeAtRevival){
        super(GameCharacters.getPredefinedGameName(),level,MaxLifeAtRevival,characterName,characterAge);
        for(int i=0;i<quirk.length;i++){
            quirks[i]=quirk[i];
            presentIndex=i;
        }
        presentIndex++;
    }


    public String toString(){
        return "GameName: "+ getDefinedGameName()+"\n" +
                "Level: "+getLevel()+"\n"+
                "CharacterName: "+getCharacterName()+"\n"+
                "MaxLifeAtRevival: "+getMaxLifeAtRevival()+"\n" +
                "CharacterAge: "+getCharacterAge()+"\n"+
                "Quirks: "+ Stream.of(quirks).filter(Objects::nonNull).map(Objects::toString).collect(Collectors.joining(",","[","]"));
    }
    public boolean addQuirkToCharacter(String quirk){
        quirks[presentIndex]=quirk;
        presentIndex++;
        return true;
    }
    public String[] getQuirks(){
        return quirks;
    }

    public boolean equals(Object obj){
        if(this==obj)return true;
        if(obj instanceof Monsters){
            Protagonists mont=(Protagonists)obj;
            return mont.getCharacterName().equals(getCharacterName());
        }
        return super.equals(obj);
    }



}
