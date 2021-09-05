import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Expert1213 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("algo/src/input/input1213.txt"));
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int num = sc.nextInt();
            String find = sc.next();
            String str = sc.next();
            char[] find1 = new char[find.length()];
            char[] chars  = new char[str.length()];
            //짧은 배열 담기
            for (int i = 0; i < find1.length; i++) {
                find1[i]=find.charAt(i);
            }
            // 긴 배열  담기
            for (int i = 0; i < chars.length; i++) {
                chars[i]=str.charAt(i);
            }
            boolean flag = false;
            int count=0;
            for (int i = 0; i < chars.length; i++) {
                if(find1[0]==chars[i]){
                    for (int j = 1; j < find1.length; j++) {
                        if(i+j>=chars.length)continue;
                        if(find1[j]==chars[i+j]){
                            flag = true;
                        }else{
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        count++;
                    }
                }
            }
            System.out.println("#"+test_case+" "+count);

        }
    }
}
