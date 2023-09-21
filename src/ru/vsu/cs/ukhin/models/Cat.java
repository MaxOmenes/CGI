package ru.vsu.cs.ukhin.models;

import ru.vsu.cs.ukhin.Main;

import java.awt.*;

public class Cat {
    private Color color;
    private static final Color strokeColor = Color.black;
    public Cat(Color color){
        this.color = color;
    }

    //size
    private static final int HEIHGT = 500;
    private static final int WIDTH = 330;

    // indent
    private static final int headIndent = 25;

    //body size
    private static final int headWidth = WIDTH - 2 * headIndent;
    private static final int headHeight = HEIHGT/2 - headIndent;

    private static final int earsWidth = headHeight/2 ;
    private static final int earsHeight = headWidth/2;
    private static final int earsRotate = 60;


    public void draw(Graphics2D g2d, int x, int y){
        g2d.setStroke(new BasicStroke(5));
        //draw head
        g2d.setColor(strokeColor);
        g2d.drawOval(x+headIndent, y+headIndent, headWidth, headHeight);

        //draw ears
        g2d.setColor(strokeColor);
        g2d.rotate(Math.toDegrees(earsRotate));
        g2d.drawOval(x+headIndent+headWidth/2, y-headHeight-headIndent, earsWidth, earsHeight);

        g2d.setColor(strokeColor);
        g2d.rotate(Math.toDegrees(180-earsRotate));
        g2d.drawOval(x, y-headIndent-headHeight, earsWidth, earsHeight);

    }
}
