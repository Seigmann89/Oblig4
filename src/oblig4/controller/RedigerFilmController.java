package oblig4.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import oblig4.MainJavaFX;
import oblig4.model.Film;

public class RedigerFilmController {

    @FXML
    private TextField tittelTextField;
    @FXML
    private TextArea beskrivelseTextArea;
    @FXML
    private TextField spilleTidTextField;
    @FXML
    private DatePicker utgivelseTextField;

    private Stage redigerStage;
    private Film film;
    private boolean okClicked = false;

    @FXML
    public void initialize() {
        beskrivelseTextArea.setWrapText(true);
    }


    public boolean isOkClicked() {
        return okClicked;
    }


    public void setFilm(Film film) {
        this.film = film;

        tittelTextField.setText(film.getTittel());
        beskrivelseTextArea.setText(film.getBeskrivelse());
        spilleTidTextField.setText(String.valueOf(film.getSpilleTid()));
        utgivelseTextField.setValue(film.getUtgivelsesdato());

    }

    @FXML
    public void handleOk() {
        if (isInputValid()) {
            film.setUtgivelsesdato(utgivelseTextField.getValue());
            film.setBeskrivelse(beskrivelseTextArea.getText());
            film.setTittel(tittelTextField.getText());
            film.setSpilleTid(Integer.parseInt(spilleTidTextField.getText()));

            okClicked = true;
            redigerStage.close();
        }
    }


    private boolean isInputValid() {
        String errorMessage = "";

        if (tittelTextField.getText() == null || tittelTextField.getText().length() == 0) {
            errorMessage += "Ugyldig tittel!\n";
        }
        if (beskrivelseTextArea.getText() == null || beskrivelseTextArea.getText().length() == 0) {
            errorMessage += "Ugyldig beskrivelse!\n";
        }
        if (spilleTidTextField.getText() == null || spilleTidTextField.getText().length() == 0) {
            errorMessage += "Ugyldig spilletid!\n";
        }
        if (utgivelseTextField.getValue() == null) {
            errorMessage += "Ugyldig dato!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(redigerStage);
            alert.setTitle("Ugyldige felter");
            alert.setHeaderText("Vennligst rett opp følgende feil");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    @FXML
    public void handleCancel(){
        redigerStage.close();
    }

    public void setRedigerStage(Stage redigerStage) {
        this.redigerStage = redigerStage;
    }

    public Film getFilm() {
        return film;
    }
}
