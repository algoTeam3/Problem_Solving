package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {
    static int N,M,start;
    static boolean[] visit;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        visit = new boolean[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            map[v1][v2]=1;
            map[v2][v1]=1;
        }
        DFS(start);
        System.out.println();
        Arrays.fill(visit,false);
        BFS(start);
    }
    static  void BFS(int v){
        Queue<Integer> q = new LinkedList<>();
        int x = map.length-1;
        q.offer(v);
        visit[v]=true;

       while(!q.isEmpty()){
           int temp = q.poll();
           System.out.print(temp+" ");
           for (int i = 1; i <= x; i++) {
               if(map[temp][i]==1&&!visit[i]){
                   q.offer(i);
                   visit[i]=true;
               }
           }
       }
    }
    static void DFS(int v){
        visit[v]=true;
        System.out.print(v+" ");
        int x = map.length-1;
        for (int i = 1; i <= x; i++) {
            if(map[v][i]==1&&!visit[i]){
                DFS(i);

            }
        }
    }
}
