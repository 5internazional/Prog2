package uebung16_10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuadratTest {
private Quadrat q;
private Punkt p;
private Rechteck r;
    @BeforeEach
    void setUp() {
         p = new Punkt(3, 4);
         q = new Quadrat(3, p);
         r = new Rechteck(3, 4, p);

    }

    @Test
    public void berechneFl(){
        q.berchneFlaeche();
        assertEquals(9, q.berchneFlaeche(), 0);
    }
    @Test
    public void berechneUm(){
        q.berechneUmfang();
        assertEquals(12, q.berechneUmfang(), 0);
    }

    @Test
    public void getAnkerFig(){
        q.getAnker();
        assertEquals(p, q.getAnker());
    }

    @Test
    public void verschAnk(){
        q.getAnker().verschiebe(1, 1);
        assertEquals(4, q.getAnker().getX());
        assertEquals(5, q.getAnker().getY());
    }

    @Test
    public void rechteckTest(){
        r.berchneFlaeche();
        assertEquals(12, r.berchneFlaeche(), 0);

    }

    @Test
    public void rechteckTestUmf(){
        r.berechneUmfang();
        assertEquals(14, r.berechneUmfang(), 0);
    }



}