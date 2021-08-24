package BOJ;

import java.util.Scanner;

public class BOJ_B2_2292_벌집 {
     // N(1 ≤ N ≤ 1,000,000,000)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int cnt = 1;
        int num = 2;

        if (N == 1) {
            System.out.print(1);
        } else {
            while (num <= N) {
                num = num + (6 * cnt);
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}
