public class LinkedListDeque<T> implements Deque<T> {

    private class TNode {
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
        sentinel.next = new TNode(item, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    /* Adds an item of type T to the front of the deque. */
    @Override
    public void addFirst(T item) {
        sentinel.next = new TNode(item, sentinel.next, sentinel);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    /* Adds an item of type T to the back of the deque. */
    @Override
    public void addLast(T item) {
        sentinel.prev = new TNode(item, sentinel, sentinel.prev);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    /* Returns the number of items in the deque. */
    @Override
    public int size() {
        return size;
    }

    /* Prints the items in the deque from first to last, separated by a space.
       Once all the items have been printed, print out a new line. */
    @Override
    public void printDeque() {
        TNode p = sentinel;
        String res = "";
        while (p.next != sentinel) {
            p = p.next;
            res += p.item.toString();
            res += " ";
        }
        System.out.println(res);
        System.out.println();
    }

    /* Removes and returns the item at the front of the deque.
       If no such item exists, returns null.*/
    @Override
    public T removeFirst() {
        if (sentinel.next != sentinel) {
            T res = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = null;
            sentinel.next.prev = sentinel;
            size -= 1;
            return res;
        }
        return null;
    }

    /* Removes and returns the item at the back of the deque.
    If no such item exists, returns null.*/
    @Override
    public T removeLast() {
        if (sentinel.prev != sentinel) {
            T res = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = null;
            sentinel.prev.next = sentinel;
            size -= 1;
            return res;
        }
        return null;
    }

    /* Gets the item at the given index, where 0 is the front,
       1 is the next item, and so forth. If no such item exists,
       returns null. Must not alter the deque!*/
    @Override
    public T get(int index) {
        if (index + 1 > size) {
            return null;
        }
        if (index < size / 2) {
            TNode p = sentinel;
            for (int i = 0; i <= index; i++) {
                p = p.next;
            }
            return p.item;
        } 
        TNode p = sentinel;
        for (int i = 0; i < size - index; i++) {
            p = p.prev;
        }
        return p.item;
    }

    public T getRecursiveHelper(int remainingSteps, TNode p) {
        // Base case
        if (remainingSteps == 0) {            
            return p.next.item;
        }
        // if still steps to go, next, then step - 1
        return getRecursiveHelper(remainingSteps - 1, p.next);
    }

    public T getRecursive(int index) {
        if (index + 1 > size) {
            return null;
        }
        return getRecursiveHelper(index, sentinel);
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> I = new LinkedListDeque<>();
        System.out.println("Create an empty LinkedListDeque 'I'");
        System.out.println("Is I empty? " + I.isEmpty());
        System.out.println("I add 1, 2, 3, 4");
        I.addFirst(2);
        I.addLast(3);
        I.addFirst(1);
        I.addLast(4);
        System.out.println("Size of I is: " + I.size());
        System.out.println("I is: ");
        I.printDeque();
        System.out.println("The index 2 is: " + I.getRecursive(2));
        System.out.println("The index 5 is: " + I.getRecursive(5));
        System.out.println("I back add 5, 6, 7, 8; front add 0");
        I.addLast(5);
        I.addLast(6);
        I.addLast(7);
        I.addLast(8);
        I.addFirst(0);
        I.isEmpty();
        System.out.println("Size of I is: " + I.size());
        System.out.println("I is: ");
        I.printDeque();
        System.out.println("The index 8 is: " + I.get(8));
        System.out.println("Is I empty? " + I.isEmpty());
        System.out.println("I remove 0 and 8");
        I.removeFirst();
        I.removeLast();
        System.out.println("Size of I is: " + I.size());
        System.out.println("I is: ");
        I.printDeque();
        System.out.println("Is I empty? " + I.isEmpty());

        System.out.println(" ======= Try different type ======= ");
        LinkedListDeque<String> S = new LinkedListDeque<>();
        System.out.println("Create an empty LinkedListDeque 'S'");
        System.out.println("Is S empty? " + S.isEmpty());
        System.out.println("S add b, c, d, e");
        S.addFirst("c");
        S.addLast("d");
        S.addFirst("b");
        S.addLast("e");
        System.out.println("Size of S is: " + S.size());
        System.out.println("S is: ");
        S.printDeque();
        System.out.println("The index 2 is: " + S.getRecursive(2));
        System.out.println("The index 5 is: " + S.getRecursive(5));
        System.out.println("S back add f, g, h, i; front add a");
        S.addLast("f");
        S.addLast("g");
        S.addLast("h");
        S.addLast("i");
        S.addFirst("a");
        S.isEmpty();
        System.out.println("Size of S is: " + S.size());
        System.out.println("S is: ");
        S.printDeque();
        System.out.println("The index 8 is: " + S.get(8));
        System.out.println("Is S empty? " + S.isEmpty());
        System.out.println("S remove a and i");
        S.removeFirst();
        S.removeLast();
        System.out.println("Size of S is: " + S.size());
        System.out.println("S is: ");
        S.printDeque();
        System.out.println("Is S empty? " + S.isEmpty());
    }
}