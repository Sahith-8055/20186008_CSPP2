import java.util.Arrays;
/*
     * The goal for the list is to store items.
     * How are we going to store the items in the list?
     * An array would be good. Right?
     * So, when we do not what we are going to have in the list
     * We need to create a Generic list to store the items

     * Here E is a type parameter, and it will be replaced with
        actual type when the object got created.
     */

/**
 * Class List.
 *
 * @param      <E>   {Parameter which will be replaced when real object is created}.
 */
public class List<E> {
    /**
     * {Declaring an Array of type E}.
     */
    private E[] list;
    /**
     * {Declaring an integer variable size}.
     */
    private int size;
    //Constructor

    /**
     * Constructs the object.
     */
    public List() {
        // Create a variable of the type Object[]
        list = ((E[])new Object[10]);
        //Object is the base class for all the classes
        size = 0;
    }
    //Overloaded Constructor

    /**
     * Constructs the object.
     *
     * @param      param  The parameter
     */
    public List(int param) {
        list = ((E[])new Object[param]);
        size = 0;
    }
    /* The add method does what the name suggests.
     * Add a generic type item to the list.
     * The assumption is to store the item at the end of the list
     * What is the end of the list?
     * Is it the same as the end of the array?
     * Think about how you can use the size variable to add item
     * to the list.
     */

    /**
     * {Method to add an item to the list}.
     *
     * @param      item  The item
     */
    public void add(E item) {
        //Inserts the specified element at the end of the list.
        //You can modify the code in this method.
        if (size == list.length) {
            resize();
        }
        list[(size++)] = item;
    }
    /*Inserts all the elements of specified int
    array to the end of list*/

    /**
     * Method to add all the items to the end of the list.
     *
     * @param      items  The items
     */
    public void addAll(E[] items) {
        //Write logic for addAll method
        for (E element : items) {
            add(element);
        }
    }
    /**
     * {Method to resize the given list}.
     */
    private void resize() {
        list = Arrays.copyOf(list, 2 * list.length);
    }

    /*
     * The size method returns the value of the size.
     * The purpose of the method is to announce the size of the list
     * to the objects outside the list
     *
     * The method returns an int. Empty list should return 0.
     */

    /**
     * {Method to find the size of the list}.
     *
     * @return     {Size of the list, an integer type}.
     */
    public int size() {
        return size;
    }
    /*
     * The remove method does what the name suggests.
     * Removes a String item, specified by the index argument, from the list
     * It also does an additional step.
     * Think about what happens when
     * an item is removed from the middle of the list
     * It creates a hole in the list, right?
     * This would mean, all the items that are
     * to the right side of the removed item should be
     * moved to the left by one position.
     * Here is an example:
     * array = [1,2,3,0,0,0,0,0,0,0]
     * remove(1) would remove the item 2 which is at index position 1.
     * But how do you remove the item from an array?
     * Well, the way to remove it is to move all
     * the items, that are to the right of the removed item, to the left
     * So, the new array looks like this.
     * array = [1,3,0,0,0,0,0,0,0,0]
     * The method returns void (nothing)
     */

    /**
     * {Method to remove an item from an index position}.
     *
     * @param      index  The index
     */
    public void remove(int index) {
        //Write logic for remove method
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                list[i] = list[i + 1];
            }
            size--;
        } else {
            System.out.println("Invalid Position Exception");
        }
    }
    /*
     * Get method has to return the items that is
     * at the index position passed as an argument to the method.
     * If the item doesn't exist then return a -1 to indicate that
     * there is no element at that index.
     * How can an element not be there at a given position?
     * Well, if the position is greater than the number of items
     * in the list then that would mean the item doesn't exist.
     * How do we check if the position is greater than the
     * number of items in the list? Would size variable be useful?
     */

    /**
     * {Method to get the element at a particular index position}.
     *
     * @param      index  The index
     *
     * @return     {Value, which is of type E}.
     */
    public E get(int index) {
         //Write logic for get method
        if (index < 0 || index >= size) {
            return null;
        } else {
            return list[index];
        }
    }
    /*
     * What happens when you print an object using println?
     * Java provides a method named toString that is internally
     * invoked when an object variable is used in println.
     * For example:
     * List l = new List();
     * System.out.println(l);
     * This statement is a shortcut for
     * System.out.println(l.toString());
     *
     * So, implement the toString method to display the items
     * in the list in the square brackets notation.
     * i.e., if the list has numbers 1, 2, 3
     * return the string [1,2,3]
     * Caution: The array may be having other elements
     * Example: [1,2,3,0,0,0,0,0,0,0]
     * toString should only return the items in the list and
     * not all the elements of the array.
     *
     */

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            str = str + list[i] + "\n";
        }
        str = str + list[i];
        return str;
    }
    /*
     * Contains return true if the list has
     * the item passed as an argument to the method
     * So, iterate through the list and return true if
     * the item exists and otherwise false
     */

    /**
     * {Method to check whether the item is present in the list}.
     *
     * @param      item  The item
     *
     * @return     {Boolean Value}.
     */
    public boolean contains(E item) {
        //Write logic for contains method
        boolean check = false;
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                check = true;
            }
        }
        return check;
    }
    /*
     * Returns the index of the first occurrence
     * of the specified element in this list,
     * or -1 if this list does not contain the element.
     */

    /**
     * Searches for the first match.
     *
     * @param      item  The item
     *
     * @return     {Index value, which is an integer}.
     */
    public int indexOf(E item) {
       //Write logic for indexOf method
        for (int i = 0; i < size; i++) {
            if (item.equals(list[i])) {
                return i;
            }
        }
        return -1;
    }

    /* Removes all of its elements that
     * are contained in the specified int array.
     */

    /**
     * Method to remove all the items from the list.
     *
     * @param      items  The items
     */
    public void removeAll(E[] items) {
        // write the logic
        for (E element : items) {
            for (int i = 0; i < items.length; i++) {
                if (contains(element)) {
                    remove(indexOf(element));
                }
            }
        }
    }

    /*Returns a list containing elements, including
     startIndex and excluding endIndex. The first parameter
     indicates the startIndex and the second parameter
     indicates the endIndex.
     */

    /**
     * {Method to create a sublist}.
     *
     * @param      n     { parameter_description }
     * @param      n2    The n 2
     *
     * @return     {List}
     */
    public List subList(int n, int n2) {
        if (n >= 0 && n < size
            && n2 <= size && n2 >= 0 && n <= n2) {
            List<E> list1 = new List(n2 - n);
            for (int i = n; i < n2; i++) {
                list1.add(this.get(i));
            }
            return list1;
        }
        System.out.println("Index Out of Bounds Exception");
        return null;
    }
    /*Returns a boolean indicating whether the parameter
      i.e a List object is exactly matching with the given list or not.
     */

    /**
     * {Method to check whether the list object matches with the given list}.
     *
     * @param      listdata  The listdata
     *
     * @return     {Boolean value}.
     */
    public boolean equals(List<E> listdata) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (list[i].equals(listdata.get(i))) {
                count++;
            }
        }
        return (count == listdata.size());
    }
    /*Removes all the elements from list*/

    /**
     * {Method to clear the list}.
     */
    public void clear() {
        size = 0;
    }
}
