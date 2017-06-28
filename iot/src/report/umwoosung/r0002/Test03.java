package report.umwoosung.r0002;

public class Test03 {

	public void printmultipleTable(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				System.out.println(b[j] + "X" + a[i] + " = " + (b[j] * a[i]) + ",");
			}
		}
		System.out.println();

	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] b = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Test03 ae = new Test03();
		ae.printmultipleTable(a, b);

	}
}

// a 의 배열변수를 4개로 만들어놨다고 선언한것.
// b 는 방크기와 숫자를 일일이 대입한것.
// (배열변수의)방숫자는 0부터 시작한다.
