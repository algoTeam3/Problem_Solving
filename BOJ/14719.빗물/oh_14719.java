import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class oh_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] arr = new int[h][w];

        //정보 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            int height =Integer.parseInt(st.nextToken());
            for (int j = 0; j < h; j++) {
                if (j >= height) continue;
                arr[j][i]=1;

            }
        }
        int sum =0;
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            int start =0;
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j]==1){
                    if (!flag){
                        flag=true;
                        start =j;
                    }else{
                        sum+= (j-start)-1;
                        start=j;

                    }
                }
            }
        }
        System.out.println(sum);
    }
}
