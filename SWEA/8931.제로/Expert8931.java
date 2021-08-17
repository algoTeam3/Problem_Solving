package exD3;

import java.util.Scanner;
import java.util.Stack;

public class Expert8931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data =

                        "2\n" +
                        "6\n" +
                        "10000\n" +
                        "10000\n" +
                        "0\n" +
                        "0\n" +
                        "100000\n" +
                        "0\n" +
                        "10\n" +
                        "1\n" +
                        "3\n" +
                        "5\n" +
                        "4\n" +
                        "0\n" +
                        "0\n" +
                        "7\n" +
                        "0\n" +
                        "0\n" +
                        "6";

        sc = new Scanner(data);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int input = sc.nextInt();
            int num = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < input; i++) {
                num = sc.nextInt();
                if (num == 0) {
                    if(stack.isEmpty()){
                        continue;
                    }
                    stack.pop();
                } else {
                    stack.push(num);
                }
            }

            System.out.print("#" + test_case + " ");
            if (stack.isEmpty()) {
                System.out.printf("%d\n",0);
            } else {
                int sum=0;
                for (int x : stack) {
                    sum+=x;
                }
                    System.out.print(sum+"\n");
            }

        }
    }
}
