public class debugPalindrome extends ArrayDeque<Character> {

    // Return a Deque where the characters appear in the same order as in the String.
    public Deque<Character> wordToDeque(String word) {  
        Deque<Character> res = new ArrayDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            res.addLast(word.charAt(i));
        }
        return res;
    }

    public boolean isPalindromeHelper(Deque<Character> d) {
        if (d.get(0) != null) {
            Character first;
            Character last;
            // System.out.println("first is: " + d.removeFirst().getClass().getName());
            // System.out.println("last is: " + d.removeLast().getClass().getName());            
            // first = (Character)d.removeFirst();
            // last = (Character)d.removeLast();   
            first = d.removeFirst();
            last = d.removeLast();   


            // System.out.println(" ======= first is: " + first.getClass().getName());
            // System.out.println(" ======= last is: " + last.getClass().getName());

            // System.out.println("first is: " + first);
            // System.out.println("last is: " + last);         
            if (!first.equals(last)) {
                return false;
            }
            isPalindromeHelper(d);
        }
        return true;
    }
 
    //  Check if the given word is a palindrome.
    public boolean isPalindrome(String word) {
        if (word == null) {
            return false;
        }
        else if (word.length() <= 1){
            return true;
        }
        return isPalindromeHelper(wordToDeque(word));
    }

    public static void main(String[] args) {
        // Instanciate to call a non-static method (wordToDeque).
        Palindrome palindrome = new Palindrome();
        System.out.println("finished instanciation");
        System.out.println("");
        Deque d = palindrome.wordToDeque("peddep");
        System.out.println("finished wordToDeque");
        System.out.println("");
        d.printDeque();
        System.out.println("successfully done everything");
        System.out.println(palindrome.isPalindrome("peddep"));
        
        System.out.println("***** Test 2 *****");

        Palindrome p = new Palindrome();
        System.out.println("finished instanciation");
        System.out.println("");
        Deque d2 = p.wordToDeque("hello");
        System.out.println("finished wordToDeque");
        System.out.println("");
        d2.printDeque();
        System.out.println("successfully done everything");
        System.out.println(palindrome.isPalindrome("hello"));
    }
} 