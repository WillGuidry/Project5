package popularity;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EngagementDLList<E> {

    private static class Node<E> {
        private Node<E> next;
        private Node<E> previous;
        private E data;

        public Node(E d) {
            data = d;
        }


        public void setNext(Node<E> n) {
            next = n;
        }


        public void setPrevious(Node<E> n) {
            previous = n;
        }


        public Node<E> next() {
            return next;
        }


        public Node<E> previous() {
            return previous;
        }


        public E getData() {
            return data;
        }
    }

    private int size;

    private Node<E> head;

    private Node<E> tail;

    public EngagementDLList() {
        initialization();
    }


    private void initialization() {
        head = new EngagementDLList.Node<E>(null);
        tail = new EngagementDLList.Node<E>(null);
        head.setNext(tail);
        tail.setPrevious(head);
        size = 0;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return size;
    }


    public void clear() {
        size = 0;
    }


    public E get(int index) {
        return getNodeAtIndex(index).getData();
    }


    public void add(E newEntry) {
        add(size(), newEntry);
    }


    public void add(int index, E obj) {
        if (index < 0 || size < index) {
            throw new IndexOutOfBoundsException();
        }
        if (obj == null) {
            throw new IllegalArgumentException("Cannot add null "
                + "objects to a list");
        }

        Node<E> nodeAfter;
        if (index == size) {
            nodeAfter = tail;
        }
        else {
            nodeAfter = getNodeAtIndex(index);
        }

        Node<E> addition = new Node<E>(obj);
        addition.setPrevious(nodeAfter.previous());
        addition.setNext(nodeAfter);
        nodeAfter.previous().setNext(addition);
        nodeAfter.setPrevious(addition);
        size++;

    }


    private Node<E> getNodeAtIndex(int index) {
        if (index < 0 || size() <= index) {
            throw new IndexOutOfBoundsException("No element exists at "
                + index);
        }
        Node<E> current = head.next();
        for (int i = 0; i < index; i++) {
            current = current.next();
        }
        return current;
    }


    public Iterator<E> iterator() {
        return new DLListIterator<E>();
    }

    private class DLListIterator<A> implements Iterator<E> {

        private Node<E> next;

        public DLListIterator() {
            next = head;
        }


        @Override
        public boolean hasNext() {
            return next.next.getData() != null;

        }


        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No nodes left in the list.");
            }
            next = next.next();
            return next.getData();
        }
    }

}
