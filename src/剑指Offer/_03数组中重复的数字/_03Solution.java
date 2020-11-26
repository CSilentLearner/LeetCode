package 剑指Offer._03数组中重复的数字;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 要求时间复杂度O(N)，空间复杂度O(1)。因此不能使用排序的方法，也不能使用额外的标记数；
 * 此题对自己来说，一个比较特别的点就是交换的过程中，发现是否有重复数字！
 * */
public class _03Solution {
    public static int findRepeatNumber(int[] nums) {
        int len = nums.length;

        for(int i = 0; i < len; i++){
            //此处的if答案用的while，其实多用了一个判断是无用的，个人是这么认为的！！
            //但是后来自己又觉得还是用while说的通一点
            while (nums[i] != i){//只要当前位置的元素不在当前位置上，就需要比较或者交换一下了
                if(nums[i] == nums[nums[i]]){//发现当前位置的元素在该元素值为下标的位置上，则是重复
                    return nums[i];
                }
                //发现当前位置的元素也在该元素值为下标的位置上，则交换
                int tem = nums[i];
                nums[i] = nums[tem];
                nums[tem] = tem;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt(); //输入数组长度
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(nums));

        //调用方法
        int result = findRepeatNumber(nums);
        System.out.println(result);

    }
}