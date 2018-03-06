package oblig4;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import oblig4.controller.RedigerFilmController;
import oblig4.model.Film;

import java.io.IOException;
import java.time.LocalDate;

public class MainJavaFX extends Application {

    private ObservableList<Film> filmListe = FXCollections.observableArrayList();
    private Stage primaryStage;
    public static MainJavaFX mainJavaFXApplikasjon;

    public MainJavaFX() {
        filmListe.add(new Film("Avatar", 150, "A paraplegic marine dispatched to the moon Pandora on a unique " +
                "mission becomes torn..", LocalDate.of(2009, 12, 10)));
        filmListe.add(new Film("Interstellar", 169, "A team of explorers travel through a wormhole in space in an" +
                " attempt to ensure humanity's survival", LocalDate.of(2014, 11, 7)));

        mainJavaFXApplikasjon = this;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainJavaFX.mainJavaFXApplikasjon = this;

        this.primaryStage = primaryStage;
        hovedScene();
    }

    public void hovedScene() throws Exception {
        FXMLLoader fxmlInnlaster = new FXMLLoader();

        fxmlInnlaster.setLocation(getClass().getResource("view/FilmOversikt.fxml"));
        Parent rootNode = fxmlInnlaster.load();

        Scene hovedScene = new Scene(rootNode);

        primaryStage.setTitle("Film");
        primaryStage.setScene(hovedScene);
        primaryStage.show();
    }

    public boolean redigerScene(Film film) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();

            fxmlLoader.setLocation(getClass().getResource("view/RedigerFilm.fxml"));
            Parent rootNode = fxmlLoader.load();

            Stage redigerStage = new Stage();
            redigerStage.initModality(Modality.APPLICATION_MODAL);
            redigerStage.initOwner(primaryStage);
            Scene redigerScene = new Scene(rootNode);
            redigerStage.setScene(redigerScene);

            RedigerFilmController controller = fxmlLoader.getController();
            controller.setRedigerStage(redigerStage);
            controller.setFilm(film);

            redigerStage.setTitle("Endre/Legg til ny Film");
            redigerStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    public ObservableList<Film> getFilmListe() {
        return filmListe;
    }



    public static void main(String[] args) {
        launch(args);
    }
}
