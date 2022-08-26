package Saving_Character_Data;
import java.util.*;
public interface ISaveable {
    boolean AddToStorage(GameCharacters character);
    void RetrieveCharactersFromStorage();
}
