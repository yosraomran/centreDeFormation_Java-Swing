package Formation;
import javax.swing.*;
public class Certif extends JFrame{
	   private JLabel jLabel1;
	    private JLabel jLabel2;
	    private JLabel jLabel3;
	    private JLabel jLabel4;
	    private JPanel jPanel1;
	    public String nomF;
	    public String Date;
	    public String NomP;
	    public  Certif(String nomF,String Date,String NomParticipant) {
	    	super("Certificat");
	    	this.nomF=nomF;
	    	this.NomP=NomParticipant;
	    	this.Date=Date;
	        jPanel1 = new javax.swing.JPanel();
	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        jLabel4 = new javax.swing.JLabel();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        jPanel1.setLayout(null);
	        jPanel1.add(jLabel1);
	        jLabel1.setText(NomP);
	        jLabel1.setBounds(170, 216, 330, 50);
	        jPanel1.add(jLabel2);
	        jLabel2.setText(nomF);
	        jLabel2.setBounds(410, 290, 300, 30);

	        jLabel3.setText(Date);
	        jPanel1.add(jLabel3);
	        jLabel3.setBounds(380, 386, 210, 30);

	        jLabel4.setIcon(new javax.swing.ImageIcon(".\\src\\Formation\\CERTIF.jpg")); // NOI18N
	        jPanel1.add(jLabel4);
	        jLabel4.setBounds(0, 0, 900, 500);

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );

	        pack();	
	    }
}
