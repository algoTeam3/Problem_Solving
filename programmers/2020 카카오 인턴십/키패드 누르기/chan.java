public class chan {

	static String answer = "";			// L인지 R인지 번호를 누른 손을 연속된 문자열로 출력하기 위한 변수
	static int[] curLeft = {3, 0};		// 현재 왼 손가락의 위치이자, 왼손의 시작점
	static int[] curRight = {3, 2};		// 현재 오른 손가락의 위치이자, 오른손의 시작점
	static int[] current = new int[2];	// 현재 누른 번호
	static int ltemp, rtemp;			// 2,5,8,0 입력시 더 가까운 손을 찾기 위한 임의 변수	
	static int[][] ij = new int[10][2];	// 1부터 0번까지 키패드에서 위치를 나타내기 위한 2차원 배열
	
	// 키패드로 숫자 입력이 들어왔을 때 그 숫자의 2차원 배열 위치
	public static int[] placeAt(int num) {
        if (num == 0) {
        	ij[num][0] = 3;
        	ij[num][1] = 1;
        }

        int cnt = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cnt++ == num) {
                    ij[num][0] = i;
                    ij[num][1] = j;
                    break;
                }
            }
        }
        return ij[num];
    }
	// 오른손 엄지손가락을 사용할 때는 R을 출력하고, 현재 오른 손가락의 위치를 방금 입력된 번호의 위치로 바꾼다.
	public static void setRighthand() {
		answer += "R";
        curRight[0] = current[0];
		curRight[1] = current[1];
	}

	// 왼손 엄지손가락을 사용할 때는 L을 출력하고, 현재 왼 손가락의 위치를 방금 입력된 번호의 위치로 바꾼다.
	public static void setLefthand() {
		answer += "L";
        curLeft[0] = current[0];
		curLeft[1] = current[1];
	}
	
    public static String solution (int[] numbers, String hand) {
        // 순서대로 누른 번호 배열을 0번째부터 끝까지 차례로 처리
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];		// 현재 누른 번호
            current = placeAt(num);		// 현재 누른 번호의 위치 (current[0]이 i행, current[1]이 j열)
            
            // 1, 4, 7이 입력되면 왼손 손가락 사용
            if (num == 1 || num == 4 || num == 7) {
            	setLefthand();
            } 
            // 3, 6, 9이 입력되면 오른손 손가락 사용
            else if (num == 3 || num == 6 || num == 9) {
            	setRighthand();
            } 
            // 2, 5, 8, 0이 입력되면 더 가까운 손가락을 찾고, 둘 다 똑같은 거리에 있다면 어느 손 잡이인지에 따라 결정            
            else {
            	// 현재 위치에서 왼손가락과의 거리, 오른손가락과의 거리를 비교하기 전 계산
            	ltemp = Math.abs(current[0] - curLeft[0]) + Math.abs(current[1] - curLeft[1]);
            	rtemp = Math.abs(current[0] - curRight[0]) + Math.abs(current[1] - curRight[1]);
            	// 거리가 같다면 어느 손 잡이인지에 따라 결정
            	if (ltemp == rtemp) {
            		if (hand.equals("left")) {
            			setLefthand();
            		} else {
            			setRighthand();
            		}
            	} 
            	// 오른손가락이 더 가깝다면
            	else if (ltemp > rtemp) {
            		setRighthand();
            	} 
            	// 왼손가락이 더 가깝다면
            	else if (ltemp < rtemp) {
            		setLefthand();
            	}
            }
        }
        return answer;
    }
    
    public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		String hand = "right";
		System.out.println(solution(numbers, hand));
		
	}
}