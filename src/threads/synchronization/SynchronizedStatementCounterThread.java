package threads.synchronization;

public class SynchronizedStatementCounterThread extends Thread{

	private SynchronizedStatementCounter c;
	private boolean increase;
	
	public SynchronizedStatementCounterThread(SynchronizedStatementCounter c, boolean increase) {
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
	
	public SynchronizedStatementCounter getC() {
		return c;
	}
	
	/**
	 * run it several times!
	 * @param args
	 */
	public static void main(String[] args) {
		SynchronizedStatementCounter c = new SynchronizedStatementCounter();
		
		SynchronizedStatementCounterThread t1 = new SynchronizedStatementCounterThread(c,true);
		SynchronizedStatementCounterThread t2 = new SynchronizedStatementCounterThread(c,false);
		
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
