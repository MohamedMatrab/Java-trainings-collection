package Animation_2d;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;

public class MyPanel extends JPanel implements ActionListener{

    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;
    Image enemy;
    Image backgroundImage;
    Timer timer;
    int xVelocity = 1;
    int yVelocity = 1;
    int x = 0;
    int y = 0;
    JButton pause;
    MyPanel(){
        pause=new JButton("Pause !");
        pause.addActionListener(this);

        this.add(pause);
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setBackground(Color.YELLOW);
        enemy=new ImageIcon(Objects.requireNonNull(getClass().getResource("enemy.png"))).getImage();
        backgroundImage=new ImageIcon(Objects.requireNonNull(getClass().getResource("back.jpg"))).getImage();
        timer=new Timer(10, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D=(Graphics2D) g;
        //g2D.drawImage(backgroundImage,0,0,null);
        g2D.drawImage(enemy,x,y,null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(timer.isRunning()){
            if(e.getSource()==pause){
                timer.stop();
                pause.setText("Continue!");
            }
            if(x>=PANEL_WIDTH-enemy.getWidth(null) || x<0){
                xVelocity*=-1;
            }
            if (y>=PANEL_HEIGHT-enemy.getHeight(null) || y<0){
                yVelocity*=-1;
            }

            x+=xVelocity;
            y+=yVelocity;
            repaint();
        }
        else {
            if(e.getSource()==pause){
                timer.start();
                pause.setText("Pause !");
            }
        }
    }
}