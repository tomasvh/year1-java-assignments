/**Implementation of BST stack reconfigured from assignment-1
 * @Author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * */

package count_words;

public class BSTStack {
    private TreeWordSet.BST[] stackArray = new TreeWordSet.BST[0];
    /**Default constructor*/
    public BSTStack(){}
    /**
     * Constructor with parameter
     *
     * @param stackArray String[]*/
    public BSTStack(TreeWordSet.BST[] stackArray) {
        this.stackArray = stackArray;
    }

    /**
     * Overridden method from interface for getting size
     *
     * @return size integer*/

    public int size() {
        return this.stackArray.length;
    }

    /**
     * Overridden method for checking if the array stringstack is empty
     *
     * @return boolean*/

    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Overridden method for adding a new element at the end of the stack
     *
     * @param element String
     * */
    public void push(TreeWordSet.BST element) {
        int newSize = this.size() + 1;
        TreeWordSet.BST[] tmpStackArray = new TreeWordSet.BST[newSize];
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
    public TreeWordSet.BST pop() throws Exception {
        if(isEmpty()) {
            throw new Exception("Empty Stack");
        } else {
            int newSize = this.size() - 1;
            TreeWordSet.BST element = stackArray[newSize];
            TreeWordSet.BST[] tmpStackArray = new TreeWordSet.BST[newSize];
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
    public TreeWordSet.BST peek() throws Exception {
        if(isEmpty()) {
            throw new Exception("Empty Stack");
        } else {
            return stackArray[this.size() - 1];
        }
    }
}
