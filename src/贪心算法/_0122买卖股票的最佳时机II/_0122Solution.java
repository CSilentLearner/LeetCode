package 贪心算法._0122买卖股票的最佳时机II;


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
