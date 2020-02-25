package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.*;
import javafx.geometry.Point2D;

public class FlowerBed implements Orchard{
    Rectangle rect = new Rectangle();
    boolean movable;
    List<Orchard> flowers = new ArrayList<Orchard>();


    public FlowerBed(Point2D point,Color color,boolean bool) {
  //  public FlowerBed(double x, double y, double width, double height,boolean flag) {
        this.movable = true;
        rect.setX(point.getX());
        rect.setY(point.getY());
        rect.setHeight(100);
        rect.setWidth(80);
        rect.setFill(color.brighter());
        rect.setStroke(Color.BLACK);
        rect.setStrokeWidth(5);
    }
    @Override
    public void move(double dx, double dy) {
        rect.setX(rect.getX()+dx);
        rect.setY(rect.getY()+dy);
        for (Orchard flower : flowers) {
            flower.move(dx, dy);
        }
    }

    public Rectangle getRectangle(){

        return rect;
    }
    @Override
    public boolean ContainsPoint(Point2D point) {
        boolean inRectangle = (point.getX() >= rect.getX() && point.getX() <= rect.getX()+rect.getWidth()
                && point.getY()>= rect.getY() && point.getY() <= rect.getY()+rect.getHeight());
        return inRectangle;
    }
    public void addchild(Orchard garden) {

        flowers.add(garden);

    }

}
