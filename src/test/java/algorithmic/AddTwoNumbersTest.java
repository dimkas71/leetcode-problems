package algorithmic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static algorithmic.Utils.reverse;

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
        ListNode l1 = fromArray(new int[]{2, 4, 3});
        ListNode l2 = fromArray(new int[]{5, 6, 4});

        long value1 = toReversedLong(l1);
        long value2 = toReversedLong(l2);
        long result = value1 + value2;

        Assertions.assertArrayEquals(new int[]{7,0,8}, toArray(fromLongReversed(result)));
    }
    @DisplayName("""
        Example 1:
        Input: l1 = [2,4,3], l2 = [5,6,4]
        Output: [7,0,8]
        Explanation: 342 + 465 = 807.
    """)
    @Test
    void exampleWithAddTwoNumbers1() {

        ListNode l1 = fromDigitString(reverse("243"));
        ListNode l2 = fromDigitString(reverse("564"));

        ListNode listNode = addTwoNumbers(l1, l2);

        Assertions.assertEquals("708", toDigitString(listNode));


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
        ListNode l1 = fromDigitString(reverse("249"));
        ListNode l2 = fromDigitString(reverse("5649"));

        Assertions.assertEquals("10407", toDigitString(addTwoNumbers(l1, l2)));
    }

    @DisplayName("""
            [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
            [5,6,4]
            """)
    @Test
    void failedBigNumberLeetCodeTest() {

    }



    private ListNode fromLongReversed(long result) {
        return fromArray(Arrays.stream(
                                new StringBuilder().append(String.valueOf(result)).reverse().toString().split("")
                            ).mapToInt(s -> Integer.parseInt(s))
                             .toArray()
        );

    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return fromDigitString(Utils.add(toDigitString(l1), toDigitString(l2)));
    }

    private long toLong(ListNode ln) {
        if (ln == null) return 0;

        StringBuilder sb = new StringBuilder();
        sb.append(ln.val);
        ListNode next = ln.next;

        while (next != null) {
            sb.append(next.val);
            next = next.next;
        }

        return Long.parseLong(sb.reverse().toString());

    }

    private ListNode fromLong(long l) {
        if (l == 0) return new ListNode(0);
        String[] tmp = String.valueOf(l).split(""); //["8", "0", "7"] it needs a reverse order here...
        String[] splitted = new String[tmp.length];
        int pointer = tmp.length - 1;

        while (pointer >= 0) {
            splitted[tmp.length - 1 - pointer] = tmp[pointer];
            pointer--;
        }

        if (splitted.length == 1) return new ListNode(Integer.parseInt(splitted[0]));

        int i = 0;
        int j = 1;

        ListNode root = new ListNode(Integer.parseInt(splitted[i]));

        ListNode current = new ListNode(Integer.parseInt(splitted[j]));
        root.next = current;

        while (j < splitted.length - 1) {
            i++; j++;
            ListNode temp = current;
            current = new ListNode(Integer.parseInt(splitted[j]));
            temp.next = current;
        }

        return root;
    }

    private ListNode fromArray(int[] array) {
        if ((array == null) || (array.length == 0)) return null;
        if (array.length == 1) return new ListNode(array[0]);
        //At this point the array's length is greater than 1!!!;

        int i = 0;
        int j = 1;
        ListNode root = new ListNode(array[i]);
        ListNode current = new ListNode(array[j]);
        root.next = current;

        while (j < array.length - 1) {
            i++;j++;
            ListNode temp = current;
            current = new ListNode(array[j]);
            temp.next = current;

        }
        return root;
    }

    private int[] toArray(final ListNode node) {
        if (node == null) return new int[]{};

        int size = 1;
        ListNode next = node.next;
        while (next != null) {
            size++;
            next = next.next;
        }

        int[] result = new int[size];
        int index = 0;
        result[index++] = node.val;

        next = node.next;
        while (next != null) {
            result[index++] = next.val;
            next = next.next;
        }

        return result;


    }

    private long toReversedLong(final ListNode node) {
        if (node == null) return 0;
        StringBuilder sb = new StringBuilder();

        sb.append(node.val);
        ListNode next = node.next;

        while (next != null) {
            sb.append(next.val);
            next = next.next;
        }

        return Long.parseLong(sb.reverse().toString());
    }

    private ListNode fromDigitString(String from) {
        if (from == null || from.isEmpty()) return null;
        if (from.length() == 1) return new ListNode(Integer.parseInt(from));

        String[] tmp = from.split("");
        String[] splitted = new String[tmp.length];
        int pointer = tmp.length - 1;

        while (pointer >= 0) {
            splitted[tmp.length - 1 - pointer] = tmp[pointer];
            pointer--;
        }

        if (splitted.length == 1) return new ListNode(Integer.parseInt(splitted[0]));

        int i = 0;
        int j = 1;

        ListNode root = new ListNode(Integer.parseInt(splitted[i]));

        ListNode current = new ListNode(Integer.parseInt(splitted[j]));
        root.next = current;

        while (j < splitted.length - 1) {
            i++; j++;
            ListNode temp = current;
            current = new ListNode(Integer.parseInt(splitted[j]));
            temp.next = current;
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
}

class ListNode {
    int val;
    ListNode next;

    ListNode(){this(0, null);}
    ListNode(int val) {this(val, null);}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}

}
