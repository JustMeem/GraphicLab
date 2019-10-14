package com.company;

import java.awt.*;

public class Ellipse extends Figure{
    private Point center;
    private int height, width;
    private double angle;
    public Ellipse(Point center, int height, int width) {
        this.center = center;
        this.height = height;
        this.width = width;
        this.angle = 0;
    }

    @Override
    public void rotate(double a) {
        angle += a;
    }

    @Override
    public void move() {
        center.move();
    }

    @Override
    public void setVector(int dx, int dy) {
        center.setVector(dx, dy);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        int x = center.getX() , y = center.getY();
        g2.rotate(angle, x, y);
        g2.fillOval(x - width/2, y  - height/2, width, height);
        //center.draw((Graphics) g2);
        g2.rotate(-angle, x, y);
    }
}
