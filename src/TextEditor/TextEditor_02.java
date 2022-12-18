package TextEditor;

import com.sun.org.apache.xml.internal.security.algorithms.JCEMapper;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextEditor_02 extends JFrame implements ActionListener {

    //----->
    JLabel text;
    JButton colorButton;
    JTextArea textArea;
    JScrollPane scrollPane;
    JSpinner fontSizeSpinner;
    JComboBox<String> fontBox;
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenuItem openItem,saveItem,exitItem;
    //------>
    TextEditor_02(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Bro !");
        this.setSize(500,550);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        textArea=new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial",Font.PLAIN,20));

        scrollPane=new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(450,450));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        fontSizeSpinner=new JSpinner();
        fontSizeSpinner.setValue(textArea.getFont().getSize());
        fontSizeSpinner.setPreferredSize(new Dimension(50,25));
        fontSizeSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                textArea.setFont(new Font(textArea.getFont().toString(),Font.PLAIN,(int)fontSizeSpinner.getValue()));
            }
        });

        text =new JLabel("font :");

        colorButton=new JButton("Color");
        colorButton.addActionListener(this);

        String[] fonts=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        fontBox=new JComboBox<>(fonts);
        fontBox.addActionListener(this);
        fontBox.setSelectedItem("Arial");

        // ----  menuBar  -------

        menuBar=new JMenuBar();
        fileMenu=new JMenu("File");
        openItem=new JMenuItem("Open");
        saveItem=new JMenuItem("Save");
        exitItem=new JMenuItem("exit");

        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        // ------   menuBar  -------

        this.setJMenuBar(menuBar);
        this.add(text);
        this.add(fontSizeSpinner);
        this.add(colorButton);
        this.add(fontBox);
        this.add(scrollPane);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new TextEditor_02();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==colorButton){
            Color color= JColorChooser.showDialog(null,"Choose Color",Color.BLACK);
            textArea.setForeground(color);
        }
        if(e.getSource()==fontBox){
            textArea.setFont(new Font((String) fontBox.getSelectedItem(),Font.PLAIN,(int)fontSizeSpinner.getValue()));
        }
        if(e.getSource()==openItem){

            JFileChooser fileChooser=new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));

            FileNameExtensionFilter filter=new FileNameExtensionFilter("Text Files","txt","HTML Files");
            fileChooser.setFileFilter(filter);

            int response=fileChooser.showOpenDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                Scanner fileIn=null;


                try {
                    fileIn=new Scanner(file);
                    if(file.isFile()){
                        while (fileIn.hasNextLine()){
                            String line=fileIn.nextLine()+"\n";
                            textArea.append(line);
                        }
                    }
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

            }

        }
        if(e.getSource()==saveItem){
            JFileChooser fileChooser=new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));

            int response=fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file;

                file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                try (PrintWriter fileOut = new PrintWriter(file)) {
                    fileOut.println(textArea.getText());
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        if(e.getSource()==exitItem){
            System.exit(0);
        }
    }

}