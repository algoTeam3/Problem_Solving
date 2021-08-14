package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_D3_8931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> s = new Stack<>();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int K = Integer.parseInt(br.readLine());
            for (int k = 0; k < K; k++) {
                int num = Integer.parseInt(br.readLine());
                if(num != 0) {
                    s.push(num);
                }else {
                    s.pop();
                }
            }
            int sum = 0;
            int size = s.size();
            for (int i = 0; i < size; i++) {
                sum += s.pop();
            }
            System.out.println("#" + t + " " + sum);
        }
    }



}
