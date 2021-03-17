package algorithmic;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@DisplayName("""
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
        """)
class LeetCodeTwoSumTest {


    @DisplayName("""
        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Output: Because nums[0] + nums[1] == 9, we return [0, 1].
            """)
    @Test
    void example1() {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        assertArrayEquals(new int[]{0, 1}, twoSum(numbers, target));
    }

    @DisplayName("""
        Input: nums = [3,2,4], target = 6
        Output: [1,2]
            """)
    @Test
    void example2() {
        int[] numbers = {3, 2, 4};
        int target = 6;

        assertArrayEquals(new int[]{1, 2}, twoSum(numbers, target));

    }

    @DisplayName("""
        Input: nums = [3,3], target = 6
        Output: [0,1]
            """)
    @Test
    void example3() {
        int[] numbers = {3, 3};
        int target = 6;

        assertArrayEquals(new int[]{0, 1}, twoSum(numbers, target));

    }

    private int[] twoSum(int[] numbers, int target) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            first = i;
            for (int j = i + 1; j < numbers.length; j++) {
                second = j;
                if ((numbers[i] + numbers[j]) == target) return new int[]{first, second};
            }
        }

        return new int[]{first, second};
    }
}
