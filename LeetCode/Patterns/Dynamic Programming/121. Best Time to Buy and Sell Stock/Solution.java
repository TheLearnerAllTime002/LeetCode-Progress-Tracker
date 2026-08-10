class Solution {
    public int maxProfit(int[] price) {
        int buy_price = price[0];
        int profit = 0;

        for (int i = 1; i < price.length; i++) {
            if (price[i] < buy_price) {
                buy_price = price[i];
            } else {
                int current_profit = price[i] - buy_price;
                profit = Math.max(current_profit, profit);
            }
        }
        return profit;
    }
}