package algorithmic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("""
        1796. Second Largest Digit in a String
        Easy
        Given an alphanumeric string s, return the second largest numerical digit that appears in s,
        or -1 if it does not exist.
                
        An alphanumeric string is a string consisting of lowercase English letters and digits.
        Example 1:
                
        Input: s = "dfa12321afd"
        Output: 2
        Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.
        Example 2:
                
        Input: s = "abc1111"
        Output: -1
        Explanation: The digits that appear in s are [1]. There is no second largest digit.\s
                
        Constraints:
                
        1 <= s.length <= 500
        s consists of only lowercase English letters and/or digits.
        """)
class LCSecondLargestNumberTest {
    @DisplayName("""
             Example 1:
                
        Input: s = "dfa12321afd"
        Output: 2
        Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.
            """)
    @Test
    void example1() {
        Assertions.assertEquals(2, secondHighest("dfa12321afd"));
    }

    @DisplayName("""
        Example 2:
                
        Input: s = "abc1111"
        Output: -1
            """)
    @Test
    void example2() {
        Assertions.assertEquals(-1, secondHighest("abc1111"));
    }

    @DisplayName("""
            input "ch077"
            output 0
            """)
    @Test
    void failedOnLeetCode() {
        Assertions.assertEquals(0, secondHighest("ch077"));
    }

    @ParameterizedTest(name = "{index} -> {0}")
    @ValueSource(strings = {"", "   ", "a1b1c1d1"})
    void blankTest(String s) {
        Assertions.assertEquals(-1, secondHighest(s));
    }

    private int secondHighest(String s) {
        final int NOT_RESULT = -1;
        if (s == null || s.isBlank() || s.isEmpty()) return NOT_RESULT;
        char[] chars = s.toCharArray();
        int[] digits = new int[10];


        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isDigit(c)) {
                int readDigit = Integer.parseInt(Character.toString(c));
                digits[readDigit] = 1;
            }
        }

        boolean foundFirstDigit = false;
        int secondLargestDigit = -1;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 1) {
                if (!foundFirstDigit) {
                    foundFirstDigit = true;
                } else {
                    secondLargestDigit = i;
                    break;
                }
            }
        }


        return secondLargestDigit;
    }
}
