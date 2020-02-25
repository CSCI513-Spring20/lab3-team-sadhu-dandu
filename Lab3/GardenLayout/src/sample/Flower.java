package sample;

import java.awt.Point;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Flower implements Orchard{

    Circle circle;
    boolean movable;
    public Flower(Point2D b,Color c, boolean bool) {
        circle = new Circle();
        this.movable = bool;
        circle.setCenterX(b.getX());
        circle.setCenterY(b.getY());
        circle.setRadius(10);
        circle.setFill(c.darker());
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(4);


    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public boolean isMovable() {
        return movable;
    }

    public void setMovable(boolean movable) {
        this.movable = movable;
    }

    public Circle getCircle() {

        return circle;
    }
    public void move(double dx, double dy) {
        circle.setCenterX(circle.getCenterX()+dx);
        circle.setCenterY(circle.getCenterY()+dy);

    }
    @Override
    public boolean ContainsPoint(Point2D point) {
        return (circle.contains(point));
    }
}