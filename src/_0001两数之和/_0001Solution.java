package _0001两数之和;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _0001Solution {
    /**
     * 方法1：两层for，依次遍历，遍历求解
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * */
    public static int[] twoSum_1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 方法2：把加法变减法，减法的结果去哈希表去做查询，查到就成功找到了，查不到插入，直到结束
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * */
    public static int[] twoSum_2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum_2(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
