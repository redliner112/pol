package report.umwoosung.r0005;


//0부터 4까지 반복물을 작성하여
//Cal10(int a)라고 선언된 생성자를 호출하여 1부터 5까지 를 출력해보세요
public class Exam2 {
	public static void main(String[] args) {
		Cal10[] c = new Cal10[5];
		for(int i=0;i<=4;i++){
			c[i] =new Cal10(i+1);
		}

		for(int i=0;i<=4;i++){
			c[i] = new Cal10(i,2,"+");
		}
		for(int i=0;i<=4;i++){
			System.out.println(c[i].a);
		}
	}
}
