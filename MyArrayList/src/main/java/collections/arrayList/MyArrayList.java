package collections.arrayList;


import collections.sorter.QuickSort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Implementation of MyArrayListImpl interface, which provides methods for adding, getting element by index,
 * getting element index, changing, deleting elements, as well as getting list size, checking for
 * presence/absence of elements in the list. This class is based on a dynamic array.
 * @param <T> Type of element in the array
 * @author Anatoly Ahaminov "tolyanahaminov@gmail.com"
 */
public class MyArrayList<T> implements MyArrayListImpl<T> {
    /**
     * Default capacity of the list
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * Array for store data
     */
    private T[] array;

    /**
     * size of the list
     */
    private int size;

    /**
     * Constructor for creating a list, which based on the array with a capacity setting during initialization
     * @param capacity capacity of the list
     */
    public MyArrayList(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("invalid capacity");
        else {
            array = (T[]) new Object[capacity];
        }
    }

    /**
     * Constructor for creating a list, which based on the array with a default capacity of 10 null elements
     */
    public MyArrayList() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Method for adding an element to the end of the list. If the capacity of the list is full, then it will be
     * increase and the element will add to the end of the list
     * @param element is the element of the list
     */
    @Override
    public void add(T element) {
        if (array[array.length - 1] != null) {
            increaseCapacity();
        }
        array[size++] = element;
    }

    /**
     * Method for adding an element at a specific index. In this case, each element located to the right
     * of the specified element shift to the right by one cell.
     * @param index is the index of the cell in the list to put the value in it
     * @param element value of the element
     */
    @Override
    public void add(int index, T element) {
        if (array.length <= size) {
            increaseCapacity();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    /**
     * Method for deleting the element from the list by index
     * @param index is the index of element for deleting
     */
    @Override
    public void remove(int index) {
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    /**
     * Method for deleting the element from the list.
     * At first searching the index of this element in the list and then delete the element by index
     * @param element is the element of the list
     * @see MyArrayList#indexOf(T element)
     */
    @Override
    public void remove(T element) {
        var index = indexOf(element);
        if (index < 0) return;
        remove(index);
    }

    /**
     * Method for searching index of the element in the list. If the list don't include this element - return -1,
     * else return index of this element
     * @param element is the element for searching
     * @return index (int type) of the element
     */

    @Override
    public int indexOf(T element) {
        if (element == null) return -1;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element))
                return i;
        }
        return -1;
    }

    /**
     * Method for getting element of the list by index
     * @param index is the index of element in list
     * @return the object which has been found by specified index
     * @exception IndexOutOfBoundsException if there is incorrect index
     */
    @Override
    public T get(int index) {
        if (index < size)
            return array[index];
        throw new IndexOutOfBoundsException("incorrect index");
    }

    /**
     * Method for setting specific value (second argument) for the element of the list, which is found by
     * the argument specified in 1 parameter
     * @param index is the index of the element for changing
     * @param value is an object to replace with the original list item
     * @exception IndexOutOfBoundsException if there is incorrect index
     */
    @Override
    public void set(int index, T value) {
        if (index < size)
            array[index] = value;
        else
            throw new IndexOutOfBoundsException("incorrect index");
    }

    /**
     * Method to find count of elements of the list
     * @return count of elements of the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Method to make all elements of the list null
     */
    @Override
    public void clear() {
        final T[] temp = array;
        for (int i = 0; i < size; i++) {
            temp[i] = null;
        }
        size = 0;
    }

    /**
     * Method for checking if there are items in the list
     * @return true if the list contains element(s), and false if there are no elements into the list
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Method for sorting elements of the list according to the order induced by the specified comparator.
     * Method is based on quicksort, the average execution of which is O( n log ( n )).
     * @see QuickSort#quickSort(Object[], int, int, Comparator)
     * @param comparator
     */
    @Override
    public void sort(Comparator<T> comparator) {

        QuickSort.quickSort(array, 0, size - 1, comparator);
    }

    /**
     * Method to increase capacity of the list
     */
    private void increaseCapacity() {
        T[] temp = array;
        array = (T[]) new Object[temp.length * 3 / 2 + 1];
        array = Arrays.copyOf(temp, array.length);
    }

    /**
     * Method to display elements of the list
     * @return string representation of list elements
     */
    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
