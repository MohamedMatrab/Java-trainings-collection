package Com.Audios;

import javax.sound.sampled.*;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        File file=new File("C:\\Users\\Mohamed\\Desktop\\Java Entrem\\untitled\\src\\Whip 06.wav");
        if (file.exists()){
            try {
                System.out.println("This File Exists !! ");
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);

                String response = "";
                Scanner scanner = new Scanner(System.in);

                while (!response.equals("Q")) {
                    System.out.println("P:Play | S:Stop | R:Reset | Q:Quit ");
                    response = scanner.next();
                    response = response.toUpperCase();
                    switch (response) {
                        case ("P"):
                            clip.start();
                            break;
                        case ("S"):
                            clip.stop();
                            break;
                        case ("R"):
                            clip.setMicrosecondPosition(0);
                            break;
                        case ("Q"):
                            clip.close();
                            break;
                        default:
                            System.out.println("Enter A Valid Choice !");
                    }

                }
                System.out.println("Quit Success !");
            }
            catch (Exception e){
                System.out.println("There is a problem in The Sound !");
            }

        }else {
            System.out.println("This File Doesn't Exist !! ");
        }

    }
}