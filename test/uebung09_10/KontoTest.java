package uebung09_10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KontoTest {
    private Konto k;

    @BeforeEach
    void setUp() {
        k = new Konto();
    }

    @Test
    public void einzahlen() {
        k.einzahlen(15f);
        assertEquals(15f, k.getKontostand(), 0);

    }
    @Test
    public void testEinzahlenZweimal() {
        k.einzahlen(15f);
        k.einzahlen(25f);
        assertEquals(40f, k.getKontostand(), 0);

    }

    @Test
    public void testNullEinzahlen(){
        k.einzahlen(0f);
        assertEquals(0f, k.getKontostand(), 0);
    }

    @Test
    public void testLargestNumEinzahlen(){

    }

    @Test
    public void testNegativeEinzahlen(){
        assertThrows(IllegalArgumentException.class, () ->{k.einzahlen(-5f);});

    }

    @Test
    public void abheben(){
        k.einzahlen(10f);
        k.abheben(5f);
        assertEquals(5, k.getKontostand(), 0);
    }

    @Test
    public void abhebeZweiMal(){
        k.einzahlen(10f);
        k.abheben(5f);
        k.abheben(2f);
        assertEquals(3, k.getKontostand(), 0);

    }

    @Test
    public void abhebenNull(){
        k.abheben(0f);
        assertEquals(0f, k.getKontostand(), 0);

    }

    @Test
    public void kontoIstLeerTest(){
        k.einzahlen(0f);
        assertTrue(k.kontoIstLeer());
    }
    @Test
    public void kontoIstLeerFalseTest(){
        k.einzahlen(10f);
        assertFalse(k.kontoIstLeer());
    }
    @Test
    public void kontoIstLeerTrueTest(){
        k.einzahlen(10f);
        k.abheben(10f);
        assertFalse(k.kontoIstLeer());
    }

}