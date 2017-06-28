package report.umwoosung.r0004;

public class Test01 {
	public void printPlusResult(int a, int b){
		System.out.println("더한결과값:" + (a+b));
		
	}
	public int getPlusResult(int a,int b){
		return a+b;
	}
	
	public static void main(String[]args){
		Test01 e= new Test01();
		
		e.printPlusResult(1,3);
		int result = e.getPlusResult(1,3);
		System.out.println("더한결과값:" + result);
	}

}
