package report.umwoosung.r0001;

public class Test05 {
	public static void main(String[]args){
		for(int i = 1;i<10;i++){
			int n = 1;
			for(n = 1;n<9;n++){
				System.out.print(i + "X" + n + "=" + (n*i)+",");
			
			}
			System.out.println(i + "X" + n + "=" + (n*i));
		}
		
	}

}//for문안에 왜 int n으로 안들어가고 밖에서 int n을 따로 선언해줘야하나?



