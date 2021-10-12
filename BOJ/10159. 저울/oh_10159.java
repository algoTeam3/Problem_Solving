import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class oh_10159 {
    static final int INF=987654321;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] map = new int[n + 1][n + 1];
        //map 생성
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i==j)continue;
                map[i][j]=INF;
            }
        }
        //값 입력
        for (int i = 0; i < m; i++) {
           st = new StringTokenizer(br.readLine());
           int to=Integer.parseInt(st.nextToken());
           int from=Integer.parseInt(st.nextToken());
           
           map[from][to]=1;
        }
        //플로이드
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    map[i][j]=Math.min(map[i][j],map[i][k]+map[k][j]);
                }
            }
        }
        //출력
        for (int i = 1; i <= n; i++) {
            int count=0;
            for (int j = 1; j <= n; j++) {
                if(map[i][j]==INF&&map[j][i]==INF)count++;
            }
            System.out.println(count);
        }
    }
}
