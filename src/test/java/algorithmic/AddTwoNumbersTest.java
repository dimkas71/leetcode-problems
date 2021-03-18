package algorithmic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return new ListNode();
    }

    private ListNode fromArray(int[] array) {
        if ((array == null) || (array.length == 0)) return new ListNode();
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

    private int[] toArray(ListNode node) {
        if (node == null) return new int[]{};



    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(){this(0, null);}
    ListNode(int val) {this(val, null);}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}

}
