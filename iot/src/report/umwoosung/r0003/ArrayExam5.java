package report.umwoosung.r0003;

public class ArrayExam5 {

	public int[] getArrVar(int length, int initNum, int maxNum) {
		int[] a = new int[length];
		for (int i = initNum; i <= maxNum; i++) {
			a[i] = (i + 1) * 2;

		}
		return a;
	}

	public void printArrVar(int[] a) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(a[i - 1]);

		}
	}

	public static void main(String[] args) {
		ArrayExam5 ae = new ArrayExam5();
		int[] a = ae.getArrVar(10, 0, 9);
		ae.printArrVar(a);
	}
}
