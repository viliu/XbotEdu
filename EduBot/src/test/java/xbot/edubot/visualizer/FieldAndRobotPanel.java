package xbot.edubot.visualizer;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

import xbot.common.math.FieldPose;

public class FieldAndRobotPanel extends JPanel {

    private static final long serialVersionUID = 6951710231450011531L;
    FieldPose robotPose;
    FieldPose goalPose;

    AffineTransform tx;
    Line2D.Double line;
    Polygon arrowHead;

    public FieldAndRobotPanel() {
        robotPose = new FieldPose(0, 0, 90);

        
        tx = new AffineTransform();

        arrowHead = new Polygon();  
        arrowHead.addPoint( 0,5);
        arrowHead.addPoint( -5, -5);
        arrowHead.addPoint( 5,-5);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 0);
    }

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(500, 0);
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;
        // paint some kinda robot
        int centerX = this.getWidth() / 2;
        int centerY = this.getHeight() / 2;

        int robotCenterX = (int)(centerX+robotPose.getPoint().x);
        int robotCenterY = (int)(centerY+robotPose.getPoint().y);

        FieldPose drawableRobot = new FieldPose(robotCenterX, robotCenterY, robotPose.getHeading().getValue());
        FieldPose drawableRobotFront = drawableRobot.getPointAlongPoseLine(200);

        // Draw Robot Center Point
        graphics.setColor(Color.BLUE);
        graphics.setStroke(new BasicStroke(5));
        graphics.drawOval(
            robotCenterX,
            robotCenterY,
            5, 5);

        // Draw Robot Arrow
        graphics.setStroke(new BasicStroke(2));
        line = new Line2D.Double(
            drawableRobot.getPoint().x,
            drawableRobot.getPoint().y,
            drawableRobotFront.getPoint().x,
            drawableRobotFront.getPoint().y);
        graphics.draw(line);

        tx.setToIdentity();
        tx.translate(line.x1*2, line.y1*2);
        //tx.rotate(Math.toRadians(robotPose.getHeading().getValue()));

        graphics.setTransform(tx);   
        graphics.fill(arrowHead);
    }
}