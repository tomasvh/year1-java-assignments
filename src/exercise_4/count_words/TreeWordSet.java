/**TreeWordSet Class implementation
 *
 * @Author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * @InspirationReference Slides
 * */

package count_words;

import java.util.Iterator;


public class TreeWordSet implements WordSet {

    private BST root = null;
    private int size = 0;

    /**Default constructor*/
    public TreeWordSet() {

    }

    /**Inner class for BST nodes*/
    protected class BST {

        private Word value;
        private TreeWordSet.BST left = null;
        private TreeWordSet.BST right = null;

        /**inner constructor with parameter
         * @param word Word*/
        public BST (Word word) {
            this.value = word;
        }

        /**inner method for adding a word
         * @param word Word*/
        public void add (Word word) {
            if (this.value.compareTo(word) > 0) {
                if (left == null) {
                    left = new TreeWordSet.BST(word);
                } else {
                    left.add(word);
                }
            } else if (this.value.compareTo(word) < 0) {
                if (right == null) {
                    right = new TreeWordSet.BST(word);
                } else {
                    right.add(word);
                }
            }
        }

        /**inner method for checking if the searchtree contains a given word
         * @param word Word
         * @return boolean
         * */
        public boolean contains( Word word) { // recursive look−up
            if (this.value.compareTo(word) > 0) { // search left branch
                if ( left == null) {
                    return false;
                } else {
                    return left.contains(word);
                }
            }
            else if (this.value.compareTo(word) < 0) { // search right branch
                if ( right == null) {
                    return false;
                } else {
                    return right.contains(word);
                }
            }
            return true; // Found!
        }
        /**inner method for printing Word values
         * @param str StringBuilder
         * @return String*/
        public String print (StringBuilder str) {
            if ( left != null ) {// visit left child
                left.print(str);
            }
            str.append(' ');
            str.append(this.value.toString()); // in−order print value
            if (right != null) {// visit right child
                right.print(str);
            }
            return str.toString();
        }
    }

    /**Inner class Binary Search Tree*/


    /**Overridden method for add
     * @param word Word
     * */
    @Override
    public void add(Word word) {
            if (root == null) {
                root = new BST(word);
                this.size++;
            } else if (!this.root.contains(word)){
                root.add(word);
                this.size++;
            }
    }

    /**Overridden method for contains
     * @param word Word
     * @return boolean*/
    @Override
    public boolean contains(Word word) {
        if (root == null) {
            return false;
        } else {
            root.contains(word);
        }
        return true;

    }

    /**Overridden method for returning the size of the TreeWordSet
     * @return int*/
    @Override
    public int size() {
        return this.size;
    }

    /**Overridden method for printing*/
    @Override
    public String toString() {
        if (root == null){
            return null;
        }

           return root.print(new StringBuilder());
    }

    /**Implementation of iterator using a selfmade implementation of Stack specified towards BSTs
     * @Inspiration: https://www.programcreek.com/2014/04/leetcode-binary-search-tree-iterator-java/
     */
 class TreeSetIterator implements Iterator {
     Word[] words;
     int current = 0;
     int size = 0;

     /**Default constructor
      * */
     public TreeSetIterator() {
         words = new Word[TreeWordSet.this.size];
         createArray(TreeWordSet.this.root);
     }

     /**Populating the array
      * @param startBST BST
      * */
     public void createArray(BST startBST) {
         if (startBST.left != null ) {// visit left child
             createArray(startBST.left);
         }
         words[size] = startBST.value;
         this.size++;
         if (startBST.right != null) {// visit right child
             createArray(startBST.right);
         }
     }

     /**Method for checking if the stack is empty*/
     @Override
     public boolean hasNext() {
         return this.current < this.size;
     }

     /**Method for finding the next*/
     @Override
     public Object next () {
         Word result = this.words[current];
         current++;
         return result;
     }





 }


     /**
      * Iterator start method
      */
     @Override
     public Iterator<Word> iterator() {
         return new TreeSetIterator();
     }
 }





