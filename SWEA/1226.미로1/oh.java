import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Expert1226 {
    static int[][] map;
    static int[][] dir ={{-1,0},{1,0},{0,-1},{0,1}};//상하좌우
    static int answer;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\ALGO\\algo\\src\\input\\input1226.txt"));
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int test_case = 1; test_case <=T ; test_case++) {
            answer = 0;
            int tes_case = Integer.parseInt(br.readLine());
            map = new int[16][16];
            //배열 담기
            for (int r = 0; r < map.length; r++) {
                String str = br.readLine();
                for (int c = 0; c < map.length; c++) {
                    map[r][c]= Character.getNumericValue(str.charAt(c));
                }
            }
            //완탐
            search(1,1);
            System.out.println("#"+test_case+" "+answer);
        }
    }
    static void search(int r ,int c){

        for (int i = 0; i < 4; i++) {
            int nr = r+ dir[i][0];
            int nc = c+ dir[i][1];

            if(map[nr][nc]==0){
                map[nr][nc]=1;
                search(nr,nc);

            }else if(map[nr][nc]==3){
                answer =1;
            }
        }
    }
}
