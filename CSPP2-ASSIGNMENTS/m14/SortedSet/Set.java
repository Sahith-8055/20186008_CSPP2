import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for set.
 * @author Sahith.
 */
public class Set {
	/**
	 * {Declaring an integer array}.
	 */
    public int[] set;

    /**
     * Declaring the size of the set.
     */
    public int size;

    /**
     * Default constructor to create an array with the szie 10.
     */
    public Set() {
    	final int number = 10;
        set = new int[number];
        size = 0;
    }

    /**
     * add the item to this set at the last.
     * If the set is full, resize the set to double
     * the size of the current set.
     * @param item to be inserted at the last.
     */
    public void add(int item) {
        if (size == set.length) {
            resize();
        }
        if (!contains(item)) {
            set[size++] = item;
        }
    }

    /**
     * resize the set by double, when it is full.
     */
    private void resize() {
        set = Arrays.copyOf(set, size * 2);
    }

    /**
     * {Add the elements to the set}.
     *
     * @param      arr   The arr
     */
    public void add(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            add(arr[i]);
        }
    }

    /**
     * {Intersection of two sets}.
     *
     * @param      other  The other
     *
     * @return     { description_of_the_return_value }
     */
    public Set intersection(Set other) {
        Set result = new Set();
        for (int i = 0; i < this.size; i++) {
            if (other.contains(this.get(i))) {
                result.add(this.get(i));
            }
        }
        return result;
    }

    /**
     * {retain all the elements}.
     *
     * @param      arr   The arr
     *
     * @return     { description_of_the_return_value }
     */
    public Set retainAll(final int[] arr) {
        Set other = new Set();
        for (int item : arr) {
            other.add(item);
        }
        return intersection(other);
    }

    /**
     * {Cartesian Product of two sets}.
     *
     * @param      other  The other
     *
     * @return     { description_of_the_return_value }
     */
    public int[][] cartesianProduct(final Set other) {
        int [][] result = new int[this.size() * other.size()][2];
        int k = -1;
        if (this.size() == 0 || other.size() == 0) {
            return null;
        }
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < other.size(); j++) {
                result[++k][0] = this.get(i);
                result[k][1] = other.get(j);
            }
        }
        return result;
    }

    /**
     * {Size method}.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }

    /**
     * {Get method}.
     *
     * @param      index  The index
     *
     * @return     {value}
     */
    public int get(final int index) {
        if (index < 0 || index >= this.size()) {
            return -1;
        } else {
            return set[index];
        }
    }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (this.size() == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < size - 1; i++) {
            sb.append(set[i] + ", ");
        }
        sb.append(set[size - 1] + "}");
        return sb.toString();
    }

    /**
     * {Check whether the element is present (or) not}.
     *
     * @param      item  The item
     *
     * @return     {Boolean value}
     */
    public boolean contains(final int item) {
        return indexOf(item) != -1;
    }

    /**
     * Searches for the first match.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int indexOf(final int item) {
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                return i;
            }
        }
        return -1;
    }
}
