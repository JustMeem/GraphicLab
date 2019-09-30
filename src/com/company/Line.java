package com.company;

import java.awt.*;

public class Line extends Figure {
    private int x1, y1, x2, y2;
    private double angle = 0;
    //private double angle;

    @Override
    public void move() {
        if ((x1 + x2) /2 + dx > boundX || (x1 + x2) /2 + dx < 0) {
            dx = -dx;
        }
        if ((y1 + y2)/2 + dy > boundY || (y1 + y2)/2 + dy < 0) {
            dy = -dy;
        }
        x1 += dx;
        x2 += dx;
        y1 += dy;
        y2 += dy;
    }


    @Override
    public void rotate(double a) {
        angle += a;
    }

    public Line(int x1, int y1, int x2, int y2, int boundX, int boundY) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.boundX = boundX;
        this.boundY = boundY;
        //angle = 0;
        dx = dy = 0;
    }


    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.rotate(angle, (x1 + x2) /2, (y1 + y2)/2);
        g2.drawLine(x1, y1, x2, y2);
        g2.rotate(-angle, (x1 + x2) /2, (y1 + y2)/2);
    }
}
