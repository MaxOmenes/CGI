package ru.vsu.cs.ukhin.models;

import java.awt.*;

public class Car {
    final private int HEIGHT = 200;
    final private int WEIGHT = 600;
    Color carColor;

    public Car(Color carColor){
        this.carColor = carColor;
    }

    public void draw(Graphics2D g2d, int x, int y){
        int frontWeight = (WEIGHT/6);
        int backWeight = (WEIGHT/6);
        int centreWeight = (WEIGHT-frontWeight-backWeight);

        int frontHeight = HEIGHT/2;
        int backHeight = HEIGHT/2;

        int wheelsSize = frontHeight;
        int underCar = 20;

        int headlightsIndent = 15;
        int headlightsHeight = 25;
        int headlightsWeight = 15;

        int glassIndent = 15;
        //draw front of car
        g2d.setColor(carColor);
        g2d.fillRect(x, y+HEIGHT-frontHeight, frontWeight, frontHeight-underCar);

        //draw center of car
        g2d.setColor(carColor);
        g2d.fillRect(x+frontWeight, y, centreWeight, HEIGHT-frontHeight);
            //between
            g2d.fillRect(x+frontWeight+wheelsSize, y+HEIGHT-frontHeight, centreWeight-2*wheelsSize, frontHeight-underCar);

        //draw wheels
        g2d.setColor(Color.BLACK);
        g2d.fillOval(x+frontWeight, y+HEIGHT-frontHeight, wheelsSize, wheelsSize);
        g2d.fillOval(x+frontWeight+centreWeight-wheelsSize, y+HEIGHT-frontHeight, wheelsSize, wheelsSize);

        //draw back of car
        g2d.setColor(carColor);
        g2d.fillRect(x+frontWeight+centreWeight, y+HEIGHT-frontHeight, backWeight, backHeight-underCar);

        //draw headlights
            //front
            g2d.setColor(Color.BLACK);
            g2d.drawRect(x, y+HEIGHT-frontHeight+headlightsIndent, headlightsWeight, headlightsHeight);
            g2d.setColor(Color.YELLOW);
            g2d.fillRect(x, y+HEIGHT-frontHeight+headlightsIndent, headlightsWeight, headlightsHeight);
            //back
            g2d.setColor(Color.BLACK);
            g2d.drawRect(x+WEIGHT-headlightsWeight, y+HEIGHT-frontHeight+headlightsIndent, headlightsWeight, headlightsHeight);
            g2d.setColor(Color.RED);
            g2d.fillRect(x+WEIGHT-headlightsWeight, y+HEIGHT-frontHeight+headlightsIndent, headlightsWeight, headlightsHeight);
        //draw glass
        g2d.setColor(Color.BLACK);
        g2d.fillRoundRect(x+frontWeight+glassIndent, y+glassIndent, (centreWeight-(3*glassIndent))/2, HEIGHT-frontHeight-2*glassIndent, 15, 15);
        g2d.fillRoundRect(x+WEIGHT-backWeight-centreWeight/2, y+glassIndent, (centreWeight-(3*glassIndent))/2, HEIGHT-frontHeight-2*glassIndent, 15, 15);
    }
}
