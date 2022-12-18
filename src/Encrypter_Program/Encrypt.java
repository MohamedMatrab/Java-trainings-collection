package Encrypter_Program;

import java.util.*;
import java.io.*;

public class Encrypt {

    private final Scanner scanner;
    private Random random;
    private final ArrayList<Character> list;
    private ArrayList<Character> shuffledList;
    private char character;
    private String line;
    private char[] letters;
    Encrypt(){

        scanner=new Scanner(System.in);
        random=new Random();
        list=new ArrayList<>();
        shuffledList=new ArrayList<>();
        character=' ';

        newKey();
        askQuestion();

    }

    private void askQuestion(){
        while(true){
                System.out.println("***********************************");
                System.out.println("What Do You Want To Do ??");
                System.out.println("(N)ew Key , (G)et Key , (E)ncrypt , (D)ecrypt , (Q)uit");
                char response=Character.toUpperCase(scanner.nextLine().charAt(0));
                switch (response){
                    case 'N':
                        newKey();
                        break;
                    case 'G':
                        getKey();
                        break;
                    case 'E':
                        encrypt();
                        break;
                    case 'D':
                        decrypt();
                        break;
                    case 'Q':
                        quit();
                        break;
                    default:
                        System.out.println("Enter A Valid Choice !");
                }
            }

    }
    private void newKey(){

        character=' ';
        list.clear();
        shuffledList.clear();

        for(int i=32;i<127;i++){
            list.add(character);
            character++;
        }
        shuffledList=new ArrayList<>(list);
        Collections.shuffle(shuffledList);
        System.out.println("A new key has been generated !");
    }
    private void getKey(){
        System.out.println("Key :");
        for(Character x:list)
            System.out.print(x);

        System.out.println();
        for (Character x:shuffledList)
            System.out.print(x);
        System.out.println();
    }
    private void encrypt(){
        System.out.println("Enter A message to be encrypted :");
        String message=scanner.nextLine();

        letters=message.toCharArray();

        for (int i=0;i<letters.length;i++){

            for (int j=0;j<list.size();j++){
                if(letters[i]==list.get(j)){
                    letters[i]=shuffledList.get(j);
                    break;
                }
            }
        }
        System.out.println("Encrypted message : ");
        for (char letter : letters)
            System.out.print(letter);

        System.out.println();
    }
    private void decrypt(){
        System.out.println("Enter A message to be Decrypted :");
        String message=scanner.nextLine();

        letters=message.toCharArray();

        for (int i=0;i<letters.length;i++){

            for (int j=0;j<shuffledList.size();j++){
                if(letters[i]==shuffledList.get(j)){
                    letters[i]=list.get(j);
                    break;
                }
            }
        }
        System.out.println("Decrypted message : ");
        for (char letter : letters)
            System.out.print(letter);

        System.out.println();
    }
    private void quit(){
        System.out.println("You quited !");
        System.exit(0);
    }


    public static void main(String[] args) {

        Encrypt encrypt=new Encrypt();

    }
}
