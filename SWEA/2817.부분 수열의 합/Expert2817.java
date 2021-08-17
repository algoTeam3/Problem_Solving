package com.algo;

import java.util.Scanner;

public class Expert2817 {
    static int n,sum,r,count;
    static int input[];
    static int arr[];
    static boolean isSelect[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data ="2\n" +
                "4 3\n" +
                "1 2 1 2\n"+
                "4 3\n" +
                "1 2 1 2";

        sc=new Scanner(data);

        int T=sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            count=0;
            n = sc.nextInt();
            r = sc.nextInt();

            input = new int[n];
            isSelect=new boolean[n];
            arr=new int[n];

            sum = 0;
            for (int i = 0; i <n; i++) {
                input[i]=sc.nextInt();

            }

            dfs(0);
            System.out.print("#"+test_case+" "+count+"\n");
        }


    }

    static void dfs(int cnt){
        if (cnt == n) {

            for(int x=0;x<n;x++){
                if(isSelect[x]){
//                    System.out.print(input[x]+" ");
                    sum+=input[x];

                }

            }
//            System.out.println();
            if(sum==r){
                count++;
            }
            sum=0;
            return;
        }

        isSelect[cnt]=true;
        dfs(cnt+1);
        isSelect[cnt]=false;
        dfs(cnt+1);


    }
}
