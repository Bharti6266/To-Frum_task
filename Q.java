import java.util.HashSet;

public class Q {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>(); 
        int start = 0; 
        int maxLength = 0; 

        
        for (int end = 0; end < s.length(); end++) {
          
            while (charSet.contains(s.charAt(end))) {
                charSet.remove(s.charAt(start));
                start++;
            }

         
            charSet.add(s.charAt(end));

          
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(lengthOfLongestSubstring("ABCBC")); // Output: 3 ("ABC")
        System.out.println(lengthOfLongestSubstring("AAA")); // Output: 1 ("A")
    }
}
