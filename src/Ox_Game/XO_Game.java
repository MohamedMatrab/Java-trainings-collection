package Ox_Game;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class XO_Game extends JFrame{
    ImageIcon icon=new ImageIcon(Objects.requireNonNull(getClass().getResource("game.png")));
    final int WIDTH_OF_BUTTON=150;
    final int HEIGHT_OF_BUTTON=120;
    Random random;
    JLabel topLabel;
    ArrayList<ArrayList<JButton>> allButtons;
    int whoseTurn=1;
    XO_Game(){

        random=new Random();

        topLabel=new JLabel("XO Game !");
        topLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        topLabel.setVerticalTextPosition(SwingConstants.CENTER);
        topLabel.setBounds(0,0,3*WIDTH_OF_BUTTON,100);
        topLabel.setFont(new Font("Ink Free",Font.PLAIN,50));
        topLabel.setBackground(Color.BLACK);
        topLabel.setForeground(Color.GREEN);
        topLabel.setOpaque(true);
        this.add(topLabel);

        allButtons=new ArrayList<>();
        for (int i=0;i<3;i++){
            allButtons.add(i,new ArrayList<>());
            for (int j=0;j<3;j++){
                allButtons.get(i).add(j,new JButton());
                allButtons.get(i).get(j).setBounds(j*WIDTH_OF_BUTTON,100+i*HEIGHT_OF_BUTTON,WIDTH_OF_BUTTON,HEIGHT_OF_BUTTON);
                allButtons.get(i).get(j).setFont(new Font("Ink Free",Font.BOLD,60));
                allButtons.get(i).get(j).setForeground(Color.BLUE);
                allButtons.get(i).get(j).setFocusable(false);
                int finalI = i,finalJ=j;
                allButtons.get(i).get(j).addActionListener(e -> {
                    if(Objects.equals(allButtons.get(finalI).get(finalJ).getText(),"")){
                        if(whoseTurn==1){
                            allButtons.get(finalI).get(finalJ).setText("X");
                            allButtons.get(finalI).get(finalJ).setForeground(Color.BLUE);
                            topLabel.setText("O turn");
                            whoseTurn=0;
                        }
                        else {
                            allButtons.get(finalI).get(finalJ).setText("O");
                            allButtons.get(finalI).get(finalJ).setForeground(Color.RED);
                            topLabel.setText("X turn");
                            whoseTurn=1;
                        }
                        checkWinner();
                    }
                  });
                this.add(allButtons.get(i).get(j));
            }
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(3*WIDTH_OF_BUTTON,topLabel.getHeight()+3*HEIGHT_OF_BUTTON+40);
        this.setIconImage(icon.getImage());
        this.setResizable(false);
        this.setTitle("XO Game !");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        firstTurn();

    }
    public void firstTurn() {

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(random.nextInt(2)==0) {
            whoseTurn=1;
            topLabel.setText("X turn");
        }
        else {
            whoseTurn=0;
            topLabel.setText("O turn");
        }
    }
    public void checkWinner(){
        for (int i=0;i<3;i++){

            //--> Line Win
            if(Objects.equals(allButtons.get(i).get(0).getText(),allButtons.get(i).get(1).getText()) && Objects.equals(allButtons.get(i).get(2).getText(),allButtons.get(i).get(1).getText())){
                if(!Objects.equals(allButtons.get(i).get(0).getText(),"")){
                    System.out.println(allButtons.get(i).get(0).getText()+" Wins !");
                    whoWins('l',i);
                    return;
                }
            }

            //---> Colon Win
            if(Objects.equals(allButtons.get(0).get(i).getText(),allButtons.get(1).get(i).getText()) && Objects.equals(allButtons.get(2).get(i).getText(),allButtons.get(1).get(i).getText())){
                if(!Objects.equals(allButtons.get(0).get(i).getText(),"")){
                    System.out.println(allButtons.get(0).get(i).getText()+" Wins !");
                    whoWins('c',i);
                    return;
                }
            }
        }

        //---> Diagonal Win
        if(Objects.equals(allButtons.get(0).get(0).getText(),allButtons.get(1).get(1).getText()) && Objects.equals(allButtons.get(2).get(2).getText(),allButtons.get(1).get(1).getText())){
            if(!Objects.equals(allButtons.get(0).get(0).getText(),"")){
                System.out.println(allButtons.get(0).get(0).getText()+" Wins !");
                whoWins('d',-1);
                return;
            }
        }

        //---> Diagonal Win
        if(Objects.equals(allButtons.get(0).get(2).getText(),allButtons.get(1).get(1).getText()) && Objects.equals(allButtons.get(2).get(0).getText(),allButtons.get(1).get(1).getText())){
            if(!Objects.equals(allButtons.get(0).get(2).getText(),"")){
                System.out.println(allButtons.get(0).get(2).getText()+" Wins !");
                whoWins('i',-1);
            }
        }
    }
    public void whoWins(char LineOrColon,int number){

        switch (LineOrColon){
            case 'c':
                for (int i=0;i<3;i++){
                    allButtons.get(i).get(number).setBackground(Color.GREEN);
                    for(int j=0;j<3;j++){
                        allButtons.get(i).get(j).setEnabled(false);
                    }
                }
                topLabel.setText(allButtons.get(0).get(number).getText()+" Wins !");
                break;
            case 'l':
                for (int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        allButtons.get(j).get(i).setEnabled(false);
                    }
                    allButtons.get(number).get(i).setBackground(Color.GREEN);
                }
                topLabel.setText(allButtons.get(number).get(0).getText()+" Wins !");
                break;
            case 'd':
                for (int i=0;i<3;i++){
                    allButtons.get(i).get(i).setBackground(Color.GREEN);
                    for(int j=0;j<3;j++){
                        allButtons.get(i).get(j).setEnabled(false);
                    }
                }
                topLabel.setText(allButtons.get(0).get(0).getText()+" Wins !");
                break;
            case 'i':
                for (int i=0;i<3;i++){
                    allButtons.get(i).get(2-i).setBackground(Color.GREEN);
                    for(int j=0;j<3;j++){
                        allButtons.get(i).get(j).setEnabled(false);
                    }
                }
                topLabel.setText(allButtons.get(1).get(1).getText()+" Wins !");
                break;
            default:
                System.out.println();
        }
    }


}