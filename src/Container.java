/**
 * This program retrieves integers from a .txt file and finds
 * the maximum area if they were to form a container
 * CPSC 224-02, Spring 2018
 * Programming Assignment #3
 *
 * @author Danielle Forrest
 * @version v1.0 2/7/18
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Container {
    /**
     * computes  returns the maximum area of containers formed by two lines
     * @param contArr an arraylist of integers from txt file
     * @return  returns the maximum area of containers formed by two lines
     */
    public static int maxContainer(ArrayList<Integer> contArr){
        int maxArea = 0;
        int i = 0;
        int j = contArr.size() - 1;
        //This algorithm iterates through the arraylist and finds the maximum area by length and height
        while (i < j) {
            maxArea = Math.max(maxArea, (j - i) * Math.min(contArr.get(i), contArr.get(j)));
            if (contArr.get(i) < contArr.get(j))
                i++;
            else
                j--;
        }

        return maxArea;
    }
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> contArr = new ArrayList<>();
        File file = new File("data.txt");
        Scanner sc = new Scanner(file);
        //add numbers from file to arraylist
        while (sc.hasNextInt()) {
            contArr.add(sc.nextInt());
        }
        //check to see if arraylist has been initialized and has at least two numbers
        if (contArr == null || contArr.size() < 2) {
            System.out.println("Error in data file!");
        }else//print max area
            System.out.println("The max area is " + maxContainer(contArr));
    }


}
