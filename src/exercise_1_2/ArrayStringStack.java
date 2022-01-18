/**
 * Class for an array based stringstack, inherits from stringstack interface
 *
 * @Author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * */


package exercise_2;

public class ArrayStringStack implements StringStack {

    private String[] stackArray = new String[0];
    /**Default constructor*/
    public ArrayStringStack(){}
    /**
     * Constructor with parameter
     *
     * @param stackArray String[]*/
    public ArrayStringStack(String[] stackArray) {
        this.stackArray = stackArray;
    }

    /**
     * Overridden method from interface for getting size
     *
     * @return size integer*/
    @Override
    public int size() {
        return this.stackArray.length;
    }

    /**
     * Overridden method for checking if the array stringstack is empty
     *
     * @return boolean*/
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Overridden method for adding a new element at the end of the stack
     *
     * @param element String
     * */
    @Override
    public void push(String element) {
        int newSize = this.size() + 1;
        String[] tmpStackArray = new String[newSize];
        for (int i = 0; i < stackArray.length; i++) {
            tmpStackArray[i] = stackArray[i];
        }
        stackArray = null;
        stackArray = tmpStackArray;
        stackArray[newSize - 1 ] = element;

    }

    /**
     * Overridden method for reducing the stack with an(1) element from the end and returning the element removed
     *
     * @return element String
     * */
    @Override
    public String pop() throws Exception {
        if(isEmpty()) {
            throw new Exception("Empty Stack");
        } else {
            int newSize = this.size() - 1;
            String element = stackArray[newSize];
            String[] tmpStackArray = new String[newSize];
            for (int i = 0; i < newSize; i++) {
                tmpStackArray[i] = stackArray[i];
            }
            stackArray = null;
            stackArray = tmpStackArray;
            return element;
        }
    }

    /**
     * Overridden method for looking at the last element in the stack
     *
     * @return element String
     * */
    @Override
    public String peek() throws Exception {
            if(isEmpty()) {
                throw new Exception("Empty Stack");
            } else {
                return stackArray[this.size() - 1];
            }
    }
}
