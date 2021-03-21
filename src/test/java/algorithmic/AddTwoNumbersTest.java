package algorithmic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("""
        You are given two non-empty linked lists representing two non-negative integers.
        The digits are stored in reverse order, and each of their nodes contains a single digit.
        Add the two numbers and return the sum as a linked list.
                
        You may assume the two numbers do not contain any leading zero, except the number 0 itself.
                
        2 ----> 4 -----> 3
        5 ----> 6 -----> 4
        ------------------
        7 ----> 0 -----> 8        
        
        Example 1:
        Input: l1 = [2,4,3], l2 = [5,6,4]
        Output: [7,0,8]
        Explanation: 342 + 465 = 807.
        Example 2:
                
        Input: l1 = [0], l2 = [0]
        Output: [0]
        Example 3:
                
        Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        Output: [8,9,9,9,0,0,0,1]
                
        Constraints:
                
        The number of nodes in each linked list is in the range [1, 100].
        0 <= Node.val <= 9
        It is guaranteed that the list represents a number that does not have leading zeros.
        """)

class AddTwoNumbersTest {

    @DisplayName("""
        Example 1:
        Input: l1 = [2,4,3], l2 = [5,6,4]
        Output: [7,0,8]
        Explanation: 342 + 465 = 807.
    """)
    @Test
    void example1() {
        ListNode l1 = fromDigitString("243");
        ListNode l2 = fromDigitString("564");
        ListNode result = addTwoNumbers(l1, l2);

        Assertions.assertEquals(7, result.val);
        Assertions.assertEquals(0, result.next.val);
        Assertions.assertEquals(8, result.next.next.val);

    }
    @DisplayName("""
        Example 1:
        Input: l1 = [0], l2 = [0]
        Output: [0]
        Explanation: 0 + 0 = 0.
    """)
    @Test
    void example2() {
        ListNode l1 = fromDigitString("0");
        ListNode l2 = fromDigitString("0");
        ListNode result = addTwoNumbers(l1, l2);

        Assertions.assertEquals(0, result.val);
        Assertions.assertNull(result.next);

    }

    @Test
    @DisplayName("""
        Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        Output: [8,9,9,9,0,0,0,1]
            """)
    void example3() {
        ListNode l1 = fromDigitString("9999999");
        ListNode l2 = fromDigitString("9999");
        ListNode result = addTwoNumbers(l1, l2);

        Assertions.assertEquals("89990001",toDigitString(result));

    }

    @DisplayName("""
            Input:
            [2,4,9]
            [5,6,4,9]
            Output:
            [8,9,8,5]
            Expected:
            [7,0,4,0,1]
            """)
    @Test
    void failedLeetCodeTest() {
        ListNode l1 = fromDigitString("249");
        ListNode l2 = fromDigitString("5649");
        ListNode result = addTwoNumbers(l1, l2);

        Assertions.assertEquals(7, result.val);
        Assertions.assertEquals(0, result.next.val);
        Assertions.assertEquals(4, result.next.next.val);
        Assertions.assertEquals(0, result.next.next.next.val);
        Assertions.assertEquals(1, result.next.next.next.next.val);
        Assertions.assertNull(result.next.next.next.next.next);

    }

    @Nested
    @DisplayName("""
            For testing toDigitString and fromDigitString methods
            For example: 
                "249" -> Should be transformed to ListNode("249") without reversing
            """)
    class ListNodeToAndFromStringTest {

        @Test
        @DisplayName("""
                ListNode (249) -> 249
                """)
        void testToDigitStringMethod() {
            ListNode actual = new ListNode(2, new ListNode(4, new ListNode(9)));
            String result = toDigitString(actual);

            Assertions.assertEquals("249", result, () -> "Should be equal");

            actual = new ListNode(2);
            result = toDigitString(actual);

            Assertions.assertEquals("2", result, () -> "Should be equal to 2");

        }

        @Test
        @DisplayName("""
                reverse String "249" should be converted to List(249)
                """)
        void testFromDigitStringMethod() {
            ListNode root = fromDigitString("249");
            Assertions.assertEquals(2, root.val);
            Assertions.assertEquals(4, root.next.val);
            Assertions.assertEquals(9, root.next.next.val);

            root = fromDigitString("1");
            Assertions.assertEquals(1, root.val);
            Assertions.assertNull(root.next);


        }

    }

    @DisplayName("""
        Adding string as an array of digits as numbers. For example
        "10001" + "543" should be "10544"
        """)
    class AddStringOfDigitsAsNumbersTest {

        @DisplayName("""
            "0" + "0" should be equal "0"
            """)
        @Test
        void zeroStringPlusZeroString() {

            String s1 = "0";
            String s2 = "0";

            Assertions.assertEquals("0", add(s1, s2));

        }

        @ParameterizedTest(name = "{0} + {1} = {2}")
        @CsvSource({
                "0, 0, 0",
                "0, 1, 1",
                "101, 1, 102",
                "342, 465, 807",
                "9999999, 9999, 10009998",
                "10001, 543, 10544",
                "10003, 543, 10546",
                "942, 9465, 10407"

        })
        void stringAddingTests(String s1, String s2, String expected) {
            Assertions.assertEquals(expected, add(s1, s2));
        }

    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //All logic for this task demands all strings should be reverted

        String s1 = new StringBuilder(toDigitString(l1)).reverse().toString();
        String s2 = new StringBuilder(toDigitString(l2)).reverse().toString();
        String result = new StringBuilder(add(s1, s2)).reverse().toString();

        return fromDigitString(result);
    }

    private ListNode fromDigitString(String from) { //807
        if (from == null || from.isEmpty()) return null;
        if (from.length() == 1) return new ListNode(Integer.parseInt(from));

        String[] tmp = from.split("");

        int currentPointer = 1;

        ListNode root = new ListNode(Integer.parseInt(tmp[0]));

        ListNode current = new ListNode(Integer.parseInt(tmp[currentPointer]));
        root.next = current;

        while (currentPointer < tmp.length - 1) {
            ListNode memoized = current;
            current = new ListNode(Integer.parseInt(tmp[++currentPointer]));
            memoized.next = current;

        }
        return root;
    }

    private String toDigitString(ListNode node) {
        if (node == null) return "";

        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        ListNode next = node.next;

        while (next != null) {
            sb.append(next.val);
            next = next.next;
        }
        return sb.toString();
    }

    public static String add(String s1, String s2) {
        String longest = s1;
        String shortest = s2;

        if (s2.length() > s1.length()) {
            longest = s2;
            shortest = s1;
        }
        int i = longest.length() - 1;
        int j = shortest.length() - 1;

        int[] collector = new int[longest.length() + 1];

        int accumulator = 0;
        while (i >= 0) {
            int firstDigit = Integer.parseInt(String.valueOf(longest.charAt(i)));
            int secondDigit = 0;

            if (j >= 0 ) {
                secondDigit = Integer.parseInt(String.valueOf(shortest.charAt(j)));
            }

            int result = firstDigit + secondDigit + accumulator;

            if (result > 9) {
                accumulator = 1;
                result = result - 10;
            } else {
                accumulator = 0;
            }

            collector[longest.length() - 1 - i] = result;
            i--; j--;
        }

        int arraySize = longest.length();

        if (accumulator > 0) {
            collector[longest.length()] = accumulator;
            arraySize += 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int k = arraySize - 1; k >= 0; k--) {
            sb.append(collector[k]);
        }

        return sb.toString();

    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(){this(0, null);}
    ListNode(int val) {this(val, null);}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}

}
