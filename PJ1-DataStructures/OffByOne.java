public class OffByOne implements CharacterComparator {
    
    @Override
    public boolean equalChars(char x, char y) {
        int intX = x;
        // System.out.println(intX);
        int intY = y;
        // System.out.println(intY);
        if ( intX - intY == 1 || intX - intY == -1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        OffByOne obo = new OffByOne();
        System.out.println(obo.equalChars('a', 'b'));  // true
        System.out.println(obo.equalChars('r', 'q'));  // true
        System.out.println(obo.equalChars('a', 'e'));  // false
        System.out.println(obo.equalChars('z', 'a'));  // false
        System.out.println(obo.equalChars('a', 'a'));  // false
        System.out.println(obo.equalChars('&', '%'));  // true
    }


}