package threads.join;

public class MainThread {
	
	public static void main(String[] args) {
		
		GeradorDePDFThread g = new GeradorDePDFThread();	//nao tem thread rodando
		g.start();							//comeca a gerar o PDF				
				
		try {			
			System.out.println("Estou no começo da geração do PDF!");
			g.join();
			System.out.println("Tenho certeza que a geração do PDF encerrou!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
