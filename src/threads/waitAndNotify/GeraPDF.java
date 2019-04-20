package threads.waitAndNotify; 

public class GeraPDF {
	
	private int progresso;
	
	public void rodar() {
		for(int i = 0; i < 100; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			progresso++;
			System.out.println("Progresso de geração do pdf: "+progresso);
		}
	}

}
