# leetcode-problems
Solutions for leetcode problems

1. Two sum problem:
   Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
   You may assume that each input would have exactly one solution, and you may not use the same element twice.
   You can return the answer in any order.

        Example 1:
                
        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Output: Because nums[0] + nums[1] == 9, we return [0, 1].
        Example 2:
                
        Input: nums = [3,2,4], target = 6
        Output: [1,2]
        Example 3:
                
        Input: nums = [3,3], target = 6
        Output: [0,1]

2. Add two numbers problem.

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

3. Same tree problem.

   Given the roots of two binary trees p and q, write a function
   to check if they are the same or not.

        Two binary trees are considered the same if they are structurally identical,
        and the nodes have the same value.
        Example 1:
        Input: p = [1,2,3], q = [1,2,3]
        Output: true
        Example 2:

        Input: p = [1,2], q = [1,null,2]
        Output: false
        Example 3:
                
        Input: p = [1,2,1], q = [1,1,2]
        Output: false

4.  
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
    Explanation: The digits that appear in s are [1]. There is no second largest digit.s
            
    Constraints:
            
    1 <= s.length <= 500
    s consists of only lowercase English letters and/or digits.