package threads.motivation;

public class Main {
	
	public static void main(String[] args) {
		
		GeradorDePDF g = new GeradorDePDF();	//nao tem thread rodando
		g.geraPdf();							//comeca a gerar o PDF
		
		/**
		 * Paralelamente, gostaria de exibir um progresso...
		 * Como devemos proceder?
		 */
		
		for(int i = 0; i<=100; i++){		
			try {
				Thread.sleep(1000);
				System.out.println("Progresso ("+i+"%)");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
