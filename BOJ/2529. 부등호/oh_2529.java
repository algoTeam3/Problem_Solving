package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class oh_2529 {
    static int n;
    static long max, min;
    static boolean check[];
    static char ch[];
    static int input[];
    static StringBuilder answerMax=new StringBuilder();
    static StringBuilder answerMin=new StringBuilder();
    static String st1;
    static String st2;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ch = new char[n];
        check = new boolean[10];

        //부등호입력
        for (int i = 0; i < n; i++) {
            ch[i] = st.nextToken().charAt(0);
        }

        input = new int[n + 1];
        max = Long.MIN_VALUE;
        min = Long.MAX_VALUE;
        Dfs(0);
        System.out.println(answerMax);
//        System.out.println(st1);

        System.out.println(answerMin);
//        System.out.println(st2);



    }

    private static void Dfs(int cnt) {
        if (cnt == n + 1) {
            cal();
            return;
        }
        for (int i = 0; i < check.length; i++) {
            if (check[i]) continue;
            if (!search(cnt, i)) continue;
            check[i] = true;
            input[cnt] = i;
            Dfs(cnt + 1);
            check[i] = false;

        }
    }

    //가지치기
    private static boolean search(int cnt, int i) {
        boolean flag = true;
        if (cnt == 0) return flag;
        switch (ch[cnt - 1]) {
            case '<':
                flag = input[cnt - 1] < i ? true : false;
                break;
            case '>':
                flag = input[cnt - 1] > i ? true : false;
                break;
        }

        return flag;
    }

    //배열을 숫자로 만들기
    private static void cal() {
        long sum = 0;
        for (int i = input.length-1; i >= 0; i--) {
            sum += input[i] * (long) (Math.pow(10, input.length-1-i));
        }
        if (max < sum) {
            max=sum;
            answerMax = new StringBuilder();
            st1="";
            for (int i : input) {
                answerMax.append(i);
                st1+=i;
            }
        }
        if (min > sum) {
            min=sum;
            answerMin = new StringBuilder();
            st2="";
            for (int i : input) {
                answerMin.append(i);
                st2+=i;
            }
        }
    }
}
