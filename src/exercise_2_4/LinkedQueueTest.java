/**Test suite for LinkedQueue*/

package exercise_4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


public class LinkedQueueTest {

    /**Helper method for building the LinkedQueues
     *
     * @param size int
     * */
    private LinkedQueue build (int size) {
        LinkedQueue list = new LinkedQueue();
        for (int i = 0; i < size; i++) {
            list.enqueue(i);

        }
        return list;
    }

    /**Helper method to randomly populating LinkedQueues
     *
     * @param size int
     * @param max int
     * */
    private LinkedQueue random(int size,int max) {
        Random rand = new Random();
        LinkedQueue list = new LinkedQueue();
        for (int i=0;i<size;i++) {
            int n = 1 + rand.nextInt(max);
            list.enqueue(n);
        }
        return list;
    }

    private static int count = 0;
    /* Executed before every test method. */
    @BeforeEach
    public void setUp() {
        System.out.println("Run test method: "+(++count));
    }
    /* Executed after every test method. */
    @AfterEach
    public void tearDown() {
        System.out.println(" --- done with test "+count);
    }

    /**Test case for Enqueue and Dequeue methods*/
    @Test public void testSizeEnqueueDequeue() {
        LinkedQueue list1 = build(5);
        list1.enqueue(5);
        assertEquals(6, list1.size());

        LinkedQueue list2 = random(10, 10000);
        list2.enqueue(5);
        assertEquals(11, list2.size());
        list2.dequeue();
        assertEquals(10, list2.size());

        LinkedQueue list3 = new LinkedQueue();
        assertThrows(IndexOutOfBoundsException.class, list3::dequeue);
    }

    /**Test cases for isEmpty method*/
    @Test public void testIsEmpty () {
        LinkedQueue list1 = build(5);
        assertFalse(list1.isEmpty());

        LinkedQueue list2 = new LinkedQueue();
        assertTrue(list2.isEmpty());
    }

    /**Test case for method accessing first and last node in LinkedQueue*/
    @Test public void testfirstLast () {
        LinkedQueue list1 = build(5);
        assertSame(0, list1.first());
        assertSame(4, list1.last());


        LinkedQueue list2 = new LinkedQueue();
        assertThrows(IndexOutOfBoundsException.class, list2::first);
        assertThrows(IndexOutOfBoundsException.class, list2::last);
    }



}