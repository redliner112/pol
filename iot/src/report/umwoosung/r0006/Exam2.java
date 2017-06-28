package report.umwoosung.r0006;

public class Exam2 {
	
	int getIndexFromArray(int []arr,int num){
		for(int i=0;i<arr.length;i++){
			if(arr[i]==num){
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int []a = new int [5];
		for(int i=0;i<5;i++){
			a[i]=(i+1)*10;
		}
		Exam2 e3 = new Exam2();
		int idx = e3.getIndexFromArray(a,30);
		System.out.println("30이란값을 가지고있는 방의index는" + idx);
	}

}
