package SWEA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SWEA_D4_성수의프로그래밍 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for(int t = 1; t <= tc; t++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            double r = 0;
            ArrayList<Integer> al = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                int tmp = sc.nextInt();
                al.add(tmp);
            }

            Collections.sort(al);

            for(int i = al.size() - k; i < al.size(); i++) {
                r = (r + al.get(i)) / 2;
            }
            System.out.printf("#%d %.6f\n", t, r);
        }
}
