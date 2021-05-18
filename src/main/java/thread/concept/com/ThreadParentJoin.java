package thread.concept.com;

public class ThreadParentJoin {

	public static void main(String[] args) {

		MyThread t = new MyThread();
		t.parentClassRef = Thread.currentThread();
		t.start();
		
		for(int i=0; i< 10; i++) {
			System.out.println("In main Thread1");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static  class MyThread extends Thread{
		
		public Thread parentClassRef;
		public void run() {
			for(int i=0; i< 10; i++) {
				try {
					parentClassRef.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("In Child Thread1");
			}
		}
	}

}
