package week5;

import java.util.Scanner;

public class Supervisor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a [] = new int[n];

		for (int i = 0; i < n; i++) {
			a[i]=sc.nextInt();

		}

		int b = sc.nextInt();
		int c = sc.nextInt();

		int main_supervisor = n;
		int sub_supervisor = 0;


		for (int i = 0; i < n; i++) {
			a[i]=a[i]-b;
			sub_supervisor = sub_supervisor + a[i]/c;
			if(a[i]%c>0) {
				sub_supervisor = sub_supervisor+1;
			}

			}
	
		int total = main_supervisor + sub_supervisor;

		System.out.println(total);
	}

}
