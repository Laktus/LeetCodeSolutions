import java.util.HashMap;
import java.util.Map;

public class ID322_CoinChange {
    public static int coinChange(int[] coins, int amount) {
        return coinChangeTopDown(coins, amount, new HashMap<>());
    }

    private static int coinChangeTopDown(int[] coins, int amount, Map<Integer, Integer> mem) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (mem.get(amount) != null) {
            return mem.get(amount);
        }

        int res = -1;
        for (int i = 0; i < coins.length; i++) {
            int coin = coinChangeTopDown(coins, amount - coins[i], mem);
            if (coin != -1) {
                res = res == -1 ? 1 + coin : Math.min(res, 1 + coin);
            }
        }
        mem.put(amount, res);
        return res;
    }

    private static int coinChangeBottomUp(int[] coins, int amount){
        int[] dp = new int[amount+1];
        dp[0] = 0;

        for(int i = 1; i < dp.length; i++){
            int min = Integer.MAX_VALUE - 1;
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i) {
                    min = Math.min(min, dp[i - coins[j]]);
                }
            }
            dp[i] = min + 1;
        }

        return dp[amount] < 0 ? -1 : dp[amount];
    }
}