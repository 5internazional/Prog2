//Pflichtaufgabe3_Gruppe8_Aramian(574031)_Krysenkova(573734)
//JUNIT_5 is used
package pflichtaufgabe3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UniversityUnitTest {

    private Person p1, p2;
    private Docent d1;
    private Student s1, s2, s3;

    @BeforeEach
    public void setUp() {
        p1 = new Person ("Martina", "Zuse", 'f');
        p2 = new Person ("Angela", "Bart", 'f');

        d1 = new Docent ("Martin", "Busch", 'm', 4);

        s1 = new Student ("Thomas", "Bart", 'm', 343);
        s2 = new Student ("Angela", "Mueller", 'f', 120);
        s3 = new Student ("Jan", "Kaper", 'd', 123);
    }

    @Test
    public void testCreateListStudents() {
        assertArrayEquals(new Student[] {s1, s2, s3}, Administration.createList(s1, s2, s3));
    }

    @Test
    public void testCreateListMiexed() {
        assertArrayEquals(new Person[] {p1, d1, s2}, Administration.createList(p1, d1, s2));
    }

    @Test
    public void testCreateListOne() {
        assertArrayEquals(new Docent[] {d1}, Administration.createList(d1));
    }

    @Test
    public void testSortListOne() {
        Docent[] list = {d1};
        assertArrayEquals(list, Administration.sortList(list));
    }

    @Test
    public void testSortListBestCase() {
        Person[] list = {s1, p2, d1};
        assertArrayEquals(list, Administration.sortList(list));
    }

    @Test
    public void testSortListHappyPath() {
        Person[] list = {p1, d1, s1, p2};
        Person[] erg = {s1, p2, d1, p1};
        assertArrayEquals(erg, Administration.sortList(list));
    }

    @Test
    public void testSortListException() {
        assertThrows(NullPointerException.class, () ->{Administration.sortList(null);});
    }

    @Test
    public void testCountFemaleNobody() {
        assertEquals(0, Administration.countFemale(new Person[] {d1, s1, s3}));
    }

    @Test
    public void testCountFemaleHappyPath() {
        assertEquals(2, Administration.countFemale(new Person[] {p1, d1, s1, s2, s3}));
    }

    @Test
    public void testCountFemaleException() {
        assertThrows(NullPointerException.class, () ->{Administration.countFemale(null);});

    }
    //Test OutputList
    @Test
    public void testOutputListNormal() {
        assertEquals("[Martina Zuse, Angela Bart, Thomas Bart, matriculation number: 343]", Administration.outputList(new Person[] {p1, p2, s1}));
    }

    @Test
    public void testOutputException(){ //Exceptionfall
        assertThrows(NullPointerException.class, () ->{Administration.outputList(null);});
    }

    @Test
    public void testOutputOne(){ //Array mit 1 element - Grenzfall
        assertEquals("[Martin Busch, fb-number = 4]", Administration.outputList(new Person[]{d1}));
    }

    @Test
    public void testOutputMixed(){ //Array mit verschiedene Klassenelemente
        assertEquals("[Martin Busch, fb-number = 4, Thomas Bart, matriculation number: 343, Angela Bart]", Administration.outputList(new Person[]{d1, s1, p2}));
    }

    @Test
    public void testOutputStudents() { //Array mir Studenten
        assertEquals("[Thomas Bart, matriculation number: 343, Angela Mueller, matriculation number: 120, Jan Kaper, matriculation number: 123]", Administration.outputList(new Person[]{s1, s2, s3}));
    }






}