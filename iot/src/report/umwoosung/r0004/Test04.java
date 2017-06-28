package report.umwoosung.r0004;

public class Test04 {
	public static void main(String[] args) {
		int[] a = new int[20];
		for (int i = 0; i < 20; i++) {
			int random = (int) (Math.random() * 45) + 1;
			a[i] = random;
			for (int j = i; j >= 0; j--) {
				if (a[j] == a[i] && i != j) {
					j = 0;
					i--;
				}
			}
		}

		for (int i = 0; i < 6; i++) {
			System.out.println((i + 1) + "번째로또번호는 : " + a[i]);
		}
	}

}
// 5 int []a의 방의값을 20으로 선언
// 6 반복문으로 (int i= 0 선언;i<20조건;i++변수)
// 7 (int)(Math.random()*4)+1(숫자랜덤생성변수*46) 으로int random을 선언 <== 왜46을하지않고 +1을
// 한것인가?
// 8 a[i] = random; a[i]에 (숫자랜덤생성변수*46)을넣고 <==키값에 랜덤생성변수가 들어간것인가?
// 9반복문으로 (int j= 0 선언;j>=0조건;j--변수)
// 10 if문 (j<20 그리고 a[j]==a[i] && i!=j) <==설명필요
// 11번째줄 <== 의미는?
// <== ?? 키를 46개를 구할려면 방이 46개가 있어야 하지않는것인가? 왜 20개의 방만 있는것인가?
// <==??a[i]와 a[j]의 차이
