import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : Sahith.
 */
class Set {
    //your code goes here...
    //Good luck :-)
    /**
     * Declaring the size of the set, an integer.
     */
    private int size;
    /**
     * {Declaring an integer array named list}.
     */
    private int[] list;

    /**
     * Constructs the object.
     */
    Set() {
        size = 0;
        final int number = 10;
        list = new int[number];
    }

    /**
     * {Method to find the size of the set}.
     *
     * @return     {Size of the set which is an integer}
     */
    public int size() {
        return size;
    }

    /**
     * {Method to resize the array dynamically}.
     */
    private void resize() {
        list = Arrays.copyOf(list, 2 * list.length);
    }

    /**
     * {Method to check if the item is present in the set}.
     *
     * @param      item  The item
     *
     * @return     {Boolean value}
     */
    public boolean contains(final int item) {
        for (int i = 0; i < size; i++) {
            if (item == list[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * {Method to add the items to a set}.
     *
     * @param      item  The item
     */
    public void add(final int item) {
        if (size > list.length) {
            resize();
        } else if (!(contains(item))) {
            list[size++] = item;
        }
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        String str = "{";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            str += list[i] + ", ";
        }
        str += list[i] + "}";
        return str;
    }

    /**
     * {Method to add the given items to the set}.
     *
     * @param      items  The items
     */
    public void add(final int[] items) {
        if (size + items.length >= list.length) {
            resize();
        }
        for (int i = 0; i < items.length; i++) {
            add(items[i]);
        }
    }

    /**
     * {Method to retrieve the item from the set}.
     *
     * @param      index  The index
     *
     * @return     {Item present at that index position}
     */
    public int get(final int index) {
        if (index < 0 || index >= size) {
            return -1;
        } else {
            return list[index];
        }
    }

    /**
     * {Method to find the intersection of two sets}.
     *
     * @param      list1  The list 1
     *
     * @return     {Another set which has the common elements}
     */
    public Set intersection(final Set list1) {
        Set set2 = new Set();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < list1.size; j++) {
                if (list[i] == list1.get(j)) {
                    set2.add(get(i));
                }
            }
        }
        return set2;
    }

    /**
     * {Method to retain all the elements of a given integer array}.
     *
     * @param      items  The items
     *
     * @return     {Set which retains the common elements}
     */
    public Set retainAll(final int[] items) {
        Set set1 = new Set();
        set1.add(items);
        return intersection(set1);
    }

    /**
     * {Method to find the cartesian product between two sets}.
     *
     * @param      list1  The list 1
     *
     * @return     {2-Dimensional Array}
     */
    public int[][] cartesianProduct(final Set list1) {
        int count = 0;
        int[][] set3 = new int[size * list1.size][2];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < list1.size; j++) {
                    set3[count][0] = get(i);
                    set3[count][1] = list1.get(j);
                    count++;
                }
            return set3;
    }
    return null;
}

}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty.
    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "size":
                System.out.println(s.size());
                break;
                case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
                case "print":
                System.out.println(s);
                break;
                case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
                case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
                case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
                default:
                break;
            }
        }
    }
}
