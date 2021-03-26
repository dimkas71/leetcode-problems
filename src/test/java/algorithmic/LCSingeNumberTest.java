package algorithmic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@DisplayName("""
        Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
        Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?
                
        Example 1:
                
        Input: nums = [2,2,1]
        Output: 1
        Example 2:
                
        Input: nums = [4,1,2,1,2]
        Output: 4
        Example 3:
                
        Input: nums = [1]
        Output: 1
                
        Constraints:
                
        1 <= nums.length <= 3 * 104
        -3 * 104 <= nums[i] <= 3 * 104
        Each element in the array appears twice except for one element which appears only once.
        """)
class LCSingeNumberTest {

    @DisplayName("""
            Example 1:
                
        Input: nums = [2,2,1]
        Output: 1
            """)
    @Test
    void example1() {
        Assertions.assertEquals(1, singleNumber(new int[]{2, 2, 1}));
    }

    @DisplayName("""
        Example 2:
                
        Input: nums = [4,1,2,1,2]
        Output: 4
            """)
    @Test
    void example2() {
        Assertions.assertEquals(4, singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    @DisplayName("""
        Example 3:
                
        Input: nums = [1]
        Output: 1
                
            """)
    @Test
    void example3() {
        Assertions.assertEquals(1, singleNumber(new int[]{1}));
    }

    private int singleNumber(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int elem : numbers) {
            Integer count = map.getOrDefault(elem, 0) + 1;
            map.put(elem, count);
        }

        int found = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                found = entry.getKey();
                break;
            }
        }

        return found;
    }
}

