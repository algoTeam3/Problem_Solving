import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 별, 동그라미, 네모, 세모
 *  0   1   2   3
 */
public class BOJ14696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T =Integer.parseInt(br.readLine());
       
        for (int i = 0; i <T ; i++) {
            //A덱 세팅
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] A = new int[4];
            for (int j = 0; j < N; j++) {
                A[4-Integer.parseInt(st.nextToken())]++;
            }
            //B덱 세팅
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int[] B = new int[4];
            for (int j = 0; j < M; j++) {
                B[4-Integer.parseInt(st.nextToken())]++;
            }
            //비교
            char answer ='D';
            for (int j = 0; j < 4; j++) {
                if(A[j]==B[j]){
                    continue;
                }else{
                    answer=A[j]>B[j]?'A':'B';
                    break;
                }
            }
            System.out.println(answer);
        }
    }
}
