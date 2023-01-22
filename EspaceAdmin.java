package Formation;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class EspaceAdmin extends JFrame implements ActionListener {
	
		private JButton jButton4;
	    private JButton jButton5;
	    private JButton jButton6;
	    private JButton jButton7;
	    private JLabel jLabel1;
	    private JLabel jLabel2;
	    private JLabel jLabel3;
	    private JPanel jPanel2;
	    EspaceAdmin(){
	    	super("Espace admin");
	    	setLayout(null);
	    	setLocationRelativeTo(null);
	    	setBounds(0, 0, 1000, 500);
	    	jPanel2 = new JPanel();
	    	
	    	jPanel2.setPreferredSize(new java.awt.Dimension(1000, 500));
	        jButton4 = new JButton();
	        jButton5 = new JButton();
	        jButton6 = new JButton();
	        jButton7 = new JButton();
	        jLabel2 = new JLabel();
	        jLabel1 = new JLabel();
	        jLabel2.setIcon(new ImageIcon(("C:\\Users\\hp\\OneDrive\\Bureau\\SoumaDidiYoyo\\src\\Formation\\Artboard 17@15x.png")));
	        jLabel2.setPreferredSize(new java.awt.Dimension(1000,500)); 
	        jPanel2.setBounds(0, 0, 1000, 500);
	        jPanel2.add(jLabel2);

	        jButton4.setBackground(new java.awt.Color(27, 37, 51));
	        jButton4.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
	        jButton4.setForeground(new java.awt.Color(255, 255, 255));
	        jButton4.setText("Rendement");  
	        jButton4.setBounds(100, 260, 220, 40);
	        jLabel2.add(jButton4);
	        jButton4.addActionListener(this);

	        jButton5.setBackground(new java.awt.Color(27, 37, 51));
	        jButton5.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
	        jButton5.setForeground(new java.awt.Color(255, 255, 255));
	        jButton5.setText("Consulter Participant");
	        jButton5.setBounds(100, 210, 220, 40);
	        jLabel2.add(jButton5);
	           

	        jButton6.setBackground(new java.awt.Color(27, 37, 51));
	        jButton6.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
	        jButton6.setForeground(new java.awt.Color(255, 255, 255));
	        jButton6.setText("Consulter Formation");
	        jButton6.setBounds(100, 160, 220, 40);
	        jLabel2.add(jButton6);
	        jButton5.addActionListener(this);
	        jButton6.addActionListener(this);
            jButton7.addActionListener(this);
	        
	        jButton7.setBackground(new java.awt.Color(27, 37, 51));
	        jButton7.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
	        jButton7.setForeground(new java.awt.Color(255, 255, 255));
	        jButton7.setText("Consulter Formateur");
	        jButton7.setBounds(100, 110, 220, 40);
	        jLabel2.add(jButton7);

	        jLabel1.setFont(new java.awt.Font("Franklin Gothic Heavy", 2, 36)); // NOI18N
	        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
	        jLabel1.setText("Espace Admin");
	        jLabel1.setBounds(100, 50, 250, -1);
	       
	        jPanel2.add(jLabel1);
	        
	
	        
	        
	        add( jPanel2);

	        
	        
	        pack();
	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	    }
	    
	    public static void main(String args[])
	    {
	    	EspaceAdmin p=new EspaceAdmin();
	    	p.setVisible(true);
	        p.setSize(1000,500);
	    }

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton j=(JButton)e.getSource();
			if(j==jButton6) {
		ConsulterFormation c=new ConsulterFormation();
		c.setVisible(true);
		c.setSize(1016, 535);
	}
			else if(j==jButton7) {
				ConsulterFormateur c=new ConsulterFormateur();
				c.setVisible(true);
				c.setSize(1000, 539);
			}
			else if(j==jButton5) {
				ConsulterParticipant c=new ConsulterParticipant();
				c.setVisible(true);
				c.setSize(1000, 537);
			} 
			else if(j==jButton4) {
				Rendement c=new Rendement();
				c.setVisible(true);
				c.setSize(1000, 537);
			} 
			
		}
			
}




