package com.company;

import java.awt.*;

public class Point extends Figure {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        dx = dy = 0;
    }

    @Override
    public void rotate(double a) {
        double cos = Math.cos(a);
        double sin = Math.sin(a);
        int x = (int) Math.round(this.x * cos - this.y * sin);
        int y = (int) Math.round(this.x * sin + this.y * cos);
    }

    public void rotate(Point base, double a) {
        rotate(base, Math.sin(a), Math.cos(a));
    }

    public void rotate(Point base, double sin, double cos) {
        int x = base.x + (int) Math.round((this.x - base.x) * cos - (this.y - base.y) * sin);
        int y = base.y + (int) Math.round((this.x - base.x) * sin + (this.y - base.y) * cos);
        this.x = x;
        this.y = y;
    }

    public void move() {
        this.x += dx;
        this.y += dy;
    }

    public void move(int x, int y, int maxX, int maxY) {
        if (this.x + x > maxX) {
            this.x = 2 * maxX - (this.x + x);
        } else {
            this.x += x;
        }
        if (this.y + y > maxY) {
            this.y = 2 * maxY - (this.y + y);
        } else {
            this.y += y;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.fillRect(x, y, 3, 3);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
