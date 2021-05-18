package thread.concept.com;

public class SystemGroup {
	
	public static void main(String[] args) {
		
		ThreadGroup tg = Thread.currentThread().getThreadGroup().getParent();
		Thread[] t = new Thread[tg.activeCount()];
		tg.enumerate(t);
		for(Thread x : t) {
			System.out.println("Name:"+x.getName()+" isDemon:"+x.isDaemon());
		}
	}

}
