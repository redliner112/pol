package holyday.test;

public class ThreadWithRunnable implements Runnable {

	public void run() {
		try{
			Thread.sleep(10);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}


}
