package threads.synchronization;

public class CounterThread extends Thread{
	
	private Counter c;
	private boolean increase;
	
	public CounterThread(Counter c, boolean increase) {
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
	
	public Counter getC() {
		return c;
	}
	
	/**
	 * run it several times!
	 * @param args
	 */
	public static void main(String[] args) {
		Counter c = new Counter();
		
		CounterThread t1 = new CounterThread(c,true);
		CounterThread t2 = new CounterThread(c,false);
		
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
