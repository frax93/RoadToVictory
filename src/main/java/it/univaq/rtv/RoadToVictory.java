package it.univaq.rtv;

import com.lynden.gmapsfx.GoogleMapView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.lang.*;






public class RoadToVictory extends Application{


    /**
     * @param stage
     * @throws Exception
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws Exception, FileNotFoundException,IOException {

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/Scene.fxml"));
        Scene scene = new Scene(root);
        GoogleMapView googleMapView = (GoogleMapView)  scene.lookup("#googleMapView");
        googleMapView.autosize();
        scene.getStylesheets().add("view/Styles.css");
        stage.setTitle("Road To Victory");
        stage.setScene(scene);
        stage.show();




    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
