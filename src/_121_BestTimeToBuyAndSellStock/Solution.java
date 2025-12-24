package _121_BestTimeToBuyAndSellStock;

public class Solution {
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
		System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
		System.out.println(maxProfit(new int[]{0, 99}));
		System.out.println(maxProfit(new int[]{2, 4, 1}));
	}

	public static int maxProfit(int[] prices) {

		int buyIndex = 0;
		int sellIndex = buyIndex + 1;

		int profit = 0;

		while (sellIndex < prices.length){
			if (prices[sellIndex] - prices[buyIndex] < 0){
				buyIndex ++;
				if (buyIndex == sellIndex){
					sellIndex ++;
				}
			}
			else {
				if (profit < prices[sellIndex] - prices[buyIndex]){
					profit = prices[sellIndex] - prices[buyIndex];
				}
				sellIndex ++;
			}
		}
		return profit;
	}
}
