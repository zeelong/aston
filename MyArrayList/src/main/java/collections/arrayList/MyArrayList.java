package collections.arrayList;


import java.util.Arrays;
import java.util.Comparator;

/**
 * Реализация интерфейса MyArrayListImpl, предусматривающего методы по добавлению,
 * получению элемента по индексу, получению индекса элемента, изменению, удалению элементов,
 * а также получению размера списка, проверку на присутствие/отсутствие элементов в списке. В основе данного
 * класса лежит динамический массив.
 * @param <T> Тип элементов в списке
 * @author Anatoly Ahaminov "tolyanahaminov@gmail.com"
 */
public class MyArrayList<T> implements MyArrayListImpl<T> {
    /**
     * Емкость списка по умолчанию
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * Массив для хранения данных
     */
    private T[] array;

    /**
     * Размер списка
     */
    private int size;

    /**
     * Конструктор с емкостью, заданной при инициализации
     * @param capacity емкость списка
     */
    public MyArrayList(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("invalid capacity");
        else {
            array = (T[]) new Object[capacity];
        }
    }

    /**
     * Конструктор с емкостью по умолчанию,равной 10
     */
    public MyArrayList() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Метод для добавления элемента в конец списка
     * @param element элемент списка
     */
    @Override
    public void add(T element) {
        if (array[array.length - 1] != null) {
            increaseCapacity();
        }
        array[size++] = element;
    }

    /**
     * Метод для добавления элемента в определенный индекс. При это элементы, находящиееся правее указанного
     * в параметре элемента, сдвигаются вправо на одну ячейку.
     * @param index индекс ячейки в списке для помещения в нее значения
     * @param element значение элемента
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

    @Override
    public void remove(int index) {
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    @Override
    public void remove(T element) {
        var index = indexOf(element);
        if (index < 0) return;
        remove(index);
    }

    @Override
    public int indexOf(T element) {
        if (element == null) return -1;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element))
                return i;
        }
        return -1;
    }

    @Override
    public T get(int index) {
        if (index < size)
            return array[index];
        throw new IndexOutOfBoundsException("incorrect index");
    }

    @Override
    public void set(int index, T value) {
        if (index < size)
            array[index] = value;
        else
            throw new IndexOutOfBoundsException("incorrect index");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        final T[] temp = array;
        for (int i = 0; i < size; i++) {
            temp[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //TODO
    @Override
    public void sort(Comparator<T> comparator) {
    }

    private void increaseCapacity() {
        T[] temp = array;
        array = (T[]) new Object[temp.length * 3 / 2 + 1];
        array = Arrays.copyOf(temp, array.length);
    }

    //TODO
    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
