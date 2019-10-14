package com.company;

public class Rectangle extends Polygon {
    public Rectangle(int x, int y, int width, int height, int boundX, int boundY) {
        super(new int[]{x, x + width, x + width, x}, new int[]{y, y, y + height, y + height}, boundX, boundY);
    }
}
