package Serialise_reverse;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user;

        FileInputStream fileIn=new FileInputStream("C:\\Users\\Mohamed\\Desktop\\Java Entrem\\untitled\\File.ser");
        ObjectInputStream in=new ObjectInputStream(fileIn);
        user = (User) in.readObject();
        in.close();
        fileIn.close();

        System.out.println(user.name);
        System.out.println(user.password);
        user.passOrNot();

    }
}