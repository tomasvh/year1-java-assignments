/**
 * Class implementation of a Array based stack for integers
 *
 * @author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * */

package exercise_4;

import java.util.Iterator;

public class ArrayIntStack extends AbstractIntCollection implements IntStack {

    public ArrayIntStack() {

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

    /**Inherited method from Intstack interface for pushing an Integer to the stack
     *
     * @param n int
     * */
    @Override
    public void push(int n) {
        this.size++;                                //increase size
        if (this.size == this.values.length) {      //if size is equal to length, resize
            resize();
        }
        for (int i = this.size; i > 0; i--) {
            this.values[i] = this.values[i-1];      /*beginning from the back, give the index the value of the
                                                    index before it.*/
        }
        this.values[0] = n;                         //change index 0 to the value provided
    }

    /**Inheritec method from Intstack interface to pop a integer from the stack
     *
     * @return answer int
     * */
    @Override
    public int pop() throws IndexOutOfBoundsException {
        int index = 0;                              //Starting index
        int answer = this.values[0];                //give the parameter the value of the index to be popped
        for(int i = index; i < this.size; i++) {
            this.values[i] = this.values[i+1];      /*change the value for each index to the value of the one
                                                    after it */
        }
        this.size--;
        return answer;                              //Decrease size by 1 and return the popped value
    }

    /**
     * Inherited method from Intstack interface to peek at the first element in the stack
     * @return int
     * */
    @Override
    public int peek() throws IndexOutOfBoundsException {
        return this.values[0];
    }
}
