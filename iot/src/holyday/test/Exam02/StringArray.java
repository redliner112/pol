package Exam02;

public class StringArray {
	public static void main(String[] arg) {
		String[] arrStr = new String[5];
		arrStr[0] = "a";
		for (int i = 0; i < arrStr.length; i++) {
			arrStr[i] = i + "";
			System.out.println(arrStr[i]+"��° ���Դϴ�.");
		}
		for (int i = 0; i < arrStr.length; i++) {
			arrStr[i] = (i+1) + "";
			System.out.println(i +"��° ���� ���ڴ�"+arrStr[i] + "�Դϴ�");
		}
	}

}
