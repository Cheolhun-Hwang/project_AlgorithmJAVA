package week_two;

import java.lang.reflect.Field;

public class RobotCleaner {
	final static int EMPTY = 0;
	final static int BLOCK = 1;
	final static int CLEAN = 2;
	
	/*
	 * 로봇 청소기가 주어졌을 때, 청소하는 영역의 개수를 구하는 프로그램을 작성하시오.

		로봇 청소기가 있는 장소는 N×M 크기의 직사각형으로 나타낼 수 있으며, 1×1크기의 정사각형 칸으로 나누어져 있다. 각각의 칸은 벽 또는 빈 칸이다. 청소기는 바라보는 방향이 있으며, 이 방향은 동, 서, 남, 북중 하나이다. 지도의 각 칸은 (r, c)로 나타낼 수 있고, r은 북쪽으로부터 떨어진 칸의 개수, c는 서쪽으로 부터 떨어진 칸의 개수이다.
		
		로봇 청소기는 다음과 같이 작동한다.
		1.현재 위치를 청소한다.
		2.현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
			1.왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
			2.왼쪽 방향에 청소할 방향이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
			3.네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
			4.네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
		
		
		로봇 청소기는 이미 청소되어있는 칸을 또 청소하지 않으며, 벽을 통과할 수 없다.

		//입력
		 * 첫째 줄에 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 50)
		둘째 줄에 로봇 청소기가 있는 칸의 좌표 (r, c)와 바라보는 방향 d가 주어진다. d가 0인 경우에는 북쪽을, 1인 경우에는 동쪽을, 2인 경우에는 남쪽을, 3인 경우에는 서쪽을 바라보고 있는 것이다.
		셋째 줄부터 N개의 줄에 장소의 상태가 북쪽부터 남쪽 순서대로, 각 줄은 서쪽부터 동쪽 순서대로 주어진다. 빈 칸은 0, 벽은 1로 주어진다. 장소의 모든 외각은 벽이다.
		로봇 청소기가 있는 칸의 상태는 항상 빈 칸이다.
		
		3 3
		1 1 0
		1 1 1
		1 0 1
		1 1 1
		
		1
		
		11 10
		7 4 0
		1 1 1 1 1 1 1 1 1 1
		1 0 0 0 0 0 0 0 0 1
		1 0 0 0 1 1 1 1 0 1
		1 0 0 1 1 0 0 0 0 1
		1 0 1 1 0 0 0 0 0 1
		1 0 0 0 0 0 0 0 0 1
		1 0 0 0 0 0 0 1 0 1
		1 0 0 0 0 0 1 1 0 1
		1 0 0 0 0 0 1 1 0 1
		1 0 0 0 0 0 0 0 0 1
		1 1 1 1 1 1 1 1 1 1
		
		57

	 * */
	
