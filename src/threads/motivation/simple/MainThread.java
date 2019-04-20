package threads.motivation.simple;

public class MainThread {
	
	public static void main(String[] args) {
		
		GeradorDePDFThread g = new GeradorDePDFThread();	//nao tem thread rodando
		g.start();							//comeca a gerar o PDF		
		
		for(int i = 0; i<=100; i++){		
			try {
				Thread.sleep(1000);
				System.out.println("Progresso ("+i+"%)");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		g.setRunning(false);		
	}

}
