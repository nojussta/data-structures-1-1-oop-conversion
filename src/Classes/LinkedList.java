package Classes;

public class LinkedList<E> implements Iterable<E> {
    private static class Node<E> {

        private E Data;    // ji nematoma už klasės ListKTU ribų
        private Node<E> Link; // next - kaip įprasta - nuoroda į kitą mazgą

        Node(E data, Node<E> link) { //mazgo konstruktorius
            this.Data = data;
            this.Link = link;
        }

        /**
         * Suranda sąraše k-ąjį mazgą
         *
         * @param k ieškomo mazgo indeksas (prasideda nuo 0)
         * @return surastas mazgas
         */
        public Node<E> findNode(int k) {
            Node<E> e = this;
            for (int i = 0; i < k; i++) {
                e = e.Link;
            }
            return e;
        }
    } // klasės Node pabaiga

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
    private int size;

    public LinkedList() {
    }

    public void addF(E item) {
        begin = new Node<E>(item, begin);
    }

    public boolean addE(E e) {
        if (e == null) {
            return false;   // nuliniai objektai nepriimami
        }
        if (begin == null) {
            begin = new Node<>(e, begin);
            end = begin;
        } else {
            Node<E> e1 = new Node(e, null);
            begin.Link = e1;
            begin = e1;
        }
        size++;
        return true;
    }

    public E get() {
        return current.Data;
    }

//    public E get(int k) {
//        if (k < 0 || k >= size) {
//            return null;
//        }
//        current = begin.findNode(k);
//        return current.Data;
//    }

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
