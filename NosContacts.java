package Formation;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
public class NosContacts extends JFrame implements ActionListener  {

	   private JButton jButton1;
	   private JButton jButton2;
	   private JLabel jLabel2;
	   private JPanel jPanel1;
	   private JTextField jTextField1;
	   
	   
	NosContacts()
	     {   
		super("contacter nous");
	     
	    //setLayout(null);
	    setLocationRelativeTo(null);
	    setBounds(100, 100, 1000, 500);
	    jPanel1 = new JPanel();
	   
	   
	       jTextField1 = new JTextField();
	       jButton1 = new JButton();
	       jButton2 = new JButton();
	       jLabel2 = new JLabel();
	       jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\OneDrive\\Bureau\\SoumaDidiYoyo\\src\\Formation\\contact.png"));
	       
	       jTextField1.setBackground(new java.awt.Color(28, 37, 52));
	       jTextField1.setForeground(new java.awt.Color(204, 204, 204));
	       jTextField1.setBorder(null);
	       jTextField1.setBounds(410, 250, 180, 50);
	     
	       jButton1.setBackground(new java.awt.Color(27, 37, 51));
	       jButton1.setFont(new java.awt.Font("Segoe UI", 2, 14));
	       jButton1.setForeground(new java.awt.Color(255, 255, 255));
	       jButton1.setText("Envoyer");
	       jButton1.setBounds(415, 320, 170, 20);
	       jLabel2.add(jButton1);
	       jButton2.setBackground(new java.awt.Color(27, 37, 51));
	       jButton2.setFont(new java.awt.Font("Segoe UI", 2, 14));
	       jButton2.setForeground(new java.awt.Color(255, 255, 255));
	       jButton2.setText("Retourner");
	       jButton2.setBounds(415, 370, 170, 20);
	       jLabel2.add(jButton2);
	       jButton2.addActionListener(this);
	       
	       
	       jLabel2.add(jTextField1);
	       jPanel1.add(jLabel2);
	       add( jPanel1);
	       
	       setVisible(true);
	       setSize(1000,500);
	       pack();
	       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
}


	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		
	}}
