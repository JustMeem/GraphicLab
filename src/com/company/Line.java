package com.company;

import java.awt.*;

public class Line extends Figure {
    private int x1, y1, x2, y2;
    //private double angle;

    @Override
    public void move() {
        if (x1 + dx > boundX || x2 + dx > boundX || x1 + dx > 0 || x2 + dx < 0) {
            dx = -dx;
        }
        if (y1 + dy > boundY || y2 + dy > boundY || y1 + dy > 0 || y2 + dy < 0) {
            dy = -dy;
        }
        x1 += dx;
        x2 += dx;
        y1 += dy;
        y2 += dy;
    }


    @Override
    public void rotate(double a) {
        double cos = Math.cos(a);
        double sin = Math.sin(a);
        int baseX = (x1 + x2) / 2, baseY = (y1 + y2) / 2;
        int x = baseX + (int) Math.round((this.x1 - baseX) * cos - (this.y1 - baseY) * sin);
        int y = baseY + (int) Math.round((this.x1 - baseX) * sin + (this.y1 - baseY) * cos);
        this.x1 = x;
        this.y2 = y;
        x = baseX + (int) Math.round((this.x2 - baseX) * cos - (this.y2 - baseY) * sin);
        y = baseY + (int) Math.round((this.x2 - baseX) * sin + (this.y2 - baseY) * cos);
        this.x2 = x;
        this.y2 = y;
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
        g2.drawLine(x1, y1, x2, y2);
    }
}
