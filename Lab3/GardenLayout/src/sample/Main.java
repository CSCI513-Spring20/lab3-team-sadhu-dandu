package sample;

import javafx.scene.paint.Color;
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
    boolean dragging = false;
    Flower flower1 = new Flower(new Point2D(20,50),Color.BLACK,true);
   // Flower flower2 = new Flower(a,Color.PALETURQUOISE,true);
    FlowerBed flowerbed = new FlowerBed(50,50,50,50);
    List<Orchard>Items = new ArrayList<Orchard>();

    Orchard garden;
    AnchorPane root;
    Scene scene;

    @Override
    public void start(Stage primaryStage) {


        root = new AnchorPane();
        scene = new Scene(root, 600, 600);
        scene.setFill(Color.SEAGREEN);
        Items.add(flower1);
        Items.add(flowerbed);
        root.getChildren().add(flower1.getCircle());
        //root.getChildren().add(flower2.getCircle());
        root.getChildren().add(flowerbed.getRectangle());


        primaryStage.setScene(scene);
        primaryStage.show();


        EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                clickPoint = new Point2D(mouseEvent.getX(), mouseEvent.getY());
                System.out.println(clickPoint.getX() + " " + clickPoint.getY());

                String eventName = mouseEvent.getEventType().getName();
                if (!dragging) {
                    garden = getComponent();
                }
                switch (eventName) {
                    case ("MOUSE_DRAGGED"):

                        if (Items != null && lastPosition != null && garden != null) {
                            dragging = true;
                            double deltaX = clickPoint.getX() - lastPosition.getX();
                            double deltaY = clickPoint.getY() - lastPosition.getY();
                            garden.move(deltaX, deltaY);
                            //flowerbed.move(deltaX, deltaY);
                            //flower1.move(deltaX,deltaY);
                            //flower2.move(deltaX,deltaY);
                        }

                    case ("MOUSE_RELEASED"):
                        if (Items != null && garden instanceof Flower) {
                            for (Orchard shape : Items) {
                                if (shape instanceof FlowerBed && shape.ContainsPoint(clickPoint)) {
                                    ((FlowerBed) shape).addchild(garden);
                                    break;
                                }
                            }
                        }
                        dragging = false;
                }
                lastPosition = clickPoint;
            }
        };
        scene.setOnMouseDragged(mouseHandler);
        scene.setOnMouseReleased(mouseHandler);
        scene.setOnMousePressed(mouseHandler);
    }

    private Orchard getComponent(){
        Orchard Component = null;
        for(Orchard shape: Items){
            if (shape.ContainsPoint(clickPoint)){
                Component = shape;
                break;
            }
        }
        return Component;
    }
    public static void main(String[]args) {

        launch(args);
    }
}
