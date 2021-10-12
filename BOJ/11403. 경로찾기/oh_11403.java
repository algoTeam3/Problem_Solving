import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class oh_11403 {
    static int n;
    static int[][] map;
    static final int INF=987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];

        //값 담기
        for (int i = 1; i < map.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < map[i].length; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==0){
                    map[i][j]=INF;
                }
            }
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
            for (int j = 1; j <= n; j++) {
                if(map[i][j]==INF){
                    System.out.print("0"+" ");
                }else{
                    System.out.print("1"+" ");
                }
            }
            System.out.println();
        }
        
    }
}
