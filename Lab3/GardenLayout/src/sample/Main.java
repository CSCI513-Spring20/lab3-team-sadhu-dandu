package sample;

import javafx.scene.paint.Color;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {

    Point2D a =new Point2D(50,50);
    Point2D b =new Point2D(20,30);
    Point2D lastPosition = null;
    Point2D clickPoint;
    Flower flower1 = new Flower(new Point2D(40,50),Color.BLACK,true);
   // Flower flower2 = new Flower(a,Color.PALETURQUOISE,true);
    FlowerBed flowerbed = new FlowerBed(50,50,10,10);
    Orchard gar;
    AnchorPane root;
    Scene scene;

    @Override
    public void start(Stage primaryStage) {


        root = new AnchorPane();
        scene = new Scene(root,600,600);
        scene.setFill(Color.SEAGREEN);
        root.getChildren().add(flower1.getCircle());
        //root.getChildren().add(flower2.getCircle());
        root.getChildren().add(flowerbed.getRectangle());
        primaryStage.setScene(scene);
        primaryStage.show();



        EventHandler<MouseEvent> mouseHandler= new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                clickPoint = new Point2D(mouseEvent.getX(), mouseEvent.getY());
                System.out.println(clickPoint.getX()+" "+clickPoint.getY());

                String eventName = mouseEvent.getEventType().getName();
                switch(eventName) {
                    case("MOUSE_DRAGGED"):

                        if(lastPosition !=null) {
                            System.out.println("Dragging");
                            double deltaX = clickPoint.getX()-lastPosition.getX();
                            double deltaY = clickPoint.getY()-lastPosition.getY();
                            flowerbed.move(deltaX, deltaY);
                            flower1.move(deltaX,deltaY);
                            //flower2.move(deltaX,deltaY);
                        }

                        break;
                }
                lastPosition = clickPoint;
            }
        };

        scene.setOnMouseDragged(mouseHandler);
        scene.setOnMouseReleased(mouseHandler);
        scene.setOnMousePressed(mouseHandler);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
