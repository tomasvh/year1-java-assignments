/**
 * Main executing class for linked queue class
 *
 * @author Tomas Marx-Raacz von Hidvég
 * @version 1.0
 * */

package exercise_4;

public class CollectionsMain {

    public static void main(String[] args){
        ArrayIntList ourAIL = new ArrayIntList();
        ArrayIntStack ourAIS = new ArrayIntStack();

        for (int i = 0; i < 8; i++ ){
            int num = (int) (Math.random()*10) + 1;
            ourAIL.add(num);
            ourAIS.push(num);
        }

        System.out.println(ourAIL.toString() + "\n" + ourAIS.toString());

        ourAIL.add(6);
        ourAIS.push(6);

        System.out.println(ourAIL.toString() + "\n" + ourAIS.toString());

        System.out.println("get index 5 before remove: " + ourAIL.get(5));
        ourAIL.remove(5);
        System.out.println("get index 5 after remove: " + ourAIL.get(5));
        System.out.println("peek before pop: " + ourAIS.peek());
        ourAIS.pop();
        System.out.println("peek after pop: " + ourAIS.peek());
        System.out.println(ourAIL.toString() + "\n" + ourAIS.toString());
        System.out.println(ourAIL.indexOf(5));
        System.out.println(ourAIL.indexOf(11));
        ourAIL.addAt(4, 4);
        System.out.println(ourAIL.toString());
        System.out.println(ourAIL.get(4));

    }
}
