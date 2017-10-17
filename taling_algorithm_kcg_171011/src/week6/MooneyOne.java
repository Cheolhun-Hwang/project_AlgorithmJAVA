package week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MooneyOne {
	
	static public String func(int N, int[] M) {
		String answer = "";
		boolean flag = true;
		
		int n = N;
		int index = 0;
		ArrayList<Integer> store = new ArrayList<Integer>();
		
		/*
		 * 자바에는 기본형과 클래스형으로 나뉩니다.
		 * 서로 동일한 형태를 받을 수 있지만 클래스는 추가적인 메소드를 사용할 수 있는 장점이 있습니다.
		 * 
		 * short == Short
		 * int == Integer
		 * double == Double
		 * float == Float
		 */
		
		//이부분은 참고용으로 넣어두었습니다. 정렬로 받는다는 조건이 없을때, 정렬을 한뒤 넣어주는 방식
		/*
		 * Integer[] temp = new Integer[M.length];
		 * Arrays.sort(temp);
		 * List<Integer> list = Arrays.asList(temp);
		 * Collections.reverse(list);
		 * temp = list.toArray(new Integer[list.size()]);
		*/
		
		//이런과정으로 내림차순 정렬을 할수 있습니다.
		
		/*
		 * 반대로 오름차순으로 간단히 해준다음에 for문을 거꾸로 내로오면 내림차순 됩니다.
		 * Arrays.sort(temp);
		 */
		
		while( flag && (index < M.length) && (n!=0)) {
			System.out.println("index : " + index + " / M.length : " + M.length);
			if( ( n - M[(M.length-1)-index]) < 0 ) {
				index++;
			}else {
				System.out.println("n : " + n);
				n = n - M[(M.length-1)-index];
				store.add(M[(M.length-1)-index]);
			}
		}
		
		Collections.sort(store);
		for(int i = 0 ; i< store.size();i++) {
			answer += store.get(i) + " ";
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 27;
		int[] M = {1, 2, 5};
		
		System.out.println(func(N, M));
	}

}
