/** Implementation of the BinaryIntHeap
 * @Author Tomas Marx-Raacz von Hidveg
 * @version 1.0
 * @InspirationReference : https://www.geeksforgeeks.org/max-heap-in-java/  accessed 2020-08-31 @ 12:40
 * */

package binheap;


public class BinaryIntHeap {

    private int[] intArray = new int[8];
    int size = 0;

    /**Default constructor*/
    public BinaryIntHeap() {

    }

    /**Method for returning the position of the parent
     * @param pos int
     * @return int*/
    private int parent(int pos)
    {
        return pos / 2;
    }

    /**Method to return position of left child
     * @param pos int
     * @return int*/
    private int leftChild(int pos)
    {
        return (2 * pos);
    }

    /**method for returning right child position
     * @param pos int
     * @return int*/
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }

    /** Method to figure out if the position is a leaf
     * @param pos int*/
    private boolean isLeaf(int pos)
    {
        if (pos >= (this.size / 2) && pos <= this.size) {
            return true;
        }
        return false;
    }

    /** Method for swaping position between two elements
     * @param firstPos int
     * @param secondPos int*/
    private void swap(int firstPos, int secondPos)
    {
        int tmp;
        tmp = this.intArray[firstPos];
        this.intArray[firstPos] = this.intArray[secondPos];
        this.intArray[secondPos] = tmp;
    }

    /**Fixing the top position to host the highest number
     * @param pos int*/
    private void maxHeapify(int pos)
    {
        if (isLeaf(pos))
            return;

        if (this.intArray[pos] < this.intArray[leftChild(pos)] ||
                this.intArray[pos] < this.intArray[rightChild(pos)]) {

            if (this.intArray[leftChild(pos)] > this.intArray[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }
            else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    /**Method for inserting a number
     * @param number int*/
    public void insert(int number)
    {
        if (this.intArray.length  == this.size) {
            doubleArray();
        }
        this.intArray[this.size++] = number;


        // Traverse up and fix violated property
        int current = this.size-1;
        while (this.intArray[current] > this.intArray[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    /**method for returning the size of the internal arrayList
     * @return int*/
    public int size () {
        return this.size;
    }

    /**method for checking if the heap is empty
     * @return boolean
     * */
    public boolean isEmpty(){
        return this.size == 0;
    }

    /** Method for pulling the highest integer
     **/

    public void doubleArray(){
        int[] tempArray = this.intArray.clone();
        this.intArray = new int[this.intArray.length*2];
            for (int i = 0; i < tempArray.length; i++) {
                this.intArray[i] = tempArray[i];
            }

    }

    /**Method for pulling the highest number(index 0) and then putting the second highest in its place*/
    public int pullHighest() throws Exception{
        if (isEmpty()) {
            throw new Exception("The list is empty");
        } else {
            int popped = intArray[0];
            intArray[0] = intArray[--size];
            maxHeapify(0);
            return popped;
        }
    }






}


