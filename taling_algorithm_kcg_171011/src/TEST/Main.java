package TEST;

import java.util.Scanner;

public class Main {
	 	static int result = 0;
	    static int t[], p[];
	    static int n, max = 0;
	    
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	 
	        n = sc.nextInt();
	        t = new int[n];
	        p = new int[n];
	        
	        for(int i=0; i<n; i++) {
	            t[i] = sc.nextInt();
	            p[i] = sc.nextInt();
	        }
	 
	        for(int i=0; i<n; i++) dfs(i, 0, 0);
	 
	        System.out.println(result);
	        sc.close();
	        
	    }
	 
	    private static void dfs(int i, int max, int sum) {
	        
	        // i번째 날짜에 업무를 수행할 수 있는지 검사한다.
	        // = 이 날에 업무를 수행하면 N을 초과하는지 검사한다
	        if( i+t[i] <= n ) { 
	            
	            // 지금까지 합한 업무 시간이 최대값인지 검사한다
	            if( sum >= max ) {
	                sum += p[i]; // 업무시간을 더한다.
	                max = sum; // 최대값을 현재 합계로 설정한다.
	                
	                if( result < max ) {
	                	result = max; // 최대값을 경신한다 (result는 출력해야할 최대 수익)
	                }
	            }
	        }
	 
	        // 현재 위치의 다음 위치부터 탐색한다.
	        // 현재 1일 때,
	        // 다음으로 갈 수 있는 날짜는
	        // 본문에서 설명한 것과 같이 2가지의 조건이 성립해야한다.
	        // 1. 현재일 + 업무수행시간은 항상 다음 업무일 이상이어야 한다.
	        // 2. 다음 업무일 + 다음 업무수행시간은 N을 초과하면 안된다.
	        // 이렇게해서 모든 길을 방문할 수 있다.
	        for(int j=i+1; j<n; j++) {
	            if(j+t[j] <= n && j >=i+t[i]) {
	            	dfs(j, sum, max);
	            }
	        }
	    }
}

