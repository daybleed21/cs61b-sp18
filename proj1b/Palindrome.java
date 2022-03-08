public class Palindrome {

    /* Give a String , it returns a Deque where the characters appear
     *  in the same order as in the String.
     * */
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> L = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            Character s = word.charAt(i);
            L.addLast(s);
        }
        return L;
    }

    /*  this method should return true if word is a palindrome
     *  and false otherwise
     * ‘A’ and ‘a’ should not be considered equal
     */

    public boolean isPalindrome(String word) {
        /** We can also use Deque to solve this problem
         * use wordToDeque method and String s += removeFirst
         */

        int n = word.length();
        if (n == 0 || n == 1)
            return true;
        StringBuilder reWord = new StringBuilder();
        for (int i = 0; i < n; i++) {
            reWord.append(word.charAt(n - i - 1));
        }
        return word.equals(reWord.toString());
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> l = wordToDeque(word);
        while(l.size() > 1){
            if(!cc.equalChars(l.removeFirst(),l.removeLast())){
                return false;
            }
        }
        return true;
    }
}
