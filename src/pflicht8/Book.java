package pflicht8;

public class Book implements Comparable<Book> {
    private String titel;
    private String autor;
    private int jahr;

    /**
     * Empty constructor
     */
    public Book() {
        titel = null;
        autor = null;
        jahr = 0;
        System.out.println("Warning: you tried to call a constructor without parameters");
    }

    /**
     * Constructor of a book
     *
     * @param titel the name of the book
     * @param autor the author of the book
     * @param jahr  the year of issue of the book
     * @throws IllegalArgumentException when data is null
     */
    public Book(String titel, String autor, int jahr) throws IllegalArgumentException {
        if (titel.equals("") || autor.equals("") || jahr <= 0)
            throw new IllegalArgumentException("Parameters can't be empty");
        this.autor = autor;
        this.jahr = jahr;
        this.titel = titel;
    }

    // Getters and setters

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getJahr() {
        return jahr;
    }

    public void setJahr(int jahr) {
        this.jahr = jahr;
    }

    //------

    @Override
    public int compareTo(Book o) {
        if(this.jahr < o.jahr) {
            return -1;
        }
        else if(this.jahr > o.jahr) {
            return 1;
        } else {
            return 0;
        }
    }


    @Override
    public String toString() {
        return "titel: " + titel + ", autor: " + autor + ", jahr: " + jahr;
    }
}