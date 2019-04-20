package threads.motivation;

public class GeradorDePDF{
	
	private boolean running = true;
	
	public static long count = 0;
	
	public void geraPdf(){
		while(running){			
			try {
				Thread.sleep(500);
				System.out.println("Gerando o pdf..."+(++count));
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
