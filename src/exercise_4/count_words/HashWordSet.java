
/**
 * Implementation of HashWordSet from WordSet interface
 * @Author Tomas Marx-Raacz von Hidvég
 * @Version 1.0
 * @InspirationReference: Slides, Iterator implementation: http://robertovormittag.net/how-to-implement-a-simple-hashset-in-java/
 * */

package count_words;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashWordSet implements WordSet {

    private int size; // Current size
    private Node[] buckets = new Node[8];


    /** Implementation of Iterator for Hash, changed to use Nodes instead of buckets.*/
    class SimpleHashSetIterator implements Iterator {

        private int currentNode;
        private int previousNode;
        private Node currentEntry;
        private Node previousEntry;

        public SimpleHashSetIterator() {
            currentEntry = null;
            previousEntry = null;
            currentNode = -1;
            previousNode = -1;
        }

        @Override
        public boolean hasNext() {

            // currentEntry node has next
            if (currentEntry != null && currentEntry.next != null) { return true; }

            // there are still nodes
            for (int index = currentNode +1; index < buckets.length; index++) {
                if (buckets[index] != null) { return true; }
            }

            // nothing left
            return false;
        }

        @Override
        public Object next() {

            previousEntry = currentEntry;
            previousNode = currentNode;

            // if either the current or next node are null
            if (currentEntry == null || currentEntry.next == null) {

                // go to next bucket
                currentNode++;

                // keep going until you find a bucket with a node
                while (currentNode < buckets.length &&
                        buckets[currentNode] == null) {
                    // go to next bucket
                    currentNode++;
                }

                // if bucket array index still in bounds
                // make it the current node
                if (currentNode < buckets.length) {
                    currentEntry = buckets[currentNode];
                }
                // otherwise there are no more elements
                else {
                    throw new NoSuchElementException();
                }
            }
            // go to the next element in bucket
            else {

                currentEntry = currentEntry.next;
            }

            // return the element in the current node
            return currentEntry.value;

        }

    }

    /**Look above for Hashset iterator*/
    @Override
    public Iterator<Word> iterator() {
        return new SimpleHashSetIterator();
    }

    /**Inner class Node*/
    private class Node { // Private inner classes
        Word value ;
        Node next = null;

        /**inner Node constructor
         * @param word Word*/
        public Node (Word word ) {
            this.value = word;
        }
        /**inner method to return a string from the Word value
         * @return String
         * */
        public String toString () {
            return this.value.toString();
        }
    }

    /**Method for finding out which bucket in the HashSet a word should be in
     * @param word Word
     * @return int*/
    private int getBucketNumber(Word word){
        int hc = word.hashCode(); // Use hashCode() from String class
        if (hc < 0) {
            hc = -hc;
        }
        return hc % buckets.length; // Simple hash function
    }

    /**Method for resizing the HashSet Array*/
    private void rehash() {
        Node[] temp = buckets; // Copy of old buckets
        int size = temp.length*2;
        buckets = new Node[size]; // New empty buckets
        this.size = 0;
        for (Node n : temp) { // Insert old values into new buckets
            if (n == null) continue; // Empty bucket
            while (n != null ) {
                add(n.value ); // Add elements again
                n = n.next;
            }
        }
    }

    /**Overridden method for adding a Word
     * @param word Word*/
    @Override
    public void add(Word word) {
        int pos = getBucketNumber(word);
        Node node = buckets[pos]; // First node in list
        while (node != null) { // Search list
            if (node.value.equals(word)) {
                return;
            } else {
                node = node.next; // Next node in list
            }
        }
        node = new Node(word); // Not found, add new node as first entry
        node.next = buckets[pos];
        buckets[pos] = node;
        this.size++;
        if (this.size == buckets.length) rehash(); // Rehash if needed
    }

    /**Overridden method for checking if the HashSet contains a word
     * @param word Word
     * @return boolean
     * */
    @Override
    public boolean contains(Word word) {
            int checkedPosition = getBucketNumber(word);
            Node currentNode = buckets[checkedPosition];
            while (currentNode != null) { // Search list for element
                if (currentNode.value.compareTo(word) == 0) {
                    return true; // Found!
                } else {
                    currentNode = currentNode.next;
                }
            }
            return false ; // Not found
    }

    /**Overridden method for returning the size of the HashSet
     * @return int
     * */
    @Override
    public int size() {
            return this.size;
    }


    /**Overridden method for printing the HashSet
     * @return String*/
    @Override
    public String toString() {
        StringBuilder strB = new StringBuilder();
        for (int i = 0; i < this.buckets.length; i++){
            if (this.buckets[i] != null) {
                strB.append(this.buckets[i].value.toString());
                strB.append(" ");
            }
        }
        return strB.toString();
    }
}
