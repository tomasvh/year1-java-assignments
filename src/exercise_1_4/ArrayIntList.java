/**
 * Class implementation for an Integer Arraylist
 *
 * @author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * */

package exercise_4;

import java.util.Iterator;

public class ArrayIntList extends AbstractIntCollection implements IntList {

   public ArrayIntList () {

   }

    /**Inherits the unchanged method from AbstractIntCollection*/
    @Override
    public int size() {
        return super.size();
    }

    /**Inherits the unchanged method from AbstractIntCollection*/
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    /**Inherits the unchanged method from AbstractIntCollection*/
    @Override
    public String toString() {
        return super.toString();
    }

    /**Inherits the unchanged method from AbstractIntCollection*/
    @Override
    public Iterator<Integer> iterator() {
        return super.iterator();
    }

    /**Inherits the unchanged method from AbstractIntCollection*/
    @Override
    protected void resize() {
        super.resize();
    }

    /**Inherits the unchanged method from AbstractIntCollection*/
    @Override
    protected boolean checkIndex(int index, int upper) {
        return super.checkIndex(index, upper);
    }

    /**Inherited method from IntList interface for adding an Integer at the end of the list
     * (copied from lecture slide)
     *
     * @param n int
     * */
    @Override
    public void add(int n) {
    this.values[size++] = n;                        //add int to the index size+1
    if (this.size == this.values.length) {
        resize();                                   //if size = values.length resize
    }
    }

    /**Inherited method from IntList interface for adding an Integer at the provided index
     *
     * @param n int
     * @param index int
     * */
    @Override
    public void addAt(int n, int index) throws IndexOutOfBoundsException {
       this.size++;                                 //increase size
        if (this.size <= this.values.length) {
            resize();                               //If the new size is greater than length, resize
        }
        for(int i = this.size; i > index; i--) {
            this.values[i] = this.values[i-1];      /* From the start the size index going backwards towards the
                                                    provided index give the index the value of the one before it*/
        }
        this.values[index] = n;                     //change the number to the provided index

    }

    /**
     * Inherited method from IntList interface for removing the Integer from the provided index
     * @param index int
     * */
    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        for(int i = index; i < this.size; i++) {
            this.values[i] = this.values[i+1];      /*goes through the array from the index,
                                                    giving the index the value of the next index
                                                    */
        }
        this.size--;
    }

    /**
     * Inherited method from IntList interface for getting the Integer from the provided index
     *
     * @param index int
     * @return valueOfIndex int*/
    @Override
    public int get(int index) throws IndexOutOfBoundsException {
        int valueOfIndex = this.values[index];
        return valueOfIndex;
    }

    /**
     * Inherited method from IntList interface for getting the index of a provided Integer(if any(-1 if non))
     *
     * @param n int
     * @return answer int
     * */
    @Override
    public int indexOf(int n)  {
       int answer = -1;                         /*Arbitrary number, if nothing exists its -1, if it doesn´t exist -1
                                                */
        for (int i = 0; i < this.size; i++) {
            if (this.values[i] == n) {
                answer = i;
                break;                          /*Checking through the array, if provided int exists,
                                                 answer is changed and returned and loop is ended
                                                 (i.e returns first index)
                                                */
            }
        }
        return answer;
    }
}
