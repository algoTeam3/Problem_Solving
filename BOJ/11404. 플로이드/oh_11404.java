import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class oh_11404 {
    static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[][] map = new int[n+1][n+1];
        //맵생성
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(i==j)continue;
                map[i][j]=INF;
            }

        }
        //값입력받기
        int m= Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from =Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            map[from][to]= Math.min(map[from][to],value);

        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Math.min(map[i][j], (map[i][k] + map[k][j]));
                }
            }
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == INF) {
                    map[i][j] = 0;
                }
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
