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
     * Default constructor to create an array with the size 10.
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
     * @return     {Set of common elements}.
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
     * @return     {Set of all the retained elements}.
     */
    public Set retainAll(final int[] arr) {
        Set other = new Set();
        for (int item : arr) {
            other.add(item);
        }
        return intersection(other);
    }

    /**
     * {Size method}.
     *
     * @return     {Size of the set}.
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
     * @return     {Index value}.
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
