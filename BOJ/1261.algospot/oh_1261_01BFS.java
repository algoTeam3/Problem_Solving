package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class oh_1261_01BFS {
    static int n,m;
    static int[][] map;
    static int[][] visit;
    static boolean[][] check;
    static int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};//상 하 좌 우


    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n =Integer.parseInt(st.nextToken());//열
        m = Integer.parseInt(st.nextToken());//행

        //입력받기
        map=new int[m][n];
        visit=new int[m][n];
        check=new boolean[m][n];
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j]=str.charAt(j)-'0';

            }
        }

        _01BFS();
        System.out.println(visit[m-1][n-1]);
    
    }

    private static void _01BFS() {
        Deque<Integer[]> dq = new LinkedList<>();
        dq.push(new Integer[]{0,0});
        check[0][0]=true;

        while (!dq.isEmpty()){
            Integer[] z = dq.pollLast();



            for (int i = 0; i < 4; i++) {
                int nx = z[0] + dir[i][0];
                int ny = z[1] + dir[i][1];

                if(nx<0||ny<0||nx>=m||ny>=n||check[nx][ny])continue;
                if(map[nx][ny]==0){
                    visit[nx][ny]=visit[z[0]][z[1]];
                    dq.addLast(new Integer[]{nx,ny});
                }else{
                    visit[nx][ny]=visit[z[0]][z[1]]+1;
                    dq.addFirst(new Integer[]{nx,ny});
                }
                check[nx][ny]=true;
            }
        }

    }
}

