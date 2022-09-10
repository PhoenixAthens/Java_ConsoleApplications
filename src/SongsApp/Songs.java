package SongsApp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Songs implements Comparable<Songs>{
    private SimpleDateFormat sdf=new SimpleDateFormat("mm:ss");
    private String Title;
    private String Duration;
    public Songs(String title,double duration){
        this.Title=title;
        this.Duration=convertDoubleToDate(duration);
    }
    public Songs(){

    }
    public static Songs composeSong(String title,double duration){
        return new Songs(title,duration);
    }
    public String getTitle(){
        return Title;
    }
    public String getDuration(){
        return Duration;
    }
    public void setTitle(String newTitle){
        this.Title=newTitle;
    }
    public void setDuration(double newDuration){
        this.Duration=convertDoubleToDate(newDuration);
    }
    public String toString(){
        return "[SongName: "+Title+", Duration: "+Duration+"]";
    }
    private String convertDoubleToDate(double Duration){
        /*String temp=;
        System.out.println(temp);
        int indexOfDelimiter=temp.indexOf('.');
        System.out.println(indexOfDelimiter);
        */
        String[] arr=(String.valueOf(Duration)).split("\\.");
        //System.out.println(Arrays.toString(arr));
        int minutes=Integer.parseInt(arr[0]);
        int convert=Integer.parseInt(arr[1]);
        int seconds=0;
        if(convert>=1000){
            seconds=(convert*60)/10000;
        }else if(convert>=100){
            seconds=(convert*60)/1000;
        }else if(convert>=10){
            seconds=(convert*60)/100;
        }else{
            seconds=(convert*60)/10;
        }
        return sdf.format(new Date(000,00,00,00,minutes,seconds));
    }
    public boolean equals(Object obj){
        if(this==obj)return true;
        if(obj instanceof Songs){
            Songs s=(Songs)obj;
            if(s.getTitle().equals(getTitle())&&s.getDuration().equals(getDuration())){
                return true;
            }
        }
        return super.equals(obj);
    }
    public int compareTo(Songs s){
        int result=(s.Title).compareToIgnoreCase(Title);
        if(result==0)result=(s.Duration).compareTo(Duration);
        return result;
    }


}
