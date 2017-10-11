package week_one;

import java.util.ArrayList;
import java.util.Arrays;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestScore stu1 = new TestScore("b", 19, new ArrayList<Integer>(Arrays.asList(85, 77, 79)) );
		
		stu1.setScoreRate();
		
		stu1.printResult();
	}

}
