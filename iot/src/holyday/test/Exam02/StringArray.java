package Exam02;

public class StringArray {
	public static void main(String[] arg) {
		String[] arrStr = new String[5];
		arrStr[0] = "a";
		for (int i = 0; i < arrStr.length; i++) {
			arrStr[i] = i + "";
			System.out.println(arrStr[i]+"번째 방입니다.");
		}
		for (int i = 0; i < arrStr.length; i++) {
			arrStr[i] = (i+1) + "";
			System.out.println(i +"번째 방의 숫자는"+arrStr[i] + "입니다");
		}
	}

}
