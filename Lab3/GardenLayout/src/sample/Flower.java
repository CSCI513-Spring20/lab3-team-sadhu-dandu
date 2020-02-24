package sample;

import java.awt.Point;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Flower implements Orchard{

    Circle circle;
    public Flower(Point2D b,Color RED, boolean c) {
        circle = new Circle();
        circle.setCenterX(b.getX());
        circle.setCenterY(b.getY());
        circle.setRadius(10);
        circle.setFill(Color.BLUE);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(1);


    }

    public Circle getCircle() {

        return circle;
    }
    public void move(double dx, double dy) {
        circle.setCenterX(circle.getCenterX()+dx);
        circle.setCenterY(circle.getCenterY()+dy);

    }
}