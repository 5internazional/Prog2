package pflichtaufgabe7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinTreeTest {
    private BinTree leer;
    private BinTree eineKnote;
    private BinTree sorted;
    private BinTree unsorted;
    private BinNode q1;
    private BinNode q2;
    private BinNode w1;
    private BinNode w2;
    private BinNode e1;
    private BinNode e2;
    private BinNode wurzel1;
    private BinNode a1;
    private BinNode a2;
    private BinNode a3;
    private BinNode wurzel2;

    @BeforeEach
    void setUp() {
        leer = new BinTree();
        eineKnote = new BinTree(new BinNode(5));
        q1 = new BinNode(1);
        q2 = new BinNode(3);
        w1 = new BinNode(2, q1, q2);
        w2 = new BinNode(4, w1, new BinNode(5));
        e1 = new BinNode(8);
        e2 = new BinNode(9, e1, null);
        wurzel1 = new BinNode(7, w2, e2);
        sorted = new BinTree(wurzel1);
        a1 = new BinNode(2);
        a2 = new BinNode(7);
        a3 = new BinNode(4, a1, a2);
        wurzel2 = new BinNode(6, a3, new BinNode(9));
        unsorted = new BinTree(wurzel2);

    }

//Testen countTwoChildrenNodes-Methode
    @Test
    public void twoChildrenLeer(){
        leer.countTwoChildrenNodes();
        assertEquals(0, leer.countTwoChildrenNodes(), 0);
    }

    @Test
    public void twoChildrenEineKnoten(){
        eineKnote.countTwoChildrenNodes();
        assertEquals(0, eineKnote.countTwoChildrenNodes(), 0);
    }

    @Test
    public void twoChildrenSorted(){
        sorted.countTwoChildrenNodes();
        assertEquals(3, sorted.countTwoChildrenNodes(), 0);
    }

    @Test
    public void twoChildrenUnsorted(){
        unsorted.countTwoChildrenNodes();
        assertEquals(2, unsorted.countTwoChildrenNodes(), 0);
    }


    //Testen isSorted-Methode
    @Test
    public void isSortedLeer(){
        assertTrue(leer.isSorted());
    }
    @Test
    public void isSortedUnsorted(){
        assertFalse(unsorted.isSorted());
    }

    @Test
    public void isSortedSorted(){
        assertTrue(sorted.isSorted());
    }

    @Test
    public void isSortedEineKnote(){
        assertTrue(eineKnote.isSorted());
    }


    //Testen removeNode-Methode
    @Test
    public void removeLeer(){
        assertFalse(leer.removeNode(5));
    }

    @Test
    public void removeEineKnote(){
        assertFalse(eineKnote.removeNode(325));
    }

    @Test
    public void removeEineKnoteTrue(){
        assertTrue(eineKnote.removeNode(5));
    }

    @Test
    public void removeUnsorted(){ //werte nicht in Baum
        assertFalse(unsorted.removeNode(325));
    }

    @Test
    public void removeUnsorted2(){ //werte  in Baum
        assertFalse(unsorted.removeNode(4));
    }


    @Test
    public void removeSorted(){ //werte nicht in Baum
        assertFalse(sorted.removeNode(325));
    }

    @Test
    public void removeSorted2(){ //werte  in Baum, nicht Blatt
        assertTrue(sorted.removeNode(4));
        assertTrue(sorted.isSorted());
        assertFalse(sorted.nodeInTree(4, wurzel1));

    }

    @Test
    public void removeSorted4(){ //werte  in Baum, nicht Blatt
        assertTrue(sorted.removeNode(9));
        assertTrue(sorted.isSorted());
        assertFalse(sorted.nodeInTree(9, wurzel1));

    }

    @Test
    public void removeSorted5(){ //werte  in Baum, Wurzel
        assertTrue(sorted.removeNode(7));
        assertTrue(sorted.isSorted());
        assertFalse(sorted.nodeInTree(7, wurzel1));

    }
    @Test
    public void removeSorted3(){ //werte  in Baum,  Blatt

        assertTrue(sorted.removeNode(3));
        assertFalse(sorted.nodeInTree(3, wurzel1));

    }
}