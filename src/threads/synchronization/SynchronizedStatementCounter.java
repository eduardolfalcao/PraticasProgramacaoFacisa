package threads.synchronization;

//https://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html
public class SynchronizedStatementCounter {
    private int c = 0;
    private Object lock = new Object();

    public void increment() {
    	//synchronized(c){
    	synchronized(lock){
    		c++;
    	}
    }

    public void decrement() {
    	//synchronized(c){
    	synchronized(lock){
    		c--;
        }
    }

    public int value() {
    	//synchronized(c){
    	synchronized(lock){
    		return c;
        }
    }
}