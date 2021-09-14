package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_D4_1231_중위순회 {
    static int N;
    static char[] alpabet;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            N = Integer.parseInt(br.readLine());
            alpabet = new char[N + 1];
            for (int i = 1; i <= N; i++) {
                String[] str = br.readLine().split(" ");
                alpabet[i] = str[1].charAt(0);
            }
            System.out.print("#" + t + " ");
            inorder(1);
            System.out.println();
        }
    }

    private static void inorder(int cnt) {
        if (cnt > N) {
            return;
        }

        inorder(cnt * 2);
        System.out.print(alpabet[cnt]);
        inorder(cnt * 2 + 1);
    }
}
