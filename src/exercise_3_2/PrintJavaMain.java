/**Class for exploring and printing facts on files in this directory
 *
 * @Author Tomas Marx-Raacz von Hidvég
 * @version 1.0*/

package exercise_2;

import java.io.File;



public class PrintJavaMain {

    private static int depth = 1;




    /**Method for printing all files and folders in the chosen directory
     * @param file File*/
    public static void printAllJavaFiles (File file) {
        if (file.isDirectory()){
            depth++;
            File [] subs = file.listFiles();
            for (File element:subs) {
                printAllJavaFiles(element);
            }
            depth--;
        }else if (file.toString().contains(".java")){
            depth++;
            System.out.println(file.getName() + " " + (file.length()/1024) +"kb");
        }

    }

    public static void main(String[] args) {

        /*Gets this directory*/
        final String dir = System.getProperty("user.dir");
        File startDir = new File(dir);

        printAllJavaFiles(startDir);



    }
}
