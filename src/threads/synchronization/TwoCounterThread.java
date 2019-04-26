package threads.synchronization;

public class TwoCounterThread extends Thread{
	
	private TwoCounterSynchronizedStatement c;	//experimente a classe TwoCounterSynchronized
	private boolean increase;
	private boolean a;
	
	public TwoCounterThread(TwoCounterSynchronizedStatement c, boolean increase, boolean a) {
		this.c = c;
		this.increase = increase;
		this.a = a;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 50000000; i++){
			if(a){
				if(increase){			
					c.incrementA();
				} else{
					c.decrementA();
				}		
			}
			else{
				if(increase){			
					c.incrementB();
				} else{
					c.decrementB();
				}
			}
		}
	}
	
	public TwoCounterSynchronizedStatement getC() {
		return c;
	}
	
	/**
	 * run it several times!
	 * @param args
	 */
	public static void main(String[] args) {
		
		double tStart = (double) System.currentTimeMillis();
		
		TwoCounterSynchronizedStatement c = new TwoCounterSynchronizedStatement();
		
		TwoCounterThread t1 = new TwoCounterThread(c,true,true);
		TwoCounterThread t2 = new TwoCounterThread(c,true,false);
		TwoCounterThread t3 = new TwoCounterThread(c,false,true);
		TwoCounterThread t4 = new TwoCounterThread(c,false,false);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		double tEnd = (double) System.currentTimeMillis();
		
		System.out.println("T1 a:"+t1.getC().getA());
		System.out.println("T1 b:"+t1.getC().getB());
		System.out.println("T2 a:"+t2.getC().getA());
		System.out.println("T2 b:"+t2.getC().getB());
		System.out.println("T3 a:"+t3.getC().getA());
		System.out.println("T3 b:"+t3.getC().getB());
		System.out.println("T4 a:"+t4.getC().getA());
		System.out.println("T4 b:"+t4.getC().getB());
		
		System.out.println((tEnd-tStart)/1000);
				
		
	}

}
