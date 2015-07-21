/**
 *  In response to coin change problem here https://www.hackerrank.com/challenges/coin-change
 *  The problem is solved using dynamic programming approach eliminating overlapping subproblems.
 */
package com.vios.java.test;

/**
 * @author Hanni
 * Tuesday, 21 July, 2015
 *
 */
import java.util.Arrays;
import java.util.Scanner;

public class CoinChanger {
    private static Scanner sc;

    public static long findMaximumPossiblePairings(int n, int coins[]) {
        if (n < 0 || coins == null || coins.length == 0) {
            return 0;
        }
        Arrays.sort(coins);

        long tmp[] = new long[n + 1];
        tmp[0] = 1;
        for (int i = 0; i < coins.length; ++i) {
            for (int j = coins[i]; j <= n; ++j) {
                tmp[j] += tmp[j - coins[i]];
            }
        }
        return tmp[n];
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = sc.nextInt();
        int[] m = new int[count];
        for (int i = 0; i < count; i++) {
            m[i] = sc.nextInt();
        }
        System.out.println(findMaximumPossiblePairings(n, m));
    }
}

/*  
    Input for upper bound test case for this problem. 
    250 50
    1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50
*/