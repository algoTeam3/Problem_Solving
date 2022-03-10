
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ1946
 * @date : 2022-02-10
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class oh_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            //입력받기
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int fir = Integer.parseInt(st.nextToken());
                int sec = Integer.parseInt(st.nextToken());

                arr[j]= new int[]{fir,sec};
            }
            Arrays.sort(arr,(o1, o2) -> o1[0]-o2[0]);

            int count = 1;
            int max = arr[0][1];
            for (int j = 1; j < N; j++) {
                if(arr[j][1]<max){
                    count++;
                    max=arr[j][1];
                }
            }
            System.out.println(count);
        }
    }
}
