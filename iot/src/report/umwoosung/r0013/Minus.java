package report.umwoosung.r0013;

public class Minus implements InterfaceExam {
	


	public void setString(String str) {
		System.out.println("Test 의 SetString()함수호출!!"+str);
		
	}

	@Override
	public String getString() {
		return "Test의 getString()함수 호출!!";
	}
	public int cal(int a,int b){
		return a-b;
	}
}
