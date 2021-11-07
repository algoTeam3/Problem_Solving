

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class oh_2644_floyd {
    static final  int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        //map 생성
        int map[][] = new int[num+1][num+1];
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                if(i!=j){
                    map[i][j]=INF;
                }
            }
        }
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from =Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            map[from][to]=1;
            map[to][from]=1;
        }
       //플로이드
        for (int k = 1; k <= num; k++) {
            for (int i = 1; i <= num; i++) {
                for (int j = 1; j <= num; j++) {
                    if(map[i][j]>map[i][k]+map[k][j]){
                        map[i][j]=map[i][k]+map[k][j];
                    }
                }
            }
        }

        int answer = map[start][end];
        if(answer>=INF)answer=-1;
        System.out.println(answer);
    }


}
