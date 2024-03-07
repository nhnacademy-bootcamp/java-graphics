package org.nhnacademy;

import java.awt.Frame;
import java.awt.Graphics;

/**
 * FractalTree.
 */

public class FractalTree extends Frame {
    int x;
    int startY;
    int angle;
    int length;
    int rotate;
    int growth;
    int depth;

    /**
     * 생성자.
     *
     * @param width width
     * @param height height
     * @param x x
     * @param y y
     * @param angle angle
     * @param length length
     * @param rotate rotate
     * @param growth growth
     */
    public FractalTree(int width, int height, int x, int y,
            int angle, int length, int rotate, int growth) {
        this.x = x;
        this.startY = y;
        this.angle = angle;
        this.length = length;
        this.rotate = rotate;
        this.growth = growth;

        this.setSize(width, height);
    }

    /**
     * 가지 그리기.
     *
     * @param graphics 그래픽스 컨텍스트
     * @param startX 시작 X
     * @param startY 시작 Y
     * @param degree 각도
     * @param length 길이
     */
    public void branch(Graphics graphics, int startX, int startY, int degree, int length) {
        if (length > 1) {
            int endX = (int) (startX - length * Math.cos(Math.toRadians(degree)));
            int endY = (int) (startY - length * Math.sin(Math.toRadians(degree)));
            int branchLength = (int) (length * growth * 0.01);

            graphics.drawLine(startX, startY, endX, endY);
            branch(graphics, endX, endY, degree + rotate, branchLength);
        }
    }

    @Override
    public void paint(Graphics graphics) {
        branch(graphics, x, startY, this.angle, this.length);
    }

    public static void main(String[] args) {
        FractalTree tree = new FractalTree(500, 500, 250, 450, 90, 100, 30, 75);
        tree.setVisible(true);
    }
}

