package threads.join;

public class GeradorDePDFThread extends Thread{
	
	public static long count = 0;
	
	public void run(){
		geraPdf();
	}
	
	public void geraPdf(){
		while(count < 100){			
			try {
				Thread.sleep(50);
				System.out.println("Gerando o pdf..."+(++count));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
