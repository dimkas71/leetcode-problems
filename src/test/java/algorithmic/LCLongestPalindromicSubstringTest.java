package algorithmic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("""
        Given a string s, return the longest palindromic substring in s.
                
        Example 1:
                
        Input: s = "babad"
        Output: "bab"
        Note: "aba" is also a valid answer.
        Example 2:
                
        Input: s = "cbbd"
        Output: "bb"
        Example 3:
                
        Input: s = "a"
        Output: "a"
        Example 4:
                
        Input: s = "ac"
        Output: "a"
                
        Constraints:
                
        1 <= s.length <= 1000
        s consist of only digits and English letters (lower-case and/or upper-case),
                
        """)
class LCLongestPalindromicSubstringTest {

    @DisplayName("""
        Example 1:
                
        Input: s = "babad"
        Output: "bab"
        Note: "aba" is also a valid answer
    """)
    @Test
    void example1() {
        Assertions.assertEquals("bab", longestPalindrome("babad"));
    }

    @DisplayName("""
        Example 2:
                
        Input: s = "cbbd"
        Output: "bb"
    """)
    @Test
    void example2() {
        Assertions.assertEquals("bb", longestPalindrome("cbbd"));
    }

    @DisplayName("""
        Example 3:
                
        Input: s = "a"
        Output: "a"
    """)
    @Test
    void example3() {
        Assertions.assertEquals("a", longestPalindrome("a"));
    }

    @DisplayName("""
         Example 4:
                
        Input: s = "ac"
        Output: "a"
    """)
    @Test
    void example4() {
        Assertions.assertEquals("a", longestPalindrome("ac"));
    }




    @DisplayName("""
            Test when the string is a palindrome at all
            """)
    @ParameterizedTest
    @ValueSource(strings = {
            "a",
            "",
            " ",
            "bab",
            "babab",
            "bbb"
    })
    void testThatStringIsPalindromeAsWhole(String source) {
        Assertions.assertEquals(source, longestPalindrome(source));
    }

    @DisplayName("""
            Input "abb"
            Output "a"
            Expected "bb"
            """)
    @Test
    void failedAtLeetCodeTest() {
        Assertions.assertEquals("bb", longestPalindrome("abb"));
    }

    @DisplayName("""
            For isPalindrome method tests
            """)
    @Nested
    class IsPalindromeTest {

        @DisplayName("""
                Test empty or blank strings...
                """)
        @Test
        void emptyOrBlankStringIsPalindrome() {
            Assertions.assertEquals(true, isPalindrome(""));
            Assertions.assertEquals(true, isPalindrome("   "));
        }


        @DisplayName("""
                Strings with length one should be palindrome
                """)
        @Test
        void stringWithLengthOneShouldBePalindrome() {
            Assertions.assertEquals(true, isPalindrome("a"));
            Assertions.assertEquals(true, isPalindrome("1"));
            Assertions.assertEquals(true, isPalindrome("2"));

        }

        @DisplayName("""
                Test common cases 
                """)
        @Test
        void testCommonCases() {
            Assertions.assertEquals(true, isPalindrome("bab"));
            Assertions.assertEquals(true, isPalindrome("ababa"));
            Assertions.assertEquals(true, isPalindrome("bb"));
            Assertions.assertEquals(false, isPalindrome("bad"));
        }


    }


    private String longestPalindrome(String source) {
        if (isPalindrome(source)) return source;

        String longest = "";

        for (int i = 0; i <= source.length() - 1;i++) {
            for (int j = 1; j < source.length() - 1; j++) {
                String s = source.substring(i, j+1);
                if (isPalindrome(s) && s.length() > longest.length()) {
                    longest = s;
                }
            }
        }

        return longest;
    }

    private boolean isPalindrome(String source) {
        if (source.isEmpty() || source.isBlank()) return true;
        if (source.length() == 1) return true;
        return new StringBuilder(source).reverse().toString().equals(source);
    }


}
