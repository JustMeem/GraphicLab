package com.company;

import java.awt.*;

public class Rectangle extends Figure {
    private int angle;
    private int x, y, height, width;

    public Rectangle(int x, int y, int height, int width, int boundX, int boundY) {
        this.angle = 0;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.boundX = boundX;
        this.boundY = boundY;
    }


    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.rotate(angle, x + width / 2, y + height / 2);
        g2.fillRect(x, y, width, height);
        g2.rotate(-angle, x + width / 2, y + height / 2);
    }

    @Override
    public void rotate(double a) {
        angle += a;
    }

    @Override
    public void move() {
        if (x + width / 2 > boundX || x + width / 2 < 0) {
            dx = -dx;
        }
        if (y + height / 2 > boundY || y + height / 2 < 0) {
            dy = -dy;
        }
        x += dx;
        y += dy;
    }


}
