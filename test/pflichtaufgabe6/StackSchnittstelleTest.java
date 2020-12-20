package pflichtaufgabe6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class StackSchnittstelleTest {

    private Stack s1;


    @BeforeEach
    void setUp() {
        s1 = new Stack();
    }


    @Test
    public void pushTest(){ //normalfall
        s1.push(1);
        s1.push(5);
        assertEquals(2, s1.getSize(), 0);
    }

    @Test
    public void pushTest2(){ //fall mit gemischte operationen
        s1.push(426);
        s1.push(345);
        s1.pop();
        s1.push(243);
        assertEquals(2, s1.getSize(), 0);
    }

    @Test
    public void popTest(){ //normalfall
        s1.push(1);
        s1.push(5);
        assertEquals(5,  s1.pop(), 0);
    }

    @Test //exceptionfall
    public void popTestException(){
        assertThrows(EmptyStackException.class, () ->{s1.pop();});
    }

    @Test
    public void topTest(){ //normalfall
        s1.push(1);
        s1.push(573);
        s1.push(-1);
        s1.push(5);
        assertEquals(5, s1.top(), 0);
    }

    @Test//exceptionfall
    public void topTestException(){
        assertThrows(EmptyStackException.class, () ->{s1.top();});
    }

    @Test //normalfall - stack is empty
    public void isEmptyTrue(){
        assertTrue(s1.isEmpty());
    }

    @Test //normalfall - stack isn't empty
    public void isEmptyFalse(){
        s1.push(1);
        s1.push(5);
        assertFalse(s1.isEmpty());
    }
}