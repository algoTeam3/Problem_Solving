package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @packageName : BaekJoon_2020_12_22
 * @fileName : BJ_2589_보물섬.java
 * @date : 2020. 12. 23.
 * @language : JAVA
 * @classification : BFS
 * @time_limit : 1sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description
 * 1. 최단 거리로 이동하는 bfs 탐색중 가장큰 값 구하기
 */public class oh_2589 {
    static char[][] map;
    static int[][] visit;
    static int[][] dir ={{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        map =new char[n][m];
        ArrayList<xxyy> arr = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            String str = br.readLine();
            for (int j = 0; j < map[i].length; j++) {
                map[i][j]=str.charAt(j);
                if(map[i][j]=='L'){
                    arr.add(new xxyy(i,j));
                }
            }
        }
        int max =Integer.MIN_VALUE;

        for (int i = 0; i < arr.size(); i++) {
            visit = new int[n][m];
            Bfs(arr.get(i).x,arr.get(i).y);

            for (int[] ints : visit) {
                for (int x : ints) {
                    max=Math.max(max,x);
                }
            }
        }
        System.out.println(max-1);

    }

    private static void Bfs(int x,int y) {
       Queue<int[]> que = new LinkedList<>();
       que.add(new int[]{x,y});
       visit[x][y]=1;
       while (!que.isEmpty()){
           int[] z = que.poll();

           for (int i = 0; i < 4; i++) {
               int nx = z[0]+dir[i][0];
               int ny = z[1]+dir[i][1];

               if(nx<0||ny<0||nx>=visit.length||ny>=visit[0].length)continue;
               if(visit[nx][ny]==0&&map[nx][ny]=='L'){
                   que.add(new int[]{nx,ny});
                   visit[nx][ny]=visit[z[0]][z[1]]+1;

               }
           }

       }
    }
}
class xxyy {
    int x;
    int y;

    xxyy(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
