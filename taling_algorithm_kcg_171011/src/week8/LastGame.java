package week8;

public class LastGame {
	static int Min;
	static int Num;
	static int B[];
	static int R[];
	static int Dis[][] = {
			{-1, 0, 1, 0},
			{0, 1, 0, -1}
	};
	
	static public void showArray(String[][] m) {
		for(int i = 0; i<m.length;i++) {
			for(int j=0; j < m[i].length;j++) {
				System.out.print(m[i][j] +" ");
			}
			System.out.println("");
		}
	}
	
	static public boolean Move(int index, String[][] m, int depth) {
		//빨강공 파랑공 어떤걸 먼저 움직일지 판별합니다.
		System.out.println("Index : " + index);
		if(index == 0) {
			//북쪽
			//먼저 움직일것 판별하기
			if(B[0] >= R[0]) {
				//서로 행이 같거나 R이 위에 위치할때 R 먼저
				if(R[0]==B[0] && R[1]==B[1]) {
					System.out.println("서로 같은 위치 에러");
				}else {
					System.out.println("R");
					System.out.println("m[" + (R[0]-1) + "][" + (R[1]) + "] : " + m[R[0]-1][R[1]]);
					while( m[R[0]-1][R[1]].equals(".") ) {
						m[R[0]][R[1]] = ".";
						R[0]+=Dis[0][index];
						R[1]+=Dis[1][index];
						m[R[0]][R[1]] = "R";
					}
					if(m[R[0]-1][R[1]].equals("O")) {
						R[2] = 1;
					}
					
					System.out.println("R[0] : " + R[0] +" / R[1] : " + R[1] + " / R[2] : " + R[2]);
					
					
					
					System.out.println("m[" + (B[0]-1) + "][" + (B[1]) + "] : " + m[B[0]-1][B[1]]);
					while( m[B[0]-1][B[1]].equals(".") ) {
						m[B[0]][B[1]] = ".";
						B[0]+=Dis[0][index];
						B[1]+=Dis[1][index];
						m[B[0]][B[1]] = "B";
					}
					if(m[B[0]-1][B[1]].equals("O")) {
						B[2] = 1;
					}
					
					System.out.println("B[0] : " + B[0] +" / B[1] : " + B[1] + " / B[2] : " + B[2]);
					
					if((B[2] == 1 && R[2]==1) || (B[2] == 1 && R[2] == 0) || (B[2] == 0 && R[2] == 0)) {
						//실패
						R[2] = 0;
						B[2] = 0;
						return false;
					}else {
						//(B[2] == 0 && R[2] == 1) 성공
						if(Min > depth) {
							Min = depth;
						}
						R[2] = 0;
						B[2] = 0;
						return true;
					}
				}
			}else if(B[0] < R[0]) {
				//B 먼저
				System.out.println("B");
				System.out.println("m[" + (B[0]-1) + "][" + (B[1]) + "] : " + m[B[0]-1][B[1]]);
				while( m[B[0]-1][B[1]].equals(".") ) {
					m[B[0]][B[1]] = ".";
					B[0]+=Dis[0][index];
					B[1]+=Dis[1][index];
					m[B[0]][B[1]] = "B";
				}
				if(m[B[0]-1][B[1]].equals("O")) {
					B[2] = 1;
				}
				System.out.println("B[0] : " + B[0] +" / B[1] : " + B[1] + " / B[2] : " + B[2]);
				
				System.out.println("m[" + (R[0]-1) + "][" + (R[1]) + "] : " + m[R[0]-1][R[1]]);
				while( m[R[0]-1][R[1]].equals(".") ) {
					m[R[0]][R[1]] = ".";
					R[0]+=Dis[0][index];
					R[1]+=Dis[1][index];
					m[R[0]][R[1]] = "R";
				}
				if(m[R[0]-1][R[1]].equals("O")) {
					R[2] = 1;
				}
				System.out.println("R[0] : " + R[0] +" / R[1] : " + R[1] + " / R[2] : " + R[2]);
				
				if((B[2] == 1 && R[2]==1) || (B[2] == 1 && R[2] == 0) || (B[2] == 0 && R[2] == 0)) {
					//실패
					R[2] = 0;
					B[2] = 0;
					return false;
				}else {
					//(B[2] == 0 && R[2] == 1) 성공
					if(Min > depth) {
						Min = depth;
					}
					R[2] = 0;
					B[2] = 0;
					return true;
				}
			}
		}else if(index ==1) {
			//동쪽
			//먼저 움직일것 판별하기
			if(B[1] <= R[1]) {
				//같거나 오른쪽에 R이 위치하면 R 먼저
				if(R[0]==B[0] && R[1]==B[1]) {
					System.out.println("서로 같은 위치 에러");
				}else {
					System.out.println("m[" + (R[0]-1) + "][" + (R[1]) + "] : " + m[R[0]-1][R[1]]);
					while( m[R[0]][R[1]+1].equals(".") ) {
						m[R[0]][R[1]] = ".";
						R[0]+=Dis[0][index];
						R[1]+=Dis[1][index];
						m[R[0]][R[1]] = "R";
					}
					if(m[R[0]][R[1]+1].equals("O")) {
						R[2] = 1;
					}
					System.out.println("R[0] : " + R[0] +" / R[1] : " + R[1] + " / R[2] : " + R[2]);
					System.out.println("m[" + (B[0]-1) + "][" + (B[1]) + "] : " + m[B[0]-1][B[1]]);
					while( m[B[0]][B[1]+1].equals(".") ) {
						m[B[0]][B[1]] = ".";
						B[0]+=Dis[0][index];
						B[1]+=Dis[1][index];
						m[B[0]][B[1]] = "B";
					}
					if(m[B[0]][B[1]+1].equals("O")) {
						B[2] = 1;
					}
					System.out.println("B[0] : " + B[0] +" / B[1] : " + B[1] + " / B[2] : " + B[2]);
					if((B[2] == 1 && R[2]==1) || (B[2] == 1 && R[2] == 0) || (B[2] == 0 && R[2] == 0)) {
						//실패
						R[2] = 0;
						B[2] = 0;
						return false;
					}else {
						//(B[2] == 0 && R[2] == 1) 성공
						if(Min > depth) {
							Min = depth;
						}
						R[2] = 0;
						B[2] = 0;
						return true;
					}
				}
			}else if(B[1] > R[1]) {
				//B 먼저
				System.out.println("m[" + (B[0]-1) + "][" + (B[1]) + "] : " + m[B[0]-1][B[1]]);
				while( m[B[0]][B[1]+1].equals(".") ) {
					m[B[0]][B[1]] = ".";
					B[0]+=Dis[0][index];
					B[1]+=Dis[1][index];
					m[B[0]][B[1]] = "B";
				}
				if(m[B[0]][B[1]+1].equals("O")) {
					B[2] = 1;
				}
				System.out.println("B[0] : " + B[0] +" / B[1] : " + B[1] + " / B[2] : " + B[2]);
				System.out.println("m[" + (R[0]-1) + "][" + (R[1]) + "] : " + m[R[0]-1][R[1]]);
				while( m[R[0]][R[1]+1].equals(".") ) {
					m[R[0]][R[1]] = ".";
					R[0]+=Dis[0][index];
					R[1]+=Dis[1][index];
					m[R[0]][R[1]] = "R";
				}
				if(m[R[0]][R[1]+1].equals("O")) {
					R[2] = 1;
				}
				System.out.println("R[0] : " + R[0] +" / R[1] : " + R[1] + " / R[2] : " + R[2]);
				if((B[2] == 1 && R[2]==1) || (B[2] == 1 && R[2] == 0) || (B[2] == 0 && R[2] == 0)) {
					//실패
					R[2] = 0;
					B[2] = 0;
					return false;
				}else {
					//(B[2] == 0 && R[2] == 1) 성공
					if(Min > depth) {
						Min = depth;
					}
					R[2] = 0;
					B[2] = 0;
					return true;
				}
			}
		}else if(index == 2) {
			//남쪽
			//먼저 움직일것 판별하기
			if(B[0] <= R[0]) {
				//R 먼저
				if(R[0]==B[0] && R[1]==B[1]) {
					System.out.println("서로 같은 위치 에러");
				}else {
					System.out.println("m[" + (R[0]-1) + "][" + (R[1]) + "] : " + m[R[0]-1][R[1]]);
					while( m[R[0]+1][R[1]].equals(".") ) {
						m[R[0]][R[1]] = ".";
						R[0]+=Dis[0][index];
						R[1]+=Dis[1][index];
						m[R[0]][R[1]] = "R";
					}
					if(m[R[0]+1][R[1]].equals("O")) {
						R[2] = 1;
					}
					System.out.println("R[0] : " + R[0] +" / R[1] : " + R[1] + " / R[2] : " + R[2]);
					System.out.println("m[" + (B[0]-1) + "][" + (B[1]) + "] : " + m[B[0]-1][B[1]]);
					while( m[B[0]+1][B[1]].equals(".") ) {
						m[B[0]][B[1]] = ".";
						B[0]+=Dis[0][index];
						B[1]+=Dis[1][index];
						m[B[0]][B[1]] = "B";
					}
					if(m[B[0]+1][B[1]].equals("O")) {
						B[2] = 1;
					}
					System.out.println("B[0] : " + B[0] +" / B[1] : " + B[1] + " / B[2] : " + B[2]);
					if((B[2] == 1 && R[2]==1) || (B[2] == 1 && R[2] == 0) || (B[2] == 0 && R[2] == 0)) {
						//실패
						R[2] = 0;
						B[2] = 0;
						return false;
					}else {
						//(B[2] == 0 && R[2] == 1) 성공
						if(Min > depth) {
							Min = depth;
						}
						R[2] = 0;
						B[2] = 0;
						return true;
					}
				}
			}else if(B[0] > R[0]) {
				//B 먼저
				System.out.println("m[" + (B[0]-1) + "][" + (B[1]) + "] : " + m[B[0]-1][B[1]]);
				while( m[B[0]+1][B[1]].equals(".") ) {
					m[B[0]][B[1]] = ".";
					B[0]+=Dis[0][index];
					B[1]+=Dis[1][index];
					m[B[0]][B[1]] = "B";
				}
				if(m[B[0]+1][B[1]].equals("O")) {
					B[2] = 1;
				}
				System.out.println("B[0] : " + B[0] +" / B[1] : " + B[1] + " / B[2] : " + B[2]);
				System.out.println("m[" + (R[0]-1) + "][" + (R[1]) + "] : " + m[R[0]-1][R[1]]);
				while( m[R[0]+1][R[1]].equals(".") ) {
					m[R[0]][R[1]] = ".";
					R[0]+=Dis[0][index];
					R[1]+=Dis[1][index];
					m[R[0]][R[1]] = "R";
				}
				if(m[R[0]+1][R[1]].equals("O")) {
					R[2] = 1;
				}
				System.out.println("R[0] : " + R[0] +" / R[1] : " + R[1] + " / R[2] : " + R[2]);
				if((B[2] == 1 && R[2]==1) || (B[2] == 1 && R[2] == 0) || (B[2] == 0 && R[2] == 0)) {
					//실패
					R[2] = 0;
					B[2] = 0;
					return false;
				}else {
					//(B[2] == 0 && R[2] == 1) 성공
					if(Min > depth) {
						Min = depth;
					}
					R[2] = 0;
					B[2] = 0;
					return true;
				}
			}
		}else if(index ==3) {
			//서쪽
			//먼저 움직일것 판별하기
			if(B[1] >= R[1]) {
				//R 먼저
				if(R[0]==B[0] && R[1]==B[1]) {
					System.out.println("서로 같은 위치 에러");
				}else {
					System.out.println("m[" + (R[0]-1) + "][" + (R[1]) + "] : " + m[R[0]-1][R[1]]);
					while( m[R[0]][R[1]-1].equals(".") ) {
						m[R[0]][R[1]] = ".";
						R[0]+=Dis[0][index];
						R[1]+=Dis[1][index];
						m[R[0]][R[1]] = "R";
					}
					if(m[R[0]][R[1]-1].equals("O")) {
						R[2] = 1;
					}
					System.out.println("R[0] : " + R[0] +" / R[1] : " + R[1] + " / R[2] : " + R[2]);
					System.out.println("m[" + (B[0]-1) + "][" + (B[1]) + "] : " + m[B[0]-1][B[1]]);
					while( m[B[0]][B[1]-1].equals(".") ) {
						m[B[0]][B[1]] = ".";
						B[0]+=Dis[0][index];
						B[1]+=Dis[1][index];
						m[B[0]][B[1]] = "B";
					}
					if(m[B[0]][B[1]-1].equals("O")) {
						B[2] = 1;
					}
					System.out.println("B[0] : " + B[0] +" / B[1] : " + B[1] + " / B[2] : " + B[2]);
					if((B[2] == 1 && R[2]==1) || (B[2] == 1 && R[2] == 0) || (B[2] == 0 && R[2] == 0)) {
						//실패
						R[2] = 0;
						B[2] = 0;
						return false;
					}else {
						//(B[2] == 0 && R[2] == 1) 성공
						if(Min > depth) {
							Min = depth;
						}
						R[2] = 0;
						B[2] = 0;
						return true;
					}
				}
			}else if(B[1] < R[1]) {
				//B 먼저
				System.out.println("m[" + (B[0]-1) + "][" + (B[1]) + "] : " + m[B[0]-1][B[1]]);
				while( m[B[0]][B[1]-1].equals(".") ) {
					m[B[0]][B[1]] = ".";
					B[0]+=Dis[0][index];
					B[1]+=Dis[1][index];
					m[B[0]][B[1]] = "B";
				}
				if(m[B[0]][B[1]-1].equals("O")) {
					B[2] = 1;
				}
				System.out.println("B[0] : " + B[0] +" / B[1] : " + B[1] + " / B[2] : " + B[2]);
				System.out.println("m[" + (R[0]-1) + "][" + (R[1]) + "] : " + m[R[0]-1][R[1]]);
				while( m[R[0]][R[1]-1].equals(".") ) {
					m[R[0]][R[1]] = ".";
					R[0]+=Dis[0][index];
					R[1]+=Dis[1][index];
					m[R[0]][R[1]] = "R";
				}
				if(m[R[0]][R[1]-1].equals("O")) {
					R[2] = 1;
				}
				System.out.println("R[0] : " + R[0] +" / R[1] : " + R[1] + " / R[2] : " + R[2]);
				if((B[2] == 1 && R[2]==1) || (B[2] == 1 && R[2] == 0) || (B[2] == 0 && R[2] == 0)) {
					//실패
					R[2] = 0;
					B[2] = 0;
					return false;
				}else {
					//(B[2] == 0 && R[2] == 1) 성공
					if(Min > depth) {
						Min = depth;
					}
					R[2] = 0;
					B[2] = 0;
					return true;
				}
			}
		}
		return false;
	}
	
