/**Implementation of LinkedQueue class*/

package exercise_4;
import java.util.Iterator;

public class LinkedQueue implements IntQueue {

    private int size = 0;
    private Node head = null;
    private Node tail = null;

    /**Overridden getter for size
     *
     * @return size int
     * */
    @Override
    public int size() {
        return this.size;
    }

    /**Overridden method for checking if the LinkedQueue is empty
     *
     * return boolean
     * */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**Overridden method for enqueueing an element
     *
     * @param element int
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

    /**Overridden method for dequeueing an element from LinkedQueue and returning it
     *
     * @return headValue int
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

    /**Overridden method for getting the value of the first node in the LinkedQueue
     *
     * @return head.value int
     * */
    @Override
    public int first() {
        if (this.isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return this.head.getValue();
    }

    /**Overridden method for getting the value of the last node in the LinkedQueue
     *
     * @return tail.value int
     * */
    @Override
    public int last() {
        if (this.isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return this.tail.getValue();
    }

    /**Overridden method to create an iterator over the LinkedQueue
     *
     * @return QueueIterator
     * */
    @Override
    public  Iterator<Integer> iterator() { return new QueueIterator(); }

    private class QueueIterator implements Iterator<Integer> {
            private Node node = head;
            public Integer next() {
                int val = node.value;
                node = node.next;
                return val ;
            }
            public boolean hasNext() {return node != null;}
        };

    /**Overridden method to print the LinkedQueue
     *
     * @return String*/
    @Override
    public String toString() {
        QueueIterator itr = new QueueIterator();
        StringBuffer qString = new StringBuffer();

        while(itr.hasNext()) {
            qString.append(itr.next()+" ");
        }
        return qString.toString();
    }

    /**Inner class for node including constrctor and getter for value*/
    private class Node {
        int value;
        Node next = null;
        Node prev = null;


        /**Constructor with parameter
         *
         * @param value int
         * */
        public Node(int value) {
            this.value = value;
        }

        /**Getter for node value
         *
         * @return value int
         * */
        public int getValue() {
            return value;
        }
    }


}
