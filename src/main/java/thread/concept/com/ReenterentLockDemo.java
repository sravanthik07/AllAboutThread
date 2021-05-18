package thread.concept.com;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterentLockDemo {

	public static void main(String[] args) {

		/*
		 * ReentrantLock l = new ReentrantLock(); l.lock(); l.lock();
		 * System.out.println(l.isLocked());
		 * System.out.println(l.isHeldByCurrentThread());
		 * System.out.println(l.getQueueLength()); l.unlock();
		 * System.out.println(l.getHoldCount()); System.out.println(l.isLocked());
		 * l.unlock(); System.out.println(l.isLocked()); System.out.println(l.isFair());
		 */

		Display d1 = new Display();
		// Display d2 = new Display();

		MyThread1 t1 = new MyThread1(d1, "Sravs");
		MyThread1 t2 = new MyThread1(d1, "Nikki");
	//	MyThread3 t3 = new MyThread3(d1, "Srikanth");

		t1.start();
		t2.start();
	//	t3.start();

	}

	public static class Display {

		static ReentrantLock l = new ReentrantLock();

		public void wishMorning(String name) throws InterruptedException {
			l.lock();
			if (l.tryLock()) {
				System.out.println("Got lock for morning wish");
				for (int i = 0; i < 10; i++) {
					System.out.print("Good morning ");
					Thread.sleep(1000);
					System.out.println(name);
				}
				l.unlock();
				System.out.println("Released lock for morning wish");
			} else {
				System.out.println("Unable to get lock for morning wish");
			}

		}

		public void wishAfternoon(String name) throws InterruptedException {
			l.lock();
			if (l.tryLock()) {
				System.out.println("Got lock for afternoon wish");
				for (int i = 0; i < 10; i++) {
					System.out.print("Good afternoon ");
					Thread.sleep(1000);
					System.out.println(name);
				}
				l.unlock();
			} else {
				System.out.println("Unable to get lock for afternoon wish");
			}
		}

		public void wishEvening(String name) throws InterruptedException {
			l.lock();
			if (l.tryLock()) {
				System.out.println("Got lock for evening wish");
				for (int i = 0; i < 10; i++) {
					System.out.print("Good evening ");
					Thread.sleep(1000);
					System.out.println(name);
				}
				l.unlock();
			} else {
				System.out.println("Unable to get lock for evening wish");
			}
		}

		public void wishNight(String name) throws InterruptedException {
			l.lock();
			for (int i = 0; i < 10; i++) {
				System.out.print("Good night ");
				Thread.sleep(1000);
				System.out.println(name);
			}
			l.unlock();
		}
	}

	public static class MyThread1 extends Thread {

		Display d;
		String name;

		public MyThread1(Display d, String name) {
			this.d = d;
			this.name = name;
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

	public static class MyThread2 extends Thread {

		Display d;
		String name;

		public MyThread2(Display d, String name) {
			this.d = d;
			this.name = name;
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

	public static class MyThread3 extends Thread {

		Display d;
		String name;

		public MyThread3(Display d, String name) {
			this.d = d;
			this.name = name;
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