	public int runRobot(int[] rang, int[] stat, int[][] map) {
		int answer=0;
		boolean flag = true;
		boolean isfull = false;
		/*
		 * rang[0] : filed 세로축
		 * rang[1] : filed 가로축
		 * stat[0] : 로봇 filed 세로 위치
		 * stat[1] : 로봇 filed 가로 위치
		 * stat[2] : 로봇이 바라보는 방향 
		 * -로봇이 바라볼 방향으로 전진한다.
		 * -전진할 때 전진하는 곳이 이미 청소된 곳이면 왼쪽을 살핀다. 0북 > 3서 > 2남 > 1동 > 0
		 */
		
		while(flag) {
			//조건 1
			if(map[stat[0]][stat[1]]==EMPTY) {
				map[stat[0]][stat[1]]=CLEAN;
				answer++;
				System.out.println("Now.  y :" + stat[0] + " / x : "+ stat[1] +" / 방향 : "+ stat[2] + " / filed : " + map[stat[0]][stat[1]] + " / answer : " + answer);
				
				for(int i=0;i<rang[0];i++) {
					for(int j=0;j<rang[1];j++) {
						System.out.print(map[i][j]);
					}
					System.out.print("\n");
				}
			}
			//조건1 끝
			//조건2
			isfull=true;
			for(int i =0;i<4;i++) {
				if(stat[2]==0) {
					//북 > 서. y(행) : 0, x(열) : -1 
					if(   map[stat[0]][stat[1]-1] == EMPTY   ) {
						//조건 2-1
						stat[2] = 3;			// 0 > 3 > 2 > 1  !TIP : 회전문제, 제자리로 돌아오는 반복 > 주기를 이용할 수 있다. (0+x)%4=3 (2+x)%4=1 .. x=3
						stat[0] = stat[0];		// 생략가능
						stat[1] = stat[1] -1 ; // stat[1] -= 1
						isfull=false;
						break;
					}else{	//이외의 상황은 1(BLOCK) 2(CLEAN) 뿐이다.
						//조건2-2
						stat[2] = 3;
					}
				}else if(stat[2]==3) {
					//서 > 남. y(행) : +1, x(열) : 0 
					if(   map[stat[0]+1][stat[1]] == EMPTY   ) {
						stat[2] = 2;			
						stat[0] = stat[0]+1;		
						stat[1] = stat[1]; 
						isfull=false;
						break;
					}else{
						stat[2] = 2;
					}
				}else if(stat[2]==2) {
					//남 > 동. y(행) : 0, x(열) : +1 
					if(   map[stat[0]][stat[1]+1] == EMPTY   ) {
						//
						stat[2] = 1;			
						stat[0] = stat[0];		
						stat[1] = stat[1] +1 ;
						isfull=false;
						break;
					}else{	
						stat[2] = 1;
					}
				}else if(stat[2]==1) {
					//동 > 북. y(행) : -1, x(열) : 0 
					if(   map[stat[0]-1][stat[1]] == EMPTY   ) {
						stat[2] = 0;			
						stat[0] = stat[0]-1;		
						stat[1] = stat[1]; 
						isfull=false;
						break;
					}else{	
						stat[2] = 0;
					}
				}
			}
			
			// 2-3, 4 조건   'isfull'인 상황은 현 위치의 4방향이 BLOCK 이거나 CLEAN 이다. 
			if(isfull) {
				// 북:0 <> 남:2, 서:3 <> 동:1 
				if( (stat[2]==0) && (map[stat[0]+1][stat[1]] == BLOCK)) {
					flag=false;
				}else if( (stat[2]==2) && (map[stat[0]-1][stat[1]] == BLOCK)) {
					flag=false;
				}else if( (stat[2]==1) && (map[stat[0]][stat[1]-1] == BLOCK)) {
					flag=false;
				}else if( (stat[2]==3) && (map[stat[0]][stat[1]+1] == BLOCK)) {
					flag=false;
				}else {
					if(stat[2]==0) {
						stat[0] = stat[0]+1;
						stat[1] = stat[1];
					}else if(stat[2]==3) {
						stat[0] = stat[0];
						stat[1] = stat[1]+1;
					}else if(stat[2]==2) {
						stat[0] = stat[0]-1;
						stat[1] = stat[1];
					}else if(stat[2]==1) {
						stat[0] = stat[0];
						stat[1] = stat[1]-1;
					}
				}
			}
			
			
			
			//조건2 끝
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] inputArray1 = {11, 10};
		int[] inputArray2 = {7, 4, 0};
		int[][] inputArray3 = {
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
				{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
				{1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
				{1, 0, 0, 1, 1, 0, 0, 0, 0, 1},
				{1, 0, 1, 1, 0, 0, 0, 0, 0, 1},
				{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
				{1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
				{1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
				{1, 0, 0, 0, 0, 0, 1, 1, 0, 1},
				{1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
		};
		
		/*int[] inputArray1 = {3, 3};
		int[] inputArray2 = {1, 1, 0};
		int[][] inputArray3 = {
				{1, 1, 1},
				{1, 0, 1},
				{1, 1, 1}
		};*/
		
		RobotCleaner Rc = new RobotCleaner();
		System.out.println(Rc.runRobot(inputArray1, inputArray2, inputArray3));
		
	}

}
