package Menu_Bar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class menu_bar extends JFrame implements ActionListener {

    JMenuBar bar_menu;
    JMenu fileMenu,editMenu,helpMenu;
    JMenuItem loadItem,saveItem,exitItem;
    menu_bar(){

        bar_menu=new JMenuBar();

        fileMenu=new JMenu("File");
        editMenu=new JMenu("Edit");
        helpMenu=new JMenu("Help");

        loadItem=new JMenuItem("load");
        saveItem=new JMenuItem("save");
        exitItem=new JMenuItem("exit");

        bar_menu.add(fileMenu);
        bar_menu.add(editMenu);
        bar_menu.add(helpMenu);

        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        loadItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        fileMenu.setMnemonic(KeyEvent.VK_F);
        editMenu.setMnemonic(KeyEvent.VK_E);//Press shift+E
        helpMenu.setMnemonic(KeyEvent.VK_H);

        loadItem.setMnemonic(KeyEvent.VK_L);
        saveItem.setMnemonic(KeyEvent.VK_S);//Press S
        exitItem.setMnemonic(KeyEvent.VK_E);

        this.setVisible(true);
        this.setLayout(new FlowLayout());
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setJMenuBar(bar_menu);

    }

    public static void main(String[] args) {
        new menu_bar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==loadItem){
            System.out.println("Loading....");
        }
        if(e.getSource()==saveItem){
            System.out.println("File Saved !");
        }
        if(e.getSource()==exitItem){
            System.exit(0);
        }

    }
}
