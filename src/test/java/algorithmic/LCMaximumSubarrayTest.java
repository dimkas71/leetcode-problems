package algorithmic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("""
        53. Maximum Subarray
        Given an integer array nums, find the contiguous subarray (containing at least one number) 
        which has the largest sum and return its sum.
                
        Example 1:
                
        Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
        Output: 6
        Explanation: [4,-1,2,1] has the largest sum = 6.
        
        Example 2:
                
        Input: nums = [1]
        Output: 1
        Example 3:
                
        Input: nums = [5,4,-1,7,8]
        Output: 23
                
        Constraints:
                
        1 <= nums.length <= 3 * 104
        -105 <= nums[i] <= 105
        Follow up: If you have figured out the O(n) solution, try coding another solution using the divide
        and conquer approach, which is more subtle.
        """)
class LCMaximumSubarrayTest {



    @DisplayName("""
            Test array consists of one value
            """)
    @Test
    void testSingleValue() {
        Assertions.assertEquals(1, maxSubArray(new int[]{1}));
        Assertions.assertEquals(2, maxSubArray(new int[]{2}));
        Assertions.assertEquals(100, maxSubArray(new int[]{100}));
    }


    private int maxSubArray(int[] array) {
        if (array == null) return 0;
        if (array.length == 0) return 0;

        int windowStart = 0;
        int windowEnd = 0;

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        while (windowEnd < array.length) {
            currentSum += array[windowEnd];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            } else {
                currentSum -= array[windowStart];
                windowStart += 1;
            }
            windowEnd++;
        }

        return maxSum;
    }
}
