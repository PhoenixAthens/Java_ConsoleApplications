package MobilePhone;

import SongsApp.Playlist;

public class Contacts implements Comparable<Contacts> {
    private String FirstName;
    private String lastName;
    private long PhoneNumber;
    public Contacts(String firstName,String lastName,long PhNum){
        this.FirstName =firstName;
        this.lastName=lastName;
        this.PhoneNumber=PhNum;
    }
    public String getFirstName(){
        return FirstName;
    }
    public String getLastName(){
        return lastName;
    }
    public long getPhoneNumber(){
        return PhoneNumber;
    }
    public void setPhoneNumber(long number){
        this.PhoneNumber=number;
    }
    public void setFirstName(String firstName){
        this.FirstName = firstName;
    }
    public void setLastName(String newLastName){
        this.lastName=newLastName;
    }
    public static Contacts createObject(String name,String lastName,long PhNum){
        return new Contacts(name,lastName,PhNum);
    }
    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj instanceof Contacts){
            Contacts contact=(Contacts)obj;
            return PhoneNumber==contact.PhoneNumber;
        }else{
            return super.equals(obj);
        }
    }
    public int compareTo(Contacts contact){
        int result=lastName.compareTo(contact.lastName);
        if(result==0)
            result=FirstName.compareTo(contact.FirstName);
        if(result==0)
            result=Long.compare(PhoneNumber,contact.PhoneNumber);
        return result;
    }
    public String toString(){
        return String.format("%s %s : %d %n",lastName,FirstName,PhoneNumber);
    }

}
