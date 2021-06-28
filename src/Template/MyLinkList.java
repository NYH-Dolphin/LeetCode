package Template;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Iterator;

public class MyLinkList<T> implements Iterable<T> {

    @Test
    public void test(){
        MyLinkList<Integer> list = new MyLinkList<>();
        list.addHead(1);
        list.addHead(2);
        list.addHead(3);
        list.addTail(4);
        list.printList();
    }

    private int size;
    private int modCount = 0;
    private Node<T> beginMarker;
    private Node<T> endMarker;

    private static class Node<T> {
        public T data;
        public Node<T> prev;
        public Node<T> next;

        public Node(T d, Node<T> p, Node<T> n) {
            data = d;
            prev = p;
            next = n;
        }
    }

    public MyLinkList() {
        clear();
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        beginMarker = new Node<T>(null, null, null);
        endMarker = new Node<>(null, beginMarker, null);
        beginMarker.next = endMarker;
        size = 0;
        modCount++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }


    public boolean addHead(T value){
        add(0, value);
        return true;
    }

    public boolean addTail(T value) {
        add(size(), value);
        return true;
    }

    public void add(int index, T value) {
        addBefore(getNode(index), value);
    }

    private void addBefore(Node<T> p, T x) {
        Node<T> newNode = new Node<>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        size++;
        modCount++;
    }

    public T get(int index) {
        return getNode(index).data;
    }

    public int getIndex(T data){
        Node<T> node = beginMarker.next;
        int pos = 0;
        if(!isEmpty()) {
            while (node.data != data && node != endMarker) {
                node = node.next;
                pos++;
            }
            if(node.data == data){
                return pos;
            }else{
                throw new NullPointerException();
            }
        }
        throw new NullPointerException();
    }

    public ArrayList<Integer> getIndexs(T data){
        Node<T> node = beginMarker.next;
        ArrayList<Integer> indexes = new ArrayList<>();
        int pos = 0;
        if(!isEmpty()) {
            while (node != endMarker) {
                node = node.next;
                pos++;
                if(node.data == data){
                    indexes.add(pos);
                }
            }
        }
        return indexes;
    }

    public T set(int index, T value) {
        Node<T> node = getNode(index);
        T oldVal = node.data;
        node.data = value;
        return oldVal;
    }

    public T remove(int index) {
        return remove(getNode(index));
    }

    public T remove(Node<T> p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        size--;
        modCount++;
        return p.data;
    }



    private Node<T> getNode(int index) {
        return getNode(index, 0, size());
    }

    private Node<T> getNode(int index, int lower, int upper) {
        Node<T> p;
        if (index < lower || index > upper) {
            throw new IndexOutOfBoundsException();
        }
        if (index < size() / 2) {
            p = beginMarker.next;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = size(); i > index; i--) {
                p = p.prev;
            }
        }
        return p;
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }


    public void printList(){
        Node<T> node = beginMarker.next;
        if(!isEmpty()) {
            System.out.print("begin -> ");
            while (node != endMarker) {
                System.out.print(node.data + " -> ");
                node = node.next;
            }
            System.out.println("end");
        }else{
            System.out.println("Empty list");
        }
    }
}
