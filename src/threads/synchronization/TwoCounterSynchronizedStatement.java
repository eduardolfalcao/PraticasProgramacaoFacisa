package threads.synchronization;

public class TwoCounterSynchronizedStatement {
	
	private int a;
	private int b;
	private Object lockA = new Object();
	private Object lockB = new Object();
	
	public void incrementA(){
		synchronized (lockA) {
			a++;
		}		
	}
	
	public void incrementB(){
		synchronized (lockB) {
			b++;
		}
	}
	
	public void decrementA(){
		synchronized (lockA) {
			a--;
		}
	}
	
	public void decrementB(){
		synchronized (lockB) {
			b--;
		}
	}
	
	public synchronized int getA() {
		return a;
	}
	
	public synchronized int getB() {
		return b;
	}

}
