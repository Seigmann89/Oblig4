package oblig4.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import oblig4.MainJavaFX;
import oblig4.model.Film;
import oblig4.model.Person;

public class FilmOversiktController {

    @FXML
    private ListView<Film> filmListeView;

    @FXML
    private Label filmTittel;

    @FXML
    private TextField utgivelseTextField, spilleTidTextField;

    @FXML
    private TextArea beskrivelseTextField;

    @FXML
    private Button redigerBtn;

    @FXML
    private Button nyBtn;


    private MainJavaFX mainJavaFX;
    private Film film;

    @FXML
    public void initialize() {
        mainJavaFX = MainJavaFX.mainJavaFXApplikasjon;

        filmListeView.setItems(MainJavaFX.mainJavaFXApplikasjon.getFilmListe());

        beskrivelseTextField.setWrapText(true);

        filmListeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Film>() {
            @Override
            public void changed(ObservableValue<? extends Film> observable, Film oldFilm, Film newFilm) {
                filmTittel.setText(String.valueOf(newFilm.getTittel()));
                beskrivelseTextField.setText(newFilm.getBeskrivelse());
                utgivelseTextField.setText(String.valueOf(newFilm.getUtgivelsesdato()));
                spilleTidTextField.setText(String.valueOf(newFilm.getSpilleTid() + " minutter"));
            }
        });

        redigerBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                film = filmListeView.getSelectionModel().getSelectedItem();
                mainJavaFX.redigerScene(film);
            }
        });

        nyBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                nyFilm();
            }
        });
    }

    @FXML
    private void slettFilm() {
        int valgtFilm = filmListeView.getSelectionModel().getSelectedIndex();
        filmListeView.getItems().remove(valgtFilm);
    }

    @FXML
    private void nyFilm(){
        Film tempFilm = new Film();
        boolean okClicked = mainJavaFX.redigerScene(tempFilm);
        if (okClicked) {
            mainJavaFX.getFilmListe().add(tempFilm);
        }
    }

    public ListView<Film> getFilmListeView() {
        return filmListeView;
    }

}
