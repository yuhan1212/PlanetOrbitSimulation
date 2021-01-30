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
        if (d.size() < 2) {
            return true;
        }
        if (d.size() >= 2) {
            Character first = d.removeFirst();
//            d.printDeque();
            Character last = d.removeLast();
//            d.printDeque();
            if (!first.equals(last)) {
                return false;
            }
        }
        return isPalindromeHelper(d);
    }

    public boolean isPalindromeOffByHelper(Deque<Character> d, CharacterComparator cc) {
        if (d.size() < 2) {
            return true;
        }
        if (d.size() >= 2) {
            char first = d.removeFirst();
            char last = d.removeLast();
            if (!cc.equalChars(first, last)) {
                return false;
            }
        }
        return isPalindromeOffByHelper(d, cc);
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
}