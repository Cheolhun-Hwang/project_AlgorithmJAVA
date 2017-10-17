package week6;

import java.util.ArrayList;
import java.util.Set;

public class MooneyTwo {
	static private int howto;
	static private int N;
	
	static public int func(int[] M) {
		int answer = 0;
		howto = 0;
		
		for(int i = 0; i< M.length; i++) {
			dfs(i, 0, M);
		}
		
		answer = howto;
		return answer;
	}
	
	static public void dfs(int i, int sum, int[] m) {
		sum+=m[i];
		System.out.println("sum = " + sum + " / i : " + i + " / m[i] : " + m[i]);
		
		for(int j = i;j<m.length;j++) {
			if(sum == N) {
				howto++;
				//System.out.println("sum = " + sum + " / i : " + i);
				System.out.println("howto : " + howto);
				return;
			}else if(sum > N) {
				//System.out.println("Exit : sum = " + sum + " / i : " + i + " / m[i] : " + m[i]);
				return;
			}else {
				dfs(j, sum, m);
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = 5;
		int[] M = {1, 2, 5};
		
		
		System.out.println(func(M));
	}

}
