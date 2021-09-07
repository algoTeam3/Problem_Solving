package SWEA;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class SWEA_D3_1860_진기의최고급붕어빵 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for(int t = 1; t <= tc; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();
            ArrayList<Integer> a = new ArrayList<>();
            boolean flag = false;

            for(int i = 0; i < N; i++) {
                int tmp = sc.nextInt();
                a.add(tmp);
            }

            Collections.sort(a);
            for(int i = 0; i < N; i++) {
                int tmp = a.get(i);
                int sum = K * (tmp / M);
                if(sum < (i + 1))
                    flag = true;
            }
            if(!flag)
                System.out.println("#" + t + " " + "Possible");
            else
                System.out.println("#" + t + " " + "Impossible");
        }
    }

}
