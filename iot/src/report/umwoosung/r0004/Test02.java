package report.umwoosung.r0004;

public class Test02 {
	
	public static void main(String[]args){
		int[] a = new int[5];//1
	
		for(int i=0;i<5;i++){//3
			a[i] = i+1;//4
		}
		for(int i=0;i<5;i++){
			System.out.print( "a[" + i+  "]=" + a[i] + ",");//5
		}
	}

}
//