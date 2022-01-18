/**
 * Main executing class for linked queue class
 *
 * @author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * */

package exercise_5;

public class QueueMain {

    public static void main(String[] args){
        int numberOfElements = 5;
        LinkedQueue linkq = new LinkedQueue();
        System.out.println(linkq.isEmpty());
        for (int i = 0; i < numberOfElements; i++){
            linkq.enqueue((int) (Math.random()*10));
        }
        System.out.println(linkq.isEmpty());
        System.out.println(linkq.toString());
        System.out.println(linkq.size());
        linkq.enqueue(5);
        System.out.println(linkq.toString());
        System.out.println(linkq.size());
        linkq.dequeue();
        System.out.println(linkq.toString());
        System.out.println(linkq.size());



    }

}
