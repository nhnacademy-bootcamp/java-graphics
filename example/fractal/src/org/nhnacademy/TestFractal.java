package org.nhnacademy;
import java.awt.*;

public class TestFractal extends Frame {

    FractalTree4 tree;

    public TestFractal(int width, int height) {
        super();
        this.setSize(width, height);

        tree = new FractalTree4(getWidth() / 2, getHeight(), 90, getHeight() / 2, 30, 0.1);
    }

    @Override
    public void paint(Graphics graphics) {
        tree.paint(graphics);
    }

    public static void main(String[] args) {
        TestFractal tree = new TestFractal(500, 500);
        tree.setVisible(true);
        tree.show();
    }
}
