package oblig4;

import oblig4.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n" + "-----------model.Serie------------" + "\n");
        Serie galactica = new Serie("Battlestar Galactica", "When an old enemy, the Cylons, resurface and obliterate " +
                "the 12 colonies," + "\n" + "the crew of the aged Galactica protect a small civilian fleet - the last" +
                " of humanity..", LocalDate.of(2005, 1, 14));
        Serie suits = new Serie("Suits");
        Serie himym = new Serie("How I Met Your Mother");
        Serie modernfam = new Serie("Modern Family");


        //Regissør
        Person jc = new Person("James", "Cameron");
        Person mr = new Person("Michael", "Rymer");
        Person fd = new Person("Frank", "Darabont");
        Person cn = new Person("Christopher", "Nolan");

        //Roller
        Person sw = new Person("Sam", "Worthington");
        Person zs = new Person("Zoe", "Saldana");

        Person ks = new Person("Katee", "Sackhoff");
        Person jb = new Person("Jamie", "Bamber");

        Rolle js = new Rolle("Jake", "Sully", sw);
        Rolle nb = new Rolle("Neytiri", "Blue", zs);

        Rolle kt = new Rolle("Kara", "Thrace", ks);
        Rolle la = new Rolle("Lee", "Adama", jb);

        //Legg til roller
        ArrayList<Rolle> filmRoller = new ArrayList<>();

        filmRoller.add(js);
        filmRoller.add(nb);

        ArrayList<Rolle> serieRoller = new ArrayList<>();

        serieRoller.add(kt);
        serieRoller.add(la);

        //model.Episode
        Episode thirtythree = new Episode(1, 1, "33", 42, LocalDate.of(2005, 1, 14), "Beskrivelse", mr);
        Episode ycgha = new Episode(1, 5, "You Can't Go Home Again", 42, LocalDate.of(2005, 2, 4),
                "Beskrivelse", mr);
        Episode bastilleday = new Episode(1, 3, "Bastille day", 42, LocalDate.of(2005, 1, 21), "Beskrivelse",
                mr);
        Episode actofc = new Episode(1, 4, "Act of Contribution", 42, LocalDate.of(2005, 1, 28), "Beskrivelse",
                mr);
        Episode water = new Episode(1, 2, "Water", 42, LocalDate.of(2005, 1, 14), "Besekrivelse", mr);


        //Legg til sesonger og episoder
        galactica.leggTilEpisode(ycgha);
        galactica.leggTilEpisode(thirtythree);
        galactica.leggTilEpisode(bastilleday);
        galactica.leggTilEpisode(water);
        galactica.leggTilEpisode(actofc);
        galactica.lagSesonger(2,1, 5);

        Collections.sort(galactica.getSesongListe());

        System.out.println(galactica.toString());

        //Henter alle episoder
        System.out.println("\n" + "------------ALLE EP-----------" + "\n");
        galactica.hentAlleEpisoder();

        //Antall episoder
        System.out.println("\n" + "-----------ANTALL EP------------" + "\n");
        System.out.println(galactica.antallEpisoder());

        //model.Film
        System.out.println("\n" + "------------FILM-----------" + "\n");

        Film avatar = new Film("Avatar", 150, LocalDate.of(2009, 12, 10), "A paraplegic marine dispatched to " +
                "the moon Pandora on a unique mission becomes torn..", jc);
        Film interstellar = new Film("Interstellar", 169, LocalDate.of(2014, 11, 7), "A team of explorers " +
                "travel through a wormhole in space in an attempt to ensure humanity's survival", cn);
        Film greenmile = new Film("Green Mile", 189, LocalDate.of(1999, 12, 10), "The lives of guards on Death " +
                "Row are affected by one of their charges: a black man accused of child murder and rape, yet who has " +
                "a mysterious gift", fd);
        /*System.out.println(avatar.toString());
        System.out.println(interstellar.toString());
        System.out.println(greenmile.toString());

        avatar.leggTilMangeRoller(filmRoller);
        //System.out.println(avatar.getRoller());

        thirtythree.leggTilMangeRoller(serieRoller);
        water.leggTilMangeRoller(serieRoller);
        //System.out.println(thirtythree.getRoller());*/

        Collections.sort(Serie.getOversiktSerie());

        System.out.println("Liste etter sortering: " + Serie.getOversiktSerie());

        Collections.sort(Film.oversiktFilm);

        System.out.println(Film.getOversiktFilm());
    }
}