import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 *@author : Sahith.
 * List of Integers.
 */
public class Solution {
    /**
     * {list as integer array}.
     */
    private int[] list;
    /**
     * size variable.
     */
    private int size;

    /**
     * The purpose of the constructor is to initialize the class variables with
     * some default values.
     */
    public Solution() {
        final int number = 1;
        list = new int[number];
        size = 0;
    }

    /**
     * Constructs the object.
     *
     * @param      capacity  The capacity
     */
    public Solution(final int capacity) {
        list = new int[capacity];
        size = 0;
    }
    /**
     * The add method does what the name suggests. Add an int item to the list.
     * The assumption is to store the item at the end of the list What is the
     * end of the list? Is it the same as the end of the array? Think about how
     * you can use the size variable to add item to the list.
     *
     * The method returns void (nothing)
     *
     * @param      item  The item
     */
    public void add(final int item) {
        if (list.length == size) {
            resize();
        }
        list[size++] = item;
    }

    /**
     * method to resize the array.
     */
    private void resize() {
        list = Arrays.copyOf(list, 2 * size);
    }
    /**
     * The size method returns the value of the size. The purpose of the method
     * is to announce the size of the list to the objects outside the list
     *
     * The method returns an int. Empty list should return 0.
     *
     * @return     integer value.
     */
    public int size() {
        return size;
    }
    /**
     * The remove method does what the name suggests. Removes an int item,
     * specified by the index argument, from the list It also does an additional
     * step. Think about what happens when an item is removed from the middle of
     * the list It creates a hole in the list, right? This would mean, all the
     * items that are to the right side of the removed item should be moved to
     * the left by one position. Here is an example: array =
     * [1,2,3,0,0,0,0,0,0,0] remove(1) would remove the item 2 which is at index
     * position 1. But how do you remove the item from an array? Well, the way
     * to remove it is to move all the items, that are to the right of the
     * removed item, to the left So, the new array looks like this. array =
     * [1,3,0,0,0,0,0,0,0,0] The method returns void (nothing)
     *
     * [1,2,3,4,5] remove(2) [1,2,4,5]
     */

