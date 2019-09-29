package com.company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static final int WIDTH = 800;
    private static final int P_COUNT = 20;


    public static void main(String[] args) {
        JFrame frame = new JFrame("GraphicLab");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, WIDTH);

        MyPanel canvas = new MyPanel();
        Random rand = new Random(System.currentTimeMillis());
        ArrayList<Point> points = new ArrayList<>(P_COUNT);
        for (int i = 0; i < P_COUNT; i++) {
            points.add(new Point(Math.abs(rand.nextInt()%WIDTH), Math.abs(rand.nextInt()%WIDTH)));
        }
        int[] dx = new int[P_COUNT];
        int[] dy = new int[P_COUNT];
        for (int i = 0; i < P_COUNT; i++) {
            dx[i] = rand.nextInt()%10;
            dy[i] = rand.nextInt()%10;
        }
        points.forEach(canvas::addDrawable);
        frame.add(canvas);
        canvas.setRunning(true);
        frame.setVisible(true);
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                while(true){
                    for (int i = 0; i < P_COUNT; i++) {
                        Point point = points.get(i);
                        try{sleep(1);}catch(InterruptedException e){
                            break;
                        }
                        synchronized (point) {
                            /*try {
                                point.wait(1);
                            } catch (InterruptedException e) {
                            }*/
                            if (point.getX() + dx[i] > WIDTH || point.getX() + dx[i] < 0) {
                                dx[i] = -dx[i];
                            }
                            if (point.getY() + dy[i] > WIDTH || point.getY() + dy[i] < 0) {
                                dy[i] = -dy[i];
                            }
                            point.move(dx[i], dy[i]);
                        }
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
