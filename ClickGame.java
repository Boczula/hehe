package skojarzenia;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ClickGame extends JPanel implements MouseListener{
	/**
	 * 
	 */
	 
	private static final long serialVersionUID = 1L;
	JFrame  jf = new JFrame(); 		 			// frame
	JPanel  jp = new JPanel();  				// panel to add in a frame
	JButton jb = new JButton("Click ME!!");	 	// button
	Random  rand = new Random();				// for random positioning 
	String  msg1 = "Try to click me!!"; 
	JLabel label = new JLabel(msg1); 			// setting the label
	
	public boolean buttonClicked;
	
	
	public ClickGame()
	{ 
		jf.setSize(500, 500); //setting frame size
		//jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //for closing the app
		//jf.dispose();
		jf.setTitle("GAME - CLICK ME IF YOU CAN !!"); //setting title
		jf.setVisible(true); // setting the frame to visible
		
		jp.setBackground(Color.WHITE); //setting the panel color to white
	}
	
	public void setComponents()
	{
		jf.add(jp); //adding panel in the frame
		jp.setLayout(null); // null layout to move button freely in a frame
		label.setBounds(200, 150, 200, 20); //setting the label
		
		jp.add(label); //adding label
		jp.setBounds(0, 0, 500, 500); // setting panel boundries
		
		jp.add(jb); //adding button in panel
		jb.setBounds(200,180, 120, 30); //positioning button in panel
		jb.addMouseListener(this); // adding mouse listener to the button
		
	}
	
@Override
public void mouseEntered(MouseEvent me) {
		
	if(me.getSource() == jb) //checking if mouse entered jbutton
	jb.setBounds(rand.nextInt(jf.getWidth()-100),rand.nextInt(jf.getHeight()-100),120,30); // randomizing position
}
	
	/* providing null body implementation for the 
	 * remaining abstract methods of mouselistener interface
	 */
	public void mouseClicked(MouseEvent mc) {   // sprawdzenie, czy kliknięto przycisk "Click ME!!"
	    if (mc.getSource() == jb) {
	    	buttonClicked = true; 
	        jf.dispose();
	    	
	    }
	}
	
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}

	public static void main(String[] args)
	{
		ClickGame cm = new ClickGame(); // making the class object using constructor
		cm.setComponents();		// call the setComponents function
	
	}//end main
}//end class
