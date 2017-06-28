package report.umwoosung.r0005;

public class Exam3 {
	public static void main(String[]args){
		Cal10 c1 = new Cal10(1,2,"+");
		c1.printCal10();
		
		Cal10 c2 = new Cal10(1,2,"-");
		c2.printCal10();
		
		Cal10[] arrC = new Cal10[2];
		arrC[0]= c1;
		arrC[1]= c2;
	}
}
