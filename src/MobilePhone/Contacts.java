package MobilePhone;

public class Contacts {
    private String Name;
    private long PhoneNumber;
    public Contacts(String name,long PhNum){
        this.Name=name;
        this.PhoneNumber=PhNum;
    }
    public String getName(){
        return Name;
    }
    public long getPhoneNumber(){
        return PhoneNumber;
    }
    public static Contacts createObject(String name,long PhNum){
        return new Contacts(name,PhNum);
    }
    public void setPhoneNumber(long number){
        this.PhoneNumber=number;
    }
    public void setName(String name){
        this.Name=name;
    }
}
