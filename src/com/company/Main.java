package com.company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static final int WIDTH = 500;
    private static final int P_COUNT = 20;
    public static int rnd(Random r){
        return Math.abs(r.nextInt()%WIDTH);
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("GraphicLab");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, WIDTH);

        MyPanel canvas = new MyPanel();
        Random r = new Random(System.currentTimeMillis());

        frame.add(canvas);
        Figure[] figures = new Figure[5];
        figures[0] = new Line(rnd(r), rnd(r), rnd(r), rnd(r), WIDTH, WIDTH);
        figures[1] = new Circle(40, new Point(rnd(r), rnd(r), WIDTH, WIDTH));
        figures[2] = new Ellipse(new Point(rnd(r), rnd(r), WIDTH, WIDTH), 10, 30);
        figures[3] = new Rectangle(rnd(r), rnd(r), 20, 20, WIDTH, WIDTH);
        figures[4] = new Polygon(new int[]{10, 40, 40}, new int[]{10, 10, 50}, WIDTH, WIDTH);
        for (Figure f: figures){
            f.setVector(r.nextInt()%10, r.nextInt()%10);
            canvas.addDrawable(f);
        }
        canvas.setRunning(true);
        frame.setVisible(true);
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    try{sleep(10);}catch (InterruptedException e){break;}
                    for (Figure f: figures){
                        f.move();
                        f.rotate(0.05);
                    }
                }
            }
        };

        Thread second = new Thread(thread);
        Thread third = new Thread(thread);
        thread.start();
        //second.start();
        //third.start();

    }
}
