package ru.vsu.cs.ukhin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ru.vsu.cs.ukhin.models.*;

public class DrawingPanel extends JFrame /*implements ActionListener*/ {
    private final int BACKGROUND_WIDTH = 1000;
    private final int BACKGROUND_HEIGHT = 1000;

//    private final Timer timer = new Timer(1000, this);
    private int ticksFromStart = 0;

    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
//        new Car(Color.BLUE).draw(g2d, ticksFromStart, 300);
        new Cat(Color.WHITE).draw(g2d, 300, 500);

    }
    public DrawingPanel(){
        setTitle("Drawing Panel");
        setSize(BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        timer.start();
    }

//    @Override
//    public void actionPerformed(ActionEvent e){
//        if(e.getSource() == timer){
//            repaint();
//            ticksFromStart+=1;
//        }
//    }
}
