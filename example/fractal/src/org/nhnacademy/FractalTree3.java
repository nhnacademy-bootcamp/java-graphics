package org.nhnacademy;
import java.awt.*;

public class FractalTree3 extends Frame {

    Point point;
    double rotateRadian, Angle;
    int length, growth, depth;

    public FractalTree3(int width, int height, Point point,
            int angle, int length, int rotate, double growth) {
        this.point = point;
        this.Angle = Math.toRadians(angle);
        this.length = length;
        this.rotateRadian = Math.toRadians(rotate);
        this.growth = 100;

        this.setSize(width, height);
    }

    public void branch(Graphics graphics, Point start, double angle, int length) {
        if (!(length <= 1)) {
            Point end = new Point(start);
            end.translate((int)(-length * Math.sin(angle)), (int)(-length * Math.cos(angle)));
            int branchLength = (int)(length * growth);

            graphics.drawLine((int)start.getX(), (int)start.getY(), (int)end.getX(), (int)end.getY());
            branch(graphics, end, angle + rotateRadian, branchLength);
            branch(graphics, end, angle - rotateRadian, branchLength);
        }
    }

    @Override
    public void paint(Graphics graphics) {
        branch(graphics, point, Angle, length);
    }

    public static void main(String[] args) {
        FractalTree3 tree = new FractalTree3(500, 500, new Point(250, 450), 90, 100, 30 , 0.75);
        tree.setVisible(true);
        tree.show();
    }
}
