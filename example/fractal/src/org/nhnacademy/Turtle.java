package org.nhnacademy;

import java.awt.Graphics;

public class Turtle {
    double x;
    double y;
    double angle;
    Graphics graphics;

    public Turtle(Graphics graphics, double x, double y, double angle) {
        this.graphics = graphics;
        this.x = x;
        this.y = y;
        this.angle = angle;
    }

    public Turtle rotate(double degree) {
        angle += degree;
        return  this;
    }

    public Turtle flip() {
        angle += 180;
        return  this;
    }

    public Turtle go(double distance) {
        double dx = distance * Math.cos(Math.toRadians(angle));
        double dy = distance * Math.sin(Math.toRadians(angle));

        graphics.fillOval((int)x-2, (int)y-2, 4, 4);
        graphics.drawLine((int)x, (int)y, (int)(x + dx), (int)(y + dy));
        x += dx;
        y += dy;
        graphics.fillOval((int)x-2, (int)y-2, 4, 4);

        try {
            Thread.sleep(10);
        } catch(InterruptedException ignore) {}

        return  this;
    }
}
