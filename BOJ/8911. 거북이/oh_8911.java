import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class oh_8911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int xy[] = {0,0};
            int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};//상 우 하 좌
            int point = 0;
            int maxX = 0;
            int minX = 0;
            int maxY = 0;
            int minY = 0;

            String command = br.readLine();
            for (int j = 0; j < command.length(); j++) {
                char ch = command.charAt(j);
                switch (ch){
                    case 'F':
                        xy[0]+=dir[point][0];
                        xy[1]+=dir[point][1];
                        break;
                    case 'B':
                        int temp=0;
                        if(point==0||point==1){
                            temp=point+2;
                        }else{
                            temp=point-2;
                        }
                        xy[0]+=dir[temp][0];
                        xy[1]+=dir[temp][1];
                        break;
                    case 'L':
                        point-=1;
                        if(point<=-1)point=3;
                        break;
                    case 'R':
                        point+=1;
                        if(point > 3)point=0;
                        break;
                }
                maxX = Math.max(maxX,xy[0]);
                maxY = Math.max(maxY,xy[1]);
                minX = Math.min(minX,xy[0]);
                minY = Math.min(minY,xy[1]);

            }
            int answer =(maxX-minX)*(maxY-minY);
            System.out.println(answer);
        }

    }
}
