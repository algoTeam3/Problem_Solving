package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2579
 */
public class BOJ_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] score = new int[300];
        int[] max = new int[300];

        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        max[0] = score[0];
        max[1] = score[0] + score[1];
        max[2] = Math.max(score[0], score[1]) + score[2];

        for (int i = 3; i < N; i++) {
            max[i] = Math.max(max[i - 2], max[i - 3] + score[i - 1]) + score[i];
        }

        System.out.println(max[N - 1]);
    }
}
