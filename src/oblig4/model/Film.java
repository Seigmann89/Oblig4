package oblig4.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Film extends Produksjon implements Comparable<Film> {

    public static List<Film> oversiktFilm = new ArrayList<>();

    public Film(String tittel, int spilleTid, String beskrivelse, LocalDate utgivelsesdato) {
        super(tittel, beskrivelse, utgivelsesdato, spilleTid);
    }

    public Film(String tittel, int spilleTid, LocalDate utgivelsesdato, String beskrivelse, Person regissor) {
        super(tittel, spilleTid, utgivelsesdato, beskrivelse, regissor);
        oversiktFilm = oversiktFilm;

        oversiktFilm.add(this);
    }

    public Film() {
    }

    @Override
    public String toString() {
        return getTittel() + " - " + getUtgivelsesdato(); /*+ "\n" + " - " + getBeskrivelse() + " - " + "\n" + "Varer " +
                "i " + getSpilleTid() + " min" + "\n" + "Utgitt i - " + getUtgivelsesdato() + "\n" + "Regissert av - " +
                "" + getRegissor() + "\n" + "********************";*/
    }

    @Override
    public int compareTo(Film other) {
        return this.getTittel().compareTo(other.getTittel());
    }

    public static List<Film> getOversiktFilm() {
        return oversiktFilm;
    }


}
