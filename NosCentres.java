package Formation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class NosCentres extends JFrame implements ActionListener {
	
	private JLabel jLabel2;
	   private JPanel jPanel2;
	   private JButton j;
	   NosCentres()
	   {
	   super("nos centres ");
	   jLabel2=new JLabel();
	   jPanel2=new JPanel();
	   j=new JButton("Retourner");
	   j.setBackground(new java.awt.Color(140,181,247,255));
       j.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
       j.setForeground(new java.awt.Color(242, 242, 242));
       
       j.setBorderPainted(false);
       jLabel2.add(j);
       
       
       j.setBounds(850, 450, 150, 50);
       j.addActionListener(this);
	   setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	   jLabel2.setIcon(new ImageIcon("C:\\Users\\hp\\OneDrive\\Bureau\\SoumaDidiYoyo\\src\\Formation\\MAPS.png"));
	   add(jLabel2);
	     setSize(1000,500);
	      setVisible(true);
	      pack();

	   }
	public static void main(String[] args) {
		new NosCentres();

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		setVisible(false);
		
	}

}
