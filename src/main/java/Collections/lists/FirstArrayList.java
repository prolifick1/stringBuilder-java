package Collections.lists;

import java.util.*;

public class FirstArrayList<E> implements List<E> {
    private int size = 0;
    private int capacity = 0;
    private Object[] arr;

    public FirstArrayList() {
        capacity = 16;
        arr = new Object[capacity];
    }

    public FirstArrayList(int capacity) {
        this.capacity = capacity;
        arr = new Object[capacity];
    }

    public boolean add(Object o) {
        if (size >= capacity) {
            increasingOfCapacity();
        }
        arr[size++] = o;
        return true;
    }

    public void add(int id, Object o) {
        if (id >= 0 || id <= size) {
            if (size >= capacity) {
                increasingOfCapacity();
            }
            System.arraycopy(arr, id, arr, id + 1, size + 1 - id);
            arr[id] = o;
            size++;
        } else {
            System.out.println("index: " + id + " out of range");
        }
    }

    public E get(int id) {
        if ((id < size) && (id >= 0)) {
            return (E) arr[id];
        }
        return null;
    }

    public Object set(int id, Object o) {
        E oldValue = elementOfArr(id);
        if (id < size && id >= 0) {
            arr[id] = o;
            return arr[id];
        }
        return oldValue;
    }

    public E remove(int index) {
        Object o = null;
        if ((index < size) && (index >= 0)) {
            o = get(index);
            offset(index);
        }
        return (E) o;
    }

    public boolean remove(Object o) {
        if ((size == 0)) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if ((arr[i] == null && o == null) || ((arr[i] != null) && (arr[i].equals(o)))) {
                offset(i);
                return true;
            }
        }
        return false;
    }

    private void increasingOfCapacity() {
        capacity = capacity == 0 ? 1 : capacity * 2;
        Object[] newArr = new Object[capacity];
        if (size >= 0) {
            System.arraycopy(arr, 0, newArr, 0, size);
        }
        arr = newArr;
    }

    private void offset(int start) {
        if (--size > 0) {
            if (size != start) {
                System.arraycopy(arr, start + 1, arr, start, size - start);
            }
            arr[size] = null;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) == 0;
    }


    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(arr[i])) {
                return 0;
            }
        }
        return -1;
    }


    public void clear() {
        arr = new Object[capacity];
        size = 0;
    }

    public Object[] toArray() {
        Object[] newArr = new Object[size];
        System.arraycopy(arr, 0, newArr, 0, size);
        return newArr;
    }


    E elementOfArr(int id) {
        return (E) arr[id];
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}

