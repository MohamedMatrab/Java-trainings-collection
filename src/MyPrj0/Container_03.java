package MyPrj0;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Container_03 extends JLabel {
        final int HEIGHT_LENGTH =40;
        JTextArea textArea;
        JScrollPane scrollPane;
        JLabel labelTop;
        ImageIcon giveIcon=new ImageIcon(Objects.requireNonNull(getClass().getResource("images/give.png")));
        ImageIcon takeIcon=new ImageIcon(Objects.requireNonNull(getClass().getResource("images/take.png")));
        ImageIcon equalIcon=new ImageIcon(Objects.requireNonNull(getClass().getResource("images/equality.png")));
        Timer timer;
        ArrayList<JLabel> finalValues,images,namesLabel;
        String giveOrTake;
        int counter=0;
        Container_03(){

                labelTop=new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/support.png"))));
                labelTop.setBounds(0,0,500,150);

                finalValues=new ArrayList<>();
                images=new ArrayList<>();
                namesLabel=new ArrayList<>();

                timer=new Timer(100,null);

                textArea=new JTextArea();
                textArea.setWrapStyleWord(true);
                textArea.setLineWrap(true);
                textArea.setForeground(Color.BLACK);
                textArea.setFont(new Font("Consolos",Font.PLAIN,15));

                scrollPane=new JScrollPane(textArea);
                scrollPane.setBounds(50,150,400,300);
                scrollPane.setVisible(false);
                scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

                this.setBounds(0,0,500,500);
                this.setVisible(true);
                this.setLayout(null);
                this.add(labelTop);
                this.add(scrollPane);
        }
}