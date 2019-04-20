package threads.waitAndNotify;

public class GeraPDFThreaded extends Thread {
	
	private int progresso = 0;
	private BarraDeProgressoThreaded b;
	
	public GeraPDFThreaded(BarraDeProgressoThreaded b) {
		this.b = b;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			progresso++;
			synchronized (b) {
				b.notify();
			}
		}
	}
	
	public int getProgresso() {
		return progresso;
	}

}
