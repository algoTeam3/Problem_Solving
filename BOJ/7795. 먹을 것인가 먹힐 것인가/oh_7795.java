
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ_7795_먹을 것인가 먹힐 것인가
 * @date : 2021. 12. 13.
 * @language : JAVA
 * @classification : binnary search
 * @time_limit : 1sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description
 **/
public class oh_7795 {
    static int[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());                    // testcase

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());               // A의 수
            int M = Integer.parseInt(st.nextToken());               // B의 수
            int answer = 0;
            int[] A = new int[N];                                   // A담을 배열
            B = new int[M];                                         // B담을 배열

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < A.length; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < B.length; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(B);

            for (int a : A) {
                answer += lowerBound(B.length-1, a);
            }
            System.out.println(answer);


        }


    }

    private static int lowerBound(int max1, int a) {
        int min = 0;
        int max = max1;

        while(min<=max){
            int mid = (min+max)/2;

            if(B[mid]>=a){
                max = mid-1;
            }else{
                min = mid+1;
            }
        }
        return min;
    }

}
