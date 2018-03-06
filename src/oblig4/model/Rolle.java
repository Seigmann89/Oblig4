package oblig4.model;

public class Rolle{
    private String karFNavn;
    private String karENavn;
    private Person skuespiller;

    //Constructor

    public Rolle(String karFNavn, String karENavn, Person skuespiller) {
        this.karFNavn = karFNavn;
        this.karENavn = karENavn;
        this.skuespiller = skuespiller;
    }

    //Gettere

    public String getKarFNavn() {
        return karFNavn;
    }

    public String getKarENavn() {
        return karENavn;
    }

    public Person getSkuespiller() {
        return skuespiller;
    }

    //Settere


    public void setKarFNavn(String karFNavn) {
        this.karFNavn = karFNavn;
    }

    public void setKarENavn(String karENavn) {
        this.karENavn = karENavn;
    }

    public void setSkuespiller(Person skuespiller) {
        this.skuespiller = skuespiller;
    }

    @Override
    public String toString() {
        return karFNavn + " " + karENavn + " spilt av - " + skuespiller;
    }
}
