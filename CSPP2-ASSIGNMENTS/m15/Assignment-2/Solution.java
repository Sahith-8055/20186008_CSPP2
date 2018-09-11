import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for sorted set.
 * @author Sahith.
 */
final class SortedSet extends Set {

    /**
     * {Sort Method}.
     *
     * @param      array  The array
     */
    public void sort(final int[] array) {
        int temp;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * {Add method}.
     *
     * @param      item  The item
     */
    public void add(final int item) {
        if (!contains(item)) {
            set[size++] = item;
        }
        sort(set);
    }

    /**
     * Exception for signaling invalid subset selection errors.
     */
    class InvalidSubsetSelectionException extends Exception {
        InvalidSubsetSelectionException(String s) {
            super(s);
        }
    }

    /**
     * {Subset of a given set}.
     *
     * @param      fromElement   The from element
     * @param      toElement     To element
     *
     * @return     {Integer array}.
     *
     * @throws     InvalidSubsetSelectionException  {User-defined Exception}.
     */
    public int[] subSet(final int fromElement, final int toElement)
    throws InvalidSubsetSelectionException {
        if (fromElement > toElement) {
            throw new InvalidSubsetSelectionException(
                "Invalid Arguments to Subset Exception");
        }
        int[] result = new int[size];
        int k = 0;
        for (int i = 0; i < size; i++) {
            if (set[i] >= fromElement) {
                for (int j = i; j < size; j++) {
                    if (set[j] < toElement) {
                        result[k++] = set[i];
                    }
                    break;
                }
            }
        }
        return Arrays.copyOf(result, k);
    }
    /**
     * Exception for signaling set empty errors.
     */
    class SetEmptyException extends Exception {
        SetEmptyException(String s) {
            super(s);
        }
    }

    /**
     * {Method to find the highest number}.
     *
     * @param      toElement          To element
     *
     * @return     {Integer array}
     *
     * @throws     SetEmptyException  {User-defined Exception}.
     */
    public int[] headSet(final int toElement) throws SetEmptyException {
        int temp = 0;
        int[] result = new int[size];
        if (result.length > 0) {
        for (int i = 0; i < size(); i++) {
            if (set[i] < toElement) {
                result[i] = set[i];
                temp++;
            }
        }
        if (result.length <= 0) {
            throw new SetEmptyException("Set Empty Exception");
        }
    }
    return Arrays.copyOf(result, temp);
}

    /**
     * {Method to find the last element}.
     *
     * @return     {Highest value in the set}
     */
    public int last() throws SetEmptyException {
        if (size == 0) {
            throw new SetEmptyException("Set Empty Exception");
        }
        return set[size - 1];
    }

    /**
     * Adds all the elements.
     *
     * @param      element   The element
     */
    public void addAll(final int[] element) {
        for (int i : element) {
            this.add(i);
        }
    }
}
/**
 * Solution class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty.
    }

    /**
     * {Method to print integer array}.
     *
     * @param      s     {String}.
     *
     * @return     {Integer array}.
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
     * {Main method}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        SortedSet s = new SortedSet();
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
                s = new SortedSet();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
            case "retainAll":
                s = new SortedSet();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
            case "subSet":
                try {
                    if (tokens.length != 2) {
                    break;
                }
                    String[] arrstring3 = tokens[1].split(",");
                    int[] object = s.subSet(Integer.parseInt(arrstring3[0]),
                                        Integer.parseInt(arrstring3[1]));
                    if (object != null) {
                        System.out.println(Arrays.toString(object).replace("[",
                            "{").replace("]", "}"));
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "headSet":
                try {
                   if (tokens.length != 2) {
                    break;
                }
                    int[] obj = s.headSet(Integer.parseInt(tokens[1]));
                    if (obj != null) {
                        System.out.println(Arrays.toString(obj).replace("[",
                            "{").replace("]", "}"));
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "last":
                try {
                   if (tokens.length != 1) {
                    break;
                }
                    int temp = s.last();
                    System.out.println(temp);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "addAll":
                int[] intArr = intArray(tokens[1]);
                if (intArr.length == 1) {
                    s.add(intArr[0]);
                } else {
                    s.add(intArr);
                }
                break;
            default:
                break;
            }
        }
    }
}


