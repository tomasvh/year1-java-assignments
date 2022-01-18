/**
 * Class for LinkedQueue implementing intQueue interface
 *
 * @author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * */

package exercise_5;
import java.util.Iterator;

public class LinkedQueue implements IntQueue {

    private int size = 0;
    private Node head = null;
    private Node tail = null;

    /**
     * Default constructor
     * */
    public LinkedQueue (){

    }

    /**
     * Overridden getter for size
     *
     * @return size int
     * */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Overridden method for checking if the linkedqueue is empty
     *
     * @return boolean
     * */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Overridden method for enqueuing an element to the linkedqueue
     *
     * @param element  int
     * */
    @Override
    public void enqueue(int element) {
        Node node = new Node(element);
        if (this.isEmpty()){
            this.head = node;
            this.tail = this.head;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
            tail = node;
        }
        this.size++;
    }

    /**
     * Overridden method for dequeuing an element from the que and returning the element
     *
     * @return headValue
     * */
    @Override
    public int dequeue() {
        if (this.isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        int headValue = this.head.getValue();
        this.head = this.head.next;
        this.size--;
        return headValue;
    }

    /**
     * Overridden method for checking the first Node value of the linkedqueue
     *
     * @return  headValue int
     * */
    @Override
    public int first() {
        if (this.isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return this.head.getValue();
    }

    /**
     * Overridden method for checking the last Node value of the linkedqueue
     *
     * @return tailValue int
     * */
    @Override
    public int last() {
        if (this.isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return this.tail.getValue();
    }

    /**
     * Overridden method to iterate over the linkedqueue for use in the method toString()
     *
     * return QueueIterator
     * */
    @Override
    public  Iterator<Integer> iterator() { return new QueueIterator(); }

    /**
     * Internal class QueueIterator, implements Iterator interface
     * */
    private class QueueIterator implements Iterator<Integer> {
            private Node node = head;

            /**
             * Method for getting the value of the next Node
             * @return val integer
             * */
            public Integer next() {
                int val = node.value;
                node = node.next;
                return val ;
            }

            /**
             * Method for checking if the queue has a another Node
             * @return boolean
             * */
            public boolean hasNext() {return node != null;}
        }

    /**
     * Overridden method for printing the entire linkedqueue using StringBuilder concatenation
     *
     * @return qString String
     *  */
    @Override
    public String toString() {
        QueueIterator itr = new QueueIterator();
        StringBuilder qString = new StringBuilder();

        while(itr.hasNext()) {
            qString.append(itr.next()).append(" ");
        }
        return qString.toString();
    }

    /**
     * Internal private class Node
     * */
    private class Node {
        int value;
        Node next = null;
        Node prev = null;


        /**
         * Constructor with parameter
         *
         * @param value int
         * */
        public Node(int value) {
            this.value = value;
        }

        /**
         * method for getting the value of the node
         *
         * @return value int
         * */
        public int getValue() {
            return value;
        }
    }


}
