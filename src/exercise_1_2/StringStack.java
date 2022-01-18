/**
 * Interface for a stringstack (last in, first out(LiFo)
 *
 * Copied from assignment
 * */


package exercise_2;

public interface StringStack {
    int size(); 			// Current stack size
    boolean isEmpty(); 		// true if stack is empty
    void push(String element); 	// Add element at top of stack
    String pop() throws Exception; 		// Return and remove top element, exception if stack is empty
    String peek() throws Exception; 		// Return (without removing) top element, exception if stack is empty.
    }