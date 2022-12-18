package Serialise_direct;

import java.io.*;

public class Main {
    static public void main(String[] args) throws IOException {
        User user=new User();
        user.name="Mohamed ";
        user.password="HHHHhegh4444fvjhdbjfv";

        FileOutputStream fileOut =new FileOutputStream("File.ser");
        ObjectOutputStream outputStream=new ObjectOutputStream(fileOut);
        outputStream.writeObject(user);
        outputStream.close();
        fileOut.close();

        System.out.println("Your Project Saved !");
    }
}
