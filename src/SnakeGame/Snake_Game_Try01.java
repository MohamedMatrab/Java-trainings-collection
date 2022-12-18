package SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Snake_Game_Try01 extends JFrame implements KeyListener,ActionListener {

    final int WORM_SIZE =20;
    final int FRAME_WIDTH =500, FRAME_HEIGHT =500;
    final int INITIAL_NUM_OF_PARTS=4;
    JLabel containerOfGame,score,gameOverLabel;
    ArrayList<JPanel> WORM_PARTS;
    Timer timer;
    int xVelocity=0,yVelocity=WORM_SIZE;
    Random random;
    Snake_Game_Try01(){

        containerOfGame=new JLabel();
        containerOfGame.setBounds(0,0, FRAME_WIDTH,FRAME_HEIGHT);
        containerOfGame.setBackground(new Color(0x202320));
        containerOfGame.setOpaque(true);

        gameOverLabel =new JLabel("Game Over !");
        gameOverLabel.setBounds(100,100,400,400);
        gameOverLabel.setFont(new Font("Ink Free",Font.PLAIN,40));
        gameOverLabel.setForeground(Color.red);
        gameOverLabel.setVisible(false);


        score=new JLabel("              Score : 0 ");
        score.setFont(new Font("Ink Free",Font.PLAIN,40));
        score.setForeground(Color.green);
        score.setBounds(0,0,FRAME_WIDTH,50);
        this.add(score);

        WORM_PARTS=new ArrayList<>();
        for(int i=0;i<INITIAL_NUM_OF_PARTS;i++){
            WORM_PARTS.add(i,new JPanel());
            WORM_PARTS.get(i).setBounds(0,score.getHeight()+20+(INITIAL_NUM_OF_PARTS-i-1)*WORM_SIZE, WORM_SIZE, WORM_SIZE);
            WORM_PARTS.get(i).setBackground(new Color(0x2DB93E));
            containerOfGame.add(WORM_PARTS.get(i));
        }
        WORM_PARTS.get(0).setBackground(new Color(0x38E54D));

        timer=new Timer(300,this);
        timer.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setBackground(new Color(0x202320));
        this.addKeyListener(this);
        this.add(containerOfGame);
        this.add(gameOverLabel);

        timer.start();
    }

    public void GameOver(){
        timer.stop();
        containerOfGame.setVisible(false);
        gameOverLabel.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()==37 && yVelocity!=0) {
//---->Left
            xVelocity=-1*WORM_SIZE;
            yVelocity=0;
        }
        else if(e.getKeyCode()==38 && xVelocity!=0){
//---->Up
            yVelocity=-1*WORM_SIZE;
            xVelocity=0;
        }
        else if (e.getKeyCode()==39 && yVelocity!=0) {
//---->Right
            xVelocity=WORM_SIZE;
            yVelocity=0;
        }
        else if (e.getKeyCode()==40 && xVelocity!=0) {
//---->Down
            yVelocity=WORM_SIZE;
            xVelocity=0;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==timer){
            JPanel temp=new JPanel();
            int X,Y;
            for(int i=0;i<WORM_PARTS.size();i++){

                if(i==0){
                    temp.setLocation(WORM_PARTS.get(i).getX(),WORM_PARTS.get(i).getY());
                    WORM_PARTS.get(i).setLocation( WORM_PARTS.get(i).getX()+xVelocity,WORM_PARTS.get(i).getY()+yVelocity);
                }
                else {
                    X=temp.getX();
                    Y=temp.getY();
                    temp.setLocation(WORM_PARTS.get(i).getX(),WORM_PARTS.get(i).getY());
                    WORM_PARTS.get(i).setLocation(X,Y);
                }
            }
            if(WORM_PARTS.get(0).getX()>=FRAME_WIDTH-WORM_SIZE || WORM_PARTS.get(0).getX()<0 || WORM_PARTS.get(0).getY()>=FRAME_HEIGHT-WORM_SIZE || WORM_PARTS.get(0).getY()<0){
                GameOver();
            }
        }
    }
}