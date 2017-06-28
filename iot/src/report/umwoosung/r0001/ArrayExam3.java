package report.umwoosung.r0001;

public class ArrayExam3 {
	public int[] getArryVar(int initNum, int maxNum) {
		int[] a = new int[maxNum - initNum];
		for (int i = initNum - initNum; i < maxNum - initNum; i++)
			a[i] = i + 1;
		return a;
		// 1
	}

	public void printArryVar(int[] a) {
		for (int i = a.length - 1; i >= 0; i--) {
			System.out.println("a의" + i + "번째의값 = " + a[i]);
		} // 2
	}

	public static void main(String[] args) {
		ArrayExam3 ae3 = new ArrayExam3();
		int[] a = ae3.getArryVar(0, 5);
		ae3.printArryVar(a);
		// 3

	}

}
// 배열.
// 문제점.1.내는 문제를 이해못한다.
// 2.적어준 코딩을 적는데 시간이 걸리고, 다적는다고해도 오류를 잡느라 문제에 신경못쓴다
// 3.이해가 됬다고해도 숙지하는데 시간이 걸리는데 너무 위2개로 숙지의 시간이 잡아먹힌다.
// 4.이해하지도 못했는데 갑자기 코딩이 바뀌기 시작하면 아예모르겠다
// 해결방법1.시간이필요.
// 2.코딩은 시간이 필요하고,오류는 해결불가능
// 3.당일날 할수가없음
// 4.답도없음