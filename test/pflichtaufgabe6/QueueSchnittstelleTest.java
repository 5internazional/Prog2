package pflichtaufgabe6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueSchnittstelleTest {

    private Queue q;

    @BeforeEach
    void setUp() {
        q = new Queue();
    }

    @Test
    public void enqueueTest(){ //normalfall
        q.enqueue(1);
        q.enqueue(2);
        assertEquals(2, q.getSize(), 0);
    }

    @Test
    public void enqueueTest2(){ //fall mit gemischte operationen
        q.enqueue(1);
        q.enqueue(2);
        q.dequeue();
        q.enqueue(35);
        assertEquals(2, q.getSize(), 0);
    }

    @Test
    public void dequeueTest(){ //normalfall
        q.enqueue(1);
        q.enqueue(2);
        assertEquals(1, q.dequeue(), 0);
    }

    @Test //exceptionfall
    public void dequeueTestException(){
        assertThrows(NullPointerException.class, () ->{q.dequeue();});
    }

    @Test
    public void firstTest(){ //normalfall
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(54);
        assertEquals(1, q.first(), 0);
    }

    @Test //exceptionfall
    public void firstTestException(){
        assertThrows(NullPointerException.class, () ->{q.first();});
    }

    @Test
    public void isEmptyFalse(){ //normalfall - queue isn't empty
        q.enqueue(2);
        assertFalse(q.isEmpty());
    }

    @Test
    public void isEmptyTrue(){ //normalfall - queue is empty
        assertTrue(q.isEmpty());
    }
}