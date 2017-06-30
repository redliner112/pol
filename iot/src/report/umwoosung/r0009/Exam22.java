package report.umwoosung.r0009;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exam22 {
	public static void main(String[]args){
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for(int i=0;i <5;i++){
			arrList.add(Integer.parseInt(scan.nextLine()));
		
		}
		Collections.sort(arrList);
		for(int i=0;i<arrList.size();i++){
			System.out.println(arrList.get(i));
		}
	}

}
