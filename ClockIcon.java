package clockIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.GregorianCalendar;

import javax.swing.*;

public class ClockIcon implements Icon{

	int size;
	GregorianCalendar cal; 
	 Line2D hrHand;
     Line2D mnHand; 
     Line2D scHand;
     int sc; 
     int hr; 
     int mn; 

	
	public int getIconHeight() {
		return size; 
	}

	@Override
	public int getIconWidth() {
		return size; 
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		gettime();
	    Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double crc = new Ellipse2D.Double(x, y, size, size);
		int xcenter = size/2; 
		int ycenter = size/2; 
		int hradius = (int) (0.5*(size/2)); 
		int mradius = (int) (0.7*(size/2)); 
		int sradius = (int) (0.9*(size/2)); 


		g2.setColor(Color.BLACK);
		g2.fill(crc);
		
		// Hour hand
		double hAngle; 
		double mAngle; 
		double sAngle;
		hAngle = 2.0*Math.PI*hr/12.0; // 0..12 mapped to 0..2*Pi
		int hX = (int) (xcenter + hradius * Math.sin(hAngle));
		int hY = (int) (ycenter - hradius * Math.cos(hAngle));

		// Min hand
		mAngle = 2.0*Math.PI*mn/60; // 0..1 mapped to 0..2*Pi, etc.
		int mX =(int) (xcenter  + mradius * Math.sin(mAngle));
		int mY = (int) (ycenter  - mradius * Math.cos(mAngle));
		
		sAngle = 2.0*Math.PI*sc/60; // 0..1 mapped to 0..2*Pi, etc.
		int sX =(int) (xcenter  + sradius * Math.sin(sAngle));
		int sY = (int) (ycenter  - sradius * Math.cos(sAngle));
		
		g2.setColor(Color.red);
		g2.drawLine(xcenter, ycenter, hX, hY);
		g2.setColor(Color.magenta);
		g2.drawLine(xcenter, ycenter, mX, mY);
		g.setColor(Color.white);
		g2.drawLine(xcenter, ycenter, sX, sY);


		
	}
	
	
	public ClockIcon(int i){
		size = i; 
		cal = new GregorianCalendar(); 
	
	}
	
	void gettime()
	{
		GregorianCalendar now = new GregorianCalendar();
		
		sc = now.get(now.SECOND); 
		mn = now.get(now.MINUTE); 
		hr = now.get(now.HOUR); 
		
		
		
	}
	

}
