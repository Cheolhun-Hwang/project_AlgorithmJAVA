package week7;

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
			for(int i = 0;i< M.length;i++) {
				// i 값은 열에 해당합니다.
				for(int j = 1 ; j<M[i].length;j++) {
					//j 값은 순차적으로 오른쪽으로 검산하기 위한 반복입니다.
					for(int k=j ; k>0 ; k--) {
						//k 값은 행에 해당합니다.
						System.out.println("temp[" + (k-1) + "][" + (i) + "] : " + (temp[k-1][i]));
						if(temp[k-1][i] == E) {
							//위로 움직일 수 있으면 움직입니다.
							System.out.println("M[" + (k-1) + "][" + (i) + "] : " + (M[k-1][i]));
							System.out.println("M[" + (k) + "][" + (i) + "] : " + (M[k][i]));
							if(M[k-1][i] == M[k][i]) {
								//움직일 칸이 서로 같으면 더해줍니다.
								if(M[k-1][i] == 0) {
									M[k-1][i]+= M[k][i];
									M[k][i] = 0;
								}else {
									M[k-1][i]+= M[k][i];
									M[k][i] = 0;
									temp[k-1][i] = B;
								}
							}else {
								//서로 같은 값을 가지고 있지 않습니다.
								if(M[k-1][i] == 0) {
									//서로 다른 값이지만 움직일 수 있을 경우 움직입니다.
									M[k-1][i]+= M[k][i];
									M[k][i] = 0;
								}
							}
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
			for(int i = 0 ;i < M.length ;i++) {
				// i 값은 열에 해당합니다.
				for(int j = (M[i].length-1)-1 ; j>=0; j--) {
					//j 값은 순차적으로 오른쪽으로 검산하기 위한 반복입니다.
					for(int k=j ; k<M[i].length-1 ; k++) {
						//k 값은 행에 해당합니다.
						if(temp[i][k] == E) {
							//위로 움직일 수 있으면 움직입니다.
							if(M[i][k] == M[i][k+1]) {
								//움직일 칸이 서로 같으면 더해줍니다.
								if(M[i][k+1] == 0) {
									//서로 다른 값이지만 움직일 수 있을 경우 움직입니다.
									M[i][k+1]+= M[i][k];
									M[i][k] = 0;
								}else {
									M[i][k+1]+= M[i][k];
									M[i][k] = 0;
									temp[i][k+1] = B;
								}
							}else {
								//서로 같은 값을 가지고 있지 않습니다.
								if(M[i][k+1] == 0) {
									//서로 다른 값이지만 움직일 수 있을 경우 움직입니다.
									M[i][k+1]+= M[i][k];
									M[i][k] = 0;
								}
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
			for(int i = 0 ;i < M.length ;i++) {
				// i 값은 열에 해당합니다.
				for(int j = (M[i].length-1)-1 ; j>=0; j--) {
					//j 값은 순차적으로 오른쪽으로 검산하기 위한 반복입니다.
					for(int k=j ; k<M[i].length-1 ; k++) {
						//k 값은 행에 해당합니다.
						if(temp[k][i] == E) {
							//위로 움직일 수 있으면 움직입니다.
							if(M[k][i] == M[k+1][i]) {
								//움직일 칸이 서로 같으면 더해줍니다.
								if(M[k+1][i] == 0) {
									//서로 다른 값이지만 움직일 수 있을 경우 움직입니다.
									M[k+1][i]+= M[k][i];
									M[k][i] = 0;
								}else {
									M[k+1][i]+= M[k][i];
									M[k][i] = 0;
									temp[k+1][i] = B;
								}
							}else {
								//서로 같은 값을 가지고 있지 않습니다.
								if(M[k+1][i] == 0) {
									//서로 다른 값이지만 움직일 수 있을 경우 움직입니다.
									M[k+1][i]+= M[k][i];
									M[k][i] = 0;
								}
							}
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
			for(int i = 0;i< M.length;i++) {
				// i 값은 열에 해당합니다.
				for(int j = 1 ; j<M[i].length;j++) {
					//j 값은 순차적으로 오른쪽으로 검산하기 위한 반복입니다.
					for(int k=j ; k>0 ; k--) {
						//k 값은 행에 해당합니다.
						if(temp[i][k-1] == E) {
							//위로 움직일 수 있으면 움직입니다.
							if(M[i][k-1] == M[i][k]) {
								//움직일 칸이 서로 같으면 더해줍니다.
								M[i][k-1]+= M[i][k];
								M[i][k] = 0;
								temp[i][k-1] = B;
							}else {
								//서로 같은 값을 가지고 있지 않습니다.
								if(M[i][k-1] == 0) {
									//서로 다른 값이지만 움직일 수 있을 경우 움직입니다.
									M[i][k-1]+= M[i][k];
									M[i][k] = 0;
								}
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
				{2, 2, 2},
				{4, 4, 4},
				{8, 8, 8}
		};
		
		System.out.println(play(Map));
		
		/*for(int i = 0 ;i < Map.length ;i++) {
			// i 값은 열에 해당합니다.
			for(int j = (Map[i].length-1)-1 ; j>=0; j--) {
				//j 값은 순차적으로 오른쪽으로 검산하기 위한 반복입니다.
				for(int k=j ; k<Map[i].length-1 ; k++) {
					//k 값은 행에 해당합니다.
					System.out.println( k + " / " + i + "     #      " + (k+1) + " / " + i);
				}
			}
		}*/
		
		/*System.out.println();
		
		for(int i = 0;i< Map.length;i++) {
			// i 값은 열에 해당합니다.
			for(int j = 1 ; j<Map[i].length;j++) {
				//j 값은 순차적으로 오른쪽으로 검산하기 위한 반복입니다.
				for(int k=j ; k>0 ; k--) {
					//k 값은 행에 해당합니다.
					System.out.println( k + " / " + i + "     #      " + (k-1) + " / " + i);
				}
			}
		}*/
		
	}

}
