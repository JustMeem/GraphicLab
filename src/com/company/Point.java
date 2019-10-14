package com.company;

import java.awt.*;

public class Point extends Figure {
    private int x, y;

    public Point(int x, int y, int boundX, int boundY) {
        this.x = x;
        this.y = y;
        this.boundY = boundY;
        this.boundX = boundX;
        dx = dy = 0;
    }

    @Override
    public void rotate(double a) {
        double cos = Math.cos(a);
        double sin = Math.sin(a);
        int x = (int) Math.round(this.x * cos - this.y * sin);
        int y = (int) Math.round(this.x * sin + this.y * cos);
        this.x = x;
        this.y = y;
    }


    public void move() {
        if (x + dx > boundX || x + dx < 0) {
            dx = -dx;
        }
        if (y + dy > boundY || y + dy < 0) {
            dy = -dy;
        }
        x += dx;
        y += dy;
    }

    @Override
    public void draw(Graphics g) {
        g.fillRect(x, y, 5, 5);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
