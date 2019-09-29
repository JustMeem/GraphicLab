package com.company;

public abstract class Figure implements Drawable {
    protected int dx, dy;
    public void setVector(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }
    public abstract void rotate(double a);
    public abstract void move();
    public abstract void move(int x, int y, int maxX, int maxY);
}
