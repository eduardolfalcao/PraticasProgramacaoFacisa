package threads.synchronization;

public class SynchronizedCounterThread extends Thread{

	private SynchronizedCounter c;
	private boolean increase;
	
	public SynchronizedCounterThread(SynchronizedCounter c, boolean increase) {
		this.c = c;
		this.increase = increase;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 1000000; i++){
			if(increase){			
				c.increment();
			} else{
				c.decrement();
			}		
		}
	}
	
	public SynchronizedCounter getC() {
		return c;
	}
	
	/**
	 * run it several times!
	 * @param args
	 */
	public static void main(String[] args) {
		SynchronizedCounter c = new SynchronizedCounter();
		
		SynchronizedCounterThread t1 = new SynchronizedCounterThread(c,true);
		SynchronizedCounterThread t2 = new SynchronizedCounterThread(c,false);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(t1.getC().value());
		System.out.println(t2.getC().value());		
		
	}
	
}
