package org.nhnacademy;
import java.awt.*;

public class FractalTree4 {

    int startX, startY;
    int Angle, length, rotate, depth;
    double growth;

    public FractalTree4(int startX, int startY, int angle, int length, int rotate, double growth) {
        this.startX = startX;
        this.startY = startY;
        this.Angle = angle;
        this.length = length;
        this.rotate = rotate;
        this.growth = growth;
    }

    public void branch(Graphics graphics, int startX, int startY, int angle, int length) {
        if (!(length <= 1)) {
            int endX = (int) (startX - length * Math.sin(Math.toRadians(angle)));
            int endY = (int) (startY - length * Math.sin(Math.toRadians(angle)));
            int branchLength = (int)(length * growth);

            graphics.drawLine(startX, startY, endX, endY);
            try{
                Thread.sleep(100);
            } catch(InterruptedException ignore) {
            }

            branch(graphics, endX, endY, angle + rotate, branchLength);
            branch(graphics, endY, endX, angle + rotate, branchLength);
        }
    }

    public void paint(Graphics graphics) {
        branch(graphics, startX, startY, this.Angle, this.length);
    }
}
