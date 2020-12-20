package pflicht8;

public class Telefonbuch {
    //private Telefonbuch tb = new BinTreeGen<Person>();
    private BinTreeGen<Person> JansTelefonbuch;

    public Telefonbuch() {
        JansTelefonbuch = new BinTreeGen<>();
    }

    /**
     * counts the number of entries in the phone book
     *
     * @return the number of entries
     */
    public int countEntries() {
        return JansTelefonbuch.countNodes();
    }

    /**
     * adds a new person to a phone book, people with similar surnames are not allowed to be added
     *
     * @param p person to add to a phone book
     * @return true if the person added successfully, false - if not
     */
    public boolean insertPerson(Person p) {
        return JansTelefonbuch.insertNode(p);
    }

    /**
     * searches for a person in a phone book by his or her surname
     *
     * @param name surname of a person
     * @return
     */
    public Person searchPerson(String name) {
        Person p = new Person("vorname",name,"00000");
        return JansTelefonbuch.find(p).data;

    }

    @Override
    public String toString() {
        return "JansTelefonbuch: \n" + JansTelefonbuch;
    }
}
