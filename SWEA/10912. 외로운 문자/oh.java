import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;

public class Expert10912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            //알파벳을 인덱스 값으로 쓴다
            int[] alpha = new int[26];
            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                alpha[str.charAt(i)-'a']++;
                
            }
            // 홀수만 따로 배열에 담는다
            ArrayList<Character> ch = new ArrayList<>();
            for (int i = 0; i < alpha.length; i++) {
                if(alpha[i]%2==1){
                    ch.add((char)(i+97));
                }

            }
            //배열이 비었다면 good
            System.out.print("#"+test_case+" ");
            if(ch.isEmpty()){
                System.out.print("Good");
            }else{
                for (Character c : ch) {
                    System.out.print(c);
                }
            }
            System.out.println();
        }

    }
}
