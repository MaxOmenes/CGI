package ru.vsu.cs.ukhin.models;

import ru.vsu.cs.ukhin.Interface.Drawable;

import java.awt.*;

public class Cat implements Drawable {
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
    private static final int eyesIndentVertical = 40;
    private static final int eyesIndentHorisontal = 40;
    private static final int noseIndent = 10;
    private static final int pawIndent = 20;




    //body size
    private static final int headWidth = WIDTH - 2 * headIndent;
    private static final int headHeight = HEIHGT/2 - headIndent;

    private static final int earsWidth = headHeight/2 ;
    private static final int earsHeight = headWidth/2;
    private static final int earsRotate = 60;
    private static final int mouthWidth = 60;
    private static final int mouthHeight = 15;
    private static final int eyesWidth = 40;
    private static final int eyesHeight = 50;
    private static final int bodyWidth = WIDTH;
    private static final int bodyHeight = HEIHGT - headHeight*3/4;
    private static final int mustacheIndentHorizontal = 100;
    private static final int mustacheIndentVertical = 8;
    private static final int feetWidth = 110;
    private static final int feetHeight = 130;
    private static final int padSize = 26;
    private static final int bigPadSize = 70;
    private static final int pawWidth = 100;
    private static final int pawHeight = 50;



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

    private void drawMouth(Graphics2D g2d, int x, int y, int strokeWidth){
        g2d.setStroke(new BasicStroke(strokeWidth));
        g2d.setColor(Color.BLACK);
        g2d.drawOval(x-mouthWidth/2, y-mouthHeight*2, mouthWidth/2, mouthHeight*2);
        g2d.drawOval(x, y-mouthHeight*2, mouthWidth/2, mouthHeight*2);
        g2d.setColor(color);
        g2d.fillRect(x-mouthWidth/2-strokeWidth, y-mouthHeight*2-2*strokeWidth, mouthWidth+2*strokeWidth, mouthHeight+2*strokeWidth);
    }

    private void drawNose(Graphics2D g2d, int x, int y, int eyesIndentVertical, boolean colorNose){
        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(new int[]{x, x-noseIndent, x+noseIndent}, new int[]{y+eyesIndentVertical-mouthHeight, y+noseIndent, y+noseIndent}, 3);
        if(colorNose) {
            g2d.setColor(earsColor);
            g2d.fillPolygon(new int[]{x, x - noseIndent, x + noseIndent}, new int[]{y + eyesIndentVertical - mouthHeight, y + noseIndent, y + noseIndent}, 3);
        }
    }
    private void drawEye(Graphics2D g2d, int x, int y){
        g2d.setColor(Color.BLACK);
        g2d.fillOval(x, y, eyesWidth, eyesHeight);
        g2d.setColor(Color.WHITE);
        g2d.fillOval(x+5, y+10, eyesWidth/4, eyesHeight/4);
        g2d.fillOval(x+3, y+25, eyesWidth/5, eyesHeight/5);
    }
    private void drawEyes(Graphics2D g2d, int x, int y, int eyesIndentVertical, int eyesIndentHorisontal){
        drawEye(g2d, x+eyesIndentHorisontal, y-eyesIndentVertical);
        drawEye(g2d, x-eyesWidth-eyesIndentHorisontal, y-eyesIndentVertical);
    }

    private void drawMoustage(Graphics2D g2d, int x, int y, int mustacheIndentVertical, int mustacheIndentHorizontal){
        int deltaV = 30+mustacheIndentVertical;
        int deltaX = 60+mustacheIndentHorizontal;
        int mainDeltaX = 80+mustacheIndentHorizontal;

        g2d.setColor(strokeColor);
        g2d.setStroke(new BasicStroke(2));

        //left side
        g2d.drawLine(x-mustacheIndentHorizontal, y, x-mainDeltaX, y);
        g2d.drawLine(x-mustacheIndentHorizontal, y+mustacheIndentVertical, x-deltaX, y+deltaV);
        g2d.drawLine(x-mustacheIndentHorizontal, y-mustacheIndentVertical, x-deltaX, y-deltaV);

        //right side
        g2d.drawLine(x+mustacheIndentHorizontal, y, x+mainDeltaX, y);
        g2d.drawLine(x+mustacheIndentHorizontal, y+mustacheIndentVertical, x+deltaX, y+deltaV);
        g2d.drawLine(x+mustacheIndentHorizontal, y-mustacheIndentVertical, x+deltaX, y-deltaV);
    }

