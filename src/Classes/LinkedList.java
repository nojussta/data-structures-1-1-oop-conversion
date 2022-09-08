package Classes;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.function.Consumer;

public class LinkedList<E> implements Iterable<E> {
    public class Node<E> implements Comparable<E> {
        public E Data;

        public E getData() {
            return Data;
        }

        public void setData(E data) {
            Data = data;
        }

        public Node<E> getLink() {
            return Link;
        }

        public void setLink(Node<E> link) {
            Link = link;
        }

        public Node<E> Link;

        public Node(E value, Node<E> address) {
            Data = value;
            Link = address;
        }

        @Override
        public int compareTo(@NotNull E o) {
            return 0;
        }
    }

//    @NotNull
//    @Override
//    public Iterator<E> iterator() {
//        return null;
//    }
//
//    @Override
//    public void forEach(Consumer<? super E> action) {
//        Iterable.super.forEach(action);
//    }

    private Node<E> begin;
    private Node<E> end;
    private Node<E> current;

    public LinkedList() {
        begin = null;
        end = null;
        current = null;
    }

    public void addF(E item) {
        begin = new Node<E>(item, begin);
    }

    public void addE(E item) {
        var temp = new Node<E>(item, null);
        if (begin != null) {
            end.Link = temp;
            end = temp;
        } else {
            begin = temp;
            end = temp;
        }
    }

    public E get() {
        return current.Data;
    }

    public void Start() {
        current = begin;
    }

    public void Next() {
        current = current.Link;
    }

    public boolean Exist() {
        return current != null;
    }

    public void Sort() {
        for (Node<E> a1 = begin; a1 != null; a1 = a1.Link) {
            for (Node<E> a2 = a1.Link; a2 != null; a2 = a2.Link) {
                if (a1.Data.toString().compareTo(a2.Data.toString()) > 0) {
                    E K = a1.Data;
                    a1.Data = a2.Data;
                    a2.Data = K;
                }
            }
        }
    }

    public int Count() {
        Node<E> temp = begin;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.Link;
        }
        return count;
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return new Iterator();
    }

    /**
     * Iteratoriaus metodų klasė
     */
    class Iterator implements java.util.Iterator<E> {

        private Node<E> iterPosition;

        Iterator() {
            iterPosition = begin;
        }

        @Override
        public boolean hasNext() {
            return iterPosition != null;
        }

        @Override
        public E next() {
            E d = iterPosition.Data;
            iterPosition = iterPosition.Link;
            return d;
        }
    }
}
