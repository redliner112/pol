package report.umwoosung.r0006;

public class Father {
	private String address = "서울시 강서구 가양동";
	private int age = 65;
	private String name = "박철수";
	
	int getAge(){
		return this.age;
	}
	String getAdress(){
		return address;
	}
	
	String getName(){
		return name;
	}
	
	void setName(String name){
		this.name = name;
	}
}
