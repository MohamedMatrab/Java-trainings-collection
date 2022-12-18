package FileChooser;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class Chooser {

    public static void main(String[] args) {

        JButton button;
        button=new JButton("Select File !");
        button.addActionListener(e -> {
            if(e.getSource()==button){
                JFileChooser fileChooser=new JFileChooser();
                int response=fileChooser.showOpenDialog(null);
                if(response==JFileChooser.APPROVE_OPTION){
                    File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                    System.out.println(file);
                }
            }
        });

        JFrame frame=new JFrame();
        frame.setVisible(true);
        frame.setSize(500,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(button);

    }

}