public class LinkedListDeque <T> {

    private static class TNode {
        public TNode prev;
        public T item;
        public TNode next;

        public TNode(T i, TNode n, TNode p) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private TNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new TNode(null, sentinel, sentinel);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public LinkedListDeque(T item) {
        sentinel = new TNode(null, sentinel, sentinel);
        sentinel.next = TNode(item, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 0;
    }


    /* Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {

    }

    /* Adds an item of type T to the back of the deque. */
    public void addLast(T item) {

    }

    /* Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {

    }

    /* Returns the number of items in the deque. */
    public int size() {

    }

    /* Prints the items in the deque from first to last, separated by a space.
       Once all the items have been printed, print out a new line. */

    public void printDeque() {

    }

    /* Removes and returns the item at the front of the deque.
       If no such item exists, returns null.*/
    public T removeFirst() {

    }

    /* Removes and returns the item at the back of the deque.
    If no such item exists, returns null.*/
    public T removeLast() {

    }

    /* Gets the item at the given index, where 0 is the front,
       1 is the next item, and so forth. If no such item exists,
       returns null. Must not alter the deque!*/
    public T get(int index) {

    }

    public T getRecursive(int index) {

    }


}