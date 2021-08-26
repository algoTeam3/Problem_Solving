package SWEA;

import java.io.IOException;
import java.util.Scanner;

public class SWEA_4일차_거듭제곱 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10 ; t++) {
            sc.nextInt();  // 테스트케이스 번호
            System.out.println("#" + t + " " + calc(sc.nextInt(), sc.nextInt()));
        }
    }

    private static int calc(int num, int cnt) {
        if (cnt == 0) return 1;
        return num * calc(num, cnt - 1);
    }
}
