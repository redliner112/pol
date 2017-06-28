package report.umwoosung.r0002;

public class Test02 {
	int a = 0;
	int b = 0;
	int c = 0;

	public void printLoop() {
		for (int i = a; i <= b; i++) {
			if (i % c == (a%c) -1) {
				System.out.println(i);
			} else {
				System.out.print(i + ",");
			}
		}System.out.println();
	}

	public void printReverse() {
		for (int i = a; i >= b; i--) {
			if (i % c == (a%c)+1) {
				System.out.println(i);
			} else {
				System.out.print(i + ",");
			}
				
		}
	}

	public static void main(String[] args) {
		Test02 t2 = new Test02();
		t2.c = 10;
		
		t2.a = 5;
		t2.b = 100;
		t2.printLoop();
		t2.a = 100;
		t2.b = 1;
		t2.printReverse();

		// 1.Test02 �� ����� 2.t2.printReverse();�� .���� ���������θ�����ٰ� �����ؾ���
		// t2.printReverse();�� printReverse�� ȣ���߰�, print�� �̹� �װ��������Ƿ� main����
		// ����Ʈ����������.
		// �Լ���,������?
		//����:100���� 1���� 10���� ������.
	}

}
