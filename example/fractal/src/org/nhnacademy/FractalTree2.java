package org.nhnacademy;
import java.awt.Graphics;
import java.awt.Frame;

public class FractalTree2 extends Frame {
    int x;
    int y;
    int angle;
    int length;
    int rotate;
    double growth;
    int depth;

    public FractalTree2(int width, int height, int x, int y, int angle, int length, int rotate, double growth) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.length = length;
        this.rotate = rotate;
        this.growth = growth;

        this.setSize(width, height);
    }

    public void branch(Turtle turtle, int rotate, int length, double growth) {
        if (!(length <= 40)) {
            turtle.go(length);
            turtle.rotate(rotate);
            branch(turtle, rotate, (int)(length * growth), growth);
            branch(turtle, -rotate, (int)(length * growth), growth);
            turtle.flip().go(length).flip().rotate(-rotate);
        }
    }

    @Override
    public void paint(Graphics graphics) {
        Turtle turtle = new Turtle(graphics, x, y, angle);
        branch(turtle, rotate, length, growth);
    }

    public static void main(String[] args) {
        FractalTree2 tree = new FractalTree2(500, 500, 250, 500, -90, 200, -30 , 0.5);
        tree.setVisible(true);
        tree.show();
    }
}
