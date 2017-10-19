package TEST;

public class Game2048 {
	static int N;
	static int Max;
	
	static final int north = 0;
	static final int east = 1;
	static final int south = 2;
	static final int west = 3;
	
	static final int B = 1;
	static final int E = 0;
	
	static public void resetArray(int[][] m) {
		for(int i = 0; i<m.length;i++) {
			for(int j=0; j < m[i].length;j++) {
				m[i][j]=0;
			}
		}
	}
	
	static public void showArray(int[][] m) {
		for(int i = 0; i<m.length;i++) {
			for(int j=0; j < m[i].length;j++) {
				System.out.print(m[i][j] +" ");
			}
			System.out.println("");
		}
	}
	
	static public int max(int[][] m) {
		int mMax = 0;
		for(int i = 0; i<m.length;i++) {
			for(int j=0; j < m[i].length;j++) {
				if(mMax < m[i][j]) {
					mMax = m[i][j];
				}
			}
		}
		return mMax;
	}
	
	static public void resultMax(int index, int[][] M) {
		int[][] temp = new int[M.length][M.length]; 
		
		if(index == 0) {
			//북
			System.out.println("방위 : " + index);
			for(int i = 0; i<= M.length-1 ; i++) {
				for(int j = 0; j< M[i].length-1 ; j++) {
					System.out.println("temp[" + (j) + "][" + (i)+"] : " + (temp[j][i]));
					if( temp[j][i] == E ) {
						System.out.println("M[" + (j) + "][" + (i)+"] : " + (M[j][i]));
						System.out.println("M[" + (j+1) + "][" + (i)+"] : " + (M[j+1][i]));
						if( (M[j][i] == M[j+1][i]) ) {
							M[j][i] += M[j+1][i];
							M[j+1][i] = 0;
							temp[j][i] = B;
						}
					}else {
						if(M[j][i] == 0) {
							M[j][i] += M[j+1][i];
							M[j][i] = 0;
						}
					}
				}
			}
			
			Max = max(M);
			System.out.println("Max : " + Max);
			resetArray(temp);
			showArray(M);
			
		}else if(index == 1) {
			//동
			System.out.println("방위 : " + index);
			for(int i = M.length-1; i >= 0 ; i--) {
				for(int j = M[i].length-1 ; j > 0 ; j--) {
					System.out.println("temp[" + (i) + "][" + (j)+"] : " + (temp[i][j]));
					if( temp[i][j] == E ) {
						System.out.println("M[" + (i) + "][" + (j)+"] : " + (M[i][j]));
						System.out.println("M[" + (i) + "][" + (j-1)+"] : " + (M[i][j-1]));
						if( (M[i][j] == M[i][j-1]) ) {
							M[i][j] += M[i][j-1];
							M[i][j-1] = 0;
							temp[i][j] = B;
						}else {
							if(M[i][j] == 0) {
								M[i][j] += M[i][j-1];
								M[i][j-1] = 0;
							}
						}
					}
				}
			}
			
			Max = max(M);
			System.out.println("Max : " + Max);
			resetArray(temp);
			showArray(M);
			
		}else if(index == 2) {
			//남
			System.out.println("방위 : " + index);
			for(int i = M.length-1; i >= 0 ; i--) {
				for(int j = M[i].length-1 ; j > 0 ; j--) {
					System.out.println("temp[" + (j) + "][" + (i)+"] : " + (temp[j][i]));
					if( temp[j][i] == E ) {
						System.out.println("M[" + (j) + "][" + (i)+"] : " + (M[j][i]));
						System.out.println("M[" + (j-1) + "][" + (i)+"] : " + (M[j-1][i]));
						if( (M[j][i] == M[j-1][i]) ) {
							M[j][i] += M[j-1][i];
							M[j-1][i] = 0;
							temp[j][i] = B;
						}
					}else {
						if(M[j][i]==0) {
							M[j][i] += M[j-1][i];
							M[j-1][i] = 0;
						}
					}
				}
			}
			
			Max = max(M);
			System.out.println("Max : " + Max);
			resetArray(temp);
			showArray(M);
		}else if(index == 3) {
			//서
			System.out.println("방위 : " + index);
			for(int i = 0; i <= M.length-1 ; i++) {
				for(int j = 0 ; j < M[i].length-1 ; j++) {
					System.out.println("temp[" + (i) + "][" + (j)+"] : " + (temp[i][j]));
					if( temp[i][j] == E ) {
						System.out.println("M[" + (i) + "][" + (j)+"] : " + (M[i][j]));
						System.out.println("M[" + (i) + "][" + (j+1)+"] : " + (M[i][j+1]));
						if( (M[i][j] == M[i][j+1]) ) {
							M[i][j] += M[i][j+1];
							M[i][j+1] = 0;
							temp[i][j] = B;
						}else {
							if(M[i][j] == 0) {
								M[i][j] += M[i][j+1];
								M[i][j+1] = 0;
							}
						}
					}
				}
			}
			
			Max = max(M);
			System.out.println("Max : " + Max);
			resetArray(temp);
			showArray(M);
		}else {
			System.out.println("result index Error!");
		}
		
		
		
	}
	
	static public void dnf(int index, int depth, int[][] m ) {
		if( depth > N ) {
			return;
		}else {
			
			resultMax(index, m);
			depth++; 
			System.out.println("Depth : " + depth);
			
			for(int i=0; i<N;i++) {
				if(index == i) {
					return;
				}else {
					dnf(i, depth, m);
				}
			}
		}
	}
	
	static public int play(int[][] M) {
		int answer = 0;
		//MxM행렬 이기에 그만큼 길이로 행렬을 만든다. 
		//temp는 더 이상 진행할지 말지 정한다.
		Max = 0;
		
		for(int i=0 ; i< N;i++) {
			// 0:북 > 1:동 > 2:남 > 3:서
			dnf(i, 0, M);
		}
		
		answer = Max;
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N=5;
		int[][] Map = {
				{2, 0, 0},
				{0, 0, 0},
				{0, 0, 2}
		};
		
		System.out.println(play(Map));

	}

}
