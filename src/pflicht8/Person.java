package pflicht8;

public class Person implements Comparable<Person> {
    private String vorname;
    private String nachname;
    private String telefonnummer;

    /**
     * Empty constructor
     */
    public Person() {
        vorname = null;
        nachname = null;
        telefonnummer = null;
        System.out.println("Warning: you tried to call a constructor without parameters");
    }

    /**
     * Constructor of a person for a telephone book entry
     *
     * @param vorname name of a person
     * @param nachname surname of a person
     * @param telefonnummer telephone number of a person
     * @throws IllegalArgumentException when one of the data is not provided
     */
    public Person(String vorname, String nachname, String telefonnummer) throws IllegalArgumentException {
        if (vorname.equals("") || nachname.equals("") || telefonnummer.equals("")) {
            throw new IllegalArgumentException("Wrong Input");
        }
        this.vorname = vorname;
        this.nachname = nachname;
        this.telefonnummer = telefonnummer;
    }


    //Getters and setters


    public String getVorname() {
        return vorname;
    }

    /**
     *
     * @param vorname value to set as a name of a person
     * @throws IllegalArgumentException when name is null
     */
    public void setVorname(String vorname)  throws IllegalArgumentException{
        if(vorname.equals("")){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    /**
     *
     * @param nachname value to set as a surname of a person
     * @throws IllegalArgumentException when surname is null
     */
    public void setNachname(String nachname) throws IllegalArgumentException{
        if(nachname.equals("")){
            throw new IllegalArgumentException("Surname cannot be empty");
        }
        this.nachname = nachname;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    /**
     *
     * @param telefonnummer value to set as a phone number
     * @throws IllegalArgumentException when phone number is null
     */
    public void setTelefonnummer(String telefonnummer) throws IllegalArgumentException{
        if(telefonnummer.equals("")){
            throw new IllegalArgumentException("Phone number cannot be empty");
        }
        this.telefonnummer = telefonnummer;
    }


    @Override
    public String toString() {
        return  "vorname: " + vorname  +
                ", nachname: " + nachname  +
                ", telefonnummer: " + telefonnummer;

    }

    @Override
    public int compareTo(Person o) {
        return nachname.compareTo(o.nachname);
    }
}
