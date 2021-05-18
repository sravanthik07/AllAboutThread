package thread.concept.com;

public class SynchronizedDemo {

	public static void main(String[] args) {
		
		Display d1 = new Display();
		Display d2 = new Display();
		
		MyThread1 t1 = new MyThread1(d1, "Sravs");
		MyThread1 t2 = new MyThread1(d2, "Nikki");
		MyThread2 t3 = new MyThread2(d1, "Srikanth");
		
		t1.start();
		t2.start();
		t3.start();
		
	}

	public static class Display {
		
		//class level lock - This lock doesnt allow any static synch method of this class simultaneously 
		//but static methods/synchronized methods/normal methods are allowed to execute 
		public static synchronized void wishMorning(String name) throws InterruptedException {
			for(int i=0; i<10; i++) {
				System.out.print("Good morning ");
				Thread.sleep(1000);
				System.out.println(name);
			}
		}
		
		public static void wishAfternoon(String name) throws InterruptedException {
			for(int i=0; i<10; i++) {
				System.out.print("Good afternoon ");
				Thread.sleep(1000);
				System.out.println(name);
			}
		}
		
		//Object level lock
		public synchronized void wishEvening(String name) throws InterruptedException {
			for(int i=0; i<10; i++) {
				System.out.print("Good evening ");
				Thread.sleep(1000);
				System.out.println(name);
			}
		}
		
		public void wishNight(String name) throws InterruptedException {
			for(int i=0; i<10; i++) {
				System.out.print("Good night ");
				Thread.sleep(1000);
				System.out.println(name);
			}
		}
	}
	
	public static class MyThread1 extends Thread{
		
		Display d;
		String name;
		public MyThread1(Display d, String name){
			this.d = d;
			this.name=name;
		}
		public void run() {
			
			try {
				d.wishMorning(name);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static class MyThread2 extends Thread{
		
		Display d;
		String name;
		public MyThread2(Display d, String name){
			this.d = d;
			this.name=name;
		}
		public void run() {
			
			try {
				d.wishAfternoon(name);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
public static class MyThread3 extends Thread{
		
		Display d;
		String name;
		public MyThread3(Display d, String name){
			this.d = d;
			this.name=name;
		}
		public void run() {
			
			try {
				d.wishEvening(name);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
