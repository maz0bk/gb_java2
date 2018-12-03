package com.geekbrains;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class MyWindow extends JFrame {
    public MyWindow(){
        setTitle("My new window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(150, 150, 800, 600);
        setLayout(new GridLayout(2, 2));
        JPanel [] jp = new JPanel[4];
        for (int i=0; i<4; i++){
            jp[i] = new JPanel();
            add(jp[i]);
            jp[i].setBackground(new Color(100+i*40, 100+i*40,100+i*40));
        }

        jp[0].setLayout(new BorderLayout());
        JTextArea jta = new JTextArea();
        JScrollPane jsp = new JScrollPane(jta);
        jp[0].add(jsp);
        jta.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) System.out.println("Pressed Enter");
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        JButton button = new JButton("Button");
        jp[0].add(button, BorderLayout.PAGE_END);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button pressed...");
            }
        });

        jp[1].setLayout(new FlowLayout());
        JRadioButton [] jrb = new JRadioButton[4];
        ButtonGroup bgr  =new ButtonGroup();
        for (int i=0; i < jrb.length; i++){
            jrb[i] = new JRadioButton("Option # "+i);
            bgr.add(jrb[i]);
            jp[1].add(jrb[i]);
        }

        JCheckBox [] jcb = new JCheckBox[4];
        for (int i =0;i<jcb.length;i++){
            jcb[i]= new JCheckBox("Check #"+i);
            jp[1].add(jcb[i]);
        }

        jp[2].setLayout(new FlowLayout());
        String[] comboStr = {"Item #1", "Item #2", "Item #3", "Item #4"};
        JComboBox<String> jcombo1 = new JComboBox<>(comboStr);
        JComboBox<String> jcombo2 = new JComboBox<>(comboStr);
        jp[2].add(jcombo1);
        jp[2].add(jcombo2);
        jcombo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(jcombo1.getSelectedItem().toString());
            }
        });

        JTextField field = new JTextField();
        jp[2].add(field);
        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("here text:"+ field.getText());
            }
        });
        jp[2].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("MousePos: " + e.getX() + " " + e.getY());
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        jp[3].setLayout(null);
        JSlider js = new JSlider();
        JLabel jlab = new JLabel("Value: 50");
        js.setMaximum(100);
        js.setMinimum(0);
        js.setValue(50);
        jp[3].add(jlab);
        jp[3].add(js);
        js.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                jlab.setText("Value: " + js.getValue());
            }
        });
        jlab.setBounds(10,10,100,20);
        js.setBounds(20, 40, 300, 100);
        js.setBackground(new Color(160,255,160));

        JMenuBar mainMenu = new JMenuBar();
        JMenu mFile = new JMenu("File");
        JMenu mEdit = new JMenu("Edit");
        JMenuItem miFileNew = new JMenuItem("New");
        JMenuItem miFileExit = new JMenuItem("Exit");
        JMenuItem miEditGoGo = new JMenuItem("GoGo");
        setJMenuBar(mainMenu);
        mainMenu.add(mFile);
        mainMenu.add(mEdit);
        mFile.add(miFileNew);
        mFile.addSeparator(); // разделительная линия в меню
        mFile.add(miFileExit);
        mEdit.add(miEditGoGo);

        miFileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("BYE");
            }
        });
//        JButton[] jbs = new JButton[5];
//        for (int i =0; i < 5; i++){
//            jbs[i] = new JButton("#"+i);
//        }
//        setLayout(new BorderLayout());
//        add(jbs[0], BorderLayout.EAST);
//        add(jbs[1], BorderLayout.WEST);
//        add(jbs[2], BorderLayout.SOUTH);
//        add(jbs[3], BorderLayout.NORTH);
//        add(jbs[4], BorderLayout.CENTER);
        setVisible(true);
    }

}
