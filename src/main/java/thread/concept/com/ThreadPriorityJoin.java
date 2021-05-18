package thread.concept.com;

public class ThreadPriorityJoin {

	public static void main(String[] args) throws InterruptedException {
		
		MyThread1 t1 = new MyThread1();
		t1.start();
		//t.setPriority(10);
		t1.join();
		
		MyThread2 t2 = new MyThread2();
		t2.start();
		t2.join();
		
		for(int i=0; i< 10; i++) {
			System.out.println("In main Thread");
		}
		
	}
	
	public static class MyThread1 extends Thread{
		
		public void run() {
			for(int i=0; i< 10; i++) {
				System.out.println("In Child Thread1");
				//Thread.yield();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
public static class MyThread2 extends Thread{
		
		public void run() {
			for(int i=0; i< 10; i++) {
				System.out.println("In Child Thread2");
				//Thread.yield();
			}
		}
	}

}


