package thread.concept.com;

public class ThreadGroupSamp {

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getThreadGroup().getName()); //main
		
		System.out.println(Thread.currentThread().getThreadGroup().getParent().getName()); //system
		
		ThreadGroup g1 = new ThreadGroup("First threadgroup");
		
		System.out.println(g1.getName());
		
		System.out.println(g1.getParent().getName());
		
		ThreadGroup g2 = new ThreadGroup(g1, "Second threadgroup");
		
		System.out.println(g2.getName());
		
		System.out.println(g2.getParent().getName());
		
		
		Thread t1 = new Thread(g1, "First thread");
		
		System.out.println("t1.getPriority()="+t1.getPriority());
		
		System.out.println("after g1.setMaxPriority=2");
		
		g1.setMaxPriority(2); //maxpriority setted to the new threads. old threads wont gets effected
		
		Thread t2 = new Thread(g1, "second thread");
		
		System.out.println("t1.getPriority()="+t1.getPriority());
		
		System.out.println("t2.getPriority()"+t2.getPriority());
		
		g1.setMaxPriority(7); System.out.println("after g1.setMaxPriority=7");
		
		Thread t3 = new Thread(g1, "thrid thread");
		
		System.out.println("t1.getPriority()="+t1.getPriority());
		
		System.out.println("t2.getPriority()="+t2.getPriority());
		
		System.out.println("t3.getPriority()="+t3.getPriority());
		
		g1.list();
		System.out.println("g1.activeCount()="+g1.activeCount());
		
		Thread[] threadArray = new Thread[10];
		g1.enumerate(threadArray );
		
		for(Thread t: threadArray) {
			System.out.println(t.getName());
		}
		
	}

}
