package SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MyPanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
    static final int DELAY = 100;
    final int[] x=new int[GAME_UNITS];
    final int[] y=new int[GAME_UNITS];
    int bodyParts;
    int applesEaten;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;
    JButton replayButton,pauseButton;
    boolean isPaused =false;
    MyPanel(){

        pauseButton=new JButton("Pause");
        pauseButton.setSize(30,30);
        pauseButton.setLocation(SCREEN_WIDTH-pauseButton.getWidth()-10,10);
        pauseButton.setVisible(false);
        pauseButton.addActionListener(this);
        this.add(pauseButton);

        replayButton=new JButton("Replay");
        replayButton.setSize(100,30);
        replayButton.setLocation(SCREEN_WIDTH-replayButton.getWidth()-10,10);
        replayButton.setVisible(false);
        replayButton.addActionListener(this);
        this.add(replayButton);

        random=new Random();

        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setLayout(null);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();

    }

    public void startGame(){
        bodyParts=6;
        newApple();
        pauseButton.setVisible(true);
        running=true;
        direction='R';
        timer=new Timer(DELAY,this);
        timer.start();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        if(running){
            //----> Guide Lines
            for(int i=0;i<SCREEN_WIDTH/UNIT_SIZE;i++){
                g.drawLine(i*UNIT_SIZE,0,i*UNIT_SIZE,SCREEN_HEIGHT);
            }
            for(int i=0;i<SCREEN_HEIGHT/UNIT_SIZE;i++){
                g.drawLine(0,i*UNIT_SIZE,SCREEN_WIDTH,i*UNIT_SIZE);
            }
            g.setColor(Color.red);
            g.fillOval(appleX,appleY,UNIT_SIZE,UNIT_SIZE);
            for (int i=0;i<bodyParts;i++){
                if(i==0){
                    g.setColor(Color.green);
                }
                else {
                    g.setColor(new Color(45,100,0));
                }
                g.fillRect(x[i],y[i],UNIT_SIZE,UNIT_SIZE);
            }

            g.setColor(Color.yellow);
            g.setFont(new Font("Ink Free",Font.BOLD,50));
            FontMetrics metrics=getFontMetrics(g.getFont());
            g.drawString("Score : "+applesEaten,(SCREEN_WIDTH-metrics.stringWidth("Score : "+applesEaten))/2,50);

        }
        else {
            gameOver(g);
        }
    }
    public void newApple(){
        appleX=random.nextInt(SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        appleY=random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;
    }
    public void move(){
        for(int i=bodyParts;i>0;i--){
            x[i]=x[i-1];
            y[i]=y[i-1];
        }

        switch (direction){
            case 'U':
                y[0]-=UNIT_SIZE;
                break;
            case 'D':
                y[0]+=UNIT_SIZE;
                break;
            case 'R':
                x[0]+=UNIT_SIZE;
                break;
            case 'L':
                x[0]-=UNIT_SIZE;
                break;
        }
    }
    public void checkApple(){
        if(x[0]==appleX && y[0]==appleY){
            applesEaten++;
            bodyParts++;
            newApple();
        }
    }
    public void checkCollisions(){
        //check if heads itself
        for (int i=1;i<bodyParts;i++){
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
                break;
            }
        }

        //check if head corned
        if(x[0]<0 || x[0]>SCREEN_WIDTH){
            running=false;
        }
        if(y[0]<0 || y[0]>SCREEN_HEIGHT){
            running=false;
        }

        //stop timer
        if(!running){
            timer.stop();
        }

    }
    public void gameOver(Graphics g){
        System.out.println("Help Me");
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free",Font.BOLD,75));
        FontMetrics metrics=getFontMetrics(g.getFont());
        g.drawString("Game Over",(SCREEN_WIDTH-metrics.stringWidth("Game Over"))/2,SCREEN_HEIGHT/2);

        replayButton.setVisible(true);
        pauseButton.setVisible(false);
    }
    public class MyKeyAdapter extends KeyAdapter{

        @Override
        public void keyReleased(KeyEvent e){
            switch (e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    direction='L';
                    break;
                case KeyEvent.VK_UP:
                    direction='U';
                    break;
                case KeyEvent.VK_RIGHT:
                    direction='R';
                    break;
                case KeyEvent.VK_DOWN:
                    direction='D';

            }
            if(e.getKeyCode()==KeyEvent.VK_SPACE){

                if(!isPaused){
                    timer.stop();
                    isPaused=true;
                }
                else {
                    timer.start();
                    isPaused=false;
                }

            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==timer){
            if (running){
                move();
                checkApple();
                checkCollisions();
            }
            repaint();
        }
        if(e.getSource()==replayButton){
            startGame();
        }
        if(e.getSource()==pauseButton){
            if(!isPaused){
                timer.stop();
                isPaused=true;
            }
            else {
                timer.start();
                isPaused=false;
            }
        }

    }
}
