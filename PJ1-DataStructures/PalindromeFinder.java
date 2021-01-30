
/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength6 = 6;
        In in = new In("words.txt");
        Palindrome palindrome = new Palindrome();

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength6 && palindrome.isPalindrome(word)) {
                System.out.println(word);
            }
        }

        System.out.println();
        System.out.println("The following are OffByOne test");
        System.out.println();

        CharacterComparator cOne = new OffByOne();
        int minLength5 = 5;
        In inOne = new In("words.txt");
        while (!inOne.isEmpty()) {
            String word = inOne.readString();
            if (word.length() >= minLength5 && palindrome.isPalindrome(word, cOne)) {
                System.out.println(word);
            }
        }

        System.out.println();
        System.out.println("The following are OffBy5 test");
        System.out.println();

        CharacterComparator cN5 = new OffByN(5);
        int minLength4 = 4;
        In inN = new In("words.txt");
        while (!inN.isEmpty()) {
            String word = inN.readString();
            if (word.length() >= minLength4 && palindrome.isPalindrome(word, cN5)) {
                System.out.println(word);
            }
        }
    }
}
