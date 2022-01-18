/**
 * Main exectuing class
 *
 * @Author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * */


package exercise_2;

public class StackMain {

    /**
     *Main executing method with error catching  */
    public static void main(String[] args) {

        //create a new instance
        StringStack stack = new ArrayStringStack();

        // try/catch Pushing 4 elements into and then peeking at each one
        for(int i=0; i < 4; i++ ) {
            stack.push("Student" + (i+1));
            try {
                System.out.println("Peek: " + stack.peek());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        //try/catch popping each of the 4 elements and posting them
        try {
            for(int i=0; i <= 4; i++ ) {
                System.out.println("Popped: " + stack.pop());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //try/catch pushing a new element and peeking at it
        stack.push("Student" + (5));
        try {
            System.out.println("Peek: " + stack.peek());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
