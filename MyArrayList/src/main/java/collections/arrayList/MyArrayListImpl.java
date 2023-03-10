package collections.arrayList;

import java.util.Comparator;

public interface MyArrayListImpl<T> {

    void add(T element);

    void add(int index, T element);

    void remove(int index);

    void remove(T element);

    int indexOf(T element);

    T get(int index);

    void set(int index, T value);

    int size();

    void clear();

    boolean isEmpty();

    void sort(Comparator<T> comparator);

}
