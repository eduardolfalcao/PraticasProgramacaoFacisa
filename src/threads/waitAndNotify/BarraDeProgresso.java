package threads.waitAndNotify;


// Java Program to create a 
// simple progress bar
import javax.swing.*;

public class BarraDeProgresso extends JFrame {

	// create a frame
	static JFrame frame;
	static JProgressBar bar;

	public static void main(String[] args) {

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
		fill();
		
		System.out.println("O fluxo principal NÃO segue paralelamente à interface gráfica!");
	}

	// function to increase progress
	public static void fill() {
		int i = 0;
		try {
			while (i <= 100) {
				// fill the menu bar
				bar.setValue(i);

				// delay the thread
				Thread.sleep(100);
				i++;
			}
		} catch (Exception e) {
		}
	}
}