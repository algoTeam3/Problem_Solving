import java.util.Scanner;

public class Expert7102 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data =
                "2\n" +
                "6 6\n" +
                "6 4";
        sc=new Scanner(data);
        int T =sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N=sc.nextInt();
            int M=sc.nextInt();
            int sum[]= new int[N+M+1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    sum[i+j]++;
                }
            }
            int max = Integer.MIN_VALUE;
            for (int i : sum) {
                max=Math.max(max,i);
            }
            System.out.print("#"+test_case+" ");
            for (int i = 0; i < sum.length; i++) {
                if (sum[i]==max){
                    System.out.printf("%d ",i);
                }
            }
            System.out.println();
        }

    }
}
