package report.umwoosung.r0008;

import java.util.Scanner;

public class Father {
	int a = 3;
	Scanner scan;
	String str1;
	String str2;
	int s1;
	int s2;
	int result;
	int [] arr = new int [10];

	Father() {
		scan = new Scanner(System.in);
	}

	void InpuFromScanner1() {
		System.out.print("맥스값을 입력해주세요");
		str1 = scan.nextLine();
		s1 = Integer.parseInt(str1);

	}

	void InpuFromScanner2() {
		System.out.print("최소값을 입력해주세요");
		str2 = scan.nextLine();
		s2 = Integer.parseInt(str2);

	}

	void result() {
		for (int i = s1; i <= s2; i++) {
			result += i;
			System.out.print(i + ",");

		}

	void arr(){
		for(int i = 0;i<10;i++);
		
		
	}
	}

}
