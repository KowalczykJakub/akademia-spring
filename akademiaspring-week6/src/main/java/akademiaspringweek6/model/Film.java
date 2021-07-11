package akademiaspringweek6.model;

public class Film {

    private String title;
    private String year;
    private String producer;

    public Film(String title, String year, String producer) {
        this.title = title;
        this.year = year;
        this.producer = producer;
    }

    @Override
    public String toString() {
        return title + " " + year + " " + producer + "\n";
    }
}
