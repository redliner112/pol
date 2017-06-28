package report.umwoosung.r0003;

public class ArrayExam6 {
	public int[] getArrVar(int[] params) {
		int[] a = new int[params[0]];
		for (int i = params[1]; i <= params[2]; i++) {
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
		ArrayExam6 ae = new ArrayExam6();
		int[] params = { 10, 0, 9 };
		int[] a = ae.getArrVar(params);
		ae.printArrVar(a);
	}
}
