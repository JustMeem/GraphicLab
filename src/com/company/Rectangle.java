package com.company;

import java.awt.*;

public class Rectangle extends Figure {
    private int angle;
    private int x, y, height, width;

    public Rectangle(int x, int y, int height, int width) {
        this.angle = 0;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }


    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g2;
        g2.rotate(angle);
        g2.fillRect(x, y, width, height);
        g2.rotate(-angle);
    }

    @Override
    public void rotate(double a) {

    }

    @Override
    public void move() {

    }

    @Override
    public void move(int x, int y, int maxX, int maxY) {

    }
}
