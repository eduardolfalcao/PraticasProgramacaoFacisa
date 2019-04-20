package threads.motivation.simple;

public class GeradorDePDFThread extends Thread{
	
	private boolean running = true;
	
	public static long count = 0;
	
	public void run(){
		geraPdf();
	}
	
	public void geraPdf(){
		while(running){			
			try {
				Thread.sleep(100);
				System.out.println("Gerando o pdf...");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void setRunning(boolean running) {
		this.running = running;
	}
	

}
