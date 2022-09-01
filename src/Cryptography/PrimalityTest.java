package Cryptography;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PrimalityTest {
    private int number1;
    private int number2;
    public PrimalityTest(int num1, int num2){
        this.number1=num1;
        this.number2=num2;
    }
    public int getNumber1(){
        return number1;
    }
    public int getNumber2(){
        return number2;
    }
    public void setNumber1(int number1){
        this.number1=number1;
    }
    public void setNumber2(int number2){
        this.number2=number2;
    }
    public boolean checkForPrimality(){
        if(number1==number2) return false;
        boolean result1=EnterNumberForPrimality(number1);
        boolean result2=EnterNumberForPrimality(number2);
        if(!result1 && !result2){
            System.out.printf("number 1: %d, number 2: %d are both not primes\n",number1,number2);
            return false;
        }else if(!result1){
            System.out.printf("Number 1: %d is not prime\n",number1);
            return false;
        }else if(!result2){
            System.out.printf("Number 2: %d is not prime\n",number2);
            return false;
        }
        return true;

    }
    private boolean EnterNumberForPrimality(int num){
        if(num==1) return false;
        for(int i=2;i<Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String...args){
        PrimalityTest pt=new PrimalityTest(239,1009);
        /*System.out.println(pt.checkForPrimality());
        System.out.println(pt.calculateGCD(25,15));
        System.out.println(pt.calculateGCD(22,26));*/
        System.out.println(pt.randomPrimeGenerator());
    }
    public int calculateEulerFunction(){
        if(checkForPrimality()){
            int euler=(number1-1)*(number2-1);
            return euler;
        }
        return 0;
    }
    public int randomPrimeGenerator(){
        for(int i=0;i<calculateEulerFunction();i++){
            int prime= ThreadLocalRandom.current().nextInt(1,calculateEulerFunction());
            if(EnterNumberForPrimality(prime)){
                //You can also use an accumulator her and get the max value for the random number
                return prime;
            }
        }
        return 0;
    }
    private int calculateGCD(int num1,int num2){
        if(num1==0 || num2==0){
            return 0;
        }
        int a1=num1;
        int a2=num2;
        //boolean flag=true;
        while(true){
            int test=a1/a2;
            if(a1%a2==0){
                return calculateMin(a1,a2);
            }else{
                int remainder=a1%a2;
                a1=a2;
                a2=remainder;

                System.out.println("a1: "+a1+",a2: "+a2);
            }
        }
    }
    public int calculateGCD(){
        int result=calculateGCD(number1,number2);
        if(result==0){
            System.out.println("GCD is undefined");
            return 0;
        }else{
            return result;
        }

    }
    private int calculateMin(int num1,int num2){
        if(num1>num2){
            return num2;
        }
        return num1;
    }
    public void calculateBezout(){
        //we have p1,p2,e,we have to calculate d,n
        
    }


}
