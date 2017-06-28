package report.umwoosung.r0003;

public class Exam7 {
	public int[] getArrVar(int[]params){
		int[]a = new int [params[0]];
		for(int i = params[1];i<=params[2];i++){
			a[i] = (i+1)*2;
			
		}
		return a;//1
				
	}
	public void  printArrVar(int[] a){
		for(int i = 1;i<=5;i++){
			System.out.println(a[i-1]);
			
		}//2
	}
	public static void main(String[]args){
		Exam7 ae = new Exam7();
		int[]params = {5,0,4};
		int[]a = ae.getArrVar(params);
		ae.printArrVar(a);
	}//3

}//
