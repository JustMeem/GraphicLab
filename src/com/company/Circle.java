package com.company;

import java.awt.*;

public class Circle extends Figure {
    private int rad;
    private Point c;

    public Circle(int rad, Point c) {
        this.rad = rad;
        this.c = c;
        dx = dy = 0;
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(c.getX(), c.getY(), rad, rad);
    }

    @Override
    public void rotate(double a) {}

    @Override
    public void move() {
        c.move();
    }

    @Override
    public void setVector(int dx, int dy) {
        c.setVector(dx, dy);
    }

    @Override
    public void move(int x, int y, int maxX, int maxY) {
        c.move(x, y, maxX, maxY);
    }
}
