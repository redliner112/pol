package report.umwoosung.r0005;

public class Robot {
	String name;
	int age;
	
	Robot(String name, int  age){
		this.name = name;
		this.age = age;
	}
	
	
	void dokick() {
		System.out.println(age + "살먹은" + name + "이 발차기를 하였습니다.");
	}

	void doRun() {
		System.out.println(age + "살먹은" + name + "이달리기를 하였습니다.");
	}

	void doChange() {
		System.out.println(age + "살먹은" + name + "이변신을 하였습니다.");
	}

	public static void main(String[] args) {
		Robot r = new Robot("로또봇",4);
		r.doChange();
		r.dokick();
		r.doRun();
		
	}

}
