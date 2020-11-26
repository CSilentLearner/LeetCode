package 贪心算法._0376摆动序列;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 本题是一个很简单的贪心思想的题目，因为每个孩子最多只能分给一块饼干,
 * 所以拿最大的饼干先满足胃口最大的孩子，每一步局部最优肯定最后是一个全局最优！
 *
 * NB.详细解见OneNote笔记！！
 *
 * 简单举例：
 * 数组：[1,17,5,10,13,15,10,5,16,8]
 * 差值：[+16,-12,+5,+3,+2,-5,-5,+11,-8]
 * + - + + + - - + -
 * 统计正负交替个数再加一即可
 * */
public class _0376Solution {

    //思路都是贪心，但代码实现方式与题解不同！！
    public static int wiggleMaxLength(int[] nums) {
        // 题目中说了：少于两个元素的序列均为摆动序列
        if (nums.length < 2){
            return nums.length;
        }
        int curDiff = 0;
        int preDiff = 0;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 0){
                curDiff = 1;
            }
            if (nums[i] - nums[i - 1] < 0){
                curDiff = -1;
            }
            if (curDiff != preDiff){
                result++;
            }
            preDiff = curDiff;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(nums));
        int result = wiggleMaxLength(nums);
        System.out.println(result);
    }
}
