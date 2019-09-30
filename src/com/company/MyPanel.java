package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MyPanel extends JPanel implements ActionListener {
    private List<Drawable> drawables;
    private Timer timer;

    public MyPanel() {
        super();
        drawables = new ArrayList<>(100);
        timer = new Timer(10, this);
    }

    public void setRunning(boolean running) {
        if (running) {
            timer.start();
        } else
            timer.stop();
    }

    public void addDrawable(Drawable d) {
        this.drawables.add(d);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.red);
        
        for (Drawable d : drawables) {
            synchronized (d) {
                d.draw(g);
            }
        }
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}

