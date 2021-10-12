import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class oh_1956 {
    static final int INF =987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v =Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] map = new int[v + 1][v + 1];
        //map 초기화
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                map[i][j]=INF;
            }
        }
        //값 입력

            for (int j = 0; j < e; j++) {
            st=new StringTokenizer(br.readLine());
                int from  = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                map[from][to]=value;

        }
        //플로이드
        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    map[i][j]=Math.min(map[i][j],map[i][k]+map[k][j]);
                }
            }
        }
        //출력
        int sum=0;
        int min=Integer.MAX_VALUE;
        for (int i = 1; i <= v; i++) {
            min=Math.min(min,map[i][i]);
        }
        if(min==INF)min=-1;
        System.out.println(min);
    }
}
