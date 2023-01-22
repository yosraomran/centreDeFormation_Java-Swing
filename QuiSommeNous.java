package Formation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class QuiSommeNous extends JFrame implements ActionListener{
	
	private JLabel jLabel2;
	   private JPanel jPanel2;
	   private JButton j;
	   QuiSommeNous()
	   {
	   super("Qui sont nou ?");
	   jLabel2=new JLabel();
	   jPanel2=new JPanel();
	   j=new JButton();
	   j.setBackground(new java.awt.Color(27, 37, 51));
       j.setFont(new java.awt.Font("Segoe UI", 2, 14));
       j.setForeground(new java.awt.Color(255, 255, 255));
       j.setText("Retourner");
       j.setBounds(820, 120, 170, 20);
       jLabel2.add(j);
       j.addActionListener(this);
	   setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	   jLabel2.setIcon(new ImageIcon("C:\\\\Users\\\\hp\\\\OneDrive\\\\Bureau\\\\SoumaDidiYoyo\\\\src\\\\Formation\\\\quisontnous.png"));
	   add(jLabel2);
	     setSize(1000,500);
	      setVisible(true);
	      pack();

	   }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		setVisible(false);
		
	}
}
