package it.univaq.rtv;

import com.lynden.gmapsfx.GoogleMapView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/*import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;*/

/*import net.sourceforge.jgeocoder.CommonUtils;
import net.sourceforge.jgeocoder.JGeocodeAddress;
import net.sourceforge.jgeocoder.tiger.H2DbDataSourceFactory;
import net.sourceforge.jgeocoder.tiger.JGeocoder;
import net.sourceforge.jgeocoder.tiger.JGeocoderConfig;*/
import java.io.FileNotFoundException;
import java.io.IOException;


//Importante per realizzazione CUBO 3D
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.scene.transform.*;
import javafx.animation.*;
import javafx.util.*;
import javafx.scene.*;

import java.lang.*;






public class RoadToVictory extends Application{


    @Override
    public void start(Stage stage) throws Exception, FileNotFoundException,IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Scene.fxml"));
        Scene scene = new Scene(root);
        GoogleMapView googleMapView = (GoogleMapView)  scene.lookup("#googleMapView");
        googleMapView.autosize();
        scene.getStylesheets().add("Styles.css");
        stage.setTitle("Road To Victory Europa");
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
