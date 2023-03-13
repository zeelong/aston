package collections.sorter;

import java.util.Comparator;

public class QuickSort {

    /**
     * Sorts the specified array of objects according to the order, inducing by the specified
     * comparator. An average execution of this sorter is O(n log(n)). The worse case of this
     * sorter is O(n^2). This sorting algorithm is recursive leveraging the divide-and-conquer principle.
     * @param arr is array for sorting
     * @param begin is the starting index
     * @param end is the last index for sorting
     * @param comparator is a tool for determining the sort order of array elements
     * @param <T> is a type of element of the array
     */
    public static <T> void quickSort(T[] arr, int begin, int end, Comparator<T> comparator) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end, comparator);

            quickSort(arr, begin, partitionIndex - 1, comparator);
            quickSort(arr, partitionIndex + 1, end, comparator);
        }
    }

    /**
     * Method where last element is pivot. Then checking each element and swap it if it's value is smaller
     * The difference between the elements is determined by the comparator.
     * @param arr is array for sorting
     * @param begin is the starting index
     * @param end is the last index for sorting
     * @param comparator is a tool for determining the sort order of array elements
     * @return partition position
     * @param <T> is a type of element of the array
     */
    private static <T> int partition(T arr[], int begin, int end, Comparator<T> comparator) {
        T pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (comparator.compare(arr[j], pivot) < 0) {
                i++;
                T swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        T swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }
}
