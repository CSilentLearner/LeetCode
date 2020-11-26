package 贪心算法._0053最大子序和;

import java.util.Arrays;
import java.util.Scanner;

public class _0053Solution {

    //暴力：时间复杂度：O(n^2) 空间复杂度：O(1)
    public static int maxSubArray1(int[] nums) {
        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) { // 设置起始位置
            count = 0;
            for (int j = i; j < nums.length; j++) { // 每次从起始位置i开始遍历寻找最大值
                count += nums[j];
                result = count > result ? count : result;
            }
        }
        return result;
    }

    //贪心：时间复杂度：O(n) 空间复杂度：O(1)
    public static int maxSubArray2(int[] nums) {
        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (count > result) { // 取区间累计的最大值（相当于不断确定最大子序终止位置）
                result = count;
            }
            if (count <= 0) count = 0; // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和
        }
        return result;
    }

    //动态规划
    //本题等到动态规划的时候，详细解答
    public static int maxSubArray3(int[] nums) {
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(nums));

//        int result = maxSubArray1(nums);
        int result = maxSubArray2(nums);
//        int result = maxSubArray3(nums);
        System.out.println(result);
    }
}
