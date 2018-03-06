package oblig4.model;

public class Person {
    private String fNavn;
    private String eNavn;


    public Person(String fNavn, String eNavn) {
        this.fNavn = fNavn;
        this.eNavn = eNavn;
    }

    public String hentFultNavn(){
        return fNavn + " " + eNavn;
    };

    public String getfNavn() {
        return fNavn;
    }

    public String geteNavn() {
        return eNavn;
    }

    @Override
    public String toString() {
        return fNavn + " " + eNavn;
    }
}
