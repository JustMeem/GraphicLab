package com.company;

import java.awt.*;

public class Polygon extends Figure {
    private int[] x, y;
    private double angle = 0;

    public Polygon(int[] x, int[] y, int boundX, int boundY) {
        this.x = x;
        this.y = y;
        this.boundX = boundX;
        this.boundY = boundY;
    }

    @Override
    public void rotate(double a) {
        angle += a;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int midX = 0, midY = 0, div = x.length;
        for (int i = 0; i < div; i++) {
            midX += x[i] / div;
            midY += y[i] / div;
        }
        g2.rotate(angle, midX, midY);
        g2.fillPolygon(x, y, div);
        g2.rotate(-angle, midX, midY);
    }

    @Override
    public void move() {
        int midX = 0, midY = 0, div = x.length;
        for (int i = 0; i < div; i++) {
            midX += x[i] / div;
            midY += y[i] / div;
        }
        if (midX > boundX || midX / 2 < 0) {
            dx = -dx;
        }
        if (midY > boundY || midY / 2 < 0) {
            dy = -dy;
        }
        for (int i = 0; i < div; i++) {
            x[i] += dx;
            y[i] += dy;
        }
    }
}
