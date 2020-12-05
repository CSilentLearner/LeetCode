package 贪心算法._0122买卖股票的最佳时机II;

/**
 * 股票之类的问题基本上是动态规划，这道题也可以使用动态规划来解决，但巧妙使用贪心思想，
 * 将使得问题变得非常简单，具体思路解析不在这进行展示，因为思路明白后代码非常简单！
 *
 *
 * NB.详细解见OneNote笔记！！
 * */
public class _0122Solution {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int curr = prices[i];
            int prev = prices[i - 1];
            if (curr > prev) sum += curr - prev;
        }
        return sum;
    }

    public static void main(String[] args) {
       _0122Solution sol = new _0122Solution();
        System.out.println(sol.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
