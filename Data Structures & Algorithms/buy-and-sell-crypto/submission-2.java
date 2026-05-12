class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int minBuy = prices[0];

        for (int i : prices) {
            max = Math.max(max, i - minBuy);
            minBuy = Math.min(minBuy, i);
        }
        return max;
    }
}
