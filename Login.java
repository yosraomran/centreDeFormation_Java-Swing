package Formation;
import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener{
	 // Variables declaration                   
	Connection con;
	
	Statement stmt;
	Statement stmt1;
	Statement stmt2;
	String sql;
	String sql2;
	String sql3;
	ResultSet rs;
	ResultSet rs1;
	ResultSet rs2;
	public JLabel UserName;
	public JButton jButton1;
	public JButton jButton2;
	public JButton jButton3;
	public JLabel jLabel1;
	public JPanel jPanel1;
	public JTextField jTextField1;
	public JTextField jTextField2;
	public JLabel password;
	CreerCompte c;
    // End of variables declaration   
	
	
	
    Login(){
    	super("LoginFrame");
    	setLayout(null);
    	setBounds(0, 50, 1000, 580);
    	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1 = new JPanel();
        
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 580));
        jPanel1.setBounds(0, 0, 1000, 500);
        
        UserName = new JLabel();
        password = new JLabel();
        jTextField1 = new JTextField();
        jTextField2 = new JPasswordField(10);
        jButton1 = new JButton(); //connecter
        jButton2 = new JButton(); //creer compte
        jButton3= new JButton();//back
        jLabel1 = new JLabel(); // contenur image 
        jLabel1.setIcon(new javax.swing.ImageIcon(".\\src\\Formation\\Log.jpg")); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 500);
        
       UserName.setBounds(660, 140, 100, 15);
        password.setBounds(660, 240, 150, 15);
       jTextField1.setBounds(660, 170, 280, 30);
        jTextField2.setBounds(660, 280, 280, 30);
        jButton1.setBounds(660, 350, 150, 20);
        jButton2.setBounds(850, 350, 100, 20);
        jLabel1.add(UserName);
        jLabel1.add(jTextField1);
        jLabel1.add(password);
        jLabel1.add(jTextField2);
        jLabel1.add(jButton1);
        jLabel1.add(jButton2);
        jLabel1.add(jButton3);
           //STYLE
       
        UserName.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        UserName.setForeground(new java.awt.Color(240,255,240));
        UserName.setText("Email :");
        
        password.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        password.setForeground(new java.awt.Color(240,255,240));
        password.setText("Mot de passe :");
        jButton1.setText("Créer Compte");
        jButton2.setText("Connecter");
        jButton3.setText("Retourner"); 
        jButton3.setBounds(850, 435, 120, 20);
        // operation bou 
        jButton1.setOpaque(true);
        jButton1.setContentAreaFilled(false);
        jButton1.setBorderPainted(true);
        jButton2.setOpaque(true);
        jButton2.setContentAreaFilled(false);
        jButton2.setBorderPainted(true);
        	jButton1.setForeground(new java.awt.Color(240,255,240));
        	jButton2.setForeground(new java.awt.Color(240,255,240));
        	jButton3.setForeground(new java.awt.Color(240,255,240));
        	jButton3.setBackground(new java.awt.Color(27, 37, 51));
	        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14));
     
        
        jButton1.addActionListener(this);
        jButton3.addActionListener(this);
        jButton2.addActionListener(this);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1000, 500);
        pack();
    
    }                       

   public String getjTextField1() {
		return jTextField1.getText();
	}

	

public static void main (String []args) {
	  Login g= new Login();
      g.setVisible(true);
      g.setSize(1000, 500);
   }

	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton j=(JButton)e.getSource();
		
				if(j==jButton1) {
					c=new CreerCompte();
			c.setVisible(true);
			c.setSize(1016, 540);
			
		}
				else
					if(j==jButton3) {
						setVisible(false);
						
					}
					else
						if(j==jButton2){
							
							try
					        {   String v1=jTextField1.getText();
					            String v2=jTextField2.getText();
					            Class.forName("com.mysql.cj.jdbc.Driver");
					             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
					            
					              sql="select * from admin where Mail='"+v1+"' and Password='"+v2+"'";
					             sql2="select * from formateur where Mail='"+v1+"' and Password='"+v2+"'";
					              sql3="select * from participant where MailP='"+v1+"' and PasswordP='"+v2+"'";
					             stmt=  con.createStatement();
					             stmt1=con.createStatement();
					             stmt2=con.createStatement();
					             rs=stmt.executeQuery(sql);
					             rs1=stmt2.executeQuery(sql2);
					             rs2=stmt1.executeQuery(sql3);
					             if(rs.next()) {
					            	 dispose();
					            	 EspaceAdmin p=new EspaceAdmin();
					     	    	p.setVisible(true);
					     	        p.setSize(1000,500);
					             }
					             else if(rs2.next()) {
					            	 dispose();
					            	 Participant p=new Participant(getjTextField1());
					         		p.setSize(1000,538);
					         		p.setVisible(true);
					             }
					             else if(rs1.next()) {
					            	 dispose();
					            	 EspaceFormateur p=new EspaceFormateur(getjTextField1());
					            	 
					         		p.setSize(1000,500);
					         		p.setVisible(true);
					             }
					             else {
					            	 JOptionPane.showMessageDialog(null, "Cette compte n'existe pas vous devez créer compte");
					             }
					              
					        }
					        catch(Exception e1)
					        {e1.printStackTrace();
					        }
						}
		
	}

}

   
       