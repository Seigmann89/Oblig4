package oblig4.model;

import java.time.LocalDate;

public class Episode extends Produksjon implements Comparable<Episode> {
    private int sesongNummer;
    private int episodeNummer;


    public Episode(int sesongNummer, int episodeNummer, String tittel, int spilleTid, LocalDate utgivelsesdato,
                   String beskrivelse, Person
                           regissor) {
        super(tittel, spilleTid, utgivelsesdato, beskrivelse, regissor);
        this.sesongNummer = sesongNummer;
        this.episodeNummer = episodeNummer;
    }

    public Episode(int sesongNummer) {
        this.sesongNummer = sesongNummer;
        this.episodeNummer = 1;
    }

    public Episode(int sesongNummer, int episodeNummer) {
        this.sesongNummer = sesongNummer;
        this.episodeNummer = episodeNummer;
    }

    public int getEpisodeNummer() {
        return episodeNummer;
    }

    public int getSesongNummer() {
        return sesongNummer;
    }

    @Override
    public String toString() {
        return getTittel() + " - " + "S" + (sesongNummer < 10 ? "0" + sesongNummer : sesongNummer) + "E" +
                (episodeNummer < 10 ? + episodeNummer : episodeNummer);/* + " - " + getBeskrivelse() + " - " +
                getSpilleTid() + " " +
                "min. Regissert" +
                " " +
                "av: " + getRegissor() + "\n" + "Utgitt i: " + getUtgivelsesdato();*/
    }

    public String sammenlign() {
        return "S" + (sesongNummer < 10 ? "0" + sesongNummer : sesongNummer) + "E" + (episodeNummer < 10 ?
                episodeNummer : episodeNummer);
    }

    @Override
    public int compareTo(Episode other) {
        return sammenlign().compareTo(other.sammenlign());
    }
}
