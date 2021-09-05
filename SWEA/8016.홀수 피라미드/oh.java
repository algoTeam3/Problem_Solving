import java.io.IOException;

import java.util.Scanner;


public class Expert8016 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();


        int L = 1;
        int R = 1;
        for (int test_case = 1; test_case <= T; test_case++) {
            long amount = 0;
            long amount2 = 0;
            int layer = sc.nextInt();
            for (int i = 1; i < layer; i++) {
                amount += 4 * i - 2;
                amount2 += 4 * i + 2;
            }
            System.out.print("#" + test_case + " ");
            System.out.print(L + amount + " ");
            System.out.print(R + amount2 + "\n");

        }


    }


}
