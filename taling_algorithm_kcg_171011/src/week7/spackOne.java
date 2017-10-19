package week7;

public class spackOne {
	static int sec;
	static int[][] Map;
	static int R; //뱀 행
	static int C; //뱀 열
	static int index;
	static int Dir[][] = {
			{-1, 0, 1, 0},
			{0, 1, 0, -1}
	};
	//index 에 앞 0 1 2 3 
	static public void showArray(int[][] m) {
		for(int i = 0; i<m.length;i++) {
			for(int j=0; j < m[i].length;j++) {
				System.out.print(m[i][j] +" ");
			}
			System.out.println("");
		}
	}
	
	static public boolean Move() {
		boolean isflag = false;
		//방위값에 따른
		System.out.println("Map[" + R + "][" + C+ "] : " + Map[R][C]);
		R += Dir[0][index];
		C += Dir[1][index];
		sec++;
		
		System.out.println("index : " + index);
		System.out.println("dir[0][" + index+ "] : " + Dir[0][index]);
		System.out.println("dir[1][" + index+ "] : " + Dir[1][index]);
		
		System.out.println("Map[" + R + "][" + C+ "] : " + Map[R][C]);
		
		
		if( Map[R][C] == 1 || R <=0 || R >= Map.length-1 ||
				C <= 0 || C >= Map[R].length-1) {
			System.out.println("End");
			return true;
		}
		
		/*if(index==1) {
			C += 1;
		}
		else if(index==2) {
		}
		else if(index==3) {
		}
		else if(index==0) {
		}*/
		Map[R][C] = 1;
		showArray(Map);
		
		
		return isflag;
	}
	
	static public void direction(String d) {
		System.out.println("index : " + index);

		if (d.equals("L")) {
			if(index==1) {
				index=0;
			}
			else if(index==2) {
				index=1;
			}
			else if(index==3) {
				index=2;
			}
			else if(index==0) {
				index=3;
			}
		}
		else if(d.equals("R")) {
			if(index==1) {
				index=2;
			}
			else if(index==2) {
				index=3;
			}
			else if(index==3) {
				index=0;
			}
			else if(index==0) {
				index=1;
			}
		}
		System.out.println("chage index : " + index);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int L = 3;
		int N = 4;
		int[] T = {2, 2, 1, 5};
		String[] D = {"L", "L", "L", "R"};
		char[] D2 = {'L', 'L', 'L', 'R'};
		index = 1;
		//index 방향 : 0:북 > 1:동 > 2:남 > 3:서
		boolean flag = false;
		sec = 0;
		Map = new int[(2*L)+1][(2*L)+1];
		R = L;
		C = L;
		//시작
		Map[R][C]=1;
		
		for(int i = 0; i< N ; i++) {
			System.out.println("i : " + i);
			for(int j = 0 ; j<T[i]; j++) {
				System.out.println("j : " + j);
				flag = Move();
				System.out.println("return flag : " + flag);
				if(flag) {
					break;
				}
			}
			if(flag) {
				break;
			}
			direction(D[i]);
		}
		
		System.out.println(sec);
		
		
	}

}
