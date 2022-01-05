import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 
 * 특정 잠수함에서 나오는 소리인지 아닌지를 알아내라.
 * - 잠수함의 엔진소리 패턴 : (100~1~|01)~
 * 잠수함의 소리 : 0과 1 두 종류의 연속으로 이루어짐
 * ~ : 한 특정한 소리의 반복
 * (x|y) : x나 y 중 하나만을 선택해서 만들 수 있는 소리의 집합
 * @author chaeu
 *
 */
public class chan_2671 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String regex = "(100+1+|01)+";
		if (br.readLine().matches(regex)) {
			System.out.println("SUBMARINE");
		} else {
			System.out.println("NOISE");
		}
	}

}
