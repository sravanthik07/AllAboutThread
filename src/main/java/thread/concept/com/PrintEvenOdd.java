package thread.concept.com;

public class PrintEvenOdd {

	static int n = 10;
	int counter = 1;

	public static void main(String[] args) {

		PrintEvenOdd eo = new PrintEvenOdd();

		Thread even = new Thread(new Runnable() {

			@Override
			public void run() {
				eo.printEven();
			}

		});

		Thread odd = new Thread(new Runnable() {

			@Override
			public void run() {
				eo.printOdd();
			}

		});

		even.start();
		odd.start();

	}

	public void printEven() {

		synchronized (this) {
			while (counter < n) {
				if (counter % 2 == 1) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Even number: " + counter);
				counter++;
				notify();
			}
		}
	}

	public void printOdd() {

		synchronized (this) {
			while (counter < n) {
				while (counter % 2 == 0) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("Odd number: " + counter);
				counter++;
				notify();
			}
		}
	}
}
