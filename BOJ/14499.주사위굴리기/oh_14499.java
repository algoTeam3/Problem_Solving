package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Gold
 * @fileName : BOJ14499
 * @date : 2022-01-27
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class oh_14499 {
    private static int n,m,x,y,k;
    private static int[][] map;
    private static int[] dice = new int[7];
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[0].length; j++) {
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        sb = new StringBuilder();

        int[] command = new int[k];
        for (int i=0; i<k; i++) {
            //k번만큼 명령 실행
            command[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<k; i++) {
            moveDice(command[i]);
        }

        System.out.print(sb);

    }

    private static void moveDice(int order) {

        int temp;
        if (order == 1) {


            if (y+1 <= m) {
                temp = dice[5];

                dice[5] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[1];
                dice[1] = temp;

                y += 1;
                checkMap();
                sb.append(dice[1] + "\n");
            }

        } else if (order == 2) {


            if (y-1 > 0) {
                temp = dice[1];

                dice[1] = dice[6];
                dice[6] = dice[3];
                dice[3] = dice[5];
                dice[5] = temp;

                y -= 1;
                checkMap();
                sb.append(dice[1] + "\n");
            }

        } else if (order == 3) {


            if (x-1 > 0) {
                temp = dice[1];

                dice[1] = dice[2];
                dice[2] = dice[3];
                dice[3] = dice[4];
                dice[4] = temp;

                x -= 1;
                checkMap();
                sb.append(dice[1] + "\n");
            }

        } else if (order == 4) {

            if (x+1 <= n) {
                temp = dice[1];

                dice[1] = dice[4];
                dice[4] = dice[3];
                dice[3] = dice[2];
                dice[2] = temp;

                x += 1;
                checkMap();
                sb.append(dice[1] + "\n");
            }

        }


    }

    private static void checkMap() {

        if (map[x][y] == 0) {

            map[x][y] = dice[3];
        } else {

            dice[3] = map[x][y];
            map[x][y] = 0;
        }


    }
}




