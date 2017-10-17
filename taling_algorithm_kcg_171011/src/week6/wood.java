package week6;

public class wood {
	/*
	 * 
	 * A씨는 나무지기입니다. A씨는 매일 산에서 나무를 얻어 시장에 팝니다. 나무는 각 길이에 따라 가격이 다릅니다. 나무의 길이는 N으로 0이상의 자연수 입니다. 나무의 가격 M은
	 * 길이 N에 따라 가격이 다릅니다. A씨가 시장에서 나무를 팔아 얻을 수 있는 최대 금액을 출력하십시오.
	 * 
	 * 입력
	 * 첫째줄 Mn으로 길이당 금액을 입력받습니다. 길이는 N은 0부터 1씩 증가합니다.
	 * 두번째줄 A씨가 가지고 있는 나무 길이입니다.
	 * 
	 * 출력
	 * A씨가 나무를 팔아 얻을 수 있는 최대 금액
	 * 
	 * 예제 
	 * 
	 * 0 1 5 8 9 10 17 17 20
	 * 4 6 8
	 * 
	 * 결과
	 * 46
	 */
	

	public int response(int[] wd, int[] rep) {
		int answer = 0;
		
			for(int i = 0; i<rep.length; i++) {
			answer += calc(rep[i], wd);
			}
		
		
		return answer;
	}
	
	static public int calc(int purp, int[] wd) {
		int[] temp = new int[wd.length];
		temp = wd;
		int max = -1;
				
		for(int j = 1; j<purp+1 ; j++) {
			max = -1;
			for(int i=0;i<j;i++) {
				max = Math.max(max, wd[i] + temp[j-i]);
				System.out.println("wd[" + i + "] : " + wd[i] + " / temp[" + (j-i) + "] : " + temp[j-i] + " / max : " + max);
			}
			temp[j] = max;
		}
		
		
		/*for(int k = 0; k < temp.length ; k++) {
			System.out.println(temp[k]);
		}*/
		System.out.println(temp[purp]);
		return temp[purp];
	}
	
	public static void main(String[] args) {
		wood e = new wood();
		int []wd = {0, 1, 5, 8, 9, 10, 17, 17, 20};
		int []rep = {4, 6, 8};
		System.out.println(e.response(wd, rep));
	}
}
