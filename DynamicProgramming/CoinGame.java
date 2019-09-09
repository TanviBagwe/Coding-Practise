package DynamicProgramming;

/**
 * Objective: In this game, which we will call the coins-in-a-line game, an even number, n, of coins, of various denominations from various countries, are placed in a line. Two players, who we will call Alice and Bob, take turns removing one of the coins from either end of the remaining line of coins. That is, when it is a player’s turn, he or she removes the coin at the left or right end of the line of coins and adds that coin to his or her collection. The player who removes a set of coins with larger total value than the other player wins, where we assume that both Alice and Bob know the value of each coin.
 * <p>
 * Example:
 * <p>
 * coins []  =  { 6, 9, 1, 2, 16, 8}
 * <p>
 * trial 1: (players will pick the best option available for them)
 * coins [] = { 6, 9, 1, 2, 16, 8} , Alice picks 8
 * coins [] = { 6, 9, 1, 2, 16}, Bob picks 16
 * coins [] = { 6, 9, 1, 2}, Alice picks 6
 * coins [] = { 9, 1, 2}, Bob picks 9
 * coins [] = {1, 2}, Alice picks 2
 * coins [] = {1}, Bob picks 1
 * Alice: 8+6+2 =16 Bob: 16+9+1=26 => Alice Lost
 * <p>
 * So clearly picking up the best in each move is not good for Alice. What else Alice can do to win the game.
 * <p>
 * trial 2: (Alice thinks about Bob's move, Will discuss the strategy in solution)
 * coins [] = { 6, 9, 1, 2, 16, 8} , Alice picks 6
 * coins [] = { 9, 1, 2, 16, 8}, Bob picks 9
 * coins [] = { 1, 2, 16, 8}, Alice picks 1
 * coins [] = 2, 16, 8}, Bob picks 8
 * coins [] = {2, 16}, Alice picks 16
 * coins [] = {2}, Bob picks 2
 * Alice: 6+1+16 =23 Bob: 9+8+2=19 => Alice Won
 * <p>
 * So this time Alice has won. Let's see the solution and discuss what Alice has done to win the game.
 */
public class CoinGame {

    public static int solve(int[] A) {
        int[][] MV = new int[A.length][A.length];

        for (int interval = 0; interval < A.length; interval++) {
            for (int i = 0, j = interval; j < A.length; i++, j++) {
                // a = MV(i+2,j) - Alice chooses i Bob chooses i+1
                // b = MV(i+1,j-1)- Alice chooses i , Bob chooses j OR
                // Alice chooses j , Bob chooses i
                // c = MV(i,j-2)- Alice chooses j , Bob chooses j-1
                int a, b, c;
                if (i + 2 <= j)
                    a = MV[i + 2][j];
                else
                    a = 0;
                //////////////////////////////////
                if (i + 1 <= j - 1)
                    b = MV[i + 1][j - 1];
                else
                    b = 0;
                //////////////////////////////////
                if (i <= j - 2)
                    c = MV[i][j - 2];
                else
                    c = 0;
                //////////////////////////////////
                MV[i][j] = Math
                        .max(A[i] + Math.min(a, b), A[j] + Math.min(b, c));
            }
        }
        return MV[0][A.length - 1];
    }

    public static void main(String[] args) {
        int[] B = {20, 30, 2, 2, 2, 10};
        System.out.println("Max value pick up by player1(Alice) " + solve(B));

        int arr1[] = {8, 15, 3, 7};
        System.out.println("Max value pick up by player1(Alice) " + solve(arr1));
    }

}