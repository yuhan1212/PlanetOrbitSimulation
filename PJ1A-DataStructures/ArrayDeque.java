public class ArrayDeque <T> {

    private T[] items; 
    private int size;
    private int nextFirstIndex; 
    private int nextLastIndex;  
    private int defaultLength = 3;

    public ArrayDeque() {
        items = (T[]) new Object[defaultLength];
        size = 0;
        nextFirstIndex = defaultLength / 2 - 1;
        nextLastIndex = defaultLength / 2;
    }

    /** Resizes the underlying array to the target capacity. */
    private void resizeLarger() {
        T[] a = (T[]) new Object[defaultLength + size];
        // add capacity after last item
        if (nextLastIndex == 0) {
            System.arraycopy(items, 0, a, 0, size);
            nextLastIndex += size;
        }
        else {
            System.arraycopy(items, 0, a, 0, nextLastIndex);
            System.arraycopy(items, nextLastIndex, a, nextLastIndex + defaultLength, size - nextLastIndex);
        }
        items = a;
        nextFirstIndex += defaultLength;    
    }

    private void resizeSmaller() {
        T[] a = (T[]) new Object[size * 2];
        int firstIndex = correctIndex(nextFirstIndex + 1);
        int lastIndex = correctIndex(nextLastIndex - 1);
        if (firstIndex < lastIndex) {
            System.arraycopy(items, firstIndex, a, 0, size);
        }
        else {
            System.arraycopy(items, firstIndex, a, 0, items.length - firstIndex);
            System.arraycopy(items, 0, a, items.length - firstIndex, lastIndex + 1);
        }
        items = a;
        nextFirstIndex = items.length - 1;
        nextLastIndex = size;  
    }

    /** Make sure array run as circle. */
    private int correctIndex(int indexForCheck) {
        if (indexForCheck > items.length - 1) {
        indexForCheck %=  items.length; 
        }
        else if (indexForCheck < 0) {
        indexForCheck +=  items.length; 
        }
        return indexForCheck;
    }

    /* Adds an item of type T to the front of the deque. 
       take constant time, except during resizing operations. */
    public void addFirst(T item) {
        if (size == items.length) {
            resizeLarger();
        }
        items[nextFirstIndex] = item; 
        nextFirstIndex = correctIndex(nextFirstIndex - 1);
        size += 1;
    }

    /* Adds an item of type T to the back of the deque. 
       take constant time, except during resizing operations. */
    public void addLast(T item) {
        if (size == items.length) {
            resizeLarger();
        }
        items[nextLastIndex] = item; 
        nextLastIndex = correctIndex(nextLastIndex + 1);
        size += 1;
    }

    /* Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }

    /* Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /* Prints the items in the deque from first to last, separated by a space.
       Once all the items have been printed, print out a new line. */

    public void printDeque() {
        String res = "";
        int firstIndex = correctIndex(nextFirstIndex + 1);
        for (int i = 0; i < size; i++) {
            int index = correctIndex(firstIndex + i);
            res += items[index].toString();
                res += " ";
        }
        System.out.println(res);
        System.out.println();
    }

    /* Removes and returns the item at the front of the deque.
       If no such item exists, returns null. 
       take constant time, except during resizing operations. */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (items.length > defaultLength * 2 && size * 2 < items.length) {
            resizeSmaller();
        }
        int oldFirstIndex = correctIndex(nextFirstIndex + 1);
        T temp = items[oldFirstIndex];
        items[oldFirstIndex] = null;
        nextFirstIndex = oldFirstIndex;
        size -= 1;
        System.out.println(items.length);
        System.out.println(size);
        return temp;
    }

    /* Removes and returns the item at the back of the deque.
       If no such item exists, returns null.
       take constant time, except during resizing operations. */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (items.length > defaultLength * 2 && size * 2 < items.length) {
            resizeSmaller();
        }
        int oldLastIndex = correctIndex(nextLastIndex - 1);
        T temp = items[oldLastIndex];
        items[oldLastIndex] = null;
        nextLastIndex = oldLastIndex;
        size -= 1;
        System.out.println(items.length);
        System.out.println(size);
        return temp;
    }

    /* Gets the item at the given index, where 0 is the front,
       1 is the next item, and so forth. If no such item exists,
       returns null. Must not alter the deque!*/
    public T get(int index) {
        if (index + 1 > size) {
            return null;
        }
        return items[correctIndex(nextFirstIndex + 1 + index)];
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> I = new ArrayDeque<>();
        System.out.println(" ***** start from here ***** ");
        System.out.println("Create an empty ArrayDeque 'I'");
        System.out.println("Is I empty? " + I.isEmpty());
        System.out.println("I add 1, 2, 3, 4");
        I.addFirst(2);
        I.addLast(3);
        I.addFirst(1);
        I.addLast(4);
        System.out.println("Size of I is: " + I.size());
        System.out.println("I is: ");
        I.printDeque();
        System.out.println("The index 2 is: " + I.get(2));
        System.out.println("The index 5 is: " + I.get(5));
        System.out.println("I back add 5, 6, 7, 8; front add 0");
        I.addLast(5);
        I.addLast(6);
        I.addLast(7);
        I.addLast(8);
        I.addFirst(0);
        System.out.println("Is I empty? " + I.isEmpty());
        System.out.println("The index 8 is: " + I.get(8));
        I.addLast(9);
        I.addLast(10);
        I.addLast(11);
        I.addLast(12);
        I.addLast(13);
        System.out.println("Size of I is: " + I.size());
        System.out.println("I is: ");
        I.printDeque();
        System.out.println(" ===== here start to remove ===== ");
        I.removeFirst();
        System.out.println("After remove 1st I is: ");
        I.printDeque();
        I.removeLast();
        System.out.println("After remove last I is: ");
        I.printDeque();
        I.removeLast();
        System.out.println("After remove last I is: ");
        I.printDeque();
        I.removeLast();
        System.out.println("After remove last I is: ");
        I.printDeque();
        I.removeLast();
        System.out.println("After remove last I is: ");
        I.printDeque();
        I.removeLast();
        System.out.println("After remove last I is: ");
        I.printDeque();
        I.removeFirst();
        System.out.println("After remove 1st I is: ");
        System.out.println("I is: ");
        I.removeFirst();
        System.out.println("After remove 1st I is: ");
        System.out.println("I is: ");
        I.printDeque();
        System.out.println("Is I empty? " + I.isEmpty());

        System.out.println(" ======= Try different type ======= ");
        ArrayDeque<String> S = new ArrayDeque<>();
        System.out.println("Create an empty ArrayDeque 'S'");
        System.out.println("Is S empty? " + S.isEmpty());
        System.out.println("S add b, c, d, e");
        S.addFirst("c");
        S.addLast("d");
        S.addFirst("b");
        S.addLast("e");
        System.out.println("Size of S is: " + S.size());
        System.out.println("S is: ");
        S.printDeque();
        System.out.println("The index 2 is: " + S.get(2));
        System.out.println("The index 5 is: " + S.get(5));
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