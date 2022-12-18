package Java_exception;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        Scanner scanner=new Scanner(System.in);
        int Age;
        System.out.print("Enter Age : ");
        Age=scanner.nextInt();
        try {
            checkAge(Age);
        }
        catch (Exception e){
            System.out.println("A Signing Problem "+e);
        }
    }
    static void checkAge(int Age) throws AgeException {
        if(Age<18)
            throw new AgeException("\nYou must be 18 years old at least !");
        else
            System.out.println("You Are Signed Up !");
    }
}