    private void drawFoot(Graphics2D g2d, int x, int y){
        g2d.setColor(strokeColor);
        g2d.drawOval(x, y, feetWidth, feetHeight);
        g2d.setColor(color);
        g2d.fillOval(x, y, feetWidth, feetHeight);

        //draw pad
        g2d.setColor(earsColor);
        g2d.fillOval(x+feetWidth/2-padSize/2, y+15, padSize, padSize);
        g2d.fillOval(x+feetWidth/4-padSize/2, y+25, padSize, padSize);
        g2d.fillOval(x+feetWidth*3/4-padSize/2, y+25, padSize, padSize);

        //draw big pad
        g2d.fillOval(x+feetWidth/2-bigPadSize/2, y+50, bigPadSize, bigPadSize);
    }
    private void drawFeet(Graphics2D g2d, int x, int y){
        drawFoot(g2d,x-WIDTH/10-feetWidth, y+bodyHeight-feetHeight+15);//left
        drawFoot(g2d, x+WIDTH/10, y+bodyHeight-feetHeight+15);//right
    }

    private void drawPaw(Graphics2D g2d, int x, int y){
        g2d.setStroke(new BasicStroke(10));
        g2d.setColor(strokeColor);
        g2d.drawOval(x, y, pawWidth, pawHeight);
        g2d.setColor(color);
        g2d.fillOval(x, y, pawWidth, pawHeight);
        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(strokeColor);
        g2d.drawLine(x+pawWidth/2, y+30, x+pawWidth/2, y+pawHeight);
        g2d.drawLine(x+pawWidth/2+pawIndent, y+30, x+pawWidth/2+pawIndent, y+pawHeight);
        g2d.drawLine(x+pawWidth/2-pawIndent, y+30, x+pawWidth/2-pawIndent, y+pawHeight);
    }
    private void drawPaws(Graphics2D g2d, int x, int y){
        drawPaw(g2d, x-bodyWidth/2-pawWidth/2, y+bodyHeight/3);
        drawPaw(g2d, x+bodyWidth/2-pawWidth/2, y+bodyHeight/3);
        g2d.setStroke(new BasicStroke(10));
    }

    public void draw(Graphics2D g2d, int x, int y){ //x, y - centre
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //draw ears
        drawEar(g2d, x, y, earsWidth, earsHeight,earsRotate+45); //right
        drawEar(g2d, x, y, earsHeight, earsWidth, earsRotate); //left

        g2d.setStroke(new BasicStroke(10));

        //draw body
        g2d.setColor(strokeColor);
        g2d.drawOval(x-WIDTH/2, y, bodyWidth, bodyHeight);
        g2d.setColor(color);
        g2d.fillOval(x-WIDTH/2, y, bodyWidth, bodyHeight);

        drawFeet(g2d, x, y);

        drawPaws(g2d, x, y);

        //draw head
        g2d.setColor(strokeColor);
        g2d.drawOval(x-headWidth/2, y-headHeight/2, headWidth, headHeight);
        g2d.setColor(color);
        g2d.fillOval(x-headWidth/2, y-headHeight/2, headWidth, headHeight);

        drawEyes(g2d, x, y, eyesIndentVertical, eyesIndentHorisontal);

        drawMouth(g2d, x, y+ eyesIndentVertical, 5);

        drawNose(g2d, x, y, eyesIndentVertical, true);

        drawMoustage(g2d, x, y, mustacheIndentVertical, mustacheIndentHorizontal);
    }
}
