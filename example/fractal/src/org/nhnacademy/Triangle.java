package org.nhnacademy;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;

public class Triangle extends Frame {

    public void draw(Graphics graphics, int [] xPoint, int [] yPoint) {
        if ((xPoint[0] != xPoint[1]) && (xPoint[0] != xPoint[2])) {
            graphics.drawPolygon(xPoint, yPoint, xPoint.length);

            for(int i = 0 ; i < 3 ; i++) {
                int [] xPoint1 = { (xPoint[i] + xPoint[0]) / 2, (xPoint[i] + xPoint[1]) / 2, (xPoint[i] + xPoint[2]) / 2};
                int [] yPoint1 = { (yPoint[i] + yPoint[0]) / 2, (yPoint[i] + yPoint[1]) / 2, (yPoint[i] + yPoint[2]) / 2};
                draw(graphics, xPoint1, yPoint1);
            }
        }
    }

    @Override
    public void paint(Graphics graphics) {
        Insets insets = this.getInsets();

        int height = this.getHeight() - insets.top - insets.bottom;

        int x = this.getWidth() / 2;
        int y = this.getHeight() - (height * 1 / 3);
        int length = (int) Math.sqrt(this.getWidth() / 2.0 * this.getWidth() / 2.0
                + this.getWidth() / 2.0 * Math.tan(Math.toRadians(30)) * this.getWidth() / 2.0 * Math.tan(Math.toRadians(30)));

        int[] xPoint = { (int) (x + length* Math.cos(Math.toRadians(90))),
                (int) (x + length* Math.cos(Math.toRadians(210))),
                (int) (x + length* Math.cos(Math.toRadians(330))) };
        int[] yPoint = { (int) (y - length* Math.sin(Math.toRadians(90))),
                (int) (y - length* Math.sin(Math.toRadians(210))),
                (int) (y - length* Math.sin(Math.toRadians(330))) };

        draw(graphics, xPoint, yPoint);
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();

        triangle.setSize(500, 500);
        triangle.setVisible(true);

        triangle.repaint();

    }
}
