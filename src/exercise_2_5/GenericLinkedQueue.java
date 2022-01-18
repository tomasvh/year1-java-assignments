/**Implementation of a GenericLinkedQueue
 *
 * @Author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * */

package exercise_5;

import java.util.Iterator;

public class GenericLinkedQueue<T> implements Queue<T> {

        private int size = 0;
        private Node head = null;
        private Node tail = null;

    /**Overridden Getter for size
     * @return size int
     * */
        @Override
        public int size() {
            return this.size;
        }

    /**Method for checking if the GenericLinkedQueue is empty
     *
     * @return boolean
     * */
        @Override
        public boolean isEmpty() {
            return this.size == 0;
        }

        /**Overridden method for enqueuing an object
         *
         * @param o Generic object
         * */
        @Override
        public void enqueue(T o) {
            Node node = new Node(o);
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

        /**Overridden method for dequeueing an object
         *
         * @return Generic Object
         * */
        @Override
        public T dequeue() {
            if (this.isEmpty()){
                throw new IndexOutOfBoundsException();
            }
            T headValue = this.head.getValue();
            this.head = this.head.next;
            this.size--;
            return headValue;
        }

        /**Method for getting the value of the first node(head)
         *
         * @return value of head node
         * */
        @Override
        public T first() {
            if (this.isEmpty()){
                throw new IndexOutOfBoundsException();
            }
            return this.head.getValue();
        }

        /**Overridden method for getting value of the last node(tail)
         *
         * @return  value of tail node
         * */
        @Override
        public T last() {
            if (this.isEmpty()){
                throw new IndexOutOfBoundsException();
            }
            return this.tail.getValue();
        }

        /**Overridden method for creating an iterator for the GenericLinkedQueue
         * @return QueueIterator
         * */
        @Override
        public Iterator<T> iterator() { return new QueueIterator(); }

        private class QueueIterator implements Iterator<T> {
            private Node node = head;
            public T next() {
                T val = node.value;
                node = node.next;
                return val ;
            }
            public boolean hasNext() {return node != null;}
        }

        /**Overridden method to print the entire GenericLinkedQueue*/
        @Override
        public String toString() {
            QueueIterator itr = new QueueIterator();
            StringBuilder qString = new StringBuilder();

            while(itr.hasNext()) {
                qString.append(itr.next()).append(" ");
            }
            return qString.toString();
        }

        /**Inner class Node with constructor and getter for value*/
        private class Node {
            T value;
            Node next = null;
            Node prev = null;

            /**Constructor with Generic value
             * @param value Generic Object
             * */
            public Node(T value) {
                this.value = value;
            }

            /**Getter for the value of the Generic object in the node
             *
             * @return value Generic Object*/
            public T getValue() {
                return value;
            }
        }


}

