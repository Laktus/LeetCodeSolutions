import java.util.HashMap;
import java.util.Map;

public class ID322_CoinChange {
    public static int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> mem = new HashMap<>();
        return coinChange(coins, amount, mem);
    }

    public static int coinChange(int[] coins, int amount, Map<Integer, Integer> mem) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (mem.get(amount) != null) {
            return mem.get(amount);
        }

        int res = -1;
        for (int i = 0; i < coins.length; i++) {
            int coin = coinChange(coins, amount - coins[i], mem);
            if (coin != -1) {
                res = res == -1 ? 1 + coin : Math.min(res, 1 + coin);
            }
        }
        mem.put(amount, res);
        return res;
    }
}
