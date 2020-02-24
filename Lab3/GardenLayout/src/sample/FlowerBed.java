package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class FlowerBed implements Orchard{
    Rectangle rect = new Rectangle();

    public FlowerBed(double x, double y, double width, double height) {
        rect.setX(x);
        rect.setY(y);
        rect.setHeight(height);
        rect.setWidth(width);
        rect.setFill(Color.WHITE);
        rect.setStroke(Color.BLACK);
        rect.setStrokeWidth(1);
    }

    public void move(double dx, double dy) {
        rect.setX(rect.getX()+dx);
        rect.setY(rect.getY()+dy);
    }

    public Rectangle getRectangle(){
        return rect;
    }
}
