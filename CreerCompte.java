package Formation;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreerCompte extends JFrame implements ActionListener,ItemListener {
 
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JButton jButton2;
    private JLabel jLabel2;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JCheckBox jCheckBox1;
  
    private JPasswordField jPasswordField1;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JTextField jTextField1;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    private JTextField jTextField6;
    
	Connection con;
	
	Statement stmt;
	Statement stmt1;
	
	String sql;
	String sql2;
	
	ResultSet rs;
	ResultSet rs1;
	
	String vUser;
    String vTel;
    String vMail;
    String myPass;
    String vCin;
    String vSpecialite;

	CreerCompte(){
    	super ("Creation CompteFrame");
    	setBounds(0, 50, 1000, 500);
        jLabel1 = new JLabel();
        
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel10 = new JLabel();
        jLabel9 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jCheckBox1 = new JCheckBox();
        jTextField1 = new JTextField();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jTextField5 = new JTextField();
        jPasswordField1 = new JPasswordField();
        jRadioButton1 = new JRadioButton();
        jRadioButton2 = new JRadioButton();
        jTextField6 = new JTextField();
        
    
        jLabel2 = new JLabel();
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\OneDrive\\Bureau\\SoumaDidiYoyo\\src\\Formation\\log.jpg"));
        
        jLabel1.setBackground(new Color(255, 255, 255));
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("Nom d'utilisateur:");
        jLabel1.setBounds(610, 70, 100, 30);
        jLabel2.add(jLabel1);


        jLabel4.setForeground(new Color(255, 255, 255));
        jLabel4.setText("Mail :");
        jLabel4.setBounds(640, 110, 60, 30);
        jLabel2.add(jLabel4);
        
        jLabel5.setForeground(new Color(255, 255, 255));
        jLabel5.setText("Cin:");
        jLabel5.setBounds(640, 160, 60, 30);
        jLabel2.add(jLabel5);
      
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Telephone : ");
        jLabel6.setBounds(640, 200, 70, 30);
        jLabel2.add(jLabel6);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Mot de passe :");        
        jLabel7.setBounds(640, 250, 90, 30);
        jLabel2.add(jLabel7);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Vous Etes : ");
        jLabel2.add(jLabel8);
        jLabel8.setBounds(640, 300, 90, 20);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Specialites : ");
        jLabel2.add(jLabel10);
        jLabel10.setBounds(640, 380, 80, 20);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("");
        jLabel2.add(jLabel9);
        jLabel9.setBounds(640, 340, 380, 16);

        jButton1.setText("S'inscrire ");
        jLabel2.add(jButton1);
        jButton1.setBounds(870, 470, 99, 22);
        jButton1.setBackground(new java.awt.Color(28, 37, 52));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setBounds(860, 450, 140, 30);
        
        jButton2.setBackground(new java.awt.Color(28, 37, 52));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Retourner");
        jLabel2.add(jButton2);
        jButton2.setBounds(650, 450, 140, 30);
        
        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(242, 242, 242));
        jCheckBox1.setBackground(new java.awt.Color(28, 37, 52));
        jCheckBox1.setText("Vérifier votre données");
        jLabel2.add(jCheckBox1);
        jCheckBox1.setBounds(710, 420, 210, 20);
       
        jLabel2.add(jTextField1);
        jTextField1.setBounds(720, 205, 180, 25);

        jLabel2.add(jTextField3);
        jTextField3.setBounds(720, 75, 180, 25);
        
        jLabel2.add(jTextField4);
        jTextField4.setBounds(720, 115, 180, 25);
        
        jLabel2.add(jTextField5);
        jTextField5.setBounds(720, 160, 180, 25);
        
        jLabel2.add(jPasswordField1);
        jPasswordField1.setBounds(725, 250, 180, 25);

        jRadioButton1.setForeground(new Color(255, 255, 255));
        jRadioButton1.setText("Formateur");    
        jRadioButton1.setBounds(720, 310, 90, 20);
        jRadioButton1.setOpaque(true);
        jRadioButton1.setContentAreaFilled(false);
        jRadioButton1.setBorderPainted(false);
        jLabel2.add(jRadioButton1);

        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Participant");
        jLabel2.add(jRadioButton2);
        jRadioButton2.setBounds(850, 310, 90, 20);
        jRadioButton2.setOpaque(true);
        jRadioButton2.setContentAreaFilled(false);
        jRadioButton2.setBorderPainted(false);
        
        ButtonGroup G = new ButtonGroup();
        G.add(jRadioButton1);
        G.add(jRadioButton2);
        
        jLabel2.add(jTextField6);
        jTextField6.setBounds(720, 380, 180, 25);
       
        jRadioButton1.addItemListener(this);
        jRadioButton2.addItemListener(this);
    
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        
        add(jLabel2);
        pack();
        setVisible(true);
        setSize(1010,535);
       
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	    }
	   
	    public static void main(String args[]) {
	    	CreerCompte F1=new CreerCompte();
	        F1.setVisible(true);
	        F1.setSize(1016, 535);
	        }
	    
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton j=(JButton)e.getSource();
			
			if(j==jButton1) {
				 
		             if(jRadioButton1.isSelected()) {
		                 if(jCheckBox1.isSelected()) {
		                	 
		                	 vUser=jTextField3.getText();
					    		vMail=jTextField4.getText();
					    		vTel=jTextField1.getText();
					    		myPass=String.valueOf(jPasswordField1.getPassword());
					    		vCin=jTextField5.getText();
					    		vSpecialite=jTextField6.getText();
					    		
					    		
		                	 if(vCin.length()==8 && vTel.length()==8 && vCin.matches("[+-]?\\d*(\\.\\d+)?")&&vTel.matches("[+-]?\\d*(\\.\\d+)?")&& vMail.contains("@")&&vMail.contains(".com")) {
						    	try {

						    		try {
							            Class.forName("com.mysql.cj.jdbc.Driver");
							             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
							            
							             sql = "select Mail from formateur where Mail=' "+vMail+"'";
							             
							             PreparedStatement pstmt = con.prepareStatement(sql);
							          
							             pstmt.executeUpdate();
								    	}
								 
								    	  catch(Exception e1) {
								        e1.printStackTrace();
								          JOptionPane.showMessageDialog(null, "Ce compte existe déjà");
								    	  }
					            Class.forName("com.mysql.cj.jdbc.Driver");
					             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
					            
					             sql = "INSERT INTO formateur(Cin,UserName, Mail, Tel, Password, Specialite) "+ "VALUES(?,?,?,?,?,?)";
					                     
					             PreparedStatement pstmt = con.prepareStatement(sql);
					         
					             pstmt.setString(1, vUser);
					             pstmt.setString(2, vMail);
					             pstmt.setString(3, vCin);
					             pstmt.setString(4, vTel);
					             pstmt.setString(5, myPass);
					             pstmt.setString(6, vSpecialite);
					            
					             pstmt.executeUpdate();
						    	}
						 
						    	  catch(Exception e1) {
						        e1.printStackTrace();}
			                }
		                	 else {
		                		 JOptionPane.showMessageDialog(null, "verifier votre données!");
		                	 } 
		                 }
		                 else {
		                	 JOptionPane.showMessageDialog(this, "Verifiez votre données");
		                 }
		             }
		             else if(jRadioButton2.isSelected()) {
		                 if(jCheckBox1.isSelected()) {
		                	 vUser=jTextField3.getText();
						      vMail=jTextField4.getText();
						      vTel=jTextField1.getText();
						      myPass=String.valueOf(jPasswordField1.getPassword());
						      vCin=jTextField5.getText();
						      
						
						      
						      
						      if(vCin.length()==8 && vTel.length()==8 && vCin.matches("[+-]?\\d*(\\.\\d+)?")&&vTel.matches("[+-]?\\d*(\\.\\d+)?")&& vMail.contains("@")&&vMail.contains(".com")) {
						    	try {
						    		

						    		try {
							            Class.forName("com.mysql.cj.jdbc.Driver");
							             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
							            
							             sql = "select MailP from participant where Mail=' "+vMail+"'";
							             PreparedStatement pstmt = con.prepareStatement(sql);
								          System.out.println(sql);
							             pstmt.execute();
							             
							             
								    	}
								 
								    	  catch(Exception e1) {
								        e1.printStackTrace();
								        
							            	  JOptionPane.showMessageDialog(null, "Ce compte déja existe!");
							             
								    	  }
						    		
						    		
					            Class.forName("com.mysql.cj.jdbc.Driver");
					             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/centreformation?UseUniCode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true","root","");
					            
					             sql = "INSERT INTO participant(nCinP, UserName, MailP, nTelP, PasswordP, CodeFormation) "+ "VALUES(?,?,?,?,?,Null)";
					                     
					             PreparedStatement pstmt = con.prepareStatement(sql);
					             
					             
					             pstmt.setString(2, vUser);
					             pstmt.setString(3, vMail);
					             pstmt.setString(1, vCin);
					             pstmt.setString(4, vTel);
					             pstmt.setString(5, myPass);
					          
					             pstmt.executeUpdate();
						    	}
						 
						    	  catch(Exception e1) {
						        e1.printStackTrace();}
			                }}
		                 else {
		                	 JOptionPane.showMessageDialog(this, "Verifiez votre données");
		                 }
		             }
					       	
					         }
		
			
					else
						if(j==jButton2) { 
							setVisible(false);
						}
		 }
		

		@Override
		public void itemStateChanged(ItemEvent e) {
			 if (e.getSource() == jRadioButton1) {
				 
		         if (e.getStateChange() == 1) {
		             jLabel9.setText("Ajoutez votre specialité");}
			 }
				 else if(e.getSource()==jRadioButton2) 
					 if (e.getStateChange() == 1) 
			                jLabel9.setText("Cette champ est pour un formateur");
			
		}
			 }

	
			
						




