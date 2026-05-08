public class CoinChange {
    public static void main(String[] args) {
        int coins[] = {1, 2, 5};
        int amount = 11;

        int dp[] = new int[amount + 1];

        for (int i = 1; i <= amount; i++)
            dp[i] = amount + 1;

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        System.out.println("Minimum coins required: " + dp[amount]);
    }
}
//output
//Minimum coins required: 3
//
