package exercise_5;

import exercise_4.LinkedQueue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GenericLinkedQueueTest<T> {

    /**Helper method to build a Linked queue
     *
     * @param size
     * @return list GenericLinkedQueue<String>
     */
    private GenericLinkedQueue<String> build (int size) {
        GenericLinkedQueue<String> list = new GenericLinkedQueue<>();
        for (int i = 0; i < size; i++) {
            list.enqueue("lars " + i);

        }
        return list;
    }

    /**Helper method to generate a specific number of numbers from 0 to max
     *
     * @param size int
     * @param max int
     *
     * @return list GenericLinkedQueue<Integer>
     *     */
    private GenericLinkedQueue<Integer> random(int size,int max) {
        Random rand = new Random();
        GenericLinkedQueue<Integer> list = new GenericLinkedQueue<>();
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

    /**Test for Enqueue and Dequeue methods*/
    @Test
    public void testSizeEnqueueDequeue() {
        GenericLinkedQueue<String> list1 = build(5);
        list1.enqueue("Ture");
        assertEquals(6, list1.size());

        GenericLinkedQueue<Integer> list2 = random(10, 10000);
        list2.enqueue(5);
        assertEquals(11, list2.size());
        list2.dequeue();
        assertEquals(10, list2.size());

        GenericLinkedQueue<T> list3 = new GenericLinkedQueue<>();
        assertThrows(IndexOutOfBoundsException.class, list3::dequeue);
    }

    /**Test to check if the isEmpty method works*/
    @Test public void testIsEmpty () {
        GenericLinkedQueue<String> list1 = build(5);
        assertFalse(list1.isEmpty());

        LinkedQueue list2 = new LinkedQueue();
        assertTrue(list2.isEmpty());
    }
    /**Test for method to check the first and last element of the GenericLinkedQue*/
    @Test public void testfirstLast () {
        GenericLinkedQueue<String> list1 = build(5);
        assertEquals("lars 0", list1.first());
        assertEquals("lars 4", list1.last());


        GenericLinkedQueue<T> list2 = new GenericLinkedQueue<>();
        assertThrows(IndexOutOfBoundsException.class, list2::first);
        assertThrows(IndexOutOfBoundsException.class, list2::last);
    }



}