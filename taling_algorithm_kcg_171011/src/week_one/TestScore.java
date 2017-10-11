package week_one;

import java.util.ArrayList;

public class TestScore extends Student {
	private ArrayList<String> scoreRate;
	private ArrayList<Integer> score;
	
	public TestScore() {
		// TODO Auto-generated constructor stub
	}
	
	public TestScore(String n, int a, ArrayList<Integer> s) {
		// TODO Auto-generated constructor stub
		super(n, a);
		this.score = s;
		this.scoreRate = new ArrayList<String>();
	}
	
	public void setScoreRate() {
		for (Integer i : score) {
			if(i == 100) {
				scoreRate.add("A+");
			}else if(i <= 99 && i >= 90) {
				scoreRate.add("A");
			}else if(i <= 89 && i >= 80) {
				scoreRate.add("B");
			}else if(i <= 79 && i >= 70) {
				scoreRate.add("C");
			}else if(i <= 69 && i >= 60) {
				scoreRate.add("D");
			}else if(i <= 59) {
				scoreRate.add("F");
			}else {
				scoreRate.add("None");
			}
		}
	}
	
	public void printResult() {
		System.out.print(super.getName() + "\t" + super.getAge() + "\t");
		for(int i = 0; i< score.size();i++) {
			System.out.print( scoreRate.get(i) + "(" + score.get(i)+")\t");
		}
		System.out.print("\n");
	}
}
