public class Palindrome extends ArrayDeque<Character> {

    // Return a Deque where the characters appear in the same order as in the String.
    public Deque<Character> wordToDeque(String word) {  
        Deque<Character> res = new ArrayDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            res.addLast(word.charAt(i));
        }
        return res;
    }

    public boolean isPalindromeHelper(Deque<Character> d) {
        if (d.size() >= 2) {
            Character first = d.removeFirst();
            Character last = d.removeLast();      
            if (!first.equals(last)) {
                return false;
            }
            isPalindromeHelper(d);
        }
        return true;
    }

    public boolean isPalindromeOffByHelper(Deque<Character> d, CharacterComparator cc) {
        if (d.size() >= 2) {
            char first = d.removeFirst();
            char last = d.removeLast();      
            if (!cc.equalChars(first, last)) {
                return false;
            }
            isPalindromeOffByHelper(d, cc);
        }
        return true;
    }
 
    //  Check if the given word is a palindrome.
    public boolean isPalindrome(String word) {
        if (word == null) {
            return false;
        }
        return isPalindromeHelper(wordToDeque(word));
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null) {
            return false;
        }
        return isPalindromeOffByHelper(wordToDeque(word), cc);
    }


    public static void main(String[] args) {
        // Instanciate to call a non-static method (wordToDeque).
        System.out.println("^^^^^^ Start Here ^^^^^^^");
        System.out.println();
        
        Palindrome palindrome = new Palindrome();
        System.out.println("finished instanciation 'palindrome'");
        Deque d = palindrome.wordToDeque("peddep");
        System.out.println("finished wordToDeque");
        d.printDeque();
        System.out.println("check isPalindrome");
        System.out.println(palindrome.isPalindrome("peddep"));

        System.out.println();
        System.out.println("***** Test 2 *****");
        System.out.println();

        Deque d2 = palindrome.wordToDeque("hello");
        System.out.println("finished wordToDeque");
        d2.printDeque();
        System.out.println("check isPalindrome");
        System.out.println(palindrome.isPalindrome("hello"));

        System.out.println();
        System.out.println("***** Test CharacterComparator *****");
        System.out.println();

        Deque d3 = palindrome.wordToDeque("flake");
        System.out.println("finished wordToDeque");
        d3.printDeque();
        System.out.println("check isPalindrome OffByOne");
        CharacterComparator cOne = new OffByOne();
        System.out.println(palindrome.isPalindrome("flake", cOne));
        System.out.println("check isPalindrome OffByN, N = 1");
        CharacterComparator cN1 = new OffByN(1);
        System.out.println(palindrome.isPalindrome("flake", cN1));
        System.out.println("check isPalindrome OffByN, N = 5");
        CharacterComparator cN5 = new OffByN(5);
        System.out.println(palindrome.isPalindrome("flake", cN5));
    }
} 