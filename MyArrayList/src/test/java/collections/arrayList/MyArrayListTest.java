package collections.arrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    MyArrayList<Integer> list;

    @BeforeEach
    void prepareData() {
        list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
    }

    @Test
    @DisplayName("добавление элемента в конец списка")
    void add() {
        list.add(6);
        assertEquals((Integer) 6, list.get(5));
    }

    @Test
    @DisplayName("добавление элемента в определенный индекс")
    void testAdd() {
        list.add(1, 22);
        assertEquals((Integer) 22, list.get(1));
    }

    @Test
    @DisplayName("удаление элемента по индексу")
    void removeElementByIndex() {
        list.remove(1);
        assertEquals((Integer) 3, list.get(1));
    }

    @Test
    @DisplayName("удаление элемента из списка")
    void removeElement() {
        list.remove((Integer) 2);
        assertEquals((Integer) 3, list.get(1));
    }

    @Test
    @DisplayName("получение индекса элемента")
    void indexOf() {
        assertEquals(1, list.indexOf(2));
        assertEquals(-1, list.indexOf(22));
    }

    @Test
    @DisplayName("получение элемента по индексу")
    void get() {
        assertEquals((Integer) 3, list.get(2));
    }

    @Test
    @DisplayName("изменение значения элемента")
    void set() {
        list.set(1, (Integer) 22);
        assertEquals((Integer) 22, list.get(1));
    }

    @Test
    @DisplayName("получение размера списка")
    void size() {
        assertEquals(5, list.size());
    }

    @Test
    @DisplayName("удаление всех элементов списка")
    void clear() {
        list.clear();
        for (int i = 0; i < list.size(); i++) {
            assertNull(list.get(i));
        }
    }

    @Test
    @DisplayName("проверка листа на наличие элементов")
    void isEmpty() {
        assertFalse(list.isEmpty());
    }

    @Test
    @DisplayName("проверка листа на сортировку по возрастанию")
    void sort() {
        MyArrayList<Integer>list2=new MyArrayList<>();
        list2.add(3);
        list2.add(2);
        list2.add(1);
        list2.add(5);
        list2.add(4);
        list2.sort(Comparator.comparingInt(x->x));
        for (int i = 0; i < list2.size(); i++) {
            assertEquals(list.get(i),(list2.get(i)));
        }
    }

    @Test
    @DisplayName("получение строкового представления листа")
    void testToString() {
        assertEquals("[1, 2, 3, 4, 5, null, null, null, null, null]",list.toString());

    }
}