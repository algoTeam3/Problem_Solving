package exD3;


import java.io.IOException;

import java.util.Scanner;


public class Expert10505 {
    public static void main(String[] args) throws IOException {
        String data ="3\n" +
                "7\n" +
                "15 15 15 15 15 15 15\n" +
                "10\n" +
                "1 1 1 1 1 1 1 1 1 100\n" +
                "7\n" +
                "2 7 1 8 2 8 4";

        Scanner sc = new Scanner(System.in);
        sc= new Scanner(data);


        int T= sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++){
            int N = sc.nextInt();
            int sum=0;
            int[] arr = new int[N];
            for(int i=0;i<N;i++){
                int num = sc.nextInt();
                arr[i]= num;
                sum+= num;
            }
            int avg =sum/N;
            int count=0;
            for(int x:arr){
                if(x<=avg){
                    count++;
            }
        }
            System.out.print("#"+test_case+" "+count+"\n");



    }
}}
