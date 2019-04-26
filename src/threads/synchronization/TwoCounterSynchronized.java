package threads.synchronization;

public class TwoCounterSynchronized {
	
	private int a;
	private int b;
		
	public synchronized  void incrementA(){
			a++;
	}
	
	public synchronized  void incrementB(){
			b++;
	}
	
	public synchronized  void decrementA(){
			a--;
	}
	
	public synchronized  void decrementB(){
			b--;
	}
	
	public synchronized int getA() {
		return a;
	}
	
	public synchronized int getB() {
		return b;
	}

}
