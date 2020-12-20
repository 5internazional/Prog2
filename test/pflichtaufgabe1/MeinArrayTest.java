//Pflichtaufgabe1_Gruppe8_Aramian(574031)_Krysenkova(573734)
package pflichtaufgabe1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeinArrayTest {

//Testen istGleich Methode

    @Test
    public void istGleichTest(){ //Happy Path
        float arr[] = {1.2f, 4.2f, 2.6f};
        float arr2[] = {1.2f, 4.2f, 2.6f};
        assertTrue(MeinArray.istGleich(arr, arr2));
    }
    @Test
    public void istGleichTestFalse(){ //Normalfall
        float arr[] = {1.2f, 4.0f, 2.6f};
        float arr2[] = {1.2f, 4.2f, 2.6f};
        assertFalse(MeinArray.istGleich(arr, arr2));
    }

    @Test
    public void istGleichTest2(){      //different size, but common values
        float[] ar1 = {2f, 3f, 4f, 7f, 1f};
        float[] ar2 = {2f, 3f, 4f, 7f};
        assertFalse(MeinArray.istGleich(ar1,ar2));
    }

    @Test
    public void istGleichNullArray(){ //grenzfall
        float[] ar1 = {};
        float[] ar2 = {};
        assertTrue(MeinArray.istGleich(ar1, ar2));
    }
    @Test
    public void istGleichNullArray2(){ //grenzfall
        float[] ar1 = {};
        float[] ar2 = {2f, 3f, 4f, 7f};
        assertFalse(MeinArray.istGleich(ar1, ar2));
    }

   // Testen sucheElem Methode
    @Test
    public void sucheElem() throws Exception { //erste element ist gesuchte element - best case
        double arr[] = {1.2, 2.2, 4.0};
        var result = MeinArray.sucheElem(1.2, arr);
        assertEquals(0, result, 0);
}

    @Test
    public void sucheElemNichtInArr() throws Exception { //Normalfall - array sortiert, element nicht in array
        double arr[] = {1.2, 2.6, 4.0};
        var result = MeinArray.sucheElem(1.3, arr);
        assertEquals(-1, result, 0);
    }
    @Test
    public void sucheElemNullArr()  { //Exception - leere array
        double arr[] = {};
        assertThrows(Exception.class, () ->{MeinArray.sucheElem(1.3, arr);});

    }

    @Test
    public void exceptionTestDouble(){ //Exception - unsortierte array
        double arr [] = {1.3, 3.1, 6.6, 17.0, 4.4, 14.4, 1.2};
        assertThrows(Exception.class, () ->{MeinArray.sucheElem(1.3, arr);});

    }


//Testen einfuegeSortiert Methode
    @Test
    public void einfuegeSortiert() throws Exception { //Normalfall - array ist sortiert, elem ist nicht in array
        int arr [] = {1, 3, 6, 17};
        int result [] = MeinArray.einfuegeSortiert(arr, 5);
        int expected[] = {1, 3, 5, 6, 17};
        assertArrayEquals(expected, result);

    }

    @Test
    public void einfuegeSortiertExistNum() throws Exception { //best case - element ist die erste in sortiertem array
        int arr [] = {1, 3, 6, 17};
        int result [] = MeinArray.einfuegeSortiert(arr, 1);
        assertArrayEquals(arr, result);

    }

    @Test
    public void einfuegeSortierInLeerArray() { //Exception - leere array
        int arr[] = {};
        assertThrows(Exception.class, () ->{MeinArray.einfuegeSortiert(arr, 9);});
    }

    @Test
    public void exceptionTestInt(){ //Exception - unsortierte Array
        int arr [] = {17, 9, 6, 4, 3,1};
        assertThrows(Exception.class, () ->{MeinArray.einfuegeSortiert(arr, 9);});

    }




    //side tests of other methods

    @Test
    public void checkIfIntSort(){ //Happy Path
        int arr [] = {1, 3, 6, 17};
        assertTrue(MeinArray.checkIfSortedInt(arr));
    }

    @Test
    public void checkIfSortIntFalse(){
        int arr [] = {1, 3, 6, 17, 4, 14, 1};
        assertFalse(MeinArray.checkIfSortedInt(arr));
    }

    @Test
    public void checkIfSortDoubleFalse(){
        double arr [] = {1.3, 3.1, 6.6, 17.0, 4.4, 14.4, 1.2};
        assertFalse(MeinArray.checkIfSortedDouble(arr));
    }


    @Test
    public void checkIfSortDouble(){ //Happy Path
        double arr [] = {1.3, 3.1, 6.6, 17.0};
        assertTrue(MeinArray.checkIfSortedDouble(arr));
    }




    


}