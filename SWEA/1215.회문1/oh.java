import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Expert1215 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("algo/src/input/input1215.txt"));
        Scanner sc = new Scanner(System.in);
        int T=10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int count=0;
            int N = sc.nextInt();
            Stack<Character> stack = new Stack<>();
            char[][] map = new char[8][8];
            //배열담기
            for (int i = 0; i < map.length; i++) {
                String str=sc.next();
                for (int j = 0; j < map.length; j++) {
                    map[i][j]=str.charAt(j);
                }
            }
            //가로 탐색
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j <= map.length-N; j++) {

                    for (int k = 0; k < N; k++) {
                        //N이 홀수 일때
                        if(N%2==1){
                            if(k==N/2)continue;
                            if(k<N/2){
                                stack.push(map[i][j+k]);

                            }else{
                                if(map[i][j+k]==stack.peek()){
                                    stack.pop();
                                }else break;
                            }

                        }else {
                            if(k<N/2){
                                stack.push(map[i][j+k]);

                            }else{
                                if(map[i][j+k]==stack.peek()){
                                    stack.pop();
                                }else break;
                            }
                        }
                    }
                    if(stack.isEmpty()){
                        count++;
                    }else
                        stack.clear();

                }
            }
            //세로탐색
            for (int j = 0; j < map.length; j++) {
                for (int i = 0; i <= map.length-N; i++) {

                    for (int k = 0; k < N; k++) {
                        //N이 홀수 일때
                        if(N%2==1){
                            if(k==N/2)continue;
                            if(k<N/2){
                                stack.push(map[i+k][j]);

                            }else{
                                if(map[i+k][j]==stack.peek()){
                                    stack.pop();
                                }
                            }

                        }else{
                            if(k<N/2){
                                stack.push(map[i+k][j]);

                            }else{
                                if(map[i+k][j]==stack.peek()){
                                    stack.pop();
                                }
                            }
                        }
                    }
                    if(stack.isEmpty()){
                        count++;
                    }else
                        stack.clear();

                }
            }
            System.out.println("#"+test_case+" "+count);
        }
    }
}
