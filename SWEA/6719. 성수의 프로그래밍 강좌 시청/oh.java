import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Expert6719 {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String data ="3\n" +
                "2 2\n" +
                "2 3\n" +
                "2 1\n" +
                "2 3\n" +
                "5 3\n" +
                "9 5 2 3 5";
        br=new BufferedReader(new StringReader(data));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int K=Integer.parseInt(st.nextToken());
            Integer arr[]=new Integer[N];
            st=new StringTokenizer(br.readLine());
            //배열에 담기
            for (int i = 0; i < N; i++) {
                arr[i]=Integer.parseInt(st.nextToken());
            }
            //큰 수부터 차례대로 담기
            Arrays.sort(arr,Collections.reverseOrder());
            Integer input[]=new Integer[K];
            for (int i = 0; i < K; i++) {
                input[i]=arr[i];
            }
            //오름 차순 정렬 후 계산
            Arrays.sort(input);
            double sum=0;
            for (int i = 0; i < K; i++) {
                sum=(double)((input[i]+sum)/2);

            }

            System.out.printf("#%d %f\n",test_case,sum);
        }
    }
}
