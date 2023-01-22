package Formation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Catalogue extends JFrame implements ActionListener{
	
	private JLabel jLabel2;
	   private JPanel jPanel2;
	   private JButton jButton1;
	   Catalogue ()
	   {
	   super("catalogue");
	   jLabel2=new JLabel();
	   jPanel2=new JPanel();
	   jButton1=new JButton("Retourner");
	   
	   jButton1.setBackground(new java.awt.Color(27, 37, 51));
       jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
       jButton1.setForeground(new java.awt.Color(242, 242, 242));
       
       jButton1.setBorderPainted(false);
       jLabel2.add(jButton1);
       
       
       jButton1.setBounds(850, 130, 150, 50);
       jButton1.addActionListener(this);
	   
	   setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	   jLabel2.setIcon(new ImageIcon(".\\src\\Formation\\catalogue.png"));
	   add(jLabel2);
	     setSize(1000,500);
	      setVisible(true);
	      pack();

	   }
	   public static void main(String args[])
	   {
	    new Catalogue ();
	   }
	@Override
	public void actionPerformed(ActionEvent e) {
	setVisible(false);
		
	}


}
