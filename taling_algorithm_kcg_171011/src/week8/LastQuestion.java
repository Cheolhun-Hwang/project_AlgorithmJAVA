package week8;

public class LastQuestion {
	
	/*
	 
	 빠른 경로찾기 문제
	 A씨는 '빠른 길 찾기 어플리케이션'을 개발하려고 합니다. 지도 API를 통해서 사용자가 있는 지역의 정보를 받아들인 이후 이진화 하여 0은 이동 가능함을 표시하며, 1은 막혀 있음을 나타냈습니다.
	 사용자는 현재 자신의 위치에서 다음 선택한 장소를 선택합니다. A씨가 만든 어플리케이션은 가장 빠른 이동경로가 몇 km 인지 출력해줍니다.
	 A씨는 어플리케이션을 더욱 퀄리티를 높이기 위해 국토부 제공 교통API를 통해 거리가 번잡할 경우를  반영하려고 합니다.
	 
	 최종 퀄리티 업그레이드를 반영한 어플리케이션의 가장 빠른 이동경로 거리를 표시하는 알고리즘을 작성하십시오.
	 
	 단, 사용자는 북, 동, 남, 서 방향으로만 움직이며, 대각선으로 움직이지 않습니다. 또한 이동거리 계산 시 벽을 넘지 못하며, 번잡할 지역을 통과하는 것을 제외합니다.
	  도한 한 칸당 1km로 간주합니다.
	 
	 입력
	 첫번째 줄 입력 N M은 지역의 가로 세로 범위를 입력받습니다.
	 두번째 줄 입력은 R, C를 입력받습니다. 사용자 위치 정보입니다. 
	 세분째 줄 입력은 R, C를 입력받습니다. 도착지점 위치 정보입니다.
	 세번째 줄 부터 입력된 R, C는 번잡한 지역의 위치 정보입니다. 
	 마지막 줄에서는 맵의 정보를 받습니다.
	 
	 R, C는 각각 북쪽, 서쪽에서부터 1씩 증가합니다.
	 
	 출력
	  가장 빠른 이동경로 거리
	  
	  예제
	 9 7
	 1 1
	 5 7
	 3 3
	 7 4
	 111111111
	 100001001
	 100000001
	 111001011
	 100001001
	 110010001
	 111111111
	 
	 10
	 
	 예제2
	 5 6
	 1 1
	 4 3
	 3 3
	 11111
	 10001
	 11011
	 11001
	 10001
	 11111
	 
	 5
	 
	 */
	static int Start[];
	static int Finish[];
	static int Dir[][] = {
			{-1, 0, 1, 0},
			{0, 1, 0, -1}
	};
	static int Min;
	static int N;
	static int M;
	
	static public void showArray(int[][] m) {
		for(int i = 0; i<m.length;i++) {
			for(int j=0; j < m[i].length;j++) {
				System.out.print(m[i][j] +" ");
			}
			System.out.println("");
		}
	}
	
	static public void dfs(int index, int[][] m, int depth, int r, int c) {
		System.out.println("Depth : " + depth);
		System.out.println("현재 최소값 : " + Min);
		if(Min > 0) {
			//Min 값이 초기 0 이상의 값을 가지고 있으면 도착지점까지 도달한 경로가 있다는 것으로 본다.
			//그렇기 때문에 짧은 경로보다 더 많은 경로를 탐색할 필요가 없다.
			if(Min < depth) {
				return;
			}
		}
		System.out.println("r : " + r + " / c : " + c);
		System.out.println("m[r+Dir[0][index]][c+Dir[1][index]] : " + m[r+Dir[0][index]][c+Dir[1][index]]);
		if(m[r+Dir[0][index]][c+Dir[1][index]] == 0) {
			//갈 수 있으면!
			//시작 값을 위치로 옮긴다.
			System.out.println("갈 수 있음.");
			//이전 왔던 곳은 체크
			//왔던 곳을 체크하는 이유는 테스트케이스 1의 경우 광활한 평야가 존재합니다.
			//이때는 4방위 회전하며 무한루프가 될 수 있습니다. 이를 방지하기 위해 자신이 왔던 곳을 기록합니다.
			m[r][c] = 3;
			r+=Dir[0][index];
			c+=Dir[1][index];
			System.out.println("Change  r: " + r + " / c : " + c);
			//한칸 움직였기 때문에 depth:경로 깊이를 추가해준다.
			depth++;
			System.out.println("Change Depth : " + depth);
			//만약 움직였는데 그곳이 도착할 곳이면 Min 값에 depth값을 대입힌다.
			if(r==Finish[0] && c==Finish[1]) {
				System.out.println("도착 ! ");
				Min = depth;
				System.out.println("Min Depth : "  + Min);
			}
			//showArray(m);
			//자식 노드 0, 1, 2, 3 방위에 대한 탐색을 지속한다.
			for(int i=0;i<4;i++) {
				//만약 경로 탐색 중 자식 노드가 부모 노드의 반대방향이라면 (자신이 왔던 길을 다시 돌아간다면)
				//최단 거리가 될 수 없으며 무한 루프에 빠질 수 있기 때문에 이를 배재한다.
				if( (index == 1 && i == 3) ||
						(index == 0 && i == 2)||
						(index == 3 && i == 1)||
						(index == 2 && i == 0)) {
					System.out.println("내가 왔던 길 ! 이전 : " + index + " > 이후 : " + i);
				}else {
					//이외의경우 탐색한다.
					System.out.println("다음 탐색 자식 노드 : " + i);
					dfs(i, m, depth, r, c);
				}
			}
		}else {
			//갈 수 없으면!!
			//더 이상 진행하지 않는다.
			System.out.println("갈 수 없음!");
			return;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//테스트케이스 2
		/*N = 5;
		M = 6;
		Start = new int[2];
		Finish = new int[2];
		Start[0] = 1;
		Start[1] = 1;
		Finish[0] = 4;
		Finish[1] = 3;
		
		Min = 0;
		
		int[][] Map = {
				{1,1,1,1,1},
				{1,0,0,0,1},
				{1,1,0,1,1},
				{1,1,0,0,1},
				{1,0,0,0,1},
				{1,1,1,1,1}	
		};
		
		int[][] B = {
				{3},
				{3}
		};*/
		
		//테스트케이스 1
		N = 9;
		M = 7;
		Start = new int[2];
		Finish = new int[2];
		Start[0] = 1;
		Start[1] = 1;
		Finish[0] = 5;
		Finish[1] = 7;
		
		Min = 0;
		
		int[][] Map = {
				 {1,1,1,1,1,1,1,1,1},
				 {1,0,0,0,0,1,0,0,1},
				 {1,0,0,0,0,0,0,0,1},
				 {1,1,1,0,0,1,0,1,1},
				 {1,0,0,0,0,1,0,0,1},
				 {1,1,0,0,1,0,0,0,1},
				 {1,1,1,1,1,1,1,1,1}
		};
		
		int[][] B = {
				{3, 7},
				{3, 4}
		};
		
		for(int i=0;i<B.length-1;i++) {
			Map[B[0][i]][B[1][i]] = 2;
		}
		
		showArray(Map);
		
		
		//dfs 실행
		for(int i = 0; i<4;i++) {
			dfs(i, Map, 0, Start[0], Start[1]);
		}
		
		System.out.println("최단 거리 : " + Min);
		
	}

}
