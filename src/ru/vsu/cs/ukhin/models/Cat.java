package ru.vsu.cs.ukhin.models;

import ru.vsu.cs.ukhin.Main;

import java.awt.*;

public class Cat {
    private Color color;

    public Cat(Color color){
        this.color = color;
    }

    //color
    private static final Color strokeColor = Color.black;
    private static final Color earsColor = Color.decode("#fac0cd");

    //size
    private static final int HEIHGT = 500;
    private static final int WIDTH = 330;

    // indent
    private static final int headIndent = 25;
    private static final int eyesIndent = 50;


    //body size
    private static final int headWidth = WIDTH - 2 * headIndent;
    private static final int headHeight = HEIHGT/2 - headIndent;

    private static final int earsWidth = headHeight/2 ;
    private static final int earsHeight = headWidth/2;
    private static final int earsRotate = 60;

    private void drawEar(Graphics2D g2d, int x, int y, int width, int height, int rotate){
        g2d.setStroke(new BasicStroke(20)); //right ear
        g2d.setColor(strokeColor);
        g2d.rotate(rotate, x, y);
        g2d.drawOval(x, y, width, height);
        g2d.setStroke(new BasicStroke(10));
        g2d.setColor(color);
        g2d.drawOval(x, y, width, height);
        g2d.setColor(earsColor);
        g2d.fillOval(x, y, width, height);

        g2d.rotate(-rotate, x, y); //return to 0
    }

    public void draw(Graphics2D g2d, int x, int y){ //x, y - centre
        //draw ears
        drawEar(g2d, x, y, earsWidth, earsHeight,earsRotate+45); //right
        drawEar(g2d, x, y, earsHeight, earsWidth, earsRotate); //left

        g2d.setStroke(new BasicStroke(10));
        //draw head
        g2d.setColor(strokeColor);
        g2d.drawOval(x-headWidth/2, y-headHeight/2, headWidth, headHeight);
        g2d.setColor(color);
        g2d.fillOval(x-headWidth/2, y-headHeight/2, headWidth, headHeight);

        //draw eyes
        g2d.setColor(Color.BLACK);
        g2d.fillOval(x+eyesIndent, y-eyesIndent, 40, 50);
        g2d.fillOval(x-eyesIndent, y-eyesIndent, 40, 50);

    }
}
