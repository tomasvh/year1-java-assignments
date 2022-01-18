import binheap.BinaryIntHeap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class testBinaryIntHeap {

    private int count = 1;
    /* Executed before every test method. */
    @BeforeEach
    public void setUp() {
        System.out.println("Run test method: "+(count));
    }

    /* Executed after every test method. */
    @AfterEach
    public void tearDown() {
        System.out.println(" --- done with test " + count);
        count++;
    }


    public int randomNumber() {
        Random randomNumber = new Random();
        return randomNumber.nextInt(1000);
    }

    int numberOfNumbers = 10;



    BinaryIntHeap binaryIntHeap = new BinaryIntHeap();

    @Test public void testBinaryHeap() {

        assertTrue(binaryIntHeap.isEmpty());
        binaryIntHeap.insert(55);
        binaryIntHeap.insert(44);
        binaryIntHeap.insert(33);
        binaryIntHeap.insert(22);
        binaryIntHeap.insert(11);
        binaryIntHeap.insert(23);
        binaryIntHeap.insert(43);
        binaryIntHeap.insert(33);
        binaryIntHeap.insert(13);
        binaryIntHeap.insert(53);


        assertFalse(binaryIntHeap.isEmpty());
        assertEquals(10, binaryIntHeap.size());
        try {
            assertEquals(55, binaryIntHeap.pullHighest());
        } catch (Exception e) {
            System.out.println(e);
        }


    }



    @Test public void testBinaryHeap2() {

        binaryIntHeap.insert(1);
        binaryIntHeap.insert(2);
        binaryIntHeap.insert(3);
        binaryIntHeap.insert(4);
        binaryIntHeap.insert(5);
        binaryIntHeap.insert(6);
        binaryIntHeap.insert(7);
        binaryIntHeap.insert(8);

        int expectedNumber = 8;
        while (!binaryIntHeap.isEmpty()) {
            try {
                assertEquals(expectedNumber, binaryIntHeap.pullHighest());
                expectedNumber--;
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
}
