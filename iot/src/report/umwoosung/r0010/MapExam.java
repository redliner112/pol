package report.umwoosung.r0010;

import java.util.HashMap;

import java.util.Iterator;



public class MapExam extends HashMap{

	MapExam(){
		
	}
	public String put(String key){
		if(!containsKey(key)){
			put(key,"test");
		}
		return"있다";
	}
	public String toString(){
	String result = "";
		Iterator it = keySet().iterator();
		  while(it.hasNext()){
			  String key = (String) it.next();
			  Integer value = (int)get(key);
			  result += key +","+value; 
		  }
		  if(result.equals("")){
			  result = "아무것도없어.";
		  }
		  return result;
	}
	public static void main(String[]args){
		MapExam me = new MapExam();
		me.put("abc","abc");
		me.put("B군",60);
		System.out.println(me);
		
	}
	
}
