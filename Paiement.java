package Formation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Paiement extends JFrame implements ActionListener{
	 private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JButton jButton3;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JRadioButton jRadioButton1;
	    private javax.swing.JRadioButton jRadioButton2;
	    private javax.swing.JRadioButton jRadioButton3;
	    private javax.swing.JTextField jTextField1;
	    String NomF;
	    public Paiement(String NomF) {
	    	super("Paiement");
	    	this.NomF=NomF;
	    	jPanel1 = new javax.swing.JPanel();
	        jLabel1 = new javax.swing.JLabel();
	        jTextField1 = new javax.swing.JTextField();
	        jLabel2 = new javax.swing.JLabel();
	        jRadioButton1 = new javax.swing.JRadioButton();
	        jRadioButton2 = new javax.swing.JRadioButton();
	        jRadioButton3 = new javax.swing.JRadioButton();
	        jButton1 = new javax.swing.JButton();
	        jButton2 = new javax.swing.JButton();
	        jButton3 = new javax.swing.JButton();
	        jLabel3 = new javax.swing.JLabel();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        getContentPane().setLayout(null);

	        jPanel1.setLayout(null);

	        jLabel1.setBackground(new java.awt.Color(24, 65, 84));
	        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
	        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
	        jLabel1.setText("Formation");
	        jPanel1.add(jLabel1);
	        jLabel1.setBounds(110, 110, 100, 20);
	        jPanel1.add(jTextField1);
	        jTextField1.setBounds(210, 110, 150, 22);
	        jTextField1.setText(NomF);

	        jLabel2.setBackground(new java.awt.Color(24, 65, 84));
	        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
	        jLabel2.setForeground(new java.awt.Color(242, 242, 242));
	        jLabel2.setText("Payé par :");
	        jPanel1.add(jLabel2);
	        jLabel2.setBounds(110, 170, 100, 30);

	        jRadioButton1.setBackground(new java.awt.Color(24, 65, 84));
	        jRadioButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
	        jRadioButton1.setForeground(new java.awt.Color(242, 242, 242));
	        jRadioButton1.setText("D17");
	        jPanel1.add(jRadioButton1);
	        jRadioButton1.setBounds(210, 220, 60, 21);

	        jRadioButton2.setBackground(new java.awt.Color(24, 65, 84));
	        jRadioButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
	        jRadioButton2.setForeground(new java.awt.Color(242, 242, 242));
	        jRadioButton2.setText("Virement Bancaire");
	        jPanel1.add(jRadioButton2);
	        jRadioButton2.setBounds(210, 270, 170, 21);

	        jRadioButton3.setBackground(new java.awt.Color(24, 65, 84));
	        jRadioButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
	        jRadioButton3.setForeground(new java.awt.Color(242, 242, 242));
	        jRadioButton3.setText("Cache");
	        jPanel1.add(jRadioButton3);
	        jRadioButton3.setBounds(210, 320, 80, 21);

	        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\OneDrive\\Bureau\\SoumaDidiYoyo\\src\\Formation\\flouth.png")); // NOI18N
	        jButton1.setText("");
	        jPanel1.add(jButton1);
	        jButton1.setBounds(350, 400, 110, 70);
	        jButton1.addActionListener(this);

	        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\OneDrive\\Bureau\\SoumaDidiYoyo\\src\\Formation\\Bancaire.png")); // NOI18N
	        jButton2.setText("");
	        jPanel1.add(jButton2);
	        jButton2.setBounds(200, 400, 110, 70);
	        jButton2.addActionListener(this);


	        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\OneDrive\\Bureau\\SoumaDidiYoyo\\src\\Formation\\D17.png")); // NOI18N
	        jButton3.setText("");
	        jPanel1.add(jButton3);
	        jButton3.setBounds(50, 400, 110, 70);
	        jButton3.addActionListener(this);


	        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\OneDrive\\Bureau\\SoumaDidiYoyo\\src\\Formation\\Paiement.png")); // NOI18N
	        jPanel1.add(jLabel3);
	        jLabel3.setBounds(0, 0, 500, 500);

	        getContentPane().add(jPanel1);
	        jPanel1.setBounds(0, 0, 500, 500);

	        pack();
	    }
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton j=(JButton)e.getSource();
			if(jRadioButton1.isSelected()) {
				j=jButton3;
				setVisible(false);
			}
			if(jRadioButton2.isSelected()) {
				j=jButton2;
				setVisible(false);
			}
			if(jRadioButton3.isSelected()) {
				j=jButton1;
				setVisible(false);
			}
			
		}
	 
}