	static public void dfs(int index, String[][] m, int depth) {
		if(depth > 10) {
			System.out.println("Deth : " + depth);
			return;
		}else if( (Min != -1) && (depth > Min) ) {
			System.out.println("Min : " + Min);
			System.out.println("M Deth : " + depth);
			return;
		}else {
			depth++;
			if(Move(index, m, depth)) {
				//true 이면
				//성공
				return;
			}else {
				//falase이면
				System.out.println(depth);
				
				for(int i = 0;i<4;i++) {
					if(index == i) {
						System.out.println("부모 값과 동일 제외");
					}else {
						if(depth < 10) {
							dfs(i, m, depth);
						}
					}
				}
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		int M = 5;
		String[][] Map = {
				{"#", "#", "#", "#", "#"},
				{"#", ".", ".", "B", "#"},
				{"#", ".", "#", ".", "#"},
				{"#", "R", "O", ".", "#"},
				{"#", "#", "#", "#", "#"}
			};
		
		
		
		//최대 10회까지만 반복함
		Num = 10;
		//10회 이상이면 결과값이 -1이 되어야함
		//10회까지 변화 없으면 -1 출력
		Min = 10;
		
		B = new int[3];
		R = new int[3];
		
		for(int i = 0 ; i< N ; i++ ){
			for(int j=0 ; j<N ; j++) {
				if(Map[i][j].equals("B")) {
					B[0] = i;
					B[1] = j;
					B[2] = 0;
				}else if(Map[i][j].equals("R")) {
					R[0] = i;
					R[1] = j;
					R[2] = 0;
				}
			}
		}
		System.out.println("B[0] : " + B[0] + " / B[1] : " + B[1]);
		System.out.println("R[0] : " + R[0] + " / R[1] : " + R[1]);

		//int i는 방위값을 나타낸다.
		//0:북>1:동>2:남>3:서
		for(int i = 0;i<4;i++) {
			dfs(i, Map, 0);
		}
		
		//dfs(1, Map, 0);
		
		System.out.println(Min);
	}

}
