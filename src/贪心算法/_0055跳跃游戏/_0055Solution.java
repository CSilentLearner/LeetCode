package 贪心算法._0055跳跃游戏;

/**
 * 这道题的贪心确实没有想到，总的来说就是寻找当前位置的最大覆盖范围，看是否覆盖的到整个数据即可！
 *
 * NB.详细解见OneNote笔记！！
 * */

public class _0055Solution {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int len = nums.length; // 数组的长度
        int cover = 0; //覆盖的范围
        for (int i = 0; i <= cover; i++) { // 第一次跳跃的话，覆盖范围就是第一个数，所以需要<=cover
            cover = Math.max(i + nums[i], cover);// 比如下面的示例，从第1个数跳，cover最大覆盖范围等于i+2=2（下标）
            if (cover + 1 >= len) return true; //cover是下标，所以需要+1
        }
        return false;
    }

    public static void main(String[] args) {
        _0055Solution sol = new _0055Solution();
        System.out.println(sol.canJump(new int[]{2,3,1,1,4}));
    }
}
