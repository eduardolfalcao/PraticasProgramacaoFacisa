package threads.waitAndNotify;

// Java Program to create a 
// simple progress bar
import javax.swing.*;

public class BarraDeProgressoThreaded extends JFrame implements Runnable{

	// create a frame
	private JFrame frame;
	private JProgressBar bar;
	
	private GeraPDFThreaded geraPdf = new GeraPDFThreaded(this);

	private void setup() {

		// create a frame
		frame = new JFrame("ProgressBar demo");
		// create a panel
		JPanel p = new JPanel();
		// create a progressbar
		bar = new JProgressBar();

		// set initial value
		bar.setValue(0);
		bar.setStringPainted(true);
		// add progressbar to pane
		p.add(bar);

		// add panel
		frame.add(p);

		// set the size of the frame
		frame.setSize(500, 500);
		frame.setVisible(true);
	}

	// function to increase progress
	private void setProgress(int i) {
		bar.setValue(i);
	}
	
	public void run() {
		setup();		
		geraPdf.start();
		
		while(geraPdf.getProgresso()<100) {
			try {
				synchronized (this) {
					this.wait();
				}				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setProgress(geraPdf.getProgresso());
		}
	}
	
	public static void main(String[] args) {
		BarraDeProgressoThreaded b = new BarraDeProgressoThreaded();
		Thread t = new Thread(b);
		t.start();
		
		while(t.isAlive()){
			System.out.println("O fluxo principal segue paralelamente à interface gráfica!");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}