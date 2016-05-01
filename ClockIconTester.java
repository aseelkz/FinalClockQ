package clockIcon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class ClockIconTester {

	public static void main(String[] args) {
		
		
		 final JFrame frame = new JFrame("Clock!"); 
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	       final ClockIcon clock = new ClockIcon(300); 
	       JPanel clockPanel = new JPanel(); 
	       JLabel clockLabel = new JLabel(" ", clock, JLabel.CENTER); 
	      

		     frame.getContentPane().add(clockLabel);
		     frame.getContentPane().add(clockPanel, BorderLayout.PAGE_END);
		     frame.pack(); 
		     frame.setVisible(true);
		     
		     int delay = 1000; //milliseconds
		     ActionListener taskPerformer = new ActionListener() {
		         public void actionPerformed(ActionEvent evt) {
		        	 clock.gettime();
		             frame.repaint(); 
		         }
		     };
		     new Timer(delay, taskPerformer).start();
		     
		     
	}

}
