package MyPrj0;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.*;

public class MyPrj extends JFrame implements ActionListener,KeyListener{
    ImageIcon icon=new ImageIcon(Objects.requireNonNull(getClass().getResource("images/moneyIcon.png")));
    Container_01 container_01;
    Container_02 container_02;
    Container_03 container_03;
    JFrame thankMe;
    JLabel thankMeText;
    JLabel thankMeIcon=new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("images/Matrab.png"))));
    int counter=0;
    double total,duty;
    ArrayList<String> dataNames =new ArrayList<>();
    ArrayList<Double> moneyByPerson=new ArrayList<>() ;
    int additionalHeight=600;
    MyPrj(){

        container_01=new Container_01();
        container_01.submitText.addActionListener(this);
        container_01.inText.addKeyListener(this);

        container_02=new Container_02();
        container_02.setVisible(false);
        container_02.nameButton.addActionListener(this);
        container_02.nameField.addKeyListener(this);
        container_02.moneyButton.addActionListener(this);
        container_02.moneyField.addKeyListener(this);

        container_03=new Container_03();
        container_03.setVisible(false);
        container_03.timer=new Timer(200, e -> {
                container_03.finalValues.get(container_03.counter).setVisible(true);
                container_03.counter++;
                if(container_03.counter==container_01.enteredValue){
                    container_03.timer.stop();
                }

        });
        //Entering Names And Money of every Person

        thankMeText=new JLabel("Made By Mohamed Matrab ");
        thankMeText.setFont(new Font("Consolos",Font.BOLD,15));
        thankMeText.setForeground(Color.BLACK);
        thankMeText.setBounds(50,210,300,50);

        thankMeIcon.setBounds(50,10,200,200);

        thankMe=new JFrame("Thanks :)");
        thankMe.setLocationRelativeTo(null);
        thankMe.setResizable(false);
        thankMe.setVisible(false);
        thankMe.setSize(300,300);
        thankMe.setLayout(null);

        thankMe.add(thankMeIcon);
        thankMe.add(thankMeText);

        this.setVisible(true);
        this.setIconImage(icon.getImage());
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.add(container_01);
        this.add(container_02);
        this.add(container_03);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==container_01.submitText){
            try {
                container_01.enteredValue=Integer.parseInt(container_01.inText.getText());
                if(container_01.enteredValue>0){
                    container_01.setVisible(false);
                    container_02.setVisible(true);
                    container_02.nameLabel.setText("Enter The Name Number "+(counter+1)+" :");
                }
                else {
                    container_01.message_alert.setText("Enter A Integer Positive Number in the Field !");
                }
            }
            catch (NumberFormatException e1){
                container_01.message_alert.setText("Enter A Integer Number in the Field !");
            }
        }
        if(e.getSource()==container_02.nameButton){

            if(!Objects.equals(container_02.nameField.getText().trim(), "") ){
                counter++;

                dataNames.add(container_02.nameField.getText());
                container_02.nameButton.setEnabled(false);
                container_02.nameField.setEnabled(false);
                container_02.moneyButton.setVisible(true);
                container_02.moneyLabel.setVisible(true);
                container_02.moneyField.setVisible(true);


            }
            else {
                JOptionPane.showMessageDialog(null,"Enter A Name !","Error",JOptionPane.ERROR_MESSAGE);
            }

        }
        if(e.getSource()==container_02.moneyButton){
            try {
                container_02.nameLabel.setText("Enter The Name Number "+(counter+1)+" :");
                moneyByPerson.add(counter-1,Double.parseDouble(container_02.moneyField.getText()));

                container_02.nameButton.setEnabled(true);
                container_02.nameField.setEnabled(true);
                container_02.moneyButton.setVisible(false);
                container_02.moneyLabel.setVisible(false);
                container_02.moneyField.setVisible(false);

                container_02.moneyField.setText("");
                container_02.nameField.setText("");

                if(counter==container_01.enteredValue){
                    container_02.setVisible(false);
                    container_03.setVisible(true);
                    dataAndFinalValues();
                }

            }catch (NumberFormatException exception){
                JOptionPane.showMessageDialog(null,"Enter A Valid Number !","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource()==container_01.inText && e.getKeyCode()==10){
            try {
                container_01.enteredValue=Integer.parseInt(container_01.inText.getText());
                if(container_01.enteredValue>0){
                    container_01.setVisible(false);
                    container_02.setVisible(true);
                    container_02.nameLabel.setText("Enter The Name Number "+(counter+1)+" :");
                }
                else {
                    container_01.message_alert.setText("Enter A Integer Positive Number in the Field !");
                }
            }
            catch (NumberFormatException e1){
                container_01.message_alert.setText("Enter A Integer Number in the Field !");
            }
        }
        if(e.getSource()==container_02.nameField && e.getKeyCode()==10){

            if(!Objects.equals(container_02.nameField.getText().trim(), "") ){
                counter++;

                dataNames.add(container_02.nameField.getText());
                container_02.nameButton.setEnabled(false);
                container_02.nameField.setEnabled(false);
                container_02.moneyButton.setVisible(true);
                container_02.moneyLabel.setVisible(true);
                container_02.moneyField.setVisible(true);


            }
            else {
                JOptionPane.showMessageDialog(null,"Enter A Name !","Error",JOptionPane.ERROR_MESSAGE);
            }

        }
        if(e.getSource()==container_02.moneyField && e.getKeyCode()==10){
            try {
                container_02.nameLabel.setText("Enter The Name Number "+(counter+1)+" :");
                moneyByPerson.add(counter-1,Double.parseDouble(container_02.moneyField.getText()));

                container_02.nameButton.setEnabled(true);
                container_02.nameField.setEnabled(true);
                container_02.moneyButton.setVisible(false);
                container_02.moneyLabel.setVisible(false);
                container_02.moneyField.setVisible(false);

                container_02.moneyField.setText("");
                container_02.nameField.setText("");

                if(counter==container_01.enteredValue){
                    container_02.setVisible(false);
                    container_03.setVisible(true);
                    dataAndFinalValues();
                    if(container_01.enteredValue<=Math.floorDiv(additionalHeight,container_03.HEIGHT_LENGTH))
                        container_03.timer.start();
                }

            }catch (NumberFormatException exception){
                JOptionPane.showMessageDialog(null,"Enter A Valid Number !","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void dataAndFinalValues(){

        //------>     Total and Duty    <------//

        total=0;
        for (int i=0;i<container_01.enteredValue;i++){
            total+=moneyByPerson.get(i);
        }
        duty=total/container_01.enteredValue;

        //------>     Final Labels and Final values    <------//

        if(container_01.enteredValue<=Math.floorDiv(additionalHeight,container_03.HEIGHT_LENGTH)){
            if(container_01.enteredValue*50>350){
                this.setSize(500,container_03.labelTop.getHeight()+(container_01.enteredValue+1)*container_03.HEIGHT_LENGTH);
                container_03.setSize(500,container_03.labelTop.getHeight()+(container_01.enteredValue+1)*container_03.HEIGHT_LENGTH);
            }

            for (int i=0;i<container_01.enteredValue;i++){
                if(moneyByPerson.get(i)<duty){
                    container_03.images.add(i,new JLabel(container_03.giveIcon));
                    container_03.giveOrTake="Give ";
                }
                else if(moneyByPerson.get(i)>duty){
                    container_03.images.add(i,new JLabel(container_03.takeIcon));
                    container_03.giveOrTake="Take ";
                }
                else if(moneyByPerson.get(i)==duty){
                    container_03.images.add(i,new JLabel(container_03.equalIcon));
                    container_03.giveOrTake="You Good  ";
                }

                container_03.images.get(i).setBounds(100,0,50,container_03.HEIGHT_LENGTH);
                container_03.namesLabel.add(i,new JLabel(dataNames.get(i)+"     "+container_03.giveOrTake+" : "+new DecimalFormat("##.##").format(Math.abs(moneyByPerson.get(i)-duty)) +" MAD"));
                container_03.namesLabel.get(i).setBounds(150,0,300,container_03.HEIGHT_LENGTH);
                container_03.namesLabel.get(i).setFont(new Font("Consolas",Font.BOLD,13));

                container_03.finalValues.add(i,new JLabel());
                container_03.finalValues.get(i).setBounds(0,container_03.labelTop.getHeight()+i*container_03.HEIGHT_LENGTH,500,container_03.HEIGHT_LENGTH);
                container_03.finalValues.get(i).add(container_03.images.get(i));
                container_03.finalValues.get(i).add(container_03.namesLabel.get(i));
                container_03.finalValues.get(i).setVisible(false);

                container_03.add(container_03.finalValues.get(i));
            }
            container_03.timer.start();
        }
        else {
            container_03.scrollPane.setVisible(true);
            for (int i=0;i<container_01.enteredValue;i++){
                if(moneyByPerson.get(i)<duty){
                    container_03.giveOrTake="Give ";
                }
                else if(moneyByPerson.get(i)>duty){
                    container_03.giveOrTake="Take ";
                }
                else if(moneyByPerson.get(i)==duty){
                    container_03.giveOrTake="You Good  ";
                }

                container_03.textArea.setText(container_03.textArea.getText()+dataNames.get(i)+"\t"+container_03.giveOrTake+" :"+new DecimalFormat("##.##").format(Math.abs(moneyByPerson.get(i)-duty))+" MAD \n");

            }
        }

        thankMe.setVisible(true);
    }
}