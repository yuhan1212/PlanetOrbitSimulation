public class OffByN implements CharacterComparator {
    private int different;

    public OffByN(int N) {
        different = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int intX = x;
        // System.out.println(intX);
        int intY = y;
        // System.out.println(intY);
        if ( intX - intY == different || intX - intY == -different) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        OffByN obn = new OffByN(1);
        System.out.println(obn.equalChars('a', 'b'));  // true
        System.out.println(obn.equalChars('r', 'q'));  // true
        System.out.println(obn.equalChars('a', 'e'));  // false
        System.out.println(obn.equalChars('z', 'a'));  // false
        System.out.println(obn.equalChars('a', 'a'));  // false
        System.out.println(obn.equalChars('&', '%'));  // true

        OffByN offBy5 = new OffByN(5);
        System.out.println(offBy5.equalChars('a', 'f'));  // true
        System.out.println(offBy5.equalChars('f', 'a'));  // true
        System.out.println(offBy5.equalChars('f', 'h'));  // false
    }


}