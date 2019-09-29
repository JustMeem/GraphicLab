package com.company;

import java.awt.*;

public class Line extends Figure {
    private int x1, y1, x2, y2;
    private double angle;

    @Override
    public void move() {
        x1 += dx;
        x2 += dx;
        y1 += dy;
        y2 += dy;
    }

    @Override
    public void move(int x, int y, int maxX, int maxY) {
        Point first = new Point(x1, y2);
        Point second = new Point(x2, y2);
        first.move(x, y, maxX, maxY);
        second.move(x, y, maxX, maxY);
    }

    @Override
    public void rotate(double a) {
        angle +=a;
    }

    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        angle = 0;
        dx = dy = 0;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.rotate(angle);
        g2.drawLine(x1, y1, x2, y2);
        g2.rotate(-angle);
    }
}
