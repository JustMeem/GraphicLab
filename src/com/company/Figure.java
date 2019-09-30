package com.company;

public abstract class Figure implements Drawable {
    int dx = 0, dy = 0, boundX, boundY;

    public void setVector(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public abstract void rotate(double a);

    public abstract void move();
}
