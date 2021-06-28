package Template;

import org.junit.Test;

import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {

    @Test
    public void test(){
        MyArrayList<Integer> list = new MyArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add(i);
        }
        list.printList();
        System.out.println(list.get(2));
        list.remove(2);
        list.printList();
    }

    private static final int DEFAULT_CAPACITY = 10; // 默认容量
    private int size; // 大小
    private T[] list; // 实际以数组为存储空间

    public MyArrayList() {
        clear();
    }

    public void clear() {
        size = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return size;
    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < size) {
            return;
        }
        T[] old = list;
        list = (T[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            list[i] = old[i];
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return list[index];
    }

    public T set(int index, T value) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T old = list[index];
        list[index] = value;
        return old;
    }

    public boolean add(T x) {
        add(size(), x);
        return true;
    }

    public void add(int index, T value) {
        if (list.length == size()) {
            ensureCapacity(size() * 2 + 1);
        }
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = value;
        size++;
    }

    public T remove(int index) {
        T removeItem = list[index];
        for (int i = index; i < size() - 1; i++) {
            list[i] = list[i + 1];
        }
        size--;
        return removeItem;
    }

    public void printList(){
        if(!isEmpty()) {
            for (int i = 0; i < list.length - 1; i++) {
                System.out.print(list[i] + ",");
            }
            System.out.println(list[list.length - 1]);
        }else{
            System.out.println("Empty List");
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements java.util.Iterator<T>{
        private int current = 0;
        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public T next() {
            if(!hasNext()){
                throw new java.util.NoSuchElementException();
            }
            return list[current++];
        }

        public void remove(){
            MyArrayList.this.remove(--current);
        }
    }
}