    /**
     * {Method to remove an element}.
     *
     * @param      index      The index
     *
     * @throws     Exception  {Exception class}
     */
    public void remove(final int index) throws Exception {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                list[i] = list[i + 1];
            }
            size--;
        } else {
            throw new Exception("Invalid Position Exception");
        }
    }
    /**
     * Get method has to return the items that is at the index position passed
     * as an argument to the method. If the item doesn't exist then return a -1
     * to indicate that there is no element at that index. How can an element
     * not be there at a given position? Well, if the position is greater than
     * the number of items in the list then that would mean the item doesn't
     * exist. How do we check if the position is greater than the number of
     * items in the list? Would size variable be useful?
     *
     * @param      index  The index
     *
     * @return     {Value of the index}.
     */
    public int get(final int index) {
        if (index >= 0 && index < size) {
            return list[index];
        }
        return -1;
    }
    /**
     * What happens when you print an object using println? Java provides a
     * method named toString that is internally invoked when an object variable
     * is used in println. For example: List l = new List();
     * System.out.println(l); This statement is a shortcut for
     * System.out.println(l.toString());
     *
     * So, implement the toString method to display the items in the list in the
     * square brackets notation. i.e., if the list has numbers 1, 2, 3 return
     * the string [1,2,3] Caution: The array may be having other elements
     * Example: [1,2,3,0,0,0,0,0,0,0] toString should only return the items in
     * the list and not all the elements of the array.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        // Replace the code below
        if (size == 0) {
            return "[]";
        }
        String toPrint = "[";
        int i;
        for (i = 0; i < size() - 1; i++) {
            toPrint = toPrint + list[i] + ",";
        }
        return toPrint + list[i] + "]";
    }
    /**
     * {Method to count the number of times the item is present in the list}.
     *
     * @param      item  The item
     *
     * @return     {Count of the item which is an integer}.
     */
    public int count(final int item) {
        int flag = 0;
        for (int element : list) {
            if (element == item) {
                flag++;
            }
        }
        return flag;
    }
    /**
     * Contains return true if the list has the item passed as an argument to
     * the method So, iterate through the list and return true if the item
     * exists and otherwise false.
     *
     * @param      item  The item
     *
     * @return     {Boolean value}.
     */
    public boolean contains(final int item) {
        // Replace the code below
        return indexOf(item) != -1;
    }
    /**
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element.
     *
     * @param      item  The item
     *
     * @return     {Index value}.
     */
    public int indexOf(final int item) {
        // Replace the code below
        for (int i = 0; i < size(); i++) {
            if (item == get(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Adds all the elements.
     *
     * @param      newArray  The new array
     */
    public void addAll(final int[] newArray) {
        for (int i = 0; i < newArray.length; i++) {
            add(newArray[i]);
        }
    }

    /**
     * Removes all the elements.
     *
     * @param      newArray   The new array
     *
     * @throws     Exception  {Exception class}
     */
    public void removeAll(final int[] newArray) throws Exception {
        for (int i = 0; i < newArray.length; i++) {
            int index = indexOf(newArray[i]);
            while (index != -1) {
                remove(i);
                index = indexOf(newArray[i]);
            }
        }
    }
    /**
     Return null and print "Index Out of Bounds Exception" if start and end
     parameters are invalid eg: [3, 2] start is greater than the end [-3, 4]
     start and end are negative If List has one Element [1, 3] is Out of Bounds,
     as size is One Given an empty list [0, 0] is Out of Bounds, as size is zero
     Caution: If size > 0 and start and end are equal then sublist is empty.
    */

    /**
     * {Method for sublist}.
     *
     * @param      start      The start
     * @param      end        The end
     *
     * @return     {List}
     *
     * @throws     Exception  {Exception class}
     */
    public Solution subList(final int start, final int end) throws Exception {
        if (start >= end || start > size || end > size) {
            throw new Exception("Index Out of Bounds Exception");
        } else if (start < 0 || end < 0) {
            throw new Exception("Index Out of Bounds Exception");
        }
        Solution newList = new Solution(end - start);
        for (int i = start; i < end; i++) {
            newList.add(this.get(i));
        }
        return newList;
    }
    /**
    Returns a boolean indicating whether the parameter i.e a List object is
    exactly matching with the given list or not.
    @param      other  The other
    @return     {Boolean value}
    */
    public boolean equals(final Solution other) {
        return other.toString().equals(this.toString());
    }
    /**
    * Removes all the elements from list
    * Think about this case and make the method
    * the simpler.
    */
    public void clear() {
        size = 0;
    }

    /**
     * main method to drive program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Solution l = new Solution();
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        while (stdin.hasNext()) {
            String line = stdin.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
                case "add":
                    if (tokens.length == 2) {
                        String[] t = tokens[1].split(",");
                        if (t.length == 1) {
                            l.add(Integer.parseInt(tokens[1]));
                        }
                    }
                break;
                case "size":
                    System.out.println(l.size());
                break;
                case "print":
                    System.out.println(l);
                break;
                case "remove":
                    try {
                      if (tokens.length == 2) {
                        l.remove(Integer.parseInt(tokens[1]));
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

                break;
                case "indexOf":
                    if (tokens.length == 2) {
                        System.out.println(l.indexOf(
                            Integer.parseInt(tokens[1])));
                    }
                break;
                case "get":
                    if (tokens.length == 2) {
                        System.out.println(l.get(
                            Integer.parseInt(tokens[1])));
                    }
                break;
                case "contains":
                    if (tokens.length == 2) {
                        System.out.println(l.contains(
                            Integer.parseInt(tokens[1])));
                    }
                break;
                case "count":
                System.out.println(l.count(
                    Integer.parseInt(tokens[1])));
                break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        int[] temp = new int[t1.length];
                        for (int i = 0; i < temp.length; i++) {
                            temp[i] = Integer.parseInt(t1[i]);
                        }
                        l.addAll(temp);
                    }
                break;
                case "removeAll":
                    try {
                        if (tokens.length == 2) {
                            String[] t2 = tokens[1].split(",");
                            int[] a = new int[t2.length];
                            for (int i = 0; i < t2.length; i++) {
                                a[i] = Integer.parseInt(t2[i]);
                            }
                            l.removeAll(a);
                        }
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                break;
                case "subList":
                    try {
                        if (tokens.length != 2) {
                        break;
                    }
                        String[] arrstring3 = tokens[1].split(",");
                        Solution object = l.subList(
                            Integer.parseInt(arrstring3[0]),
                            Integer.parseInt(arrstring3[1]));
                        if (object != null) {
                            System.out.println(object);
                        }
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                break;
                case "equals":
                    if (tokens.length == 2) {
                        String[] lt = tokens[1].split(",");
                        Solution l2 = new Solution();
                        for (int k = 0; k < lt.length; k++) {
                            l2.add(Integer.parseInt(lt[k]));
                        }
                        System.out.println(l.equals(l2));
                    }
                break;
                case "clear":
                    l.clear();
                break;
                default:
                break;
            }
        }
    }
}